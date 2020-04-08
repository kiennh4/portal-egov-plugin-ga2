package com.portal_egov.portlet.proposition_feedback;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.proposition_feedback.model.Proposition;
import com.portal_egov.portlet.proposition_feedback.model.PropositionCategory;
import com.portal_egov.portlet.proposition_feedback.permission.PropositionCategoryPermission;
import com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryLocalServiceUtil;
import com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil;
import com.portal_egov.portlet.proposition_feedback.util.PropositionConstants;

/**
 * Portlet implementation class PropositionFeedbackCategoryAdmin
 */
public class PropositionFeedbackCategoryAdmin extends MVCPortlet {
 
	
	public static void updatePropositionCategory(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			long parentCategoryId = ParamUtil.getLong(actionRequest, "parentCategoryId",0L);
			
			int categoryTypeId = ParamUtil.getInteger(actionRequest, "categoryTypeId",PropositionConstants.PROPOSITION_CATEGORY_TYPE_ID);
			
			String categoryName = ParamUtil.getString(actionRequest, "categoryName",StringPool.BLANK);
			
			String categoryDesc = ParamUtil.getString(actionRequest, "categoryDesc",StringPool.BLANK);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			if(categoryId > 0){
				
				//update Proposition Category
				PropositionCategoryLocalServiceUtil.updateCategory(categoryId, companyId, groupId, userId, 
													categoryTypeId, parentCategoryId, categoryName, categoryDesc);
				
			}else{

				ServiceContext serviceContext = ServiceContextFactory.getInstance(PropositionCategory.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {PropositionCategoryPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {PropositionCategoryPermission.VIEW});
				
				//add new Proposition Category
				PropositionCategoryLocalServiceUtil.addCategory(companyId, groupId, userId, categoryTypeId, 
											parentCategoryId, categoryName, categoryDesc, serviceContext);
			}
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			if(e instanceof NoSuchPropositionCategoryException){
				
			}else{
				_log.error(e);
			}
		}
	}
	
	public static void deletePropositionCategory(ActionRequest actionRequest,ActionResponse actionResponse){
	
		try{
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			if(categoryId > 0){
				
				List<Proposition> propositionList = PropositionLocalServiceUtil.findByCategoryAndCompany(companyId, categoryId);
				
				for(Proposition proposition : propositionList){
					
					proposition.setCategoryId(PropositionConstants.DEFAULT_PROPOSITION_CATEGORY_ID);
					
					PropositionLocalServiceUtil.updateProposition(proposition, false);
				}
				PropositionCategoryLocalServiceUtil.deleteCategory(categoryId);
			}
			
			actionResponse.sendRedirect(redirectURL);
			
		}catch(Exception e){
			if(e instanceof NoSuchPropositionCategoryException){
				
			}else{
				_log.error(e);
			}
		}
	}

	private static Log _log = LogFactory.getLog(PropositionFeedbackCategoryAdmin.class.getName());
}
