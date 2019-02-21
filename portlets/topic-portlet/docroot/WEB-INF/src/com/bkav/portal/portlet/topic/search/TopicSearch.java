package com.bkav.portal.portlet.topic.search;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.bkav.portal.portlet.topic.model.Topic;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class TopicSearch  extends SearchContainer<Topic> {
public static final String EMPTY_RESULTS_MESSAGE = "no-topic-found";
	
	public TopicSearch(PortletRequest portletRequest,PortletURL iteratorURL){
		
		super(portletRequest, new TopicDisplayTerms(portletRequest), new TopicSearchTerms(portletRequest), 
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

		TopicDisplayTerms displayTerms = (TopicDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(TopicDisplayTerms.TOPIC_NAME, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(TOPIC_ADMIN_PORTLET_NAMESPACE, "order-by-col", orderByCol);
				preferences.setValue(TOPIC_ADMIN_PORTLET_NAMESPACE, "order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(TOPIC_ADMIN_PORTLET_NAMESPACE, "order-by-col", "modified-date");
				orderByType = preferences.getValue(TOPIC_ADMIN_PORTLET_NAMESPACE, "order-by-col", "desc");
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
			
			//return new VideoUserNameComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "create-date")){
			
			//return new VideoCreateDateComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "modified-date")){
			
			//return new VideoModifiedDateComparator(ascending);
		}

		return null;
	}
	
	private static Log _log = LogFactoryUtil.getLog(TopicSearch.class);
	
	private static final String TOPIC_ADMIN_PORTLET_NAMESPACE = "_topicadmin_WAR_topicportlet";
}
