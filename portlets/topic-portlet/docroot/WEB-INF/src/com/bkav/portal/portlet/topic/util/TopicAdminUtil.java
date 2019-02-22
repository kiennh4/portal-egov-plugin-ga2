package com.bkav.portal.portlet.topic.util;


import com.bkav.portal.portlet.topic.model.Topic;
import com.bkav.portal.portlet.topic.service.TopicLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

public class TopicAdminUtil {
	
	public String[] getCategoryArrayId (long topicId) throws Exception
	{
		
		Topic topic = TopicLocalServiceUtil.getTopic(topicId);
		
		if (Validator.isNotNull(topic))
		{
			String categoryIdsStr = topic.getCategoryIds();
			
			String[] categoryArrayId = categoryIdsStr.split(",");
			
			return categoryArrayId;
		}
		else
			return null;
		
	}
	
}
