package com.bkav.portal.portlet.portalplugins.service.persistence;

import java.util.Collections;
import java.util.List;

import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;
import com.bkav.portal.portlet.portalplugins.model.impl.PortalPluginsImpl;
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

public class PortalPluginsFinderImpl extends BasePersistenceImpl<PortalPlugins> implements PortalPluginsFinder {
	
	@SuppressWarnings("unchecked")
	public List<PortalPlugins> findPortalPluginsByFilter (long groupId, String pluginName, String pluginCode, int pluginType
			, long ePortalId ,int start,int end,OrderByComparator obc)
	{
		if(groupId > 0){
			Session session = null;
			try {
				 session = openSession();
				 String sqlStr = CustomSQLUtil.get(FIND_PORTAL_PLUGINS_SQL_STR_ID);
				 sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				 
				 if (!Validator.isNotNull(pluginName))
				 {
					 sqlStr =StringUtil.replace(sqlStr, "AND (portalplugins.pluginName LIKE ?)", StringPool.BLANK);
				 }
				 
				 if (!Validator.isNotNull(pluginCode)||(pluginCode.equals(StringPool.BLANK)))
				 {
					 sqlStr =StringUtil.replace(sqlStr, "AND (portalplugins.pluginCode = ?)", StringPool.BLANK);
				 } 
				 
				 if ((!Validator.isNotNull(pluginType))||(pluginType < 0))
				 {
					 sqlStr =StringUtil.replace(sqlStr, "AND (portalplugins.pluginType = ?)", StringPool.BLANK);
				 } 
				 
				 if ((!Validator.isNotNull(ePortalId))||(ePortalId <= 0))
				 {
					 sqlStr =StringUtil.replace(sqlStr, "AND (portalplugins.ePortalId = ?)", StringPool.BLANK);
				 } 
				 
				 SQLQuery query = session.createSQLQuery(sqlStr);
				 
				 query.addEntity("PortalPlugins", PortalPluginsImpl.class);
				 
				 QueryPos queryPost = QueryPos.getInstance(query);
				 
				 queryPost.add(groupId);
				 
				 if (Validator.isNotNull(pluginName))
				 {
					 queryPost.add("%" + pluginName + "%");
				 }
				 
				 if (Validator.isNotNull(pluginCode)&&(!pluginCode.equals(StringPool.BLANK)))
				 {
					 queryPost.add(pluginCode);
				 } 
				 
				 if ((Validator.isNotNull(pluginType))&&(pluginType >= 0))
				 {
					 queryPost.add(pluginType);
				 } 
				 
				 if ((Validator.isNotNull(ePortalId))&&(ePortalId > 0))
				 {
					 queryPost.add(ePortalId);
				 } 
			
				 if(start >= 0 && end >= 0){
				    	
			    	return (List<PortalPlugins>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<PortalPlugins>) query.list();
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

	private static final String FIND_PORTAL_PLUGINS_SQL_STR_ID = "com.bkav.portal.portlet.portalplugins.service.persistence.portalplugins.finder";
}
