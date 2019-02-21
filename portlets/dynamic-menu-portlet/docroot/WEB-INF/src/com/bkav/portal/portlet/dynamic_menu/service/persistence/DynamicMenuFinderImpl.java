/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.bkav.portal.portlet.dynamic_menu.service.persistence;

import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu;
import com.bkav.portal.portlet.dynamic_menu.model.impl.DynamicMenuImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class DynamicMenuFinderImpl extends BasePersistenceImpl<DynamicMenu> implements DynamicMenuFinder{

	@SuppressWarnings("unchecked")
	public List<DynamicMenu> findByKeyword(long groupId,String keyword,int start,int end){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KW_SQL_STR_ID);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("DynamicMenu", DynamicMenuImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add("%" + keyword + "%");
			    queryPost.add(groupId);
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<DynamicMenu>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<DynamicMenu>) query.list();
			    }
			}catch (Exception e){
				_log.error(e);
			    return Collections.emptyList();
			}finally{
			    closeSession(session);
			}
		}else{
			return Collections.emptyList();
		}
	}
	
	private  Log _log = LogFactory.getLog(DynamicMenuFinderImpl.class);
	
	private static final String FIND_BY_KW_SQL_STR_ID = 
					"com.bkav.portal.portlet.dynamic_menu.service.persistence.DynamicMenuFinder.findByKeyword";
}
