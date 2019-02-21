package com.bkav.portal.portlet.autoupdate.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.autoupdate.model.UpdatePlugins;
import com.bkav.portal.portlet.autoupdate.service.UpdatePluginsLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

public class AutoUpdateRestore {
	public static boolean isRestoredPlugin(String pluginCode) {
		try {
			UpdatePlugins plugin = UpdatePluginsLocalServiceUtil
					.fetchByPluginCode(pluginCode);
			String previousVersion = "";

			if (plugin != null) {
				
				if (plugin.getPreviousVersions().equals(StringUtil.valueOf(plugin.getCurrentVersion())))
				{
					return false;
				}
				
				if (!plugin.getPreviousVersions().equals(StringPool.BLANK)) {
					String[] previousVersionArr = plugin.getPreviousVersions()
							.split(StringPool.COMMA);

					if (previousVersionArr.length > 1) {
						previousVersion = previousVersionArr[previousVersionArr.length - 2];
					}
				}

				if (!previousVersion.equals(StringPool.BLANK)) {
					String backupFolderPath = PropsUtil.get("liferay.home")
							+ StringPool.SLASH + "data" + StringPool.SLASH
							+ "backup" + StringPool.SLASH + pluginCode
							+ StringPool.SLASH + previousVersion;

					File backupFolder = new File(backupFolderPath);

					if (!backupFolder.exists()) {
						return false;
					} else {
						String deployFolderPath = PropsUtil.get("liferay.home")
								+ StringPool.SLASH + "deploy";

						File deployFolder = new File(deployFolderPath);

						FileUtils.copyDirectory(backupFolder, deployFolder);

						String previousVerion = plugin.getPreviousVersions()
								.substring(
										0,
										plugin.getPreviousVersions()
										.lastIndexOf(StringPool.COMMA));

						UpdatePluginsLocalServiceUtil
								.updateVersioPlugin(plugin.getPluginId(),
										Double.valueOf(previousVersion),
										previousVerion);

						return true;
					}

				} else {
					return false;
				}
			} else {
				return false;
			}

		} catch (Exception e) {
			_log.error(e);
			return false;
		}

	}

	private static Log _log = LogFactory.getLog(AutoUpdateRestore.class);
}
