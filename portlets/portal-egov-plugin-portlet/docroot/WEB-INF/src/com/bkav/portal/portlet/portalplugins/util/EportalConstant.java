package com.bkav.portal.portlet.portalplugins.util;

import java.util.Date;

import com.liferay.portal.kernel.util.StringPool;

public class EportalConstant {
	private static Date now = new Date();
	
	@SuppressWarnings("deprecation")
	public static final String USER_PASSWORD_SURFIX = StringPool.AT + (now.getYear()+1900);
	
	public static final String EPORTAL_MAIL_SURFIX = "@update.portal-egov.com";
	
	public static final String USER_TITLE_JOB = "Portal Member";
	
	
	
	
}
