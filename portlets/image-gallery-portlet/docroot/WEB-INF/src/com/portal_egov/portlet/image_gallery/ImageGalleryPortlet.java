package com.portal_egov.portlet.image_gallery;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ImageGalleryPortlet
 */
public class ImageGalleryPortlet extends MVCPortlet {
 

	public void addImageFolder(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long parentFolderId = ParamUtil.getLong(actionRequest, "parentFolderId");
			
			String redirect = ParamUtil.getString(actionRequest, "redirect");
			
			_log.info(parentFolderId);
			
			actionResponse.sendRedirect(redirect);
			
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	Log _log = LogFactoryUtil.getLog(ImageGalleryPortlet.class.getName());
}
