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

package com.bkav.portal.portlet.portalplugins.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;
import com.bkav.portal.portlet.portalplugins.model.ePortals;
import com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil;
import com.bkav.portal.portlet.portalplugins.service.ePortalsLocalServiceUtil;
import com.bkav.portal.portlet.portalplugins.service.base.PortalPluginsServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

/**
 * The implementation of the portal plugins remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.portalplugins.service.PortalPluginsService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author AnhBDb
 * @see com.bkav.portal.portlet.portalplugins.service.base.PortalPluginsServiceBaseImpl
 * @see com.bkav.portal.portlet.portalplugins.service.PortalPluginsServiceUtil
 */
@JSONWebService
public class PortalPluginsServiceImpl extends PortalPluginsServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.portalplugins.service.PortalPluginsServiceUtil} to access the portal plugins remote service.
	 */
	public List<PortalPlugins> findByGroupId(long groupId)
			throws SystemException, PortalException {
		return PortalPluginsLocalServiceUtil.findByGroupId(groupId);
	}
	
	public List<PortalPlugins> findByEportalCode(String ePortalCode)
			throws SystemException, PortalException {
		try {
			ePortals ePortal = ePortalsLocalServiceUtil.findByEPortalCode(ePortalCode);
			
			List<PortalPlugins> listPlugin = new ArrayList<PortalPlugins>();
			
			if (ePortal!=null)
			{
				List<PortalPlugins> privatePlugins = PortalPluginsLocalServiceUtil.findByEportalId(ePortal.getEportalId());
				
				for (PortalPlugins plugin : privatePlugins)
				{
					listPlugin.add(plugin);
				}
				
				List<PortalPlugins> publicPlugins = PortalPluginsLocalServiceUtil.findByEportalId(0);
				
				for (PortalPlugins plugin : publicPlugins)
				{
					listPlugin.add(plugin);
				}
				
				return listPlugin;
			}
			else
			{
				return listPlugin;
			}
		}
		catch (Exception e)
		{
			_log.error(e);
			return new ArrayList<PortalPlugins>();
		}
	}
	
	private static Log _log = LogFactory.getLog(PortalPluginsServiceImpl.class);
}