/**
 * @author HUNGDX
 * @time 9:26:56 AM
 * @project contacts-portlet
 */
package com.bkav.portal_egov.portlet.asset_statistics.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class StatisticEntityFinderImpl extends BasePersistenceImpl<StatisticEntity> implements StatisticEntityFinder{

	public int getAssetCounter(long groupId,long categoryId,long userId,String fromDate,String endDate){
		
		if(groupId > 0){
			
			Session session = null;

			try{
				
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(STATISTIC_SQL_STR_ID);
			    
				if(userId <= 0L){
					
					sqlStr = StringUtil.replace(sqlStr, "AND assetentry.userId = ?", StringPool.BLANK);
				}
			    
				if(categoryId <= 0L){
					
					sqlStr = StringUtil.replace(sqlStr, "INNER JOIN assetentries_assetcategories", StringPool.BLANK);
					sqlStr = StringUtil.replace(sqlStr, "ON assetentries_assetcategories.entryId = assetentry.entryId", StringPool.BLANK);
					sqlStr = StringUtil.replace(sqlStr, "AND assetentries_assetcategories.categoryId = ?", StringPool.BLANK);
				}
				
				if(Validator.isNull(fromDate)){
					
					sqlStr = StringUtil.replace(sqlStr, "AND assetentry.publishDate >= ?", StringPool.BLANK);
				}
				
				if(Validator.isNull(endDate)){
					
					sqlStr = StringUtil.replace(sqlStr, "AND assetentry.publishDate <= ?", StringPool.BLANK);
				}
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);
			    
			    queryPost.add(groupId);
			    queryPost.add(ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class));
			    
			    if(userId > 0L){
			    	
			    	queryPost.add(userId);
			    }
			    
			    if(categoryId > 0L){
			    	
			    	queryPost.add(categoryId);
			    }
			    
			    if(Validator.isNotNull(fromDate)){
			    	queryPost.add(fromDate);
			    }
			    
			    if(Validator.isNotNull(endDate)){
			    	queryPost.add(endDate);
			    }
			    
				Iterator<Long> itr = query.iterate();

				if (itr.hasNext()) {
					
					Long counter = itr.next();
					
					if (counter != null) {
						
						return counter.intValue();
					}
				}
			    
			    return 0;
			}catch (Exception e){
				e.printStackTrace();
			    return 0;
			}finally{
			    closeSession(session);
			}
		
		}else{
			
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AssetEntry> getAssetEntry(long groupId,long categoryId,long userId,String fromDate,String endDate){
		
		if(groupId > 0){
			
			SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
			
			Session session = null;

			try{
				
			    session = sessionFactory.openSession();
			
			    String sqlStr = CustomSQLUtil.get(STATISTIC_ENTRY_SQL_STR_ID);
			    
				if(userId <= 0L){
					
					sqlStr = StringUtil.replace(sqlStr, "AND assetentry.userId = ?", StringPool.BLANK);
				}
			    
				if(categoryId <= 0L){
					
					sqlStr = StringUtil.replace(sqlStr, "INNER JOIN assetentries_assetcategories", StringPool.BLANK);
					sqlStr = StringUtil.replace(sqlStr, "ON assetentries_assetcategories.entryId = assetentry.entryId", StringPool.BLANK);
					sqlStr = StringUtil.replace(sqlStr, "AND assetentries_assetcategories.categoryId = ?", StringPool.BLANK);
				}
				
				if(Validator.isNull(fromDate)){
					
					sqlStr = StringUtil.replace(sqlStr, "AND assetentry.publishDate >= ?", StringPool.BLANK);
				}
				
				if(Validator.isNull(endDate)){
					
					sqlStr = StringUtil.replace(sqlStr, "AND assetentry.publishDate <= ?", StringPool.BLANK);
				}
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    //query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			    
			    query.addEntity("AssetEntry", 
			    		PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portlet.asset.model.impl.AssetEntryImpl"));
			    
			    QueryPos queryPost = QueryPos.getInstance(query);
			    
			    
			    queryPost.add(groupId);
			    queryPost.add(ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class));
			    
			    if(userId > 0L){
			    	
			    	queryPost.add(userId);
			    }
			    
			    if(categoryId > 0L){
			    	
			    	queryPost.add(categoryId);
			    }
			    
			    if(Validator.isNotNull(fromDate)){
			    	queryPost.add(fromDate);
			    }
			    
			    if(Validator.isNotNull(endDate)){
			    	queryPost.add(endDate);
			    }
			    
			    List<AssetEntry> result = query.list();
			    
			    return  (List<AssetEntry>)query.list();
			    
//				Iterator<Long> itr = query.iterate();
//
//				if (itr.hasNext()) {
//					
//					Long counter = itr.next();
//					
//					if (counter != null) {
//						
//						return counter.intValue();
//					}
//				}
//			    
//			    return 0;
			    
			}catch (Exception e){
				e.printStackTrace();
			    return new ArrayList<AssetEntry>();
			}finally{
			    closeSession(session);
			}
		
		}else{
			return new ArrayList<AssetEntry>();
		}
	}
	
	private static final String STATISTIC_SQL_STR_ID = 
					"com.bkav.portal_egov.portlet.asset_statistics.service.persistence.StatisticEntityFinder.getAssetCounter";
	
	private static final String STATISTIC_ENTRY_SQL_STR_ID = 
			"com.bkav.portal_egov.portlet.asset_statistics.service.persistence.StatisticEntityFinder.getAssetEntry";
	
	
}