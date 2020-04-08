/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.citymaps.service.persistence;

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
import com.portal_egov.portlet.citymaps.model.CityMap;
import com.portal_egov.portlet.citymaps.model.impl.CityMapImpl;


public class CityMapFinderImpl extends BasePersistenceImpl<CityMap> implements CityMapFinder{

	public List<CityMap> findByKeyword(long groupId,long mapTypeId,String keyword,int start,int end,OrderByComparator obc){
		
		Session session = null;

		try{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
		    
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (citymap.groupId = ?)", StringPool.BLANK);
			}
		    
			if(mapTypeId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (citymap.mapTypeId = ?)", StringPool.BLANK);
			}
			
			sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("CityMap", CityMapImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(mapTypeId > 0){
		    	 queryPost.add(mapTypeId);
		    }
		    
		    if(start >= 0 && end >= 0){
		    	
		    	return (List<CityMap>) QueryUtil.list(query, getDialect(), start, end);
		    
		    }else{
		    	
		    	return (List<CityMap>) query.list();
		    }
		}catch (Exception e){
			e.printStackTrace();
		    return Collections.emptyList();
		}finally{
		    closeSession(session);
		}
	}
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.portal_egov.portlet.citymaps.service.persistence.CityMapFinder.findByKeyword";
	
}
