package com.bkav.portal.portlet.portalplugins.service.persistence;

import java.util.Collections;
import java.util.List;

import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;
import com.bkav.portal.portlet.portalplugins.model.ePortals;
import com.bkav.portal.portlet.portalplugins.model.impl.PortalPluginsImpl;
import com.bkav.portal.portlet.portalplugins.model.impl.ePortalsImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ePortalsFinderImpl extends BasePersistenceImpl<ePortals> implements ePortalsFinder {
	
	@SuppressWarnings("unchecked")
	public List<ePortals> findePortalByFilter (long groupId, String ePortalName, String ePortalCode
			,int start,int end,OrderByComparator obc)
	{
		if(groupId > 0){
			Session session = null;
			try {
				 session = openSession();
				 String sqlStr = CustomSQLUtil.get(FIND_PORTAL_PLUGINS_SQL_STR_ID);
				 sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				 
				 if (!Validator.isNotNull(ePortalName))
				 {
					 sqlStr =StringUtil.replace(sqlStr, "AND (eportals.eportalName LIKE ?)", StringPool.BLANK);
				 }
				 
				 if (!Validator.isNotNull(ePortalCode)||(ePortalCode.equals(StringPool.BLANK)))
				 {
					 sqlStr =StringUtil.replace(sqlStr, "AND (eportals.eportalCode = ?)", StringPool.BLANK);
				 } 
				 
				 SQLQuery query = session.createSQLQuery(sqlStr);
				 
				 query.addEntity("ePortals", ePortalsImpl.class);
				 
				 QueryPos queryPost = QueryPos.getInstance(query);
				 
				 queryPost.add(groupId);
				 
				 if (Validator.isNotNull(ePortalName))
				 {
					 queryPost.add("%" + ePortalName + "%");
				 }
				 
				 if (Validator.isNotNull(ePortalCode)&&(!ePortalCode.equals(StringPool.BLANK)))
				 {
					 queryPost.add(ePortalCode);
				 } 
			
				 if(start >= 0 && end >= 0){
				    	
			    	return (List<ePortals>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<ePortals>) query.list();
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

	private static final String FIND_PORTAL_PLUGINS_SQL_STR_ID = "com.bkav.portal.portlet.portalplugins.service.persistence.eportals.finder";
}
