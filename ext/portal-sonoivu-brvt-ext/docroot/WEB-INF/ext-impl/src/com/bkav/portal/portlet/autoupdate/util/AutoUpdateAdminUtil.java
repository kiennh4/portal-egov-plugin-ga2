package com.bkav.portal.portlet.autoupdate.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.autoupdate.model.UpdatePlugins;
import com.bkav.portal.portlet.autoupdate.service.UpdatePluginsLocalServiceUtil;
import com.bkav.portal.portlet.autoupdate.util.UpdatePluginsModel;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

public class AutoUpdateAdminUtil {
	public static void updatePluginToDB(String pluginCode, String pluginName,
			long serverCompanyId, double currentVersion, double currentSize,
			int pluginType) {
		try {
			UpdatePlugins plugin = UpdatePluginsLocalServiceUtil
					.fetchByPluginCode(pluginCode);

			if (plugin != null) {
				String previousVersions = StringPool.BLANK;

				if (!plugin.getPreviousVersions().equals(StringPool.BLANK)) {
					String[] previousPluginArr = plugin.getPreviousVersions()
							.split(StringPool.COMMA);

					String[] newPreviousPluginArr = new String[previousPluginArr.length + 1];

					for (int i = 0; i < newPreviousPluginArr.length - 1; i++) {
						newPreviousPluginArr[i] = previousPluginArr[i];
					}

					newPreviousPluginArr[previousPluginArr.length] = StringUtil
							.valueOf(currentVersion);

					previousVersions = buildStringFromArray(newPreviousPluginArr);
				} else {
					previousVersions = StringUtil.valueOf(currentVersion);
				}

				UpdatePluginsLocalServiceUtil.updatePlugin(
						plugin.getPluginId(), pluginName, serverCompanyId,
						currentVersion, currentSize, pluginType, pluginCode,
						previousVersions);
			} else {
				UpdatePluginsLocalServiceUtil.addPlugin(pluginName, pluginCode,
						serverCompanyId, currentVersion, currentSize,
						pluginType);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public static boolean isMoveFileToDeployFolder(String tempFilePath,
			String fileName) {
		try {
			String destination = PropsUtil.get("liferay.home")
					+ StringPool.SLASH + "deploy" + StringPool.SLASH + fileName;

			File tmpFile = new File(tempFilePath);
			File destinationFile = new File(destination);

			FileUtil.copyFile(tmpFile, destinationFile);

			return true;
		} catch (Exception e) {
			_log.error(e);
			return false;
		}
	}

	public static void createBackupPlugin(String tempFileSignPath,
			String tempFileWarPath, String version, String fileSignName,
			String fileWarName, String pluginCode) {
		try {
			String backupFolderPath = PropsUtil.get("liferay.home")
					+ StringPool.SLASH + "data" + StringPool.SLASH + "backup"
					+ StringPool.SLASH + pluginCode + StringPool.SLASH
					+ version;
			File backupFolder = new File(backupFolderPath);

			if (!backupFolder.exists()) {
				backupFolder.mkdirs();
			}

			String backupFileSignPath = backupFolderPath + StringPool.SLASH
					+ fileSignName;
			String backupFileWarPath = backupFolderPath + StringPool.SLASH
					+ fileWarName;

			File backupFileSign = new File(backupFileSignPath);
			File backupFileWar = new File(backupFileWarPath);

			File tempFileSign = new File(tempFileSignPath);
			File tempFileWar = new File(tempFileWarPath);

			boolean movedFileSign = FileUtil.move(tempFileSign, backupFileSign);

			if (!movedFileSign) {
				FileUtil.copyFile(tempFileSign, backupFileSign);
				FileUtil.delete(tempFileSign);
			}

			boolean movedFileWar = FileUtil.move(tempFileWar, backupFileWar);

			if (!movedFileWar) {
				FileUtil.copyFile(tempFileWar, backupFileWar);
				FileUtil.delete(tempFileWar);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public static List<UpdatePluginsModel> getUpdatePlugins(
			List<UpdatePluginsModel> availablePlugins) {
		List<UpdatePluginsModel> listUpdatePlugins = new ArrayList<UpdatePluginsModel>();

		try {
			List<UpdatePlugins> currentPlugins = UpdatePluginsLocalServiceUtil
					.findAll();

			for (UpdatePluginsModel updatePlugin : availablePlugins) {
				boolean isNewPlugin = true;

				for (UpdatePlugins currentPlugin : currentPlugins) {

					if (updatePlugin.getPluginCode().equals(
							currentPlugin.getPluginCode())) {
						isNewPlugin = false;
						if ((updatePlugin.getCurrentVersion() > currentPlugin
								.getCurrentVersion())
								&& (updatePlugin.getModifyDate().getTime() >= currentPlugin
										.getModifyDate().getTime())) {
							listUpdatePlugins.add(updatePlugin);
							break;
						} else {
							break;
						}
					}
				}

				if (isNewPlugin) {
					listUpdatePlugins.add(updatePlugin);
				}
			}

			return listUpdatePlugins;
		} catch (Exception e) {
			_log.error(e);
			return listUpdatePlugins;
		}
	}

	public static String getServiceUrl(String portalUpdateServer,
			String portalServiceUrl, String portalServiceClass,
			String portalServiceFunction, String ePortalCode,
			String[] paramNames, String[] paramValues) {

		StringBuilder sb = new StringBuilder();
		sb.append(HTTP_PROTOCOL);
		sb.append(portalUpdateServer);
		sb.append(StringPool.SLASH);
		sb.append(portalServiceUrl);
		sb.append(StringPool.SLASH);
		sb.append(portalServiceClass);
		sb.append(StringPool.SLASH);
		sb.append(portalServiceFunction);
		sb.append(StringPool.QUESTION);
		if ((paramNames.length == paramValues.length)
				&& (paramNames.length > 0)) {
			for (int i = 0; i < paramNames.length; i++) {
				sb.append(paramNames[i]);
				sb.append("=");
				sb.append(paramValues[i]);
				if (i < paramNames.length - 1) {
					sb.append(StringPool.AMPERSAND);
				}
			}
		}

		return sb.toString();
	}

	public static String getDownloadServiceUrl(String portalUpdateServer,
			String portalDownloadServiceUrl, String pluginId,
			String emailAddress, String pw, String dwType) {

		StringBuilder sb = new StringBuilder();
		sb.append(HTTP_PROTOCOL);
		sb.append(portalUpdateServer);
		sb.append(StringPool.SLASH);
		sb.append(portalDownloadServiceUrl);
		sb.append(StringPool.QUESTION);
		sb.append("emailAddress");
		sb.append(StringPool.EQUAL);
		sb.append(emailAddress);
		sb.append(StringPool.AMPERSAND);
		sb.append("pw");
		sb.append(StringPool.EQUAL);
		sb.append(pw);
		sb.append(StringPool.AMPERSAND);
		sb.append("dwType");
		sb.append(StringPool.EQUAL);
		sb.append(dwType);
		sb.append(StringPool.AMPERSAND);
		sb.append("pluginId");
		sb.append(StringPool.EQUAL);
		sb.append(pluginId);

		return sb.toString();
	}

	public static String getUserCredentials(String portalCode,
			String portalEmailSurfix, String portalPWsurfix) {

		StringBuilder sb = new StringBuilder();
		sb.append(portalCode);
		sb.append(StringPool.AT);
		sb.append(portalEmailSurfix);
		sb.append(StringPool.COLON);
		sb.append(portalCode);
		sb.append(StringPool.AT);
		sb.append(portalPWsurfix);

		return sb.toString();
	}

	public static List<UpdatePluginsModel> getListPluginsFromJSONString(
			String json) {
		List<UpdatePluginsModel> listPlugins = new ArrayList<UpdatePluginsModel>();

		try {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(json);

			for (int i = 0; i < jsonArray.length(); i++) {
				UpdatePluginsModel pluginItem = new UpdatePluginsModel();
				JSONObject jsonObject = jsonArray.getJSONObject(i);

				pluginItem.setPluginId(jsonObject.getLong("pluginId"));
				pluginItem.setPluginName(jsonObject.getString("pluginName"));
				pluginItem.setPluginCode(jsonObject.getString("pluginCode"));
				pluginItem.setPluginType(jsonObject.getInt("pluginType"));
				pluginItem.setCurrentVersion(jsonObject
						.getDouble("pluginVersion"));
				pluginItem.setCurrentSize(jsonObject.getDouble("pluginSize"));
				pluginItem.setCreateDate(new Date(jsonObject
						.getLong("createDate")));
				pluginItem.setModifyDate(new Date(jsonObject
						.getLong("modifyDate")));
				pluginItem.setServerCompanyId(jsonObject.getLong("companyId"));

				listPlugins.add(pluginItem);
			}

			return listPlugins;
		} catch (Exception e) {
			_log.error(e);
			return listPlugins;
		}
	}

	public static String getStringFromReader(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static boolean isValidSignatureDigital(String tempFileWarPath,
			String tempFileSignPath) {
		File warFile = new File(tempFileWarPath);

		if (warFile.exists()) {
			return verifyFileSignature(warFile, tempFileSignPath);
		} else {
			return false;
		}
	}

	/**
	 * Verify signature war file before allow atract and deploys to server
	 * 
	 * @author HungDX
	 * @param file
	 * @return
	 */
	protected static boolean verifyFileSignature(File file,
			String signatureFilePath) {

		if (Validator.isNotNull(SIGNATURE_KEY_FILE)
				&& FileUtil.exists(SIGNATURE_KEY_FILE)) {
			try {

				_log.info("Verify signature of " + file.getName());

				// Load public key from binary file
				PublicKey publicKey = loadPublicKey(SIGNATURE_KEY_FILE);

				// Generate java digital signature
				Signature signature = Signature.getInstance(publicKey
						.getAlgorithm());

				// Init verify
				signature.initVerify(publicKey);

				/**
				 * Build signature file from war file signatureFileName =
				 * baseFileName + extension(.sign)
				 */
				// String signatureFileName =
				// FilenameUtils.getBaseName(file.getName()).trim() +
				// SIGNATURE_FILE_EXTENSION;

				// String signatureFilePath = PropsUtil.get("liferay.home")
				// + StringPool.SLASH + "data"
				// + StringPool.SLASH + "temp"
				// + StringPool.SLASH + signatureFileName;

				if (FileUtil.exists(signatureFilePath)) {// Check exist
															// signature file

					// Read signature bytes from file
					FileInputStream signatureInput = new FileInputStream(
							signatureFilePath);
					byte[] signatureBytes = new byte[signatureInput.available()];
					signatureInput.read(signatureBytes);
					signatureInput.close();

					// Read signed data file
					FileInputStream dataInput = new FileInputStream(file);
					BufferedInputStream bufferInput = new BufferedInputStream(
							dataInput);

					byte[] dataBytes = new byte[1024];
					int len;
					while (bufferInput.available() != 0) {
						len = bufferInput.read(dataBytes);
						signature.update(dataBytes, 0, len);
					}
					;
					bufferInput.close();

					// Verify signature
					boolean validSignature = signature.verify(signatureBytes);

					// Delete signature file after verify
					// FileUtil.delete(signatureFilePath);

					return validSignature;

				} else {
					return false;
				}
			} catch (Exception e) {
				_log.error(e);
				return false;
			}
		} else {

			if (Validator.isNull(SIGNATURE_KEY_FILE)) {
				_log.error("Public key for digital signature is not set.Please check value of plugins.signature.key.file key"
						+ " on portal-ext.properties");
			} else {
				_log.error("Can not read signature public key from directory "
						+ SIGNATURE_KEY_FILE);
			}
			return false;
		}
	}

	/**
	 * @author HungDX Load public key from path
	 * 
	 * @param keyPath
	 * @param algorithm
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	protected static PublicKey loadPublicKey(String keyPath)
			throws IOException, NoSuchAlgorithmException,
			InvalidKeySpecException {

		File publicKeyFile = new File(keyPath);

		FileInputStream inputStream = new FileInputStream(keyPath);

		byte[] encodedPublicKey = new byte[(int) publicKeyFile.length()];

		inputStream.read(encodedPublicKey);
		inputStream.close();

		// Generate KeyPair.
		KeyFactory keyFactory = KeyFactory.getInstance(DSA_ALGORITHM);

		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
				encodedPublicKey);

		return keyFactory.generatePublic(publicKeySpec);
	}

	public static String buildStringFromArray(String[] arrayStr) {
		if (arrayStr.length > 0) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < arrayStr.length; i++) {
				sb.append(arrayStr[i]);

				if (i < arrayStr.length - 1) {
					sb.append(StringPool.COMMA);
				}
			}

			return sb.toString();
		} else {
			return StringPool.BLANK;
		}
	}

	private static final String HTTP_PROTOCOL = "http://";
	private static final String DSA_ALGORITHM = "DSA";
	// private static final String SIGNATURE_FILE_EXTENSION = ".sign";
	private static final String SIGNATURE_KEY_FILE = PropsUtil.get(
			"liferay.home").concat("/data/license/public.key");
	// private File _deployDir;
	// private static final String HTTPS_PROTOCOL = "https://";

	private static Log _log = LogFactory.getLog(AutoUpdateAdminUtil.class);
}
