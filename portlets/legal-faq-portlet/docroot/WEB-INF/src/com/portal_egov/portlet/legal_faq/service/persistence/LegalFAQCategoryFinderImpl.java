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
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.portal_egov.portlet.legal_faq.model.LegalFAQCategory;
import com.portal_egov.portlet.legal_faq.model.impl.LegalFAQCategoryImpl;

/**
 * @author HungDX
 *
 */
public class LegalFAQCategoryFinderImpl extends BasePersistenceImpl<LegalFAQCategory> implements LegalFAQCategoryFinder{


	public List<LegalFAQCategory> findByKeyword(long groupId,String keyword,int start,int end){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
			    
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("LegalFAQCategory", LegalFAQCategoryImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add("%" + keyword + "%");
			    queryPost.add(groupId);
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<LegalFAQCategory>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<LegalFAQCategory>) query.list();
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
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.portal_egov.portlet.legal_faq.service.persistence.LegalFAQCategoryFinder.findByKeyword";
	
}
