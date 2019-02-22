/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.portal_egov.portlet.visit_counter.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.portal_egov.portlet.visit_counter.service.ClpSerializer;
import com.portal_egov.portlet.visit_counter.service.VisitCounterDayLogLocalServiceUtil;
import com.portal_egov.portlet.visit_counter.service.VisitCounterDayLogServiceUtil;
import com.portal_egov.portlet.visit_counter.service.VisitCounterLocalServiceUtil;
import com.portal_egov.portlet.visit_counter.service.VisitCounterLogLocalServiceUtil;
import com.portal_egov.portlet.visit_counter.service.VisitCounterLogServiceUtil;
import com.portal_egov.portlet.visit_counter.service.VisitCounterServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			VisitCounterLocalServiceUtil.clearService();

			VisitCounterServiceUtil.clearService();
			VisitCounterDayLogLocalServiceUtil.clearService();

			VisitCounterDayLogServiceUtil.clearService();
			VisitCounterLogLocalServiceUtil.clearService();

			VisitCounterLogServiceUtil.clearService();
		}
	}
}