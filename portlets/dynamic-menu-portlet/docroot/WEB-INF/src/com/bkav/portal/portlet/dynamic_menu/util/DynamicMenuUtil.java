package com.bkav.portal.portlet.dynamic_menu.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;


public class DynamicMenuUtil {

	public static String getMenuItemURL(ThemeDisplay themeDisplay, String urlType,String url){
		try {
			
			if(Validator.isNotNull(url)){
				
				if(Validator.equals(urlType, INTERNAL_URL_TYPE)){
					
					String portalURL = themeDisplay.getPortalURL();
					
					if(!StringUtil.startsWith(url, StringPool.SLASH)){
						
						url = StringPool.SLASH + url;
					}
					
					return portalURL + url;
				}
			}else{
				
				return DEFAULT_HREF_URL;
			}
			
			return url;
		}
		catch (Exception e) {
			_log.error(e);
			return url;
		}
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(DynamicMenuUtil.class);
	
	public static final String INTERNAL_URL_TYPE ="internal";
	public static final String EXTERNAL_URL_TYPE ="external";
	
	private static final String DEFAULT_HREF_URL = "javascript:;";
}
