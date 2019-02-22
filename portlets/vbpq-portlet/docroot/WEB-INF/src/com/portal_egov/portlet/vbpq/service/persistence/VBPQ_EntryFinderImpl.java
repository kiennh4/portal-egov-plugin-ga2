/**
 * @author HungDX
 * @time 3:48:34 PM
 * @project vbpq-portlet
 */
package com.portal_egov.portlet.vbpq.service.persistence;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;
import com.portal_egov.portlet.vbpq.model.impl.VBPQ_EntryImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * @author HungDX
 *
 */
public class VBPQ_EntryFinderImpl extends BasePersistenceImpl<VBPQ_Entry> implements VBPQ_EntryFinder{

	/**
	 * 
	 * @date Jun 24, 2012
	 * @author HungDX
	 * @todo Tim kiem VBPQ_ENtry theo keyword
	 * @return List<VBPQ_Entry>
	 * @param companyId
	 * @param keyword
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<VBPQ_Entry> findByKeyword(long groupId,String keyword,int start,int end){
				
		Session session = null;

		try
		{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD);
		    
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (vbpq_entry.groupId = ?)", StringPool.BLANK);
			}
			
			if(start < 0 || end < 0){
				sqlStr = StringUtil.replace(sqlStr, "LIMIT ?,?", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("VBPQ_Entry", VBPQ_EntryImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword.toUpperCase() + "%");
		    queryPost.add("%" + keyword.toUpperCase() + "%");
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(start >=0 && end >= 0){
		    	
			    queryPost.add(start);
			    queryPost.add(end);
		    }
		    
		    return (List<VBPQ_Entry>) query.list();
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
	 * @date Jun 24, 2012
	 * @author HungDX
	 * @todo Tim kiem VBPQ theo nhieu tieu chi
	 * @return List<VBPQ_Entry>
	 * @param companyId
	 * @param keyword
	 * @param departmentId
	 * @param categoryId
	 * @param docTypeId
	 * @param expirationStatus Trang thai hieu luc cua van ban.
	 * 		  expirationStatus = 0 tuong ung voi van ban van con hieu luc
	 * 		  expirationStatus = 1 tuong ung voi van ban da het hieu luc		 	
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<VBPQ_Entry> findByMultiCondition(long groupId,String keyword,long departmentId,long categoryId,
		long docTypeId,String startDate,String endDate,int expirationStatus,int start,int end){
				
		Session session = null;

		try
		{
			Date now = new Date();
			
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_MULTI_CONDITION);
		    
			if(departmentId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (vbpq_entry.departmentId = ?)", StringPool.BLANK);
			}
			
			if(categoryId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (vbpq_entry.categoryId = ?)", StringPool.BLANK);
			}
			
			if(docTypeId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (vbpq_entry.docTypeId = ?)", StringPool.BLANK);
			}
			
			if(expirationStatus == 0){//Chi tim kiem nhung van ban con hieu luc
				sqlStr = StringUtil.replace(sqlStr, "AND (vbpq_entry.expirationDate <= ?)", StringPool.BLANK);								
			
			}else if(expirationStatus == 1){//Chi tim kiem nhung van ban het hieu luc
				sqlStr = StringUtil.replace(sqlStr, "AND ((vbpq_entry.expirationDate >= ?) OR (vbpq_entry.expirationDate = 1))", StringPool.BLANK);
			
			}else{//Tim kiem tat ca
				sqlStr = StringUtil.replace(sqlStr, "AND (vbpq_entry.expirationDate <= ?)", StringPool.BLANK);
				sqlStr = StringUtil.replace(sqlStr, "AND ((vbpq_entry.expirationDate >= ?) OR (vbpq_entry.expirationDate = 1))", StringPool.BLANK);
			}
			
			if(Validator.isNull(startDate)){
				
				sqlStr = StringUtil.replace(sqlStr, "AND vbpq_entry.publishDate >= ?", StringPool.BLANK);
			}
			
			if(Validator.isNull(endDate)){
				
				sqlStr = StringUtil.replace(sqlStr, "AND vbpq_entry.publishDate <= ?", StringPool.BLANK);
			}
			
			if(groupId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (vbpq_entry.groupId = ?)", StringPool.BLANK);
			}
			
			if(start < 0 || end < 0){
				sqlStr = StringUtil.replace(sqlStr, "LIMIT ?,?", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("VBPQ_Entry", VBPQ_EntryImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);		    
		    
		    queryPost.add("%" + keyword.toUpperCase() + "%");
		    queryPost.add("%" + keyword.toUpperCase() + "%");
	    
		    if(departmentId > 0){
		    	 queryPost.add(departmentId);
		    }
		    		    
		    if(categoryId > 0){
		    	 queryPost.add(categoryId);
		    }
		    
		    if(docTypeId > 0){
		    	 queryPost.add(docTypeId);
		    }
		    
		    if(expirationStatus == 0){
		    	queryPost.add(now);
		    }
		    
		    if(expirationStatus == 1){
		    	queryPost.add(now);
		    }
		    
		    if(Validator.isNotNull(startDate)){
		    	queryPost.add(startDate);
		    }
		    
		    if(Validator.isNotNull(endDate)){
		    	queryPost.add(endDate);
		    }
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(start >=0 && end >= 0){
			    queryPost.add(start);
			    queryPost.add(end);
		    }
		    return (List<VBPQ_Entry>) query.list();
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
	
	
	private static final String FIND_BY_KEYWORD = VBPQ_EntryFinder.class.getName() + ".findByKeyword";
	
	private static final String FIND_BY_MULTI_CONDITION = VBPQ_EntryFinder.class.getName() + ".findByMultiCondition";
	
}
