/**
 * @author HungDX
 * @time 3:51:01 PM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.conversation.service.persistence;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.portal_egov.portlet.conversation.model.CO_Thread;
import com.portal_egov.portlet.conversation.model.impl.CO_ThreadImpl;


public class CO_ThreadFinderImpl extends BasePersistenceImpl<CO_Thread> implements CO_ThreadFinder{

	public List<CO_Thread> findByKeywordAndStatus(long companyId,String keyword,int threadStatus){
		
		Session session = null;

		try
		{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_AND_STATUS);
		    
			if(companyId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, " AND (co_thread.companyId = ?)", StringPool.BLANK);
			}
		    
			if(threadStatus < 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (co_thread.status = ?)", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("CO_Thread", CO_ThreadImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    
		    if(companyId > 0){
		    	 queryPost.add(companyId);
		    }
		    
		    if(threadStatus >= 0){
		    	 queryPost.add(threadStatus);
		    }		   		    		    		    
		    return (List<CO_Thread>) query.list();
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
	
	private static final String FIND_BY_KEYWORD_AND_STATUS = CO_ThreadFinder.class.getName() + ".findByKeywordAndStatus";
}
