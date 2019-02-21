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
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.portal_egov.portlet.proposition_feedback.model.Proposition;
import com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback;
import com.portal_egov.portlet.proposition_feedback.model.impl.PropositionFeedbackImpl;


public class PropositionFeedbackFinderImpl extends BasePersistenceImpl<Proposition> implements PropositionFeedbackFinder{

	
	public List<PropositionFeedback> findByKeyword(long groupId,long propositionId,String keyword,int feedbackStatus,int start,int end,OrderByComparator obc){
		
		Session session = null;

		try
		{
			
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD);
		    
			if(propositionId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (PropositionFeedback.propositionId = ?)", StringPool.BLANK);
			}
			
			if(feedbackStatus < 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (PropositionFeedback.status = ?)", StringPool.BLANK);
			}
			
			if(groupId <= 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (PropositionFeedback.groupId = ?)", StringPool.BLANK);
			}
			
			sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("PropositionFeedback", PropositionFeedbackImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    
		    if(propositionId > 0){
		    	 queryPost.add(propositionId);
		    }
		    
		    if(feedbackStatus >= 0){
		    	 queryPost.add(feedbackStatus);
		    }
		    
		    if(groupId > 0){
		    	 queryPost.add(groupId);
		    }
		    
		    return (List<PropositionFeedback>) QueryUtil.list(query, getDialect(), start, end);
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
	
	
	private static final String FIND_BY_KEYWORD= PropositionFeedbackFinder.class.getName() + ".findByKeyword";
}
