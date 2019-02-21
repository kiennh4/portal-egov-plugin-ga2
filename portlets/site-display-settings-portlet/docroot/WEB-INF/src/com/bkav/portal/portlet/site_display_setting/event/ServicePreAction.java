
package com.bkav.portal.portlet.site_display_setting.event;

import java.util.HashMap;
import java.util.Map;

import com.bkav.portal.portlet.site_display_setting.util.SiteSettingUtil;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HuyMQ
 */
public class ServicePreAction extends Action
{
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			long groupId = PortalUtil.getScopeGroupId(request);
			
			LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, false);
			
			Map<String, String> vars = new HashMap<String, String>();

			//header
			long bannerImageId = SiteSettingUtil.getBannerImageId(layoutSet.getLayoutSetId());
			
			String bannerImageUrl = "";
			
			String bannerMimeType = "";
			
			boolean isFlashBanner = false;
			
			if (bannerImageId>0)
			{
				bannerImageUrl = SiteSettingUtil.getImageBannerFilePath(request, bannerImageId);
			
				bannerMimeType = SiteSettingUtil.getImageBannerMimeType(request, bannerImageId);
				
				isFlashBanner = bannerMimeType.toLowerCase().equals("swf");
			}
			
			vars.put("isFlashBanner", String.valueOf(isFlashBanner));
			
			vars.put("bannerImageId", String.valueOf(bannerImageId));
			
			vars.put("bannerImageUrl", bannerImageUrl);
			
			// footer
			String footerContent = SiteSettingUtil.getFooterContent(layoutSet.getLayoutSetId());

			vars.put("footerContent", footerContent);
			
			String sloganContent = SiteSettingUtil.getSloganContent(layoutSet.getLayoutSetId());
			
			vars.put("sloganContent", sloganContent);
			// Link edit banner, footer,slogan
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long plid = themeDisplay.getLayout().getPlid();
			
			String redirectURL = PortalUtil.getCurrentURL(request);
			
			PortletURL editBannerURL = PortletURLFactoryUtil.create(
				request, _PORTLET_ID, plid, ActionRequest.RESOURCE_PHASE);
			editBannerURL.setWindowState(LiferayWindowState.POP_UP);
			editBannerURL.setParameter("jspPage", "/html/view/sections/header.jsp");
			editBannerURL.setParameter("redirectURL", redirectURL);
			
			vars.put("editBannerURL", editBannerURL.toString());
			
			PortletURL editFooterURL = PortletURLFactoryUtil.create(
				request, _PORTLET_ID, plid, ActionRequest.RESOURCE_PHASE);
			editFooterURL.setWindowState(LiferayWindowState.POP_UP);
			editFooterURL.setParameter("jspPage", "/html/view/sections/footer.jsp");
			editFooterURL.setParameter("redirectURL", redirectURL);
			
			vars.put("editFooterURL", editFooterURL.toString());
			
			PortletURL editSloganURL = PortletURLFactoryUtil
					.create(request, _PORTLET_ID, plid, ActionRequest.RENDER_PHASE);
			editSloganURL.setWindowState(LiferayWindowState.POP_UP);
			editSloganURL.setParameter("jspPage", "/html/view/sections/footer.jsp");
			editSloganURL.setParameter("redirectURL", redirectURL);
			
			vars.put("editSloganURL", editSloganURL.toString());
			request.setAttribute(WebKeys.VM_VARIABLES, vars);
			
		}
		catch (Exception e)
		{
			_log.error(e, e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(ServicePreAction.class);
	
	private static final String _PORTLET_ID = "site_display_settings_WAR_sitedisplaysettingsportlet";
}
