package com.bkav.portal.autoupdate.admin.util;

import java.io.File;

import com.liferay.portal.kernel.util.PropsUtil;

public class AutoUpdateConstant {
	public static final String EPORTAL_CODE = PropsUtil.get("eportal-code");

	public static final String EPORTAL_EMAIL_SURFIX = PropsUtil
			.get("eportal-email-surfix");

	public static final String PORTAL_UPDATE_SERVICE_URL = PropsUtil
			.get("portal-update-service-url");

	public static final String PORTAL_UPDATE_SERVICE_CLASS = PropsUtil
			.get("portal-update-service-class");

	public static final String PORTAL_UPDATE_SERVICE_FUNCTION = PropsUtil
			.get("portal-update-service-function");
	
	public static final String PORTAL_DOWNLOAD_SERVICE_URL = PropsUtil
			.get("portal-download-service-url");

	public static final String EPORTAL_PASSWORD_SURFIX = "2015";

	public static final String TEMPLATE_DOWNLOAD_FOLDER = PropsUtil
			.get("liferay.home")
			+ File.separator
			+ "data"
			+ File.separator
			+ "temp";
}
