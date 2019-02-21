
package com.liferay.portal.license;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PropsValues;

public class PortalEgovLicenseUtil {

	public static void verify() throws Exception {
			
		boolean isValidSignature = verifyLicenseFileSign();
		
		if(isValidSignature){
			
			verifyLicenseDate();
			
		}else{
			throw new Exception("Invalid Portal eGov license! Portal server can not startup normally");
		}
	}

	public static int getMaxUsers() throws IOException, ParserConfigurationException, SAXException {

		String licenseMaxUser = getLicenseNodeValue(PortalEgovLicenseConstants.LICENSE_INFO_MAX_USERS);
		
		if(Validator.isNotNull(licenseMaxUser)){//if license limited user
			return GetterUtil.getInteger(licenseMaxUser);
		}else{//Unlimit users
			return 0;
		}
	}

	public static int getMaxSites() throws IOException, ParserConfigurationException, SAXException {

		String licenseMaxSite = getLicenseNodeValue(PortalEgovLicenseConstants.LICENSE_INFO_MAX_SITES);
		
		if(Validator.isNotNull(licenseMaxSite)){//if license limited user
			return GetterUtil.getInteger(licenseMaxSite);
		}else{//Unlimit users
			return 0;
		}
	}

	public static int getMaxInstances() throws IOException, ParserConfigurationException, SAXException {

		String licenseMaxInstances = getLicenseNodeValue(PortalEgovLicenseConstants.LICENSE_INFO_MAX_INSTANCES);
		
		if(Validator.isNotNull(licenseMaxInstances)){//if license limited user
			return GetterUtil.getInteger(licenseMaxInstances);
		}else{//Unlimit users
			return 0;
		}
	}
	
	private static String getLicenseNodeValue(String nodeName) throws IOException, ParserConfigurationException, SAXException {
		
		Document licenseDocument = getLicenseDocument(PortalEgovLicenseConstants.LICENSE_FILE_PATH);

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
	
	private static void verifyLicenseDate() throws Exception{
		
		Date now = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(PortalEgovLicenseConstants.LICENSE_FORMAT_DATE_PATTERN);
		
		String expirationDateStr = getLicenseNodeValue(PortalEgovLicenseConstants.LICENSE_INFO_EXPIRATION_DATE);
		
		if(Validator.isNotNull(expirationDateStr)){
			
			Date expirationDate = dateFormat.parse(expirationDateStr);
			
			if(DateUtil.compareTo(expirationDate, now, true) < 0){//expirationDate < now
				throw new Exception("License expired! Expiration date at " + expirationDateStr);
			}
		}
	}
	
	private static boolean verifyLicenseFileSign()
		throws Exception {
		
		Document signedDocument = getLicenseDocument(PortalEgovLicenseConstants.LICENSE_FILE_PATH);

		NodeList signatureNodeList =
			signedDocument.getElementsByTagNameNS(XMLSignature.XMLNS, PortalEgovLicenseConstants.SIGNATURE_ELEMENT_TAG_NAME);

		if (signatureNodeList.getLength() == 0) {
			throw new Exception("No digital signature found, document is discarded");
		}

		Node signatureNode = signatureNodeList.item(0);

		DOMValidateContext valContext = new DOMValidateContext(new SimpleKeySelector(), signatureNode);

		XMLSignatureFactory xmlSignatureFactory =
			XMLSignatureFactory.getInstance(PortalEgovLicenseConstants.SIGNATURE_MECHANISM_TYPE);
		XMLSignature signature = xmlSignatureFactory.unmarshalXMLSignature(valContext);

		return signature.validate(valContext);
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

}
