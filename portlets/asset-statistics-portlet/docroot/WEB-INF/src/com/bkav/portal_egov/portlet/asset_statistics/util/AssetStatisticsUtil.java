/**
 * @author HungDX
 * @time 11:19:29 AM
 * @project asset-statistics-portlet
 */
package com.bkav.portal_egov.portlet.asset_statistics.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bkav.portal_egov.portlet.asset_statistics.service.StatisticEntityLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class AssetStatisticsUtil{
	
	public static List<AssetEntry> getAssetEntry (long groupId,long categoryId,long userId,String fromDate,String endDate){
		
		try {
			
			return StatisticEntityLocalServiceUtil.getAssetEntry(groupId, categoryId, userId, fromDate, endDate);
		}
		catch (Exception e) {
			_log.error(e);
			return new ArrayList<AssetEntry>();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static List<AssetEntry> getAssetEntry (long groupId, long categoryId, long userId, String statisticByTimeRange,
			int fromDay, int fromMonth, int fromYear, 
			int endDay, int endMonth, int endYear,
			ThemeDisplay themeDisplay){
		
			String fromDate = "";
		
			String endDate = "";
			
			try {
				
				if(StringUtil.lowerCase(statisticByTimeRange).equals("true")){
					
					Date currentDate = CalendarFactoryUtil.getCalendar().getTime();
					
					SimpleDateFormat dateFormat_ = new SimpleDateFormat("yyyyMMdd");
					
					fromDate = dateFormat_.format(currentDate);
					endDate = dateFormat_.format(currentDate);
					
					if(fromDay > 0 && fromMonth > 0 && fromYear > 0){
						
						fromDate = dateFormat_.format(PortalUtil.getDate(fromMonth, fromDay, fromYear, themeDisplay.getTimeZone(), new PortalException()));
					}

					
					
					if(endDay > 0 && endMonth > 0 && endYear > 0){
						
						endDate = dateFormat_.format(PortalUtil.getDate(endMonth, endDay, endYear, themeDisplay.getTimeZone(), new PortalException()));
					}
				}
				
				
				return StatisticEntityLocalServiceUtil.getAssetEntry(groupId, categoryId, userId, fromDate, endDate);
			}
			catch (Exception e) {
				_log.error(e);
				return new ArrayList<AssetEntry>();
			}
		}
	
	public static int getAssetCounter(long groupId,long categoryId,long userId,String fromDate,String endDate){
		
		try {
			
			return StatisticEntityLocalServiceUtil.getAssetCounter(groupId, categoryId, userId, fromDate, endDate);
		}
		catch (Exception e) {
			_log.error(e);
			return 0;
		}
	}
	
	public static int getCategoryAssetCounter(long groupId,long categoryId,long userId,String fromDate,String endDate) {
		
		try {
			
			int counter = getAssetCounter(groupId, categoryId, userId, fromDate, endDate);
			
			if(AssetCategoryLocalServiceUtil.getChildCategoriesCount(categoryId) > 0){
				
				List<AssetCategory> subCategoryList = AssetCategoryLocalServiceUtil.getChildCategories(categoryId);
				
				for(AssetCategory subCategory : subCategoryList){
					
					int subCounter = getAssetCounter(groupId, subCategory.getCategoryId(), userId, fromDate, endDate);
					
					counter = counter + subCounter;
					
					if(AssetCategoryLocalServiceUtil.getChildCategoriesCount(subCategory.getCategoryId()) > 0){
						
						getCategoryAssetCounter(groupId, subCategory.getCategoryId(), userId, fromDate, endDate);
					}
				}
			}
			
			return counter;
		}
		catch (Exception e) {
			_log.error(e);
			return 0;
		}
	}
	
	public static long countByUser(long groupId,long userId){
		
		try {
			
			ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticle.class,classLoader);
			
			Criterion groupIdCriterion = RestrictionsFactoryUtil.eq("groupId", groupId);
			
			Criterion userIdCriterion = RestrictionsFactoryUtil.eq("userId", userId);
			
			Criterion queryCriterion = RestrictionsFactoryUtil.and(groupIdCriterion, userIdCriterion);
			
			dynamicQuery.add(queryCriterion);
			
			return JournalArticleLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		}
		catch (Exception e) {
			_log.error(e);
			return 0;
		}
	}
	
	public static long countByGroup(long groupId){
		
		try {
			
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			
			assetEntryQuery.setGroupIds(new long[]{groupId});
			assetEntryQuery.setClassName(JournalArticle.class.getName());
			
			return AssetEntryLocalServiceUtil.getEntriesCount(assetEntryQuery);
			
		}
		catch (Exception e) {
			_log.error(e);
			return 0;
		}
	}
	
	public static long countByCategory(long groupId,long categoryId){
		
		try {
			
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			
			assetEntryQuery.setGroupIds(new long[]{groupId});
			assetEntryQuery.setClassName(JournalArticle.class.getName());
			assetEntryQuery.setAnyCategoryIds(new long[]{categoryId});
			
			return AssetEntryLocalServiceUtil.getEntriesCount(assetEntryQuery);
			
		}
		catch (Exception e) {
			_log.error(e);
			return 0;
		}
	}
	
	public static long countByTag(long groupId,long tagId){
		
		try {
			
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			
			assetEntryQuery.setGroupIds(new long[]{groupId});
			assetEntryQuery.setClassName(JournalArticle.class.getName());
			assetEntryQuery.setAnyTagIds(new long[]{tagId});
			
			return AssetEntryLocalServiceUtil.getEntriesCount(assetEntryQuery);
		}
		catch (Exception e) {
			_log.error(e);
			return 0;
		}
	}
	
	public static long getGroupVocabularyCounter(long groupId){
		
		try {
			
			ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetVocabulary.class,classLoader);
			
			Criterion queryCriterion = RestrictionsFactoryUtil.eq("groupId", groupId);
			
			dynamicQuery.add(queryCriterion);
			
			return AssetVocabularyLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		}
		catch (Exception e) {
			_log.error(e);
			return 0;
		}
	}
	
	public static long getGroupCategoryCounter(long groupId){
		
		try {
			
			ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetCategory.class,classLoader);
			
			Criterion queryCriterion = RestrictionsFactoryUtil.eq("groupId", groupId);
			
			dynamicQuery.add(queryCriterion);
			
			return AssetCategoryLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		}
		catch (Exception e) {
			_log.error(e);
			return 0;
		}
	}
	
	private static final Log _log = LogFactoryUtil.getLog(AssetStatisticsUtil.class.getName());
}