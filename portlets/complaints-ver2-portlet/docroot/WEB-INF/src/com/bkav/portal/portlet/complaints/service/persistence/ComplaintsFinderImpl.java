package com.bkav.portal.portlet.complaints.service.persistence;

import java.util.Collections;
import java.util.List;

import com.bkav.portal.portlet.complaints.model.Complaints;
import com.bkav.portal.portlet.complaints.model.impl.ComplaintsImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ComplaintsFinderImpl extends BasePersistenceImpl<Complaints> implements ComplaintsFinder{
	
	@SuppressWarnings("unchecked")
	public List<Complaints> findByKeyword(long groupId,String keyword,int start,int end,OrderByComparator obc){
		
		if(groupId > 0){
			
			Session session = null;

			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
			    
				sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("Complaint", ComplaintsImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);
			    
			    queryPost.add(groupId);
			    
			    queryPost.add("%" + keyword.toUpperCase() + "%");
			    queryPost.add("%" + keyword.toUpperCase() + "%");
			    queryPost.add("%" + keyword.toUpperCase() + "%");
			    queryPost.add("%" + keyword.toUpperCase() + "%");
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<Complaints>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<Complaints>) query.list();
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
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.bkav.portal.portlet.compaints.service.persistence.ComplaintsFinder.findByKeyword";
}
