package com.bkav.portal.autoupdate.admin.util;

import java.util.Date;

import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.scheduler.CronText;
import com.liferay.portal.kernel.scheduler.CronTrigger;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.SchedulerEngineUtil;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.scheduler.TriggerType;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.PortletLocalServiceUtil;

/**
 * Class lap lich auto update
 * @author anhbdb
 *
 */
public class AutoUpdateScheduler implements MessageListener {
	
	@Override
	public void receive(Message message) {
		String serverUpdateDomain = (String) message.get("serverUpdateDomain");
		System.out.println(serverUpdateDomain);
		AutoUpdateAdminUtil.autoUpdatePlugin(serverUpdateDomain);
	}
	
	/**
	 * Dang ky su kien lap lich
	 * @param pref
	 */
	public static void autoUpdateRegisterScheduler(PortletPreferences pref) {
		try {
			int autoUpdateHour = Integer.parseInt(pref.getValue(
					"autoUpdateHour", "0"));
			int autoUpdateMinutes = Integer.parseInt(pref.getValue(
					"autoUpdateMinutes", "0"));
			int autoUpdateDay = Integer.parseInt(pref.getValue("autoUpdateDay",
					"-1"));
			String autoUpdateDayStr = "*";
			Portlet portlet = PortletLocalServiceUtil
					.getPortletById("autoupdateadmin_WAR_autoupdateportlet");

			if (autoUpdateDay > -1) {
				autoUpdateDayStr = StringUtil.valueOf(autoUpdateDay + 1);
			}

			String cronTimeText = "0" + StringPool.SPACE + autoUpdateMinutes
					+ StringPool.SPACE + autoUpdateHour + StringPool.SPACE
					+ StringPool.QUESTION + StringPool.SPACE + StringPool.STAR
					+ StringPool.SPACE + autoUpdateDayStr + StringPool.SPACE
					+ StringPool.STAR + StringPool.SPACE;

			Message message = new Message();
			message.put(
					"serverUpdateDomain",
					pref.getValue("serverUpdateDomain",
							PropsUtil.get("server-update-domain")));
			message.put(SchedulerEngine.CONTEXT_PATH, portlet.getContextPath());
			message.put(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME,
					AutoUpdateScheduler.class.getName());
			message.put(SchedulerEngine.PORTLET_ID, portlet.getPortletId());

			Trigger trigger = TriggerFactoryUtil.buildTrigger(TriggerType.CRON,
					AutoUpdateScheduler.class.getName(), AutoUpdateScheduler.class.getName(),
					new Date(), null, cronTimeText);

			boolean isExistedJob = false;

			System.out.println("Scheduling " + trigger.getJobName());


			SchedulerEngineUtil.schedule(trigger, StorageType.PERSISTED,
					"", "liferay/scheduler_dispatch", message, 5);
			SchedulerEngineUtil.start();
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Huy su kien lap lich
	 */
	public static void autoUpdateUnregisterScheduler() {
		try {
			SchedulerEngineUtil.delete(AutoUpdateScheduler.class.getName(), StorageType.PERSISTED);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
