package com.bkav.portal.portlet.portalplugins.util;

import com.liferay.portal.kernel.util.StringPool;

public class PortalPluginConstant {
	public static final String[] PLUGIN_TYPE = {"Portlet","Hook","Ext","Layout","Theme"};
	
	public static final String[] PLUGIN_FILE_TYPE = {"war","sign"};
	
	public static String typeByIndex (int index)
	{
		if ((index > PLUGIN_TYPE.length)||(index < 0))
			return StringPool.BLANK;
		else
			return PLUGIN_TYPE[index];
	}
}
