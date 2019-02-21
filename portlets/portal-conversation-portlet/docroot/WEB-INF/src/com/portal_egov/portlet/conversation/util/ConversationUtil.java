/**
 * @author HungDX
 * @time 8:48:00 AM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.conversation.util;


import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.portal_egov.portlet.conversation.model.CO_Conversation;
import com.portal_egov.portlet.conversation.model.CO_Thread;
import com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil;
import com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil;

public class ConversationUtil {
	
	/**
	 * 
	 * @todo LAY THOI GIAN GUI CAU HOI CUA NGUOI THAM GIA GIAO LUU
	 * @author HungDX	
	 * @date Jul 26, 2012
	 * @return Date
	 * @param actionRequest
	 * @return
	 */
	public static Date getConversationAskDate(ActionRequest actionRequest){
		
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		
		try {
			
			int conversationAskDay = ParamUtil.getInteger(actionRequest, "conversationAskDay",calendar.get(Calendar.DATE));
			
			int conversationAskMonth = ParamUtil.getInteger(actionRequest, "conversationAskMonth",calendar.get(Calendar.MONTH));
			
			int conversationAskYear = ParamUtil.getInteger(actionRequest, "conversationAskYear",calendar.get(Calendar.YEAR));
			
			int conversationAskHour = ParamUtil.getInteger(actionRequest, "conversationAskHour",calendar.get(Calendar.HOUR));
			
			int conversationAskMinute = ParamUtil.getInteger(actionRequest, "conversationAskMinute",calendar.get(Calendar.MINUTE));
			
			int conversationAskAMPM = ParamUtil.getInteger(actionRequest, "conversationAskAMPM",calendar.get(Calendar.AM_PM));

			if (conversationAskAMPM == Calendar.PM) {
				conversationAskHour += 12;
			}
			
			long userId = PortalUtil.getUserId(actionRequest);
			
			User user = UserLocalServiceUtil.getUser(userId);
			
			Date conversationAskDate = PortalUtil.getDate(conversationAskMonth, conversationAskDay,
					conversationAskYear, conversationAskHour, conversationAskMinute, user.getTimeZone(), new PortalException());
			
			return conversationAskDate;
		}
		catch (Exception e) {
			_log.error(e);
			return calendar.getTime();
		}
	}
	
	
	/**
	 * 
	 * @todo LAY THOI GIAN BAT DAU DIEN RA CUOC GIAO LUU TU DATEPICKER TREN FORM UPDATE CONVERSATION THREAD
	 * @author HungDX	
	 * @date Jul 25, 2012
	 * @return Date
	 * @param actionRequest
	 * @return
	 */
	public static Date getThreadStartDate(ActionRequest actionRequest){
		
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		
		try {
			
			int threadStartDay = ParamUtil.getInteger(actionRequest, "threadStartDay",calendar.get(Calendar.DATE));
			
			int threadStartMonth = ParamUtil.getInteger(actionRequest, "threadStartMonth",calendar.get(Calendar.MONTH));
			
			int threadStartYear = ParamUtil.getInteger(actionRequest, "threadStartYear",calendar.get(Calendar.YEAR));
			
			int threadStartHour = ParamUtil.getInteger(actionRequest, "threadStartHour",calendar.get(Calendar.HOUR));
			
			int threadStartMinute = ParamUtil.getInteger(actionRequest, "threadStartMinute",calendar.get(Calendar.MINUTE));
			
			int threadStartAMPM = ParamUtil.getInteger(actionRequest, "threadStartAMPM",calendar.get(Calendar.AM_PM));

			if (threadStartAMPM == Calendar.PM) {
				threadStartHour += 12;
			}
			
			long userId = PortalUtil.getUserId(actionRequest);
			
			User user = UserLocalServiceUtil.getUser(userId);
			
			Date threadStartDate = PortalUtil.getDate(threadStartMonth, threadStartDay, threadStartYear,
													threadStartHour, threadStartMinute, user.getTimeZone(), new PortalException());
			
			return threadStartDate;
		}
		catch (Exception e) {
			_log.error(e);
			return calendar.getTime();
		}
	}
	
	
	/**
	 * 
	 * @todo LAY THOI GIAN KET THUC CUOC GIAO LUU TU DATEPICKER TREN FORM UPDATE CONVERSATION THREAD
	 * @author HungDX	
	 * @date Jul 25, 2012
	 * @return Date
	 * @param actionRequest
	 * @return
	 */
	public static Date getThreadEndDate(ActionRequest actionRequest){
		
		Calendar calendar = CalendarFactoryUtil.getCalendar();
		
		try {
			
			int threadEndDay = ParamUtil.getInteger(actionRequest, "threadEndDay",calendar.get(Calendar.DATE));
			
			int threadEndMonth = ParamUtil.getInteger(actionRequest, "threadEndMonth",calendar.get(Calendar.MONTH));
			
			int threadEndYear = ParamUtil.getInteger(actionRequest, "threadEndYear",calendar.get(Calendar.YEAR));
			
			int threadEndHour = ParamUtil.getInteger(actionRequest, "threadEndHour",calendar.get(Calendar.HOUR_OF_DAY));
			
			int threadEndMinute = ParamUtil.getInteger(actionRequest, "threadEndMinute",calendar.get(Calendar.MINUTE));
			
			int threadEndAMPM = ParamUtil.getInteger(actionRequest, "threadEndAMPM",calendar.get(Calendar.AM_PM));

			if (threadEndAMPM == Calendar.PM) {
				threadEndHour += 12;
			}
			
			long userId = PortalUtil.getUserId(actionRequest);
			
			User user = UserLocalServiceUtil.getUser(userId);
			
			Date threadEndDate = PortalUtil.getDate(threadEndMonth, threadEndDay, threadEndYear,
												threadEndHour, threadEndMinute, user.getTimeZone(), new PortalException());
			
			return threadEndDate;
		}
		catch (Exception e) {
			
			_log.error(e);
			return calendar.getTime();
		}
	}
	
	
	/**
	 * 
	 * @todo LAY TIEU DE TRANG THAI CUA THREAD
	 * @author HungDX	
	 * @date Jul 26, 2012
	 * @return String
	 * @param threadId
	 * @return
	 */
	public static String getThreadStatusTitle(long threadId){
		
		String threadStatusTitle = "UNDEFINED";
		
		try {
			
			CO_Thread thread = CO_ThreadLocalServiceUtil.getCO_Thread(threadId);
			
			if(thread != null){
				
				int threadStatusValue = thread.getStatus();
				
				if(threadStatusValue == CO_Constants.DEFAULT_THREAD_STATUS_VALUE){
					
					threadStatusTitle = "UNPUBLISH";
				}else if(threadStatusValue == CO_Constants.PUBLISH_THREAD_STATUS_VALUE){
					
					threadStatusTitle = "PUBLISH";
				}else if(threadStatusValue == CO_Constants.OPEN_THREAD_STATUS_VALUE){
					
					threadStatusTitle = "OPEN";
				}else if(threadStatusValue == CO_Constants.ONLINE_THREAD_STATUS_VALUE){
					
					threadStatusTitle = "ONLINE";
				}
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
		return threadStatusTitle;
	}
	
	/**
	 * 
	 * @todo LAY TIEU DE TRANG THAI CUA CONVERSATION ENTRY
	 * @author HungDX	
	 * @date Jul 26, 2012
	 * @return String
	 * @param threadId
	 * @return
	 */
	public static String getConversationStatusTitle(long conversationId){
		
		String conversationStatusTitle = "UNDEFINED";
		
		try {
			
			CO_Conversation conversation = CO_ConversationLocalServiceUtil.getCO_Conversation(conversationId);
			
			if(conversation != null){
				
				int conversationStatusValue = conversation.getStatus();
				
				if(conversationStatusValue == CO_Constants.DEFAULT_CONVERSATION_STATUS_VALUE){
					
					conversationStatusTitle = "NEW";
				}else if(conversationStatusValue == CO_Constants.ANSWERED_CONVERSATION_STATUS_VALUE){
					
					conversationStatusTitle = "UNPUBLISH";
				}else if(conversationStatusValue == CO_Constants.PUBLISH_CONVERSATION_STATUS_VALUE){
					
					conversationStatusTitle = "PUBLISH";
				}
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
		return conversationStatusTitle;
	}
	
	private static Log _log = LogFactory.getLog(ConversationUtil.class.getName());
}
