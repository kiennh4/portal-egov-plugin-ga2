package com.bkav.portal.portlet.rss;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.rss.service.RssFeedLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class RSSAdminPortlet
 */
public class RSSAdminPortlet extends MVCPortlet {
 

	public void updateRssFeed(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			long feedId = ParamUtil.getLong(actionRequest, "feedId");
			
			String name = ParamUtil.getString(actionRequest, "name");
			
			String url = ParamUtil.getString(actionRequest, "url");
			
			String description = ParamUtil.getString(actionRequest, "description");
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			if(feedId >0){
				
				RssFeedLocalServiceUtil.updateFeed(feedId, companyId, groupId,
						userId, userName, name, url, description, DEFAULT_RSS_FEED_STATUS, serviceContext);
			}else{
				
				RssFeedLocalServiceUtil.addFeed(companyId, groupId, userId, userName,
						name, url, description, DEFAULT_RSS_FEED_STATUS, serviceContext);
			}
			
		}catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteRssFeed(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long feedId = ParamUtil.getLong(actionRequest, "feedId");
			
			if(feedId >0){
				
				RssFeedLocalServiceUtil.deleteRssFeed(feedId);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private  Log _log = LogFactory.getLog(RSSAdminPortlet.class);
	
	private static final int DEFAULT_RSS_FEED_STATUS = 0;
}
