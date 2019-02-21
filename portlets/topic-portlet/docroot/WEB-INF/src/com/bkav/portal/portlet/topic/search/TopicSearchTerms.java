package com.bkav.portal.portlet.topic.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class TopicSearchTerms extends TopicDisplayTerms{

	/**
	 * @param portletRequest
	 */
	public TopicSearchTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		topicName = DAOParamUtil.getLike(portletRequest, TOPIC_NAME);
	}
}
