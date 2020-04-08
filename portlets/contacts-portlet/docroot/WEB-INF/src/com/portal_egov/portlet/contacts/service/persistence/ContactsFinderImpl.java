/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.contacts.service.persistence;

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
import com.portal_egov.portlet.contacts.model.Contacts;
import com.portal_egov.portlet.contacts.model.impl.ContactsImpl;


public class ContactsFinderImpl extends BasePersistenceImpl<Contacts> implements ContactsFinder{

	public List<Contacts> findByKeyword(long groupId,String keyword,int contactStatus,int start,int end){
		
		Session session = null;

		try{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
		    
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (contacts.groupId = ?)", StringPool.BLANK);
			}
		    
			if(contactStatus < 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (contacts.contactStatus = ?)", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("Contacts", ContactsImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(contactStatus >= 0){
		    	 queryPost.add(contactStatus);
		    }		   		    		    		    
		    
		    if(start >= 0 && end >= 0){
		    	
		    	return (List<Contacts>) QueryUtil.list(query, getDialect(), start, end);
		    
		    }else{
		    	
		    	return (List<Contacts>) query.list();
		    }
		}catch (Exception e){
		    e.printStackTrace();
		    return Collections.emptyList();
		}finally{
		    closeSession(session);
		}
	}
	

	public List<Contacts> findByKeywordAndDepartment(long groupId,long departmentId,String keyword,int contactStatus,int start,int end){
		
		Session session = null;

		try{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_AND_DEPARTMENT_SQL_STR_ID);
		    
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (contacts.groupId = ?)", StringPool.BLANK);
			}
		    
			if(contactStatus < 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (contacts.contactStatus = ?)", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("Contacts", ContactsImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(contactStatus >= 0){
		    	 queryPost.add(contactStatus);
		    }		   		    		    		    
		    
		    if(start >= 0 && end >= 0){
		    	
		    	return (List<Contacts>) QueryUtil.list(query, getDialect(), start, end);
		    
		    }else{
		    	
		    	return (List<Contacts>) query.list();
		    }
		}catch (Exception e){
		    e.printStackTrace();
		    return Collections.emptyList();
		}finally{
		    closeSession(session);
		}
	}
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.portal_egov.portlet.contacts.service.persistence.ContactsFinder.findByKeyword";
	
	private static final String FIND_BY_KEYWORD_AND_DEPARTMENT_SQL_STR_ID = 
					"com.portal_egov.portlet.contacts.service.persistence.ContactsFinder.findByKeywordAndDepartment";
}
