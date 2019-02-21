package com.bkav.portal.portlet.license_manager.util;

import com.liferay.portal.kernel.util.PropsUtil;


public class LicenseConstants {

	public static final String SIGNATURE_MECHANISM_TYPE = "DOM";
	
	public static final String SIGNATURE_ELEMENT_TAG_NAME = "Signature";
	
	public static final String LICENSE_FILE_PATH = PropsUtil.get("liferay.home").concat("/data/license/license.xml");
	
	public static final String LICENSE_INFO_PRODUCT_NAME = "product-name";
	
	public static final String LICENSE_INFO_PRODUCT_VERSION = "product-version";
	
	public static final String LICENSE_INFO_PROVIDER_NAME = "provider";
	
	public static final String LICENSE_INFO_START_DATE = "start-date";

	public static final String LICENSE_INFO_EXPIRATION_DATE = "expiration-date";

	public static final String LICENSE_INFO_MAX_USERS = "max-users";

	public static final String LICENSE_INFO_MAX_SITES = "max-sites";

	public static final String LICENSE_INFO_MAX_INSTANCES = "max-instances";
	
}
