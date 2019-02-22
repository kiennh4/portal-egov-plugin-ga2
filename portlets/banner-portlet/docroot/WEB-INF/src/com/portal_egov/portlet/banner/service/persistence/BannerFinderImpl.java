/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.banner.service.persistence;

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
import com.portal_egov.portlet.banner.model.Banner;
import com.portal_egov.portlet.banner.model.impl.BannerImpl;


public class BannerFinderImpl extends BasePersistenceImpl<Banner> implements BannerFinder{

	public List<Banner> findByTitle(long groupId,long bannerGroupId,String bannerTitle,int start,int end,OrderByComparator obc){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
			    
				if(bannerGroupId <= 0L){
					sqlStr = StringUtil.replace(sqlStr, "AND (Banner.bannerGroupId = ?)", StringPool.BLANK);
				}
				
				sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("Banner", BannerImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add("%" + bannerTitle + "%");
			    queryPost.add(groupId);
			    
			    if(bannerGroupId > 0){
			    	 queryPost.add(bannerGroupId);
			    }
			    
			    return (List<Banner>) query.list();
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
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.portal_egov.portlet.banner.service.persistence.BannerFinder.findByTitle";
	
}
