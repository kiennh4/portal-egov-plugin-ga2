package com.bkav.portal.portlet.topic.service.persistence;

import java.util.Collections;
import java.util.List;

import com.bkav.portal.portlet.topic.model.Topic;
import com.bkav.portal.portlet.topic.model.impl.TopicImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class TopicFinderImpl extends BasePersistenceImpl<Topic> implements TopicFinder {
	@SuppressWarnings("unchecked")
	public List<Topic> findByTopicName (long groupId, String topicName ,int start,int end,OrderByComparator obc)
	{
			if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
				
				sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("Topic", TopicImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add("%" + topicName + "%");
			    queryPost.add(groupId);
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<Topic>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<Topic>) query.list();
			    }
			}catch (Exception e){
				e.printStackTrace();
			    return Collections.emptyList();
			}finally{
			    closeSession(session);
			}
		}else{
			
			return Collections.emptyList();
		}
	}
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.bkav.portal.portlet.topic.service.persistence.TopicFinder.findByKeyword";
}
