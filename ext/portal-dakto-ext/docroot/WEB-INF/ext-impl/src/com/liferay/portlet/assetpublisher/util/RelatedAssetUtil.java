/**
 * @author HungDX
 * @time 3:15:21 PM
 * @project portal_egov_ext-ext
 */
package com.liferay.portlet.assetpublisher.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.NoSuchCategoryPropertyException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetCategoryProperty;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.journal.model.JournalArticle;


public class RelatedAssetUtil{

	/**
	 * @todo LAY DANH SACH TIN BAI LIEN QUAN THEO TAGS HOAC CATEGORIES
	 * @author HungDX	
	 * @date Aug 10, 2012
	 * @return List<AssetEntry>
	 * @param currentAssetEntryId
	 * @param relatedAssetsFilter
	 * @param numbersOfRelatedAssetsDisplay
	 * @return
	 */
	public static List<AssetEntry> getRelatedAssetList(long currentAssetEntryId,String relatedAssetsFilter,int numbersOfRelatedAssetsDisplay){
		
		try {
			
			List<AssetEntry> relatedAssetList = new ArrayList<AssetEntry>();
			
			List<AssetEntry> uncheckRelatedAssetList = new ArrayList<AssetEntry>();
			
			if(Validator.equals(relatedAssetsFilter, ASSET_TAG_FILTER)){//Lay List tin bai lien quan theo Tag
				
				uncheckRelatedAssetList = getRelatedAssetByTag(currentAssetEntryId, numbersOfRelatedAssetsDisplay +1);
			
			}else if(Validator.equals(relatedAssetsFilter, ASSET_CATEGORY_FILTER)){//Lay list tin bai lien quan theo Category
				
				uncheckRelatedAssetList = getRelatedAssetByCategory(currentAssetEntryId, numbersOfRelatedAssetsDisplay +1);
			}
			
			for(AssetEntry relatedAsset : uncheckRelatedAssetList){
				
				if(relatedAsset.getEntryId() != currentAssetEntryId){
					
					relatedAssetList.add(relatedAsset);
				}
			}
			
			if(relatedAssetList.size() > numbersOfRelatedAssetsDisplay){
				
				relatedAssetList = ListUtil.subList(relatedAssetList, 0, numbersOfRelatedAssetsDisplay);
			}
			return relatedAssetList;
		}
		catch (Exception e) {	
			_log.error(e);
			return Collections.EMPTY_LIST;
		}
	}
	
	/**
	 * @todo SU DUNG DYNAMIC QUERY DE LAY DANH SACH TIN BAI LIEN QUAN DUA VAO VIEC SO SANH PUBLISHDATE CUA CAC TIN BAI HIEN 
	 * 			CO TRONG DATABASE VOI PUBLISHDATE CUA TIN BAI DANG HIEN THI CHI TIET
	 * @author HungDX	
	 * @date Aug 13, 2012
	 * @return List<AssetEntry>
	 * @param currentAssetEntryId
	 * @param prepareOperator
	 * @param numbersOfRelatedAssetsDisplay
	 * @return
	 * @throws SystemException
	 */
	public static List<AssetEntry> getRelatedAssetByPublishDate(long currentAssetEntryId,String prepareOperator,int numbersOfRelatedAssetsDisplay) 
					throws SystemException{
		
		try {
			List<AssetEntry> relatedAssetEntryList = new ArrayList<AssetEntry>();
			
			if(currentAssetEntryId > 0){
				
				//Entry dang hien thi chi tiet noi dung
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(currentAssetEntryId);
				
				if(assetEntry != null){
					
					//GroupId cua entry dang hien thi chi tiet noi dung
					long groupId = assetEntry.getGroupId();
					
					//Ngay xuat ban cua entry dang hien thi chi tiet noi dung
					Date publishDate = assetEntry.getPublishDate();
					
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetEntry.class,PortalClassLoaderUtil.getClassLoader());
					
					dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
					dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class)));
					
					if(Validator.equals(prepareOperator, StringPool.GREATER_THAN)){
						
						dynamicQuery.add(PropertyFactoryUtil.forName("publishDate").gt(publishDate));
						
					}else if(Validator.equals(prepareOperator, StringPool.LESS_THAN)){
						
						dynamicQuery.add(PropertyFactoryUtil.forName("publishDate").lt(publishDate));
					}
					
