/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.bkav.portal.portlet.video.service.persistence;

import java.util.Collections;
import java.util.List;

import com.bkav.portal.portlet.video.model.VideoEntry;
import com.bkav.portal.portlet.video.model.impl.VideoEntryImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class VideoEntryFinderImpl extends BasePersistenceImpl<VideoEntry> implements VideoEntryFinder{

	@SuppressWarnings("unchecked")
	public List<VideoEntry> findByKeyword(long groupId,String keyword,int start,int end){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(SQL_STR_ID);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("VideoEntry", VideoEntryImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add("%" + keyword + "%");
			    queryPost.add("%" + keyword + "%");
			    queryPost.add(groupId);
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<VideoEntry>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<VideoEntry>) query.list();
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
	
	@SuppressWarnings("unchecked")
	public List<VideoEntry> findByCategoryId (long groupId, long categoryId,int start,int end){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(SQL_STR_CATE);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("VideoEntry", VideoEntryImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add(categoryId);
			    queryPost.add(groupId);
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<VideoEntry>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<VideoEntry>) query.list();
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
	
	private static final String SQL_STR_CATE = "com.bkav.portal.portlet.video.service.persistence.VideoEntryFinder.findByCategoryId";
	
	private static final String SQL_STR_ID = "com.bkav.portal.portlet.video.service.persistence.VideoEntryFinder.findByKeyword";
	
}
