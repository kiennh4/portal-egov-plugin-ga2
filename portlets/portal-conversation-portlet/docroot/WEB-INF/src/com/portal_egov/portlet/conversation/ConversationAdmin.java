package com.portal_egov.portlet.conversation;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.conversation.model.CO_Category;
import com.portal_egov.portlet.conversation.model.CO_Conversation;
import com.portal_egov.portlet.conversation.model.CO_Thread;
import com.portal_egov.portlet.conversation.permission.CO_CategoryPermission;
import com.portal_egov.portlet.conversation.permission.CO_ConversationPermission;
import com.portal_egov.portlet.conversation.permission.CO_ThreadPermission;
import com.portal_egov.portlet.conversation.service.CO_CategoryLocalServiceUtil;
import com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil;
import com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil;
import com.portal_egov.portlet.conversation.util.CO_Constants;
import com.portal_egov.portlet.conversation.util.ConversationUtil;

/**
 * Portlet implementation class ConversationAdmin
 */
public class ConversationAdmin extends MVCPortlet {
public static void updateConversationContent(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			long conversationId = ParamUtil.getLong(actionRequest, "conversationId",0L);
			
			long threadId = ParamUtil.getLong(actionRequest, "threadId",0L);
			
			String conversationTitle = ParamUtil.getString(actionRequest, "conversationTitle",StringPool.BLANK);
			
			String askUserName = ParamUtil.getString(actionRequest, "askUserName",StringPool.BLANK);
			
			String askUserAddress = ParamUtil.getString(actionRequest, "askUserAddress",StringPool.BLANK);
			
			String askContent = ParamUtil.getString(actionRequest, "askContent",StringPool.BLANK);
			
			String answerUserName = ParamUtil.getString(actionRequest, "answerUserName",StringPool.BLANK);
			
			String answerUserInfo = ParamUtil.getString(actionRequest, "answerUserInfo",StringPool.BLANK);
			
			String answerContent = ParamUtil.getString(actionRequest, "answerContent",StringPool.BLANK);
			
			Date askDate = ConversationUtil.getConversationAskDate(actionRequest);
			
			Date answerDate = null;
			
			if(!Validator.equals(answerContent, StringPool.BLANK)){
				answerDate = new Date();
			}
			
			int conversationStatus = ParamUtil.getInteger(actionRequest, "conversationStatus",CO_Constants.DEFAULT_CONVERSATION_STATUS_VALUE);
			
			if((!Validator.equals(answerContent, StringPool.BLANK))
							&&(conversationStatus == CO_Constants.DEFAULT_CONVERSATION_STATUS_VALUE)){
				conversationStatus = CO_Constants.ANSWERED_CONVERSATION_STATUS_VALUE;
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			if(conversationId > 0){
				//update conversaion entry
				CO_ConversationLocalServiceUtil.updateCOConversation(conversationId, companyId, groupId, userId, threadId,
								conversationTitle, askUserName, askUserAddress, askContent, answerUserName,answerUserInfo,
								answerContent, askDate, answerDate, conversationStatus);
				
			}else{

				ServiceContext serviceContext = ServiceContextFactory.getInstance(CO_Conversation.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {CO_ConversationPermission.VIEW_CONVERSATION});
				serviceContext.setGuestPermissions(new String[] {CO_ConversationPermission.VIEW_CONVERSATION});
				//add new entry
				CO_ConversationLocalServiceUtil.addCOConversation(companyId, groupId, userId, threadId, conversationTitle, 
								askUserName, askUserAddress, askContent, answerUserName, answerUserInfo, answerContent,
								askDate, answerDate, serviceContext);
			}
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			if(e instanceof NoSuchCO_ConversationException){
				
			}else{
				_log.error(e);
			}
		}
		
	}
	
