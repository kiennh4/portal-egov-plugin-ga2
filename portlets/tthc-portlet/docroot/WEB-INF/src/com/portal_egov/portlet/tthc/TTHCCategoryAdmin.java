package com.portal_egov.portlet.tthc;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.tthc.model.TTHC_Category;
import com.portal_egov.portlet.tthc.model.TTHC_Entry;
import com.portal_egov.portlet.tthc.permission.TTHCCategoryPermission;
import com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil;
import com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil;
import com.portal_egov.portlet.tthc.util.TTHCConstants;



public class TTHCCategoryAdmin extends MVCPortlet {
 
	public void updateCategory(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0L);

			long parentCategoryId = ParamUtil.getLong(actionRequest, "parentCategoryId", 0L);

			int categoryTypeId = ParamUtil.getInteger(actionRequest, "categoryTypeId", 0);

			String categoryName = ParamUtil.getString(actionRequest, "categoryName", StringPool.BLANK);

			String categoryDesc = ParamUtil.getString(actionRequest, "categoryDesc", StringPool.BLANK);
			
			int displayPriority = ParamUtil.getInteger(actionRequest, "displayPriority", 0);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(TTHC_Category.class.getName(), actionRequest);
			
			serviceContext.setGroupPermissions(new String[] {TTHCCategoryPermission.VIEW_CATEGORY});
			serviceContext.setGuestPermissions(new String[] {TTHCCategoryPermission.VIEW_CATEGORY});
			
			if (categoryId > 0) {//Update category
				
				TTHC_CategoryLocalServiceUtil.updateTTHCCategory(categoryId, companyId, groupId, userId, parentCategoryId,
													categoryTypeId, categoryName, categoryDesc,displayPriority);
			}
			else {//add category
				TTHC_CategoryLocalServiceUtil.addTTHCCategory(companyId, groupId, userId, parentCategoryId, 
													categoryTypeId, categoryName, categoryDesc,displayPriority, serviceContext);
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL", StringPool.BLANK);
			
			if(Validator.isNotNull(redirectURL)){
				
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			if(e instanceof NoSuchTTHC_CategoryException){
				_log.info(e);
			}else{
				_log.error(e);
			}
		}
	}
	
	public void deleteCategory(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {

			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0L);

			if (categoryId > 0) {
				
				//Update TTHC Entry
				updateTTHC_Entry(groupId, categoryId);
				
				//update childrent category
				updateChildCategory(groupId, categoryId);
				
				//Xoa Category
				TTHC_CategoryLocalServiceUtil.deleteTTHC_Category(categoryId);
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL", StringPool.BLANK);
			
			if(Validator.isNotNull(redirectURL)){
				
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			if(e instanceof NoSuchTTHC_CategoryException){
				_log.info(e);
			}else{
				_log.error(e);
			}
		}
	}
	
	
	protected void updateChildCategory(long groupId,long parentCategoryId) throws SystemException{
		
		List<TTHC_Category> childCategoryList = TTHC_CategoryLocalServiceUtil.findByParentAndGroup(parentCategoryId, groupId);
		
		for(TTHC_Category childCategory : childCategoryList){
			
			childCategory.setParentId(TTHCConstants.DEFAULT_CATEGORY_ID);
			
			TTHC_CategoryLocalServiceUtil.updateTTHC_Category(childCategory);
		}
			
	}
	
	/**
	 * 
	 * @todo Update cac thuoc tinh cua TTHC_Entry ve gia tri mac dinh (= 0) sau khi xoa category
	 * @author HungDX	
	 * @date Jun 28, 2012
	 * @return void
	 * @param companyId
	 * @param categoryId
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	protected void updateTTHC_Entry(long groupId,long categoryId) throws PortalException, SystemException{
			
		TTHC_Category tthcCategory = TTHC_CategoryLocalServiceUtil.getTTHC_Category(categoryId);

		int categoryTypeId = tthcCategory.getCategoryTypeId();
		
		List<TTHC_Entry> tthcEntryList = new ArrayList<TTHC_Entry>();
		
		
		if(categoryTypeId == TTHCConstants.TTHC_AUDIENCE_CATEGORY_TYPE_ID){
			
			tthcEntryList = TTHC_EntryLocalServiceUtil.findByAudienceAndGroup(categoryId, groupId);
			
			for(TTHC_Entry tthcEntry : tthcEntryList){
				
				tthcEntry.setAudienceId(TTHCConstants.DEFAULT_CATEGORY_ID);
				
				TTHC_EntryLocalServiceUtil.updateTTHC_Entry(tthcEntry);
			}
			
		}else if(categoryTypeId == TTHCConstants.TTHC_CATEGORY_CATEGORY_TYPE_ID){
			
			tthcEntryList = TTHC_EntryLocalServiceUtil.findByCategoryAndGroup(categoryId, groupId);
			
			for(TTHC_Entry tthcEntry : tthcEntryList){
				
				tthcEntry.setCategoryId(TTHCConstants.DEFAULT_CATEGORY_ID);
				
				TTHC_EntryLocalServiceUtil.updateTTHC_Entry(tthcEntry);
			}
		}else if(categoryTypeId == TTHCConstants.TTHC_DEPARTMENT_CATEGORY_TYPE_ID){
			
			tthcEntryList = TTHC_EntryLocalServiceUtil.findByDepartmentAndGroup(categoryId, groupId);
			
			for(TTHC_Entry tthcEntry : tthcEntryList){
				
				tthcEntry.setDepartmentId(TTHCConstants.DEFAULT_CATEGORY_ID);
				
				TTHC_EntryLocalServiceUtil.updateTTHC_Entry(tthcEntry);
			}
		}else if(categoryTypeId == TTHCConstants.TTHC_LEVEL_CATEGORY_TYPE_ID){
			
			tthcEntryList = TTHC_EntryLocalServiceUtil.findByLevelAndGroup(categoryId, groupId);
			
			for(TTHC_Entry tthcEntry : tthcEntryList){
				
				tthcEntry.setLevelId(TTHCConstants.DEFAULT_CATEGORY_ID);
				
				TTHC_EntryLocalServiceUtil.updateTTHC_Entry(tthcEntry);
			}
		}else if(categoryTypeId == TTHCConstants.TTHC_RESULT_TYPE_CATEGORY_TYPE_ID){
			
			tthcEntryList = TTHC_EntryLocalServiceUtil.findByResultTypeAndGroup(categoryId, groupId);
			
			for(TTHC_Entry tthcEntry : tthcEntryList){
				
				tthcEntry.setResultTypeId(TTHCConstants.DEFAULT_CATEGORY_ID);
				
				TTHC_EntryLocalServiceUtil.updateTTHC_Entry(tthcEntry);
			}
		}
	}
	
	private static Log _log = LogFactory.getLog(TTHCCategoryAdmin.class);
}
