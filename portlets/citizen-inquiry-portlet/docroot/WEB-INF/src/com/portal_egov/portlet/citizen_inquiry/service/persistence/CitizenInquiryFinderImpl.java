/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.citizen_inquiry.service.persistence;

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
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;
import com.portal_egov.portlet.citizen_inquiry.model.impl.CitizenInquiryImpl;


public class CitizenInquiryFinderImpl extends BasePersistenceImpl<CitizenInquiry> implements CitizenInquiryFinder{

	public List<CitizenInquiry> findByKeyword(long groupId,long categoryId,String keyword,int start,int end,boolean allInquiry,OrderByComparator obc){
		
		if(groupId > 0){
			
			Session session = null;

			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
			    
				if(allInquiry){
					sqlStr = StringUtil.replace(sqlStr, "AND CitizenInquiry.approved = 1", StringPool.BLANK);
				}
				
				if(categoryId <= 0L){
					sqlStr = StringUtil.replace(sqlStr, "AND (CitizenInquiry.categoryId = ?)", StringPool.BLANK);
				}
				
				sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("CitizenInquiry", CitizenInquiryImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);
			    
			    queryPost.add(groupId);
			    
			    if(categoryId > 0){
			    	 queryPost.add(categoryId);
			    }
			    
			    queryPost.add("%" + keyword.toUpperCase() + "%");
			    queryPost.add("%" + keyword.toUpperCase() + "%");
			    queryPost.add("%" + keyword.toUpperCase() + "%");
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<CitizenInquiry>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<CitizenInquiry>) query.list();
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
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.portal_egov.portlet.citizen_inquiry.service.persistence.CitizenInquiryFinder.findByKeyword";
	
}
