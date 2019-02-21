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

import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem;
import com.bkav.portal.portlet.dynamic_menu.model.impl.DynamicMenuItemImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class DynamicMenuItemFinderImpl extends BasePersistenceImpl<DynamicMenuItem> implements DynamicMenuItemFinder{

	@SuppressWarnings("unchecked")
	public List<DynamicMenuItem> filterMenuItemList(long groupId,long filterItemId){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FILTER_ITEM_SQL_STR_ID);
			    
				if(filterItemId <= 0L){
					sqlStr = StringUtil.replace(sqlStr, "AND DynamicMenuItem.itemId <> ?", StringPool.BLANK);
				}
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("DynamicMenuItem", DynamicMenuItemImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);
			    
			    queryPost.add(groupId);
			    
			    if(filterItemId > 0){
			    	queryPost.add(filterItemId);
			    }
			    
		    	return (List<DynamicMenuItem>) query.list();
		    	
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
	
	private  Log _log = LogFactory.getLog(DynamicMenuItemFinderImpl.class);
	
	private static final String FILTER_ITEM_SQL_STR_ID = 
					"com.bkav.portal.portlet.dynamic_menu.service.persistence.DynamicMenuFinder.filterMenuItemList";
	
}
