/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.weblinks.service.persistence;

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
import com.portal_egov.portlet.weblinks.model.WeblinkCategory;
import com.portal_egov.portlet.weblinks.model.impl.WeblinkCategoryImpl;


public class WeblinkCategoryFinderImpl extends BasePersistenceImpl<WeblinkCategory> implements WeblinkCategoryFinder{

	public List<WeblinkCategory> findByKeyword(long groupId,String keyword,int start,int end){
		
		Session session = null;

		try{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
		    
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (weblinkcategory.groupId = ?)", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("WeblinkCategory", WeblinkCategoryImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(start >= 0 && end >= 0){
		    	
		    	return (List<WeblinkCategory>) QueryUtil.list(query, getDialect(), start, end);
		    
		    }else{
		    	
		    	return (List<WeblinkCategory>) query.list();
		    }
		}catch (Exception e){
			e.printStackTrace();
		    return Collections.emptyList();
		}finally{
		    closeSession(session);
		}
	}
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.portal_egov.portlet.weblinks.service.persistence.WeblinkCategoryFinder.findByKeyword";
	
}
