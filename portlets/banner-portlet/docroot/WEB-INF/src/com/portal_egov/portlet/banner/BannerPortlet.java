package com.portal_egov.portlet.banner;

import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.banner.model.Banner;
import com.portal_egov.portlet.banner.permission.BannerPermission;
import com.portal_egov.portlet.banner.service.BannerLocalServiceUtil;
import com.portal_egov.portlet.banner.util.BannerUtil;

/**
 * Portlet implementation class BannerPortlet
 */
public class BannerPortlet extends MVCPortlet {
 
	public void updateBanner(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			long bannerId = ParamUtil.getLong(uploadRequest, "bannerId",0L);
			
			long bannerGroupId = ParamUtil.getLong(uploadRequest, "bannerGroupId",0L);
			
			String bannerTitle = ParamUtil.getString(uploadRequest, "bannerTitle");
			
			String bannerLink = ParamUtil.getString(uploadRequest, "bannerLink");
			
			long bannerImageId = CounterLocalServiceUtil.increment();
			
			InputStream bannerImageStream = uploadRequest.getFileAsStream("bannerImageFile");
			
			if(bannerImageStream != null){
				
				if(bannerId > 0){
					
					Banner banner = BannerLocalServiceUtil.getBanner(bannerId);
					
					if((banner != null) && (banner.getBannerImageId() > 0)){
						
						bannerImageId = banner.getBannerImageId();
					}
				}
				
				BannerUtil.uploadBannerImage(bannerImageId, bannerImageStream);
			}
			
			String redirectURL = ParamUtil.getString(uploadRequest, "redirectURL");
			
			if(bannerId > 0){//Update banner
				
				BannerLocalServiceUtil.updateBanner(bannerId,bannerGroupId, bannerTitle, bannerLink, bannerImageId, BannerUtil.ACTIVE_BANNER_STATUS);
				
			}else{
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Banner.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {BannerPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {BannerPermission.VIEW});
				
				BannerLocalServiceUtil.addBanner(companyId, groupId, userId, userName, bannerGroupId, bannerTitle, bannerLink, bannerImageId, serviceContext);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	private static Log _log = LogFactory.getLog(BannerPortlet.class);
}
