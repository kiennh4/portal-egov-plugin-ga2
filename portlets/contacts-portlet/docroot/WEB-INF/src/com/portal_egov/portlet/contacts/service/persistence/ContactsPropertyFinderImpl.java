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
import com.portal_egov.portlet.contacts.model.ContactsProperty;
import com.portal_egov.portlet.contacts.model.impl.ContactsPropertyImpl;


public class ContactsPropertyFinderImpl extends BasePersistenceImpl<ContactsProperty> implements ContactsPropertyFinder{

	public List<ContactsProperty> findByPropertyKey(long groupId,long contactId,String propertyKey){
		
		Session session = null;

		try{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_PROPERTY_KEY_SQL_STR_ID);
		    
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (contactsproperty.groupId = ?)", StringPool.BLANK);
			}
		    
			if(contactId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (contactsproperty.contactId = ?)", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("ContactsProperty", ContactsPropertyImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add(propertyKey);
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(contactId > 0){
		    	 queryPost.add(contactId);
		    }	
		    
		    return (List<ContactsProperty>) query.list();
		}catch (Exception e){
		    e.printStackTrace();
		    return Collections.emptyList();
		}finally{
		    closeSession(session);
		}
	}

	
	private static final String FIND_BY_PROPERTY_KEY_SQL_STR_ID = "com.portal_egov.portlet.contacts.service.persistence.ContactsPropertyFinder.findByPropertyKey";
	
}
