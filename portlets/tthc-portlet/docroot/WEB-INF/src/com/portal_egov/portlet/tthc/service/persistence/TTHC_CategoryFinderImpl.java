/**
 * @author HungDX
 * @time 1:52:43 PM
 * @project tthc-portlet
 */
package com.portal_egov.portlet.tthc.service.persistence;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.portal_egov.portlet.tthc.model.TTHC_Category;
import com.portal_egov.portlet.tthc.model.impl.TTHC_CategoryImpl;


/**
 * @author HungDX
 *
 */
public class TTHC_CategoryFinderImpl extends BasePersistenceImpl<TTHC_Category> implements TTHC_CategoryFinder{

	public List<TTHC_Category> findByKeyword(long groupId,int categoryTypeId,String keyword,int start,int end){
		
		Session session = null;

		try{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD);
			
			if(categoryTypeId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "(tthc_category.categoryTypeId = ?) AND", StringPool.BLANK);
			}
			
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "(vbpq_entry.groupId = ?)", StringPool.BLANK);
			}
			
			
			if(start < 0 || end < 0){
				sqlStr = StringUtil.replace(sqlStr, "LIMIT ?,?", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("TTHC_Category", TTHC_CategoryImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    
		    if(categoryTypeId > 0){
		    	 queryPost.add(categoryTypeId);
		    }
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(start >= 0 && end >= 0){
		    	 queryPost.add(start);
		    	 queryPost.add(end);
		    }
		    
		    return (List<TTHC_Category>) query.list();
		}
		catch (Exception e){
		    e.printStackTrace();
		    return Collections.emptyList();
		}
		finally{
			
		    closeSession(session);
		}
	}
	
	private static final String FIND_BY_KEYWORD = TTHC_CategoryFinder.class.getName() + ".findByKeyword";
}
