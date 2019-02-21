/**
 * @author HungDX
 * @time 3:48:34 PM
 * @project vbpq-portlet
 */
package com.portal_egov.portlet.tthc.service.persistence;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.portal_egov.portlet.tthc.model.TTHC_Entry;
import com.portal_egov.portlet.tthc.model.impl.TTHC_EntryImpl;

/**
 * @author HungDX
 *
 */
public class TTHC_EntryFinderImpl extends BasePersistenceImpl<TTHC_Entry> implements TTHC_EntryFinder{

	/**
	 * 
	 * @date June 28, 2012
	 * @author HungDX
	 * @todo Tim kiem TTHC_Entry theo keyword
	 * @return List<TTHC_Entry>
	 * @param companyId
	 * @param keyword
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TTHC_Entry> findByKeyword(long groupId,String keyword,int start,int end){
				
		Session session = null;

		try
		{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD);
		    
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (tthc_entry.groupId = ?)", StringPool.BLANK);
			}
		    
			if(start < 0 || end < 0){
				sqlStr = StringUtil.replace(sqlStr, "LIMIT ?,?", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("TTHC_Entry", TTHC_EntryImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(start >= 0 && end >= 0){
		    	 queryPost.add(start);
		    	 queryPost.add(end);
		    }
		    
		    return (List<TTHC_Entry>) query.list();
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		    return Collections.emptyList();
		}
		finally
		{
		    closeSession(session);
		}
	}

	/**
	 * 
	 * @date June 28, 2012
	 * @author HungDX
	 * @todo Tim kiem TTHC_Entry theo nhieu tieu chi
	 * @return List<TTHC_Entry>
	 * @param companyId
	 * @param keyword
	 * @param levelId
	 * @param departmentId
	 * @param categoryId
	 * @param audienceId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TTHC_Entry> findByMultiCondition(long groupId,String keyword,long levelId,long departmentId,long categoryId,
		long audienceId,long resultTypeId,int start,int end){
				
		Session session = null;

		try
		{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_MULTI_CONDITION);
		    
			if(levelId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "(tthc_entry.levelId = ?) AND", StringPool.BLANK);
			}
			
			if(departmentId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "(tthc_entry.departmentId = ?) AND", StringPool.BLANK);
			}
			
			if(categoryId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "(tthc_entry.categoryId = ?) AND", StringPool.BLANK);
			}
			
			if(audienceId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "(tthc_entry.audienceId = ?) AND", StringPool.BLANK);
			}
			
			if(resultTypeId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "(tthc_entry.resultTypeId = ?) AND", StringPool.BLANK);
			}
			
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "(vbpq_entry.groupId = ?)", StringPool.BLANK);
			}
		    
			if(start < 0 || end < 0){
				sqlStr = StringUtil.replace(sqlStr, "LIMIT ?,?", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("TTHC_Entry", TTHC_EntryImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);		    
		    
		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    
		    if(levelId > 0){
		    	 queryPost.add(levelId);
		    }
		    
		    if(departmentId > 0){
		    	 queryPost.add(departmentId);
		    }
		    		    
		    if(categoryId > 0){
		    	 queryPost.add(categoryId);
		    }
		    
		    if(audienceId > 0){
		    	 queryPost.add(audienceId);
		    }
		    
		    if(resultTypeId > 0){
		    	 queryPost.add(resultTypeId);
		    }
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(start >= 0 && end >= 0){
		    	 queryPost.add(start);
		    	 queryPost.add(end);
		    }
		    
		    return (List<TTHC_Entry>) query.list();
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		    return Collections.emptyList();
		}
		finally
		{
		    closeSession(session);
		}
	}
	
	
	private static final String FIND_BY_KEYWORD = TTHC_EntryFinder.class.getName() + ".findByKeyword";
	
	private static final String FIND_BY_MULTI_CONDITION = TTHC_EntryFinder.class.getName() + ".findByMultiCondition";
	
}
