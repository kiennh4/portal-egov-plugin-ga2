
package com.bkav.portal.portlet.license_manager.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

public class LicenseUtil {

	public static String getProductName() {

		return getLicenseNodeValue(LicenseConstants.LICENSE_INFO_PRODUCT_NAME);
	}

	public static String getProductVersion() {

		return getLicenseNodeValue(LicenseConstants.LICENSE_INFO_PRODUCT_VERSION);
	}

	public static String getProviderName() {

		return getLicenseNodeValue(LicenseConstants.LICENSE_INFO_PROVIDER_NAME);
	}

	public static String getStartDate() {

		return getLicenseNodeValue(LicenseConstants.LICENSE_INFO_START_DATE);
	}

	public static String getExpirationDate() {

		String startDate = getStartDate();
		String expirationDate = getLicenseNodeValue(LicenseConstants.LICENSE_INFO_EXPIRATION_DATE);

		if (Validator.isNull(expirationDate) || Validator.equals(startDate, expirationDate)) {

			expirationDate = LanguageUtil.get(VI_VN_LOCALE, "license-never-expired");
		}

		return expirationDate;
	}

	public static String getMaxUsers() {

		String maxUsersStr = getLicenseNodeValue(LicenseConstants.LICENSE_INFO_MAX_USERS);

		if (GetterUtil.getInteger(maxUsersStr) <= 1) {
			maxUsersStr = LanguageUtil.get(VI_VN_LOCALE, "license-unlimited");
		}

		return maxUsersStr;
	}

	public static String getMaxSites() {

		String maxSitesStr = getLicenseNodeValue(LicenseConstants.LICENSE_INFO_MAX_SITES);

		if (GetterUtil.getInteger(maxSitesStr) <= 1) {
			maxSitesStr = LanguageUtil.get(VI_VN_LOCALE, "license-unlimited");
		}

		return maxSitesStr;
	}

	public static String getMaxInstances() {

		String maxInstancesStr = getLicenseNodeValue(LicenseConstants.LICENSE_INFO_MAX_INSTANCES);

		if (GetterUtil.getInteger(maxInstancesStr) <= 1) {
			maxInstancesStr = LanguageUtil.get(VI_VN_LOCALE, "license-unlimited");
		}

		return maxInstancesStr;
	}

	public static String getHostName() {

		String hostName = "";

		try {
			Runtime runtime = Runtime.getRuntime();

			Process process = runtime.exec("hostname");

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 128);

			hostName = bufferedReader.readLine();

			bufferedReader.close();
		}
		catch (Exception e) {
			_log.error("Unable to read local server's host name");
			_log.error(e);
		}

		return hostName;
	}

	public static String getIpAddresses() {

		Set<String> ipAddress = new HashSet<String>();

		try {
			List<NetworkInterface> networkInterfaces = Collections.list(NetworkInterface.getNetworkInterfaces());

			for (NetworkInterface networkInterface : networkInterfaces) {
				List<InetAddress> inetAddresses = Collections.list(networkInterface.getInetAddresses());

				for (InetAddress inetAddress : inetAddresses) {
					if (inetAddress.isLinkLocalAddress() || inetAddress.isLoopbackAddress() ||
						!(inetAddress instanceof Inet4Address)) {
						continue;
					}

					ipAddress.add(inetAddress.getHostAddress());
				}
			}
		}
		catch (Exception e) {
			_log.error("Unable to read local server's IP addresses");

			_log.error(e, e);
		}

		return StringUtil.merge(ipAddress);
	}

	public static String getMacAddresses() {

		Set<String> macAddresses = new HashSet<String>();

		try {
			Process process = null;

			Runtime runtime = Runtime.getRuntime();

			File ifconfigFile = new File(IP_CONFIG_FILE_PATH);

			if (ifconfigFile.exists()) {
				process = runtime.exec(new String[] {
					IP_CONFIG_FILE_PATH, "-a"
				}, null);
			}
			else {
				process = runtime.exec(new String[] {
					"ipconfig", "/all"
				}, null);
			}

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 128);

			String line = null;

			while ((line = bufferedReader.readLine()) != null) {
				Matcher matcher = _macAddressPattern.matcher(line);

				if (matcher.find()) {
					String macAddress = matcher.group(1);

					if (Validator.isNotNull(macAddress)) {
						macAddress = macAddress.toLowerCase();
						macAddress = StringUtil.replace(macAddress, "-", ":");

						macAddresses.add(macAddress);
					}
				}
			}

			bufferedReader.close();
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return StringUtil.merge(macAddresses);
	}

	private static String getLicenseNodeValue(String nodeName) {

		try {

			Document licenseDocument = getLicenseDocument(LicenseConstants.LICENSE_FILE_PATH);

			Element licenseRootElement = licenseDocument.getDocumentElement();

			NodeList nodeList = licenseRootElement.getElementsByTagName(nodeName);

			if (nodeList.getLength() > 0) {

				NodeList childNodeList = nodeList.item(0).getChildNodes();

				if (nodeList.getLength() > 0) {

					return childNodeList.item(0).getNodeValue();
				}
				else {

					return StringPool.BLANK;
				}
			}
			else {
				return StringPool.BLANK;
			}
		}
		catch (IOException e) {
			_log.error(e);
			return StringPool.BLANK;
		}
		catch (ParserConfigurationException e) {
			_log.error(e);
			return StringPool.BLANK;
		}
		catch (SAXException e) {
			_log.error(e);
			return StringPool.BLANK;
		}
	}

	private static Document getLicenseDocument(String licenseFilePath)
		throws IOException, ParserConfigurationException, SAXException {

		if (!FileUtil.exists(licenseFilePath)) {
			throw new FileNotFoundException("Can not find portal license file in path " + licenseFilePath);
		}

		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		documentFactory.setNamespaceAware(true);
		documentFactory.setIgnoringComments(true);

		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

		return documentBuilder.parse(licenseFilePath);
	}

	private static final String IP_CONFIG_FILE_PATH = "/sbin/ifconfig";
	
	private static final Locale VI_VN_LOCALE = LocaleUtil.fromLanguageId("vi_VN");

	private static final Pattern _macAddressPattern =
		Pattern.compile("\\s((\\p{XDigit}{1,2}(-|:)){5}(\\p{XDigit}{1,2}))(?:\\s|$)");

	private static final Logger _log = Logger.getLogger(LicenseUtil.class.getName());
}
