/**
 * @author HUNGDX
 * @time 10:06:31 AM
 * @project visit_counter-portlet
 */
package com.portal_egov.portlet.visit_counter.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.SystemException;
import com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog;
import com.portal_egov.portlet.visit_counter.model.VisitCounterLog;
import com.portal_egov.portlet.visit_counter.service.VisitCounterDayLogLocalServiceUtil;
import com.portal_egov.portlet.visit_counter.service.VisitCounterLocalServiceUtil;
import com.portal_egov.portlet.visit_counter.service.VisitCounterLogLocalServiceUtil;


public class VisitCounterUtil {

	/**
	 * @todo Lấy số liệu tổng số lượt truy cập Portal
	 * @author HUNGDX	
	 * @date Dec 6, 2012
	 * @return int
	 */
	public static int getTotalVisitCounter(long groupId){
		
		try {
			
			return VisitCounterLocalServiceUtil.getCounterValue(groupId);
		}
		catch (SystemException e) {
			_log.error(e);
			return DEFAULT_TOTAL_VISIT_COUNTER_VALUE;
		}
	}
	
	/**
	 * @todo Lấy số lượng người đang truy cập
	 * @author HUNGDX	
	 * @date Dec 6, 2012
	 * @return int
	 */
	public static int getOnlineVisiterCounter(){
		
		return OnlineVisitorCounter.getOnlineVisitorCounter();
	}
	
	/**
	 * @todo Cập nhật số liệu thống kê tổng số lượng truy cập Portal
	 * @author HUNGDX	
	 * @date Dec 6, 2012
	 * @return void
	 */
	
	public static int getVisitorCounterDay (int type)
	{
		Calendar calendar = Calendar.getInstance();
		
		int count = 1;
		
		Date now = new Date();

		try {
			switch (type)
			{
				case TODAY:
				{
					VisitCounterDayLog daylog = VisitCounterDayLogLocalServiceUtil.fetchVisitCounterDayLog(DF.format(now));
					
					if (daylog!=null)
					{
						count = daylog.getHitCounter();
					}
					else
					{
						count = 1;
					}
					return count;
				}
				case YESTERDAY:
				{
					calendar.add(Calendar.DATE, -1);
					
					VisitCounterDayLog daylog = VisitCounterDayLogLocalServiceUtil.fetchVisitCounterDayLog(
											DF.format(calendar.getTime()));
					
					if (daylog!=null)
					{
						count = daylog.getHitCounter();
					}
					else
					{
						count = 0;
					}
					return count;
				}
				case THIS_WEEK:
				{
					calendar.setTime(now);
					
					int numberDay = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
					
					//calendar.add(Calendar.DATE, -numberDay);
					
					count = countDayLogByNumberDay(now, numberDay);
					
					return count;
				}
				case THIS_MONTH:
				{
					calendar.setTime(now);
					
					int numberDay = calendar.get(Calendar.DATE) - 1;
					
					//calendar.add(Calendar.DATE, -numberDay);
					
					count = countDayLogByNumberDay(now, numberDay);
					
					return count;
				}
				case LAST_WEEK:
				{
					calendar.setTime(now);
					
					int numberDay = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
					
					calendar.add(Calendar.DATE, -numberDay);
					
					count = countDayLogByNumberDay(calendar.getTime(), 7);
					
					return count;
				}
				case LAST_MONTH:
				{
					calendar.setTime(now);
					
					int numberDay = calendar.get(Calendar.DATE) - 1;
					
					calendar.add(Calendar.DATE, -numberDay-1);
					
					count = countDayLogByNumberDay(calendar.getTime(), 30);
					
					return count;
				}
				default:
				{
					count = 1;
					return count;
				}
			}
		}
		catch (Exception e)
		{
			_log.error(e);
			return count;
		}
		
		
	}
	
	public static int countDayLogByNumberDay (Date endDate, int numberDay)
	{
		try
		{
			int count = 0;
			
			for (int i =0; i<numberDay;i++)
			{
				Calendar calendar = Calendar.getInstance();
				
				calendar.setTime(endDate);
				
				calendar.add(Calendar.DATE, -i); 
				
				VisitCounterDayLog daylog = VisitCounterDayLogLocalServiceUtil.fetchVisitCounterDayLog(
												DF.format(calendar.getTime()));
				if (daylog!=null)
				{
					count = count +daylog.getHitCounter();
				}
			}
			
			return count;
		}
		catch (Exception e)
		{
			_log.error(e);
			return 0;
		}
	}
	
	public static void updateCounter(long companyId,long groupId,long userId,String userName){
		
		try {
			
			VisitCounterLocalServiceUtil.incrementTotalCounter(companyId, groupId, userId, userName);
		}
		catch (SystemException e) {
			_log.error(e);
		}
	}
	
	/**
	 * @todo Cập nhật thông tin của khách truy cập Portal
	 * @author HUNGDX	
	 * @date Dec 6, 2012
	 * @return void
	 */
	public static  void updateCounterLog(long companyId,long groupId,long userId,String userName,String visitorIp,long lastAccessPageId){
		
		try {
			
			VisitCounterLog counterLog = VisitCounterLogLocalServiceUtil.getCounterLog(visitorIp);
			
			if(counterLog != null){
				
				VisitCounterLogLocalServiceUtil.incrementCounter(visitorIp);
			}else{
				
				VisitCounterLogLocalServiceUtil.addCounterLog(companyId, groupId, userId, userName, visitorIp, lastAccessPageId);
			}
		}
		catch (SystemException e) {
			_log.error(e);
		}
	}
	
	@SuppressWarnings("null")
	public static void updateCounterDayLog (long companyId, long groupId, String daylogId)
	{
		try {
			VisitCounterDayLog daylog = VisitCounterDayLogLocalServiceUtil.fetchVisitCounterDayLog(daylogId);
			
			if (daylog!=null)
			{
				VisitCounterDayLogLocalServiceUtil.updateVisitCounterDayLog(daylogId);
			}
			else
			{
				VisitCounterDayLogLocalServiceUtil.addVisitCounterDayLog(groupId, companyId, daylogId);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactory.getLog(VisitCounterUtil.class);
	
	private static final int DEFAULT_TOTAL_VISIT_COUNTER_VALUE = 1;
	
	private static final int TODAY = 1;
	
	private static final int YESTERDAY = 2;
	
	private static final int THIS_WEEK = 3;
	
	private static final int LAST_WEEK = 4;
	
	private static final int THIS_MONTH = 5;
	
	private static final int LAST_MONTH= 6;
	
	private static final SimpleDateFormat DF = new SimpleDateFormat("ddMMYYYY");
}
