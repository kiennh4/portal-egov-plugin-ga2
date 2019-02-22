/**
 * @author HungDX
 * @time 3:51:01 PM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.proposition_feedback.service.persistence;

import java.util.Collections;
import java.util.List;

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
import com.portal_egov.portlet.proposition_feedback.model.Proposition;
import com.portal_egov.portlet.proposition_feedback.model.impl.PropositionImpl;


public class PropositionFinderImpl extends BasePersistenceImpl<Proposition> implements PropositionFinder{

	
	public List<Proposition> findByMultiCondition(long groupId,long categoryId,long compilationDepartmentId,
								long verificationDepartmentId,String keyword,int propositionStatus,int start,int end){
		
		Session session = null;

		try
		{
			
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_MULTI_CONDITION);
		    
			if(groupId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (proposition.groupId = ?)", StringPool.BLANK);
			}
		    
			if(categoryId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (proposition.categoryId = ?)", StringPool.BLANK);
			}
		    
			if(compilationDepartmentId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (proposition.compilationDepartmentId = ?)", StringPool.BLANK);
			}
		    
			if(verificationDepartmentId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (proposition.verificationDepartmentId = ?)", StringPool.BLANK);
			}
		    
			if(propositionStatus < 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (proposition.status = ?)", "AND (proposition.status >= 0)");
			}

			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("Proposition", PropositionImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    
		    if(categoryId > 0){
		    	 queryPost.add(categoryId);
		    }
		    
		    if(compilationDepartmentId > 0){
		    	 queryPost.add(compilationDepartmentId);
		    }
		    
		    if(verificationDepartmentId > 0){
		    	 queryPost.add(verificationDepartmentId);
		    }
		    
		    if(propositionStatus >= 0){
		    	 queryPost.add(propositionStatus);
		    }
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    return (List<Proposition>) QueryUtil.list(query, getDialect(), start, end);
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
	
	public List<Proposition> findByMultiCondition(long groupId,long categoryId,long compilationDepartmentId,
		long verificationDepartmentId,String keyword,int propositionStatus,int start,int end,OrderByComparator obc){

		Session session = null;

		try {

			session = openSession();

			String sqlStr = CustomSQLUtil.get(FIND_BY_MULTI_CONDITION);

			if (groupId <= 0) {
				sqlStr = StringUtil.replace(sqlStr, "AND (proposition.groupId = ?)", StringPool.BLANK);
			}

			if (categoryId <= 0) {
				sqlStr = StringUtil.replace(sqlStr, "AND (proposition.categoryId = ?)", StringPool.BLANK);
			}

			if (compilationDepartmentId <= 0) {
				sqlStr = StringUtil.replace(sqlStr, "AND (proposition.compilationDepartmentId = ?)", StringPool.BLANK);
			}

			if (verificationDepartmentId <= 0) {
				sqlStr = StringUtil.replace(sqlStr, "AND (proposition.verificationDepartmentId = ?)", StringPool.BLANK);
			}

			if (propositionStatus < 0) {
				sqlStr = StringUtil.replace(sqlStr, "AND (proposition.status = ?)", "AND (proposition.status >= 0)");
			}
			
			sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
			
			SQLQuery query = session.createSQLQuery(sqlStr);

			query.addEntity("Proposition", PropositionImpl.class);

			QueryPos queryPost = QueryPos.getInstance(query);

			queryPost.add("%" + keyword + "%");
			queryPost.add("%" + keyword + "%");

			if (categoryId > 0) {
				queryPost.add(categoryId);
			}

			if (compilationDepartmentId > 0) {
				queryPost.add(compilationDepartmentId);
			}

			if (verificationDepartmentId > 0) {
				queryPost.add(verificationDepartmentId);
			}

			if (propositionStatus >= 0) {
				queryPost.add(propositionStatus);
			}

			if (groupId > 0) {
				queryPost.add(groupId);
			}
			return (List<Proposition>) QueryUtil.list(query, getDialect(), start, end);
		}
		catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
		finally {
			closeSession(session);
		}
	}
	
	/**
	 * @todo TIM KIEM DU THAO LUAT THEO COMPANY,CHO PHEP ORDER THEO NHIEU TRUONG KHAC NHAU VA LIMIT QUERY
	 * @author HungDX	
	 * @date Aug 7, 2012
	 * @return List<Proposition>
	 * @param companyId
	 * @param oderByColumn
	 * @param propositionStatus
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Proposition> findByPropositionStatus(long groupId,int propositionStatus,String orderByColumn,String orderByType,int start,int end){
		
		Session session = null;

		try
		{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_PROPOSITION_STATUS);
		    
			if(groupId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "(proposition.groupId = ?)", StringPool.BLANK);
			}
		    
			if(propositionStatus < 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (proposition.status = ?)", "AND (proposition.status > 0)");
			}
		    
		    if(!Validator.equals(orderByColumn, StringPool.BLANK) && !Validator.equals(orderByType, StringPool.BLANK) ){
		    	sqlStr = StringUtil.replace(sqlStr, "$ORDER_BY_COLUMN", orderByColumn);
		    	sqlStr = StringUtil.replace(sqlStr, "$ORDER_BY_TYPE", orderByType);
		    }else{
		    	
		    	sqlStr = StringUtil.replace(sqlStr, "ORDER BY $ORDER_BY_COLUMN $ORDER_BY_TYPE", StringPool.BLANK);
		    }
		    
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("Proposition", PropositionImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    if(propositionStatus >= 0){
		    	 queryPost.add(propositionStatus);
		    }
		    
		    return (List<Proposition>) QueryUtil.list(query, getDialect(), start, end);
		    
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
	
	
	private static final String FIND_BY_MULTI_CONDITION = PropositionFinder.class.getName() + ".findByMultiCondition";
	
	private static final String FIND_BY_PROPOSITION_STATUS = PropositionFinder.class.getName() + ".findByPropositionStatus";
}
