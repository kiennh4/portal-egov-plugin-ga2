package com.bkav.portal.portlet.topic.admin;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.topic.permission.AdminTopicPermission;
import com.bkav.portal.portlet.topic.service.TopicLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class TopicAdmin
 */
public class TopicAdmin extends MVCPortlet {
 
	public void updateTopic (ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try {
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(TopicAdmin.class.getName(), actionRequest);
			
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "admin");
			
			long topicId = ParamUtil.getLong(actionRequest, "topicId");
			String topicName = ParamUtil.getString(actionRequest, "topicName");
			String categoryIds = ParamUtil.getString(actionRequest, "categoryIds");
			
			//String categoryIds = "";
			/*
			if ((Validator.isNotNull(categoryArray))&&(categoryArray.length>0))
			{
				for (int i = 0; i < categoryArray.length;i++)
				{
					categoryIds += categoryArray[i];
				}
			}
			*/
			if ((Validator.isNotNull(topicId))&&(topicId>0))
			{
				serviceContext.setGroupPermissions(new String[] {AdminTopicPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {AdminTopicPermission.VIEW});
				TopicLocalServiceUtil.updateTopic(topicId, groupId, companyId, userId, userName, categoryIds, topicName, serviceContext);
			}
			else
			{
				serviceContext.setGroupPermissions(new String[] {AdminTopicPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {AdminTopicPermission.VIEW});
				
				TopicLocalServiceUtil.addTopic(groupId, companyId, userId, userName, categoryIds, topicName, serviceContext);
			}
			
			SessionMessages.add(actionRequest, "topic-update-successfully");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
			
		}
		catch (Exception e)
		{
			_log.error(e);
			SessionErrors.add(actionRequest, "update-failed");
		}
	}
	
	public void deleteTopic (ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try {
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			long topicId = ParamUtil.getLong(actionRequest, "topicId");
			if ((Validator.isNotNull(topicId))&&(topicId>0))
			{
				TopicLocalServiceUtil.deleteTopic(topicId);
			}
			
			SessionMessages.add(actionRequest, "topic-update-successfully");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e)
		{
			_log.error(e);
			SessionErrors.add(actionRequest, "update-failed");
		}
	}
	
	private static Log _log = LogFactory.getLog(TopicAdmin.class);
	
}