	//Remove conversation trong danh sach conversation entries cua thread
	public static void removeConversationEntry(ActionRequest actionRequest,ActionResponse actionResponse){
		try {
			
			long conversationId = ParamUtil.getLong(actionRequest, "conversationId",0L);
			
			if(conversationId >0){
				
				String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
				
				CO_Conversation currentConversation = CO_ConversationLocalServiceUtil.getCO_Conversation(conversationId);
				
				if(currentConversation != null){
					
					currentConversation.setThreadId(CO_Constants.DEFAULT_THREAD_ID);
					
					CO_ConversationLocalServiceUtil.updateCO_Conversation(currentConversation, false);
					
					actionResponse.sendRedirect(redirectURL);
				}
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	public static void publishCOConversation(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			long conversationId = ParamUtil.getLong(actionRequest, "conversationId",0L);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			if(conversationId > 0){
				
				CO_Conversation conversation = CO_ConversationLocalServiceUtil.getCO_Conversation(conversationId);
				
				if(conversation != null){
					Date now = new Date();
					long userId = PortalUtil.getUserId(actionRequest);
					
					conversation.setStatus(CO_Constants.PUBLISH_CONVERSATION_STATUS_VALUE);
					conversation.setStatusDate(now);
					conversation.setStatusByUserId(userId);
					
					CO_ConversationLocalServiceUtil.updateCO_Conversation(conversation,false);
				}
			}
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			if(e instanceof NoSuchCO_ConversationException){
				
			}else{
				_log.error(e);
			}
		}
		
	}
	
	public static void deleteCOConversation(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			long conversationId = ParamUtil.getLong(actionRequest, "conversationId",0L);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			if(conversationId > 0){
				
				CO_ConversationLocalServiceUtil.deleteCO_Conversation(conversationId);
			}
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			if(e instanceof NoSuchCO_ConversationException){
				
			}else{
				_log.error(e);
			}
		}
		
	}
	
	
	public static void updateCOThread(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long threadId = ParamUtil.getLong(actionRequest, "threadId",0L);
			
			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			long parentThreadId = ParamUtil.getLong(actionRequest, "parentThreadId",0L);
			
			long threadCategoryId = ParamUtil.getLong(actionRequest, "threadCategoryId",0L);
			
			String threadName = ParamUtil.getString(actionRequest, "threadName",StringPool.BLANK);
			
			String departmentName = ParamUtil.getString(actionRequest, "departmentName",StringPool.BLANK);
			
			String threadParticipants = ParamUtil.getString(actionRequest, "threadParticipants",StringPool.BLANK);
			
			String threadDesc = ParamUtil.getString(actionRequest, "threadDesc",StringPool.BLANK);
			
			Date threadStartDate = ConversationUtil.getThreadStartDate(actionRequest);
			
			Date threadEndDate = ConversationUtil.getThreadEndDate(actionRequest);
			
			//Status ban dau cua thread
			int currentThreadStatus = ParamUtil.getInteger(actionRequest, "threadStatus",CO_Constants.DEFAULT_THREAD_STATUS_VALUE);
			
			//Status cua thread sau khi cap nhat ngay bat dau va ngay ket thuc
			int threadStatus = getThreadStatus(threadStartDate, threadEndDate, currentThreadStatus);
			
			//Danh sach Id cua cac cau hoi trong searchContainerMapping duoc luu duoi dang String.VD 80001,80002
			String conversationMappingContainerPrimaryKeys = ParamUtil.getString(actionRequest, "conversationMappingContainerPrimaryKeys",StringPool.BLANK);
			
			//Mang string chua cac Id cua vbpq duoc split tu vbpqMappingSearchContainerPrimaryKeys theo dau "," (COMMA)
			String[] conversationMappingIds = StringUtil.split(conversationMappingContainerPrimaryKeys, StringPool.COMMA);
			
			//Danh sach cac cau hoi dang publish hien thi tren Site
			List<CO_Conversation> publishThreadConversationList = CO_ConversationLocalServiceUtil.findByThreadAndGroupAndStatus(threadId,
				groupId, CO_Constants.PUBLISH_CONVERSATION_STATUS_VALUE);
			
			//Thay doi trang thai cua cac cau hoi publish hien tai ve "UNPUBLISH"
			for(CO_Conversation publishConversation : publishThreadConversationList){
				
				publishConversation.setStatus(CO_Constants.ANSWERED_CONVERSATION_STATUS_VALUE);
				CO_ConversationLocalServiceUtil.updateCO_Conversation(publishConversation,false);
			}
			
			if(conversationMappingIds.length > 0){
				
				for (int i = 0; i < conversationMappingIds.length; i++) {
					
					long conversationId = GetterUtil.getLong(conversationMappingIds[i], 0L);
					
					if(conversationId > 0L){
						
						CO_Conversation mappingConversation = CO_ConversationLocalServiceUtil.getCO_Conversation(conversationId);
						
						if(mappingConversation != null){
							
							//Xet trang thai cau hoi thanh "PUBLISH"
							mappingConversation.setStatus(CO_Constants.PUBLISH_CONVERSATION_STATUS_VALUE);
							CO_ConversationLocalServiceUtil.updateCO_Conversation(mappingConversation,false);
						}
					}
				}
			}
			
			if(threadId > 0){
				
				//update thread
				CO_ThreadLocalServiceUtil.updateCOThread(threadId, companyId, groupId, userId, parentThreadId,
					threadCategoryId, threadName, threadDesc, departmentName, threadParticipants,
															threadStartDate,threadEndDate, threadStatus);
			}else{
				//Add new thread

				ServiceContext serviceContext = ServiceContextFactory.getInstance(CO_Thread.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {CO_ThreadPermission.VIEW_THREAD});
				serviceContext.setGuestPermissions(new String[] {CO_ThreadPermission.VIEW_THREAD});
				
				CO_ThreadLocalServiceUtil.addCOThread(companyId, groupId, userId, parentThreadId, threadCategoryId, 
														threadName, threadDesc, departmentName, threadParticipants,
														threadStartDate,threadEndDate,threadStatus, serviceContext);
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	public static void publishCOThread(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long threadId = ParamUtil.getLong(actionRequest, "threadId",0L);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			if(threadId > 0){
				
				CO_Thread coThread = CO_ThreadLocalServiceUtil.getCO_Thread(threadId);
				
				if(coThread != null){
					Date now = new Date();
					long userId = PortalUtil.getUserId(actionRequest);
					
					coThread.setStatus(CO_Constants.PUBLISH_THREAD_STATUS_VALUE);
					coThread.setStartDate(now);
					coThread.setStatusByUserId(userId);
					
					CO_ThreadLocalServiceUtil.updateCO_Thread(coThread,false);
				}
			}else{
				
				updateCOThread(actionRequest, actionResponse);
			}
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			if(e instanceof NoSuchCO_ThreadException){
				
			}else{
				_log.error(e);
			}
		}
		
	}
	
	public static void deleteCOThread(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			
			long threadId = ParamUtil.getLong(actionRequest, "threadId",0L);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			if(threadId > 0){
				
				List<CO_Thread> subThreadList = CO_ThreadLocalServiceUtil.findByParentThreadAndCompany(threadId, companyId);
				
				//Delete sub thread
				for(CO_Thread subThread : subThreadList){
					
					subThread.setParentThreadId(CO_Constants.DEFAULT_PARENT_THREAD_ID);
					
					CO_ThreadLocalServiceUtil.updateCO_Thread(subThread, false);
				}
				
				List<CO_Conversation> conversationList = CO_ConversationLocalServiceUtil.findByThreadAndCompany(threadId, companyId);
				
				for(CO_Conversation conversation : conversationList){
					
					CO_ConversationLocalServiceUtil.deleteCO_Conversation(conversation);
				}
				
				CO_ThreadLocalServiceUtil.deleteCO_Thread(threadId);
			}
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			if(e instanceof NoSuchCO_ThreadException){
				
			}else{
				_log.error(e);
			}
		}
	}
	
	public static void updateCOCategory(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			long parentCategoryId = ParamUtil.getLong(actionRequest, "parentCategoryId",0L);
			
			String categoryName = ParamUtil.getString(actionRequest, "categoryName",StringPool.BLANK);
			
			String categoryDesc = ParamUtil.getString(actionRequest, "categoryDesc",StringPool.BLANK);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			if(categoryId > 0){
				
				//update CO Category
				CO_CategoryLocalServiceUtil.updateCOCategory(categoryId, companyId, groupId, userId, parentCategoryId, categoryName, categoryDesc);
				
			}else{

				ServiceContext serviceContext = ServiceContextFactory.getInstance(CO_Category.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {CO_CategoryPermission.VIEW_CATEGORY});
				serviceContext.setGuestPermissions(new String[] {CO_CategoryPermission.VIEW_CATEGORY});
				//add new FAQ Category
				CO_CategoryLocalServiceUtil.addCOCategory(companyId, groupId, userId, parentCategoryId, categoryName, categoryDesc, serviceContext);
			}
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			if(e instanceof NoSuchCO_CategoryException){
				
			}else{
				_log.error(e);
			}
		}
	}
	
