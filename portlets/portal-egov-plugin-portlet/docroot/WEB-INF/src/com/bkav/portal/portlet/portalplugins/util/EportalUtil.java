package com.bkav.portal.portlet.portalplugins.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.portalplugins.model.ePortals;
import com.bkav.portal.portlet.portalplugins.service.ePortalsLocalServiceUtil;
import com.liferay.portal.kernel.util.StringPool;


public class EportalUtil {
	public static String getEportalNameById (long eportalId)
	{
		try {
			ePortals eportal = ePortalsLocalServiceUtil.fetchePortals(eportalId);
			
			if (eportal!=null)
			{
				return eportal.getEportalName();
			}
			else
			{
				return "Tất cả";
			}
			
		}
		catch (Exception e)
		{
			_log.error(e);
			return StringPool.BLANK;
		}
	}
	
	private static Log _log = LogFactory.getLog(EportalUtil.class);
}
