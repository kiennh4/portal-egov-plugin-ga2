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
import com.portal_egov.portlet.contacts.model.ContactsDepartment;
import com.portal_egov.portlet.contacts.model.impl.ContactsDepartmentImpl;


public class ContactsDepartmentFinderImpl extends BasePersistenceImpl<ContactsDepartment> implements ContactsDepartmentFinder{

	public List<ContactsDepartment> findByKeyword(long groupId,long parentId,String keyword,int departmentStatus,int start,int end){
		
		Session session = null;

		try{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
		    
			if(groupId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (contactsdepartment.groupId = ?)", StringPool.BLANK);
			}
		    
			if(parentId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (contactsdepartment.parentId = ?)", StringPool.BLANK);
			}
		    
			if(departmentStatus < 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (contactsdepartment.departmentStatus = ?)", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("ContactsDepartment", ContactsDepartmentImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(parentId > 0){
		    	 queryPost.add(parentId);
		    }		   		    		    		    
		    
		    if(departmentStatus >= 0){
		    	 queryPost.add(departmentStatus);
		    }
		    
		    if(start >= 0 && end >= 0){
		    	
		    	return (List<ContactsDepartment>) QueryUtil.list(query, getDialect(), start, end);
		    
		    }else{
		    	
		    	return (List<ContactsDepartment>) query.list();
		    }
		}catch (Exception e){
		    e.printStackTrace();
		    return Collections.emptyList();
		}finally{
		    closeSession(session);
		}
	}

	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.portal_egov.portlet.contacts.service.persistence.ContactsDepartmentFinder.findByKeyword";
}
