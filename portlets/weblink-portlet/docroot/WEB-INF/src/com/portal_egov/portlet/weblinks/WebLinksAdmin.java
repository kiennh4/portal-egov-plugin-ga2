package com.portal_egov.portlet.weblinks;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.weblinks.model.Weblink;
import com.portal_egov.portlet.weblinks.model.WeblinkCategory;
import com.portal_egov.portlet.weblinks.permission.WeblinkCategoryPermission;
import com.portal_egov.portlet.weblinks.permission.WeblinkPermission;
import com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalServiceUtil;
import com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil;

/**
 * Portlet implementation class WebLinksAdmin
 */
public class WebLinksAdmin extends MVCPortlet {
 

	public void updateWeblinkCategory(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			String weblinkCategoryName = ParamUtil.getString(actionRequest, "weblinkCategoryName");
			
			String weblinkCategoryDesc = ParamUtil.getString(actionRequest, "weblinkCategoryDesc");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(categoryId > 0){//Update category
				
				WeblinkCategoryLocalServiceUtil.updateCategory(companyId, groupId, userId, userName,
					categoryId, weblinkCategoryName, weblinkCategoryDesc, 0);
			}else{
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(WeblinkCategory.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {WeblinkCategoryPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {WeblinkCategoryPermission.VIEW});
				
				WeblinkCategoryLocalServiceUtil.addCategory(companyId, groupId, userId, userName, 
					weblinkCategoryName, weblinkCategoryDesc, 0, serviceContext);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	
	public void deleteWeblinkCategory(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			boolean deleteWeblinks = ParamUtil.getBoolean(actionRequest, "deleteWeblinks",false);
			
			if(categoryId > 0){
				
				WeblinkCategoryLocalServiceUtil.deleteCategory(categoryId, deleteWeblinks);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	public void updateWeblink(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			long weblinkId = ParamUtil.getLong(actionRequest, "weblinkId",0L);
			
			long weblinkCategoryId = ParamUtil.getLong(actionRequest, "weblinkCategoryId",0L);
			
			String weblinkName = ParamUtil.getString(actionRequest, "weblinkName");
			
			String weblinkURL = ParamUtil.getString(actionRequest, "weblinkURL");
			
			String weblinkDesc = ParamUtil.getString(actionRequest, "weblinkDesc");
			
			if(weblinkId > 0){//Update weblink
				
				WeblinkLocalServiceUtil.updateWeblink(companyId, groupId, userId, userName, weblinkId,
					weblinkCategoryId, weblinkName, weblinkDesc, weblinkURL, 0);
			}else{
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Weblink.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {WeblinkPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {WeblinkPermission.VIEW});
				
				WeblinkLocalServiceUtil.addWeblink(companyId, groupId, userId, userName, weblinkCategoryId, 
					weblinkName, weblinkDesc, weblinkURL, 0, serviceContext);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	public void deleteWeblink(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			
			long weblinkId = ParamUtil.getLong(actionRequest, "weblinkId",0L);
			
			if(weblinkId > 0){
				
				WeblinkLocalServiceUtil.deleteWeblink(weblinkId);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	private static Log _log = LogFactory.getLog(WebLinksAdmin.class);
}
