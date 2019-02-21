package com.liferay.portal.license;

import com.liferay.portal.util.PropsValues;


public class PortalEgovLicenseConstants {
	public static final String LICENSE_FILE_PATH = PropsValues.LIFERAY_HOME.concat("/data/license/license.xml");
	
	public static final String SIGNATURE_MECHANISM_TYPE = "DOM";

	public static final String SIGNATURE_ELEMENT_TAG_NAME = "Signature";
	
	public static final String LICENSE_INFO_START_DATE = "start-date";

	public static final String LICENSE_INFO_EXPIRATION_DATE = "expiration-date";

	public static final String LICENSE_INFO_MAX_USERS = "max-users";

	public static final String LICENSE_INFO_MAX_SITES = "max-sites";

	public static final String LICENSE_INFO_MAX_INSTANCES = "max-instances";
	
	public static final String LICENSE_FORMAT_DATE_PATTERN = "dd/MM/yyyy";
}
