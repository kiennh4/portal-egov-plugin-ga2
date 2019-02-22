package com.portal_egov.portlet.ykct.service.persistence;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.portal_egov.portlet.ykct.model.YKCT_Category;
import com.portal_egov.portlet.ykct.model.YKCT_Entry;
import com.portal_egov.portlet.ykct.model.impl.YKCT_CategoryImpl;
import com.portal_egov.portlet.ykct.model.impl.YKCT_EntryImpl;

public class YKCT_EntryFinderImpl extends BasePersistenceImpl<YKCT_Entry> implements YKCT_EntryFinder{
	
	@SuppressWarnings("unchecked")
	public List<YKCT_Entry> findByKeyword(long groupId,String keyword,int start,int end){
				
		Session session = null;

		try
		{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD);
		    
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (ykct_entry.groupId = ?)", StringPool.BLANK);
			}
			
			if(start < 0 || end < 0){
				sqlStr = StringUtil.replace(sqlStr, "LIMIT ?,?", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("YKCT_Entry", YKCT_EntryImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword.toUpperCase() + "%");
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(start >=0 && end >= 0){
		    	
			    queryPost.add(start);
			    queryPost.add(end);
		    }
		    
		    return (List<YKCT_Entry>) query.list();
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		    return Collections.emptyList();
		}
		finally
		{
		    closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<YKCT_Entry> findByMultiCondition(long groupId,String keyword, long categoryId, int start,int end){
				
		Session session = null;

		try{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_MULTI_CONDITION);
		    
		    if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (YKCT_Entry.groupId = ?)", StringPool.BLANK);
			}
		    
		    if(categoryId <= 0){
		    	sqlStr = StringUtil.replace(sqlStr, "AND (YKCT_Entry.categoryId = ?)", StringPool.BLANK);
		    }
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("YKCT_Entry", YKCT_EntryImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    queryPost.add("%" + keyword.toUpperCase() + "%");
		    
		    if(categoryId > 0){
		    	queryPost.add(categoryId);
		    }
		    
		    if(start >= 0 && end >= 0){
		    	
		    	return (List<YKCT_Entry>) QueryUtil.list(query, getDialect(), start, end);
		    
		    }else{
		    	
		    	return (List<YKCT_Entry>) query.list();
		    }
		}catch (Exception e){
			e.printStackTrace();
		    return Collections.emptyList();
		}finally{
		    closeSession(session);
		}
	}
	
	private static final String FIND_BY_KEYWORD = "com.portal_egov.portlet.ykct.service.persistence.YKCT_EntryFinder.findByKeyword";
	private static final String FIND_BY_MULTI_CONDITION = "com.portal_egov.portlet.ykct.service.persistence.YKCT_EntryFinder.findByMultiCondition";

}
