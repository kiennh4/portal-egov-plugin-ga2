/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.contacts.service.persistence;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty;
import com.portal_egov.portlet.contacts.model.impl.ContactsDepartmentPropertyImpl;


public class ContactsDepartmentPropertyFinderImpl extends BasePersistenceImpl<ContactsDepartmentProperty> implements ContactsDepartmentPropertyFinder{

	public List<ContactsDepartmentProperty> findByPropertyKey(long groupId,long departmentId,String propertyKey){
		
		Session session = null;

		try{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_PROPERTY_KEY_SQL_STR_ID);
		    
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (contactsdepartmentproperty.groupId = ?)", StringPool.BLANK);
			}
		    
			if(departmentId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (contactsdepartmentproperty.departmentId = ?)", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("ContactsDepartmentProperty", ContactsDepartmentPropertyImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add(propertyKey);
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(departmentId > 0){
		    	 queryPost.add(departmentId);
		    }		   		    		    		    
		    	
		    return (List<ContactsDepartmentProperty>) query.list();
		    
		}catch (Exception e){
		    e.printStackTrace();
		    return Collections.emptyList();
		}finally{
		    closeSession(session);
		}
	}

	
	private static final String FIND_BY_PROPERTY_KEY_SQL_STR_ID = 
					"com.portal_egov.portlet.contacts.service.persistence.ContactsDepartmentPropertyFinder.findByPropertyKey";
	
}