					dynamicQuery.addOrder(OrderFactoryUtil.desc("publishDate"));
					
					if(numbersOfRelatedAssetsDisplay >= 0){
						
						relatedAssetEntryList = AssetEntryLocalServiceUtil.dynamicQuery(dynamicQuery, 0, numbersOfRelatedAssetsDisplay);
					}
				}
				
			}
			
			return relatedAssetEntryList;
		}
		catch (Exception e) {
			_log.error(e);
			return Collections.EMPTY_LIST;
		}
	}
	

	/**
	 * @todo LAY DANH SACH TIN BAI LIEN QUAN THEO TAG CUA TIN BAI HIEN TAI
	 * @author HungDX	
	 * @date Aug 9, 2012
	 * @return List<AssetEntry>
	 * @param currentAssetEntryId
	 * @param numbersOfRelatedAssetsDisplay
	 * @return
	 */
	private static List<AssetEntry> getRelatedAssetByTag(long currentAssetEntryId,int numbersOfRelatedAssetsDisplay){
		
		try {
			List<AssetEntry> relatedAssetList = new ArrayList<AssetEntry>();
			
			long[] currentAssetTagIds = null;
			
			if(currentAssetEntryId > 0){
				
				AssetEntry currentAssetEntry = AssetEntryLocalServiceUtil.getAssetEntry(currentAssetEntryId);
				
				if(currentAssetEntry != null){
					
					long groupId = currentAssetEntry.getGroupId();
					
					String[] currentAssetTagNames = currentAssetEntry.getTagNames();
					
					if(groupId > 0 && currentAssetTagNames.length > 0){
						
						currentAssetTagIds = AssetTagLocalServiceUtil.getTagIds(groupId, currentAssetTagNames);	
					}
				}
			}
			
			if(currentAssetTagIds != null){
				
				AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
				
				assetEntryQuery.setAnyTagIds(currentAssetTagIds);
				assetEntryQuery.setOrderByCol1("publishDate");
				assetEntryQuery.setOrderByType1("DESC");
				assetEntryQuery.setStart(0);
				assetEntryQuery.setEnd(numbersOfRelatedAssetsDisplay);
				
				relatedAssetList = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);
			}
			return relatedAssetList;
		}
		catch (Exception e) {
			_log.error(e);
			return Collections.EMPTY_LIST;
		}
		
	}
	
	/**
	 * @todo LAY DANH SACH TIN BAI LIEN QUAN THEO CATEGORY CUA TIN BAI HIEN TAI
	 * @author HungDX	
	 * @date Aug 9, 2012
	 * @return List<AssetEntry>
	 * @param currentAssetEntryId
	 * @param numbersOfRelatedAssetsDisplay
	 * @return
	 */
	private static List<AssetEntry> getRelatedAssetByCategory(long currentAssetEntryId,int numbersOfRelatedAssetsDisplay){
		
		try {
			List<AssetEntry> relatedAssetList = new ArrayList<AssetEntry>();
			
			long[] currentCategoryIds = null;
			
			if(currentAssetEntryId > 0){
				
				AssetEntry currentAssetEntry = AssetEntryLocalServiceUtil.getAssetEntry(currentAssetEntryId);
				
				if(currentAssetEntry != null){
					
					List<AssetCategory> currentCategoryList =  currentAssetEntry.getCategories();
					
					if(currentCategoryList.size() > 0){
						
						currentCategoryIds = new long[currentCategoryList.size()];
						
						for(int i = 0; i< currentCategoryList.size();i++){
							
							AssetCategory assetCategory = currentCategoryList.get(i);
							
							currentCategoryIds[i] = assetCategory.getCategoryId();
						}
					}
				}
			}
			
			if(currentCategoryIds != null){
				
				AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
				
				assetEntryQuery.setAnyCategoryIds(currentCategoryIds);
				assetEntryQuery.setOrderByCol1("publishDate");
				assetEntryQuery.setOrderByType1("DESC");
				assetEntryQuery.setStart(0);
				assetEntryQuery.setEnd(numbersOfRelatedAssetsDisplay);
				
				relatedAssetList = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);
			}
			
			return relatedAssetList;
		}
		catch (Exception e) {
			_log.error(e);
			return Collections.EMPTY_LIST;
		}
	}
	
	
	/**
	 * @todo TAO VIEWURL CHO RELATED ENTRY
	 * @author HungDX	
	 * @date Aug 10, 2012
	 * @return String
	 * @param request
	 * @param assetEntry
	 * @return
	 */
	public static String getViewContentURL(HttpServletRequest request,AssetEntry assetEntry){
		
		String viewContentURL = "";
		
		if(assetEntry != null){
			try {
				
				long entryId = assetEntry.getEntryId();
				
				long classPK = assetEntry.getClassPK();
				
				ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
				
				//layout id cua page hien thi chi tiet tin bai
				long pageLayoutId = themeDisplay.getLayout().getPlid();
				
				String className = PortalUtil.getClassName(assetEntry.getClassNameId());
								
				AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);
				
				AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(classPK);
				
				List<AssetCategory> assetCategoryList = AssetCategoryLocalServiceUtil.getEntryCategories(entryId);
				
				if(!assetCategoryList.isEmpty()){	
					
					AssetCategory assetCategory = assetCategoryList.get(0);
																			
					List<AssetCategoryProperty> categoryPropertyList = AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(assetCategory.getCategoryId());
																					
					if(categoryPropertyList.size() > 0){
						
						//layoutId la layoutId cua Page duoc chon de hien thi tin bai theo tung Category
						//layoutId duoc luu duoi dang property cua Category voi propertyKey = "link-to-page"
						//Cac thuoc tinh (property) cua Category duoc luu trong bang assetcategoryproperty
						pageLayoutId = Long.parseLong(getCategoryPropertyValue(assetCategory.getCategoryId(), 
																PAGE_LAYOUT_ID_CATEGORY_PROPERTY_KEY, String.valueOf(pageLayoutId)));
					}																																	
				}
				
				//Tao URL lien ket tu trang hien tai sang trang hien thi chi tiet noi dung tin bai dua vao pageLayoutId
				//"101" la ten cua portlet Asset Publisher
				PortletURL viewFullContentURL = PortletURLFactoryUtil.create(request, "101", pageLayoutId, PortletRequest.RENDER_PHASE);
				
				viewFullContentURL.setWindowState(WindowState.NORMAL);
				viewFullContentURL.setPortletMode(PortletMode.VIEW);
				viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
				viewFullContentURL.setParameter("assetEntryId", String.valueOf(entryId));
				viewFullContentURL.setParameter("type", assetRendererFactory.getType());				
				
				if (Validator.isNotNull(assetRenderer.getUrlTitle())) 
				{					
					viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
				}
				
				viewContentURL = viewFullContentURL.toString();
				
			} catch (Exception e) {
				_log.error(e);
			}
		}
		return viewContentURL;
	}

	
	/**
	 * @todo LAY THUOC TINH DONG CUA CATEGORY (CATEGORY PROPERTY)
	 * @author HungDX	
	 * @date Aug 10, 2012
	 * @return String
	 * @param categoryId
	 * @param propertyKey
	 * @param defaultValue
	 * @return
	 */
	private static String getCategoryPropertyValue(long categoryId,String propertyKey,String defaultValue){
		
		try {
			
			//Lay danh sach tat ca cac thuoc tinh dong cua Category theo categoryId
			List<AssetCategoryProperty> propertyList = AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(categoryId);
			
			if (propertyList.isEmpty()) {//Truong hop Category khong co thuoc tinh dong thi method se tra ve gia tri mac dinh
				
				return defaultValue;
				
			}else {
				
				String propertyValue = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(categoryId, propertyKey).getValue();
				
				return propertyValue;
			}
			
		} catch (Exception e) {
			
			if(e instanceof NoSuchCategoryPropertyException){//Truong hop ko tim thay thuoc tinh tuong ung voi PropertyKey truyen vao					
				System.out.println("[" + RelatedAssetUtil.class.getName() + "]" + "No such categoryProperty exist with propertyKey = " + propertyKey);
			}else{
				_log.error(e);
			}
			return defaultValue;
		}	
	}
	private static final long WEB_CONTENT_CLASS_NAME_ID = 10108;
	private static final String ASSET_TAG_FILTER= "assetTag";
	private static final String ASSET_CATEGORY_FILTER= "assetCategory";
	private static final String PAGE_LAYOUT_ID_CATEGORY_PROPERTY_KEY = "link-to-page";
	private static Log _log = LogFactory.getLog(RelatedAssetUtil.class.getName());
}
