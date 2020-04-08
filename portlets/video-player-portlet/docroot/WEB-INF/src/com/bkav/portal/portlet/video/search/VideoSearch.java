/**
 * @author HUNGDX
 * @time 10:33:32 AM
 * @project weblinks-portlet
 */
package com.bkav.portal.portlet.video.search;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.bkav.portal.portlet.video.comparator.VideoCreateDateComparator;
import com.bkav.portal.portlet.video.comparator.VideoModifiedDateComparator;
import com.bkav.portal.portlet.video.comparator.VideoUserNameComparator;
import com.bkav.portal.portlet.video.model.VideoEntry;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;


public class VideoSearch extends SearchContainer<VideoEntry>{
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-entry-found";
	
	public VideoSearch(PortletRequest portletRequest,PortletURL iteratorURL){
		
		super(portletRequest, new VideoDisplayTerms(portletRequest), new VideoSearchTerms(portletRequest), 
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

		VideoDisplayTerms displayTerms = (VideoDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(VideoDisplayTerms.VIDEO_NAME, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(VIDEO_ADMIN_PORTLET_NAMESPACE, "order-by-col", orderByCol);
				preferences.setValue(VIDEO_ADMIN_PORTLET_NAMESPACE, "order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(VIDEO_ADMIN_PORTLET_NAMESPACE, "order-by-col", "modified-date");
				orderByType = preferences.getValue(VIDEO_ADMIN_PORTLET_NAMESPACE, "order-by-col", "desc");
			}

			OrderByComparator orderByComparator = getOrderByComparator(orderByCol, orderByType);

			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	protected static OrderByComparator getOrderByComparator(String orderByColumn, String orderByType) {

		if (Validator.isNull(orderByColumn) || Validator.isNull(orderByType)) {
			return null;
		}

		boolean ascending = false;

		if (orderByType.equals("asc")) {
			ascending = true;
		}
		
		if(Validator.equals(orderByColumn, "user-name")){
			
			return new VideoUserNameComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "create-date")){
			
			return new VideoCreateDateComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "modified-date")){
			
			return new VideoModifiedDateComparator(ascending);
		}

		return null;
	}
	
	private static Log _log = LogFactoryUtil.getLog(VideoSearch.class);
	
	private static final String VIDEO_ADMIN_PORTLET_NAMESPACE = "_videoadmin_WAR_videoplayerportlet";
}
