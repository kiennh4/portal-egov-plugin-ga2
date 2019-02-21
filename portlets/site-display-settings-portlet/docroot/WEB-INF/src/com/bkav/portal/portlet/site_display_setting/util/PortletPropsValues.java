
package com.bkav.portal.portlet.site_display_setting.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

public class PortletPropsValues
{
	public static final String[] SITE_BANNER_EXTENSIONS = PortletProps.getArray(PortletPropsKeys.SITE_BANNER_EXTENSIONS);

	public static final long SITE_BANNER_MAX_SIZE = GetterUtil.getLong(PortletProps.get(PortletPropsKeys.SITE_BANNER_MAX_SIZE));
}
