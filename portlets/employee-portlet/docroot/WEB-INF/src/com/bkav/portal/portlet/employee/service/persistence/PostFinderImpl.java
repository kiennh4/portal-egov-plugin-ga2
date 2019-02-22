package com.bkav.portal.portlet.employee.service.persistence;

import java.util.Collections;
import java.util.List;

import com.bkav.portal.portlet.employee.model.Post;
import com.bkav.portal.portlet.employee.model.impl.PostImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class PostFinderImpl extends BasePersistenceImpl<Post> implements PostFinder{

	public List<Post> findByKeyword(long groupId,String keyword,int start,int end){
		
		Session session = null;

		try{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
		    
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (Post.groupId = ?)", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("Product", PostImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(start >= 0 && end >= 0){
		    	
		    	return (List<Post>) QueryUtil.list(query, getDialect(), start, end);
		    
		    }else{
		    	
		    	return (List<Post>) query.list();
		    }
		}catch (Exception e){
			e.printStackTrace();
		    return Collections.emptyList();
		}finally{
		    closeSession(session);
		}
	}
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.bkav.portal.portlet.employee.service.persistence.PostFinder.findByKeyword";
}