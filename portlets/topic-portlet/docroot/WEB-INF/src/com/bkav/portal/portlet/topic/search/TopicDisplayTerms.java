package com.bkav.portal.portlet.topic.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class TopicDisplayTerms extends DisplayTerms {
	public static final String TOPIC_NAME = "topicName";
	/**
	 * @param portletRequest
	 */
	public TopicDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		topicName = ParamUtil.getString(portletRequest, TOPIC_NAME);
	}

	public String getName() {

		return topicName;
	}
	
	protected String topicName;
}
