/**
 * @author HungDX
 * @time 3:51:19 PM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.conversation.service.persistence;

import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.portal_egov.portlet.conversation.model.CO_Conversation;
import com.portal_egov.portlet.conversation.model.impl.CO_ConversationImpl;

public class CO_ConversationFinderImpl extends BasePersistenceImpl<CO_Conversation> implements CO_ConversationFinder{

	public List<CO_Conversation> findByKeywordAndStatus(long companyId,String keyword,int conversationStatus){
		
		Session session = null;

		try{
		    session = openSession();
		
		    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_AND_STATUS);
		    
			if(companyId <= 0L){
				sqlStr = StringUtil.replace(sqlStr, "AND (co_conversation.companyId = ?)", StringPool.BLANK);
			}
		    
			if(conversationStatus < 0){
				sqlStr = StringUtil.replace(sqlStr, "AND (co_conversation.status = ?)", StringPool.BLANK);
			}
			
		    SQLQuery query = session.createSQLQuery(sqlStr);
		    
		    query.addEntity("CO_Conversation", CO_ConversationImpl.class);
		    
		    QueryPos queryPost = QueryPos.getInstance(query);

		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    queryPost.add("%" + keyword + "%");
		    
		    if(companyId > 0){
		    	 queryPost.add(companyId);
		    }
		    
		    if(conversationStatus >= 0){
		    	 queryPost.add(conversationStatus);
		    }		   		    		    		    
		    return (List<CO_Conversation>) query.list();
		    
		}catch (Exception e){
			_log.error(e);
		    return Collections.emptyList();
		}
		finally{
		    closeSession(session);
		}
	}

	public List<CO_Conversation> findUnpublishEntry(long groupId,String searchKeyword){
		
		Session session = null;
		
		if(groupId > 0L){
			
			try{
			    
				session = openSession();
				
			    String sqlStr = CustomSQLUtil.get(FIND_UNPUBLISH_ENTRY);		    
			    
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("CO_Conversation", CO_ConversationImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);
			   
			    queryPost.add(groupId);
			    queryPost.add("%" + searchKeyword + "%");
			    
			    return (List<CO_Conversation>) query.list();
			    
			}catch (Exception e){
			    _log.error(e);
			    return Collections.emptyList();
			}
			finally{
			    closeSession(session);
			}
		}else{
			
			return Collections.emptyList();
		}
	}
	
	private static final String FIND_BY_KEYWORD_AND_STATUS = CO_ConversationFinder.class.getName() + ".findByKeywordAndStatus";
	
	private static final String FIND_UNPUBLISH_ENTRY = CO_ConversationFinder.class.getName() + ".findUnpublishEntry";
	
	private static Log _log = LogFactory.getLog(CO_ConversationFinderImpl.class);
}
