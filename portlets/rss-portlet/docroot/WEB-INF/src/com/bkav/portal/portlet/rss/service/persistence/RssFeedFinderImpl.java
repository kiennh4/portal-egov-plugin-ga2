/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.bkav.portal.portlet.rss.service.persistence;

import java.util.Collections;
import java.util.List;

import com.bkav.portal.portlet.rss.model.RssFeed;
import com.bkav.portal.portlet.rss.model.impl.RssFeedImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class RssFeedFinderImpl extends BasePersistenceImpl<RssFeed> implements RssFeedFinder{

	@SuppressWarnings("unchecked")
	public List<RssFeed> findByKeyword(long groupId,String keyword,int start,int end){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(SQL_STR_ID);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("RssFeed", RssFeedImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add("%" + keyword + "%");
			    queryPost.add("%" + keyword + "%");
			    queryPost.add(groupId);
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<RssFeed>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<RssFeed>) query.list();
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
	
	private static final String SQL_STR_ID = "com.bkav.portal.portlet.rss.service.persistence.RssFeedFinder.findByKeyword";
	
}
