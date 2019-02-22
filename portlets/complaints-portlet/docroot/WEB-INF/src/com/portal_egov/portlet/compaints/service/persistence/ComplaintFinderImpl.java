/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.compaints.service.persistence;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.portal_egov.portlet.compaints.model.Complaint;
import com.portal_egov.portlet.compaints.model.impl.ComplaintImpl;


public class ComplaintFinderImpl extends BasePersistenceImpl<Complaint> implements ComplaintFinder{

	public List<Complaint> findByKeyword(long groupId,String keyword,int status,int start,int end,OrderByComparator obc){
		
		if(groupId > 0){
			
			Session session = null;

			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
			    
			    if(status < 0){
			    	
			    	sqlStr = StringUtil.replace(sqlStr, "AND Complaint.complaintStatus = ?", StringPool.BLANK);
			    }
			    
				sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("Complaint", ComplaintImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);
			    
			    queryPost.add(groupId);
			    
			    if(status >= 0){
			    	
			    	queryPost.add(status);
			    }
			    
			    queryPost.add("%" + keyword.toUpperCase() + "%");
			    queryPost.add("%" + keyword.toUpperCase() + "%");
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<Complaint>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<Complaint>) query.list();
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
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.portal_egov.portlet.compaints.service.persistence.ComplaintFinder.findByKeyword";
	
}
