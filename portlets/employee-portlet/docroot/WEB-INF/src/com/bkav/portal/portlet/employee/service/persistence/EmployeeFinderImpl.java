package com.bkav.portal.portlet.employee.service.persistence;

import java.util.Collections;
import java.util.List;

import com.bkav.portal.portlet.employee.model.Employee;
import com.bkav.portal.portlet.employee.model.impl.EmployeeImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class EmployeeFinderImpl extends BasePersistenceImpl<Employee> implements EmployeeFinder{

public List<Employee> findByKeyword(long groupId, long depId, long postId, String keyword,int start,
		int end,  OrderByComparator obc, String check, String createDate, String endDate, String checkEndDate){
		
		if(groupId > 0){
			
			Session session = null;

			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
			    
				if(depId <= 0L){
					sqlStr = StringUtil.replace(sqlStr, "AND (Employee.depId = ?)", StringPool.BLANK);
				}
				
				if(postId <= 0L){
					sqlStr = StringUtil.replace(sqlStr, "AND (Employee.postId = ?)", StringPool.BLANK);
				}
				
				if(check == "false"){
					sqlStr = StringUtil.replace(sqlStr, "AND (Employee.createDate BETWEEN ? AND ?)", StringPool.BLANK);
				}
				
				if(checkEndDate == ""){
					sqlStr = StringUtil.replace(sqlStr, "AND (Employee.endDate BETWEEN ? AND ?)", StringPool.BLANK);
				}
				
				sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("Employee", EmployeeImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);
			    
			    queryPost.add("%" + keyword + "%");
			    
			    queryPost.add(groupId);
			    
			    if(depId > 0){
			    	 queryPost.add(depId);
			    }
			    
			    if(postId > 0){
			    	 queryPost.add(postId);
			    }
			    
			    if(check == "true"){
			    	queryPost.add(createDate);
			    	queryPost.add(endDate);
			    }
			    
			    if(checkEndDate != ""){
			    	queryPost.add(createDate);
			    	queryPost.add(endDate);
			    }
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<Employee>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<Employee>) query.list();
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
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.bkav.portal.portlet.employee.service.persistence.EmployeeFinder.findByKeyword";
}