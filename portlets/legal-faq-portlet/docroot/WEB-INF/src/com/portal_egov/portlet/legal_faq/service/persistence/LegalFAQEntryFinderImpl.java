/**
 * @author HungDX
 * @time 3:48:34 PM
 * @project vbpq-portlet
 */
package com.portal_egov.portlet.legal_faq.service.persistence;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;
import com.portal_egov.portlet.legal_faq.model.impl.LegalFAQEntryImpl;

/**
 * @author HungDX
 *
 */
public class LegalFAQEntryFinderImpl extends BasePersistenceImpl<LegalFAQEntry> implements LegalFAQEntryFinder{


	public List<LegalFAQEntry> findByKeyword(long groupId,long categoryId,String keyword,int start,int end,OrderByComparator obc){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
			    
				if(categoryId <= 0L){
					sqlStr = StringUtil.replace(sqlStr, "AND (legalfaqentry.categoryId = ?)", StringPool.BLANK);
				}
			    
			    sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
			    
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("LegalFAQEntry", LegalFAQEntryImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add("%" + keyword + "%");
			    queryPost.add("%" + keyword + "%");
			    queryPost.add(groupId);
			    
			    if(categoryId > 0){
			    	queryPost.add(categoryId);
			    }
			    
			    return (List<LegalFAQEntry>) query.list();
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
	

	public List<LegalFAQEntry> findByKeywordAndStatus(long groupId,long categoryId,String keyword,int start,int end){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_AND_STATUS_SQL_STR_ID);
			    
				if(categoryId <= 0L){
					sqlStr = StringUtil.replace(sqlStr, "AND (legalfaqentry.categoryId = ?)", StringPool.BLANK);
				}
			    
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("LegalFAQEntry", LegalFAQEntryImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);
			    
			    queryPost.add("%" + keyword + "%");
			    queryPost.add("%" + keyword + "%");
			    queryPost.add("%" + keyword + "%");
			    queryPost.add(groupId);
			    
			    if(categoryId > 0){
			    	queryPost.add(categoryId);
			    }
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<LegalFAQEntry>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<LegalFAQEntry>) query.list();
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


	public List<LegalFAQEntry> findByViewCount(long groupId,long categoryId,int start,int end){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_VIEW_COUNTER_SQL_STR_ID);
			    
				if(categoryId <= 0L){
					sqlStr = StringUtil.replace(sqlStr, "AND (legalfaqentry.categoryId = ?)", StringPool.BLANK);
				}
			    
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("LegalFAQEntry", LegalFAQEntryImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add(groupId);
			    
			    if(categoryId > 0){
			    	queryPost.add(categoryId);
			    }
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<LegalFAQEntry>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<LegalFAQEntry>) query.list();
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
	

	private static final String FIND_BY_KEYWORD_SQL_STR_ID = LegalFAQEntryFinder.class.getName() + ".findByKeyword";
	
	private static final String FIND_BY_KEYWORD_AND_STATUS_SQL_STR_ID = LegalFAQEntryFinder.class.getName() + ".findByKeywordAndStatus";
	
	private static final String FIND_BY_VIEW_COUNTER_SQL_STR_ID = LegalFAQEntryFinder.class.getName() + ".findByViewCount";
}