	public static void deleteCOCategory(ActionRequest actionRequest,ActionResponse actionResponse){
	
		try{
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			if(categoryId > 0){
				
				List<CO_Thread> threadList = CO_ThreadLocalServiceUtil.findByCategoryAndCompany(categoryId, companyId);
				
				for(CO_Thread coThread : threadList){
					
					coThread.setCategoryId(CO_Constants.DEFAULT_CATEGORY_ID);
					
					CO_ThreadLocalServiceUtil.updateCO_Thread(coThread, false);
				}
				
				
				CO_CategoryLocalServiceUtil.deleteCO_Category(categoryId);
			}
			
			actionResponse.sendRedirect(redirectURL);
		}catch(Exception e){
			if(e instanceof NoSuchCO_CategoryException){
				
			}else{
				_log.error(e);
			}
		}
	}

	/**
	 * 
	 * @todo LAY STATUS CUA THREAD DUA VAO THOI GIAN BAT DAU VA KET THUC CUA THREAD
	 * @author HungDX	
	 * @date Aug 1, 2012
	 * @return int
	 * @param threadStartDate - Thoi gian bat dau thao luan
	 * @param threadEndDate - Thoi gian ket thuc thao luan
	 * @param defaultStatus - GIa tri mac dinh tra ve
	 * @return
	 */
	private static int getThreadStatus(Date threadStartDate,Date threadEndDate,int defaultStatus){
		
		try {
			int threadStatus = CO_Constants.DEFAULT_THREAD_STATUS_VALUE;
			
			Date now = new Date();
			
			if(threadStartDate.before(now) && threadEndDate.before(now)){//Publish thread
				
				threadStatus = CO_Constants.PUBLISH_THREAD_STATUS_VALUE;
			
			}else if(threadStartDate.after(now) && threadEndDate.after(now)){//Open thread
				
				threadStatus = CO_Constants.OPEN_THREAD_STATUS_VALUE;
			}else if(threadStartDate.before(now) && threadEndDate.after(now)){//Online thread
				
				threadStatus = CO_Constants.ONLINE_THREAD_STATUS_VALUE;
			}else{
				threadStatus = defaultStatus;
			}
			return threadStatus;
		}
		catch (Exception e) {
			_log.error(e);
			return defaultStatus;
		}
	}
	
	private static Log _log = LogFactory.getLog(ConversationAdmin.class.getName());

}
