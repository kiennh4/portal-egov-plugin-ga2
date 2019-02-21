package com.portal_egov.portlet.proposition_feedback;

import java.io.InputStream;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.proposition_feedback.model.Proposition;
import com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback;
import com.portal_egov.portlet.proposition_feedback.permission.PropositionFeedbackPermission;
import com.portal_egov.portlet.proposition_feedback.permission.PropositionPermission;
import com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil;
import com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil;
import com.portal_egov.portlet.proposition_feedback.util.PropositionConstants;
import com.portal_egov.portlet.proposition_feedback.util.PropositionUtil;

/**
 * Portlet implementation class PropositionFeedbackAdmin
 */
public class PropositionFeedbackAdmin extends MVCPortlet {
 
	public static void updateProposition(ActionRequest actionRequest,ActionResponse actionResponse){
		try {
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			int propositionStatus = ParamUtil.getInteger(uploadRequest, "propositionStatus",PropositionConstants.DEFAULT_PROPOSITION_STATUS_VALUE);
			
			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			long propositionId = ParamUtil.getLong(actionRequest, "propositionId",0L);
			
			long categoryId = ParamUtil.getLong(uploadRequest, "categoryId",0L);
			
			long compilationDepartmentId = ParamUtil.getLong(uploadRequest, "compilationDepartmentId",0L);
			
			long verificationDepartmentId = ParamUtil.getLong(uploadRequest, "verificationDepartmentId",0L);
			
			long propositionDocFileId = ParamUtil.getLong(uploadRequest, "propositionDocFileId",0L);
			
			InputStream inputStream = uploadRequest.getFileAsStream(PROPOSITION_DOCUMENT_FILE_PARAM_NAME);
			
			if((inputStream != null) && (propositionDocFileId <= 0)){
				
				propositionDocFileId = PropositionUtil.uploadPropositionDocFile(uploadRequest,actionRequest, PROPOSITION_DOCUMENT_FILE_PARAM_NAME, PROPOSITION_DOCUMENT_FOLDER_NAME);
			}
			
			String propositionName = ParamUtil.getString(uploadRequest, "propositionName",StringPool.BLANK);
			
			String propositionDesc = ParamUtil.getString(uploadRequest, "propositionDesc",StringPool.BLANK);
			
			String propositionContent = ParamUtil.getString(uploadRequest, "propositionContent",StringPool.BLANK);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			if(propositionId > 0){
				
				//update Proposition
				PropositionLocalServiceUtil.updateProposition(propositionId, companyId, groupId, userId, categoryId, compilationDepartmentId,
									verificationDepartmentId, propositionName, propositionDesc, propositionContent, propositionDocFileId, propositionStatus);
				
			}else{

				ServiceContext serviceContext = ServiceContextFactory.getInstance(Proposition.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {PropositionPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {PropositionPermission.VIEW});
				
				//add new Proposition Category
				PropositionLocalServiceUtil.addProposition(companyId, groupId, userId, categoryId, compilationDepartmentId, verificationDepartmentId,
												propositionName, propositionDesc, propositionContent, propositionDocFileId, propositionStatus, serviceContext);
			}
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			if(e instanceof NoSuchPropositionException){
				
			}else{
				_log.error(e);
			}
		}
	}
	 
	public static void deleteProposition(ActionRequest actionRequest,ActionResponse actionResponse){
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);

			long propositionId = ParamUtil.getLong(actionRequest, "propositionId",0L);
			
			if(propositionId > 0){
				
				List<PropositionFeedback> propositionFeedbackList = PropositionFeedbackLocalServiceUtil.findByPropositionAndCompany(companyId, propositionId);
				
				for(PropositionFeedback feedback : propositionFeedbackList){
					
					PropositionFeedbackLocalServiceUtil.deletePropositionFeedback(feedback.getFeedbackId());
				}
				
				PropositionLocalServiceUtil.deleteProposition(propositionId);
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			if(e instanceof NoSuchPropositionException){
				
			}else{
				_log.error(e);
			}
		}
		
	}
	
	public static void updateFeedbackContent(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			long feedbackId = ParamUtil.getLong(actionRequest, "feedbackId",0L);
			
			int feedbackStatus = ParamUtil.getInteger(actionRequest, "status",PropositionConstants.DEFAULT_FEEDBACK_STATUS_VALUE);
			
			long propositionId = ParamUtil.getLong(actionRequest, "propositionId",0L);
			
			String citizenName = ParamUtil.getString(actionRequest, "citizenName",StringPool.BLANK);
			
			String citizenEmail = ParamUtil.getString(actionRequest, "citizenEmail",StringPool.BLANK);
			
			String citizenPhone = ParamUtil.getString(actionRequest, "citizenPhone",StringPool.BLANK);
			
			String citizenAddress = ParamUtil.getString(actionRequest, "citizenAddress",StringPool.BLANK);
			
			String feedbackTitle = ParamUtil.getString(actionRequest, "feedbackTitle",StringPool.BLANK);
			
			String feedbackContent = ParamUtil.getString(actionRequest, "feedbackContent",StringPool.BLANK);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			if(feedbackId > 0){

				PropositionFeedbackLocalServiceUtil.updatePropositionFeedback(feedbackId, companyId, groupId, userId, propositionId, 0,
					feedbackTitle, feedbackContent, citizenName, citizenEmail, citizenPhone, citizenAddress, feedbackStatus);
				
			}else{
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(PropositionFeedback.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {PropositionFeedbackPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {PropositionFeedbackPermission.VIEW});
				
				PropositionFeedbackLocalServiceUtil.addPropositionFeedback(companyId, groupId, userId, propositionId, 0L,
					feedbackTitle, feedbackContent, citizenName, citizenEmail, citizenPhone, citizenAddress,feedbackStatus, serviceContext);
			}
			
			PropositionLocalServiceUtil.incrementFeedbackCounter(propositionId);
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	public static void publishFeedback(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long feedbackId = ParamUtil.getLong(actionRequest, "feedbackId",0L);
			
			if(feedbackId > 0){
				
				PropositionFeedback feedback = PropositionFeedbackLocalServiceUtil.getPropositionFeedback(feedbackId);
				
				if(feedback != null){
					feedback.setStatus(PropositionConstants.PUBLISH_FEEDBACK_STATUS_VALUE);
					
					PropositionFeedbackLocalServiceUtil.updatePropositionFeedback(feedback, false);
				}
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	public static void deleteFeedback(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long feedbackId = ParamUtil.getLong(actionRequest, "feedbackId",0L);
			
			if(feedbackId > 0){
				
				PropositionFeedback feedback = PropositionFeedbackLocalServiceUtil.getPropositionFeedback(feedbackId);
				
				if(feedback != null){
					
					PropositionLocalServiceUtil.descrementFeedbackCounter(feedback.getPropositionId());
					PropositionFeedbackLocalServiceUtil.deletePropositionFeedback(feedback);
				}
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	//Ten cua folder chua cac file van ban goc cua du thao luat
	private static final String PROPOSITION_DOCUMENT_FOLDER_NAME = "DU THAO PHAP LUAT";
	
	//Attribute Name cua the input file trong form update proposition
	private static final String PROPOSITION_DOCUMENT_FILE_PARAM_NAME = "propositionDocumentFile";
	
	private static Log _log = LogFactory.getLog(PropositionFeedbackAdmin.class.getName());
}
