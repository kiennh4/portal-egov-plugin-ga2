/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.landprice.service.persistence;

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
import com.portal_egov.portlet.landprice.model.LandLocation;
import com.portal_egov.portlet.landprice.model.impl.LandLocationImpl;


public class LandLocationFinderImpl extends BasePersistenceImpl<LandLocation> implements LandLocationFinder{

	public List<LandLocation> findByKeyword(long groupId,long parentLocationId,String keyword,int start,int end,OrderByComparator obc){
		
		if(groupId > 0){
			
			Session session = null;

			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
			    
			    if(parentLocationId <= 0){
			    	
			    	sqlStr = StringUtil.replace(sqlStr, "AND LandLocation.parentLocationId = ?", StringPool.BLANK);
			    }
			    
				sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("LandLocation", LandLocationImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);
			    
			    queryPost.add(groupId);
			    
			    if(parentLocationId > 0){
			    	
			    	queryPost.add(parentLocationId);
			    }
			    
			    queryPost.add("%" + keyword.toUpperCase() + "%");
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<LandLocation>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<LandLocation>) query.list();
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
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.portal_egov.portlet.landprice.service.persistence.LandLocationFinder.findByKeyword";
	
}
