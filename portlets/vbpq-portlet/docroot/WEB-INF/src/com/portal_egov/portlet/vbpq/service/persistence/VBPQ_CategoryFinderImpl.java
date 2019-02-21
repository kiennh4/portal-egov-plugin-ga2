/**
 * @author HungDX
 * @time 3:48:34 PM
 * @project vbpq-portlet
 */
package com.portal_egov.portlet.vbpq.service.persistence;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.portal_egov.portlet.vbpq.model.VBPQ_Category;
import com.portal_egov.portlet.vbpq.model.impl.VBPQ_CategoryImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * @author HungDX
 *
 */
public class VBPQ_CategoryFinderImpl extends BasePersistenceImpl<VBPQ_Category> implements VBPQ_CategoryFinder{

	public List<VBPQ_Category> findByKeyword(long groupId,int categoryTypeId,String keyWord,int start,int end){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
			    
				if(categoryTypeId <= 0L){
					sqlStr = StringUtil.replace(sqlStr, "AND (vbpq_category.typeId = ?)", StringPool.BLANK);
				}
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("VBPQ_Category", VBPQ_CategoryImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add("%" + keyWord + "%");
			    queryPost.add("%" + keyWord + "%");
			    queryPost.add(groupId);
			    
			    if(categoryTypeId > 0){
			    	 queryPost.add(categoryTypeId);
			    }
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<VBPQ_Category>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<VBPQ_Category>) query.list();
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
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.portal_egov.portlet.vbpq.service.persistence.VBPQ_CategoryFinder.findByKeyword";
	
}
