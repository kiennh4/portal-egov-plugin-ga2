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

import java.util.Date;
import java.util.List;

import com.bkav.portal.portlet.portalplugins.model.ePortals;
import com.bkav.portal.portlet.portalplugins.service.base.ePortalsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the e portals local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.bkav.portal.portlet.portalplugins.service.ePortalsLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author AnhBDb
 * @see com.bkav.portal.portlet.portalplugins.service.base.ePortalsLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.portalplugins.service.ePortalsLocalServiceUtil
 */
public class ePortalsLocalServiceImpl extends ePortalsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.bkav.portal.portlet.portalplugins.service.ePortalsLocalServiceUtil}
	 * to access the e portals local service.
	 */
	public List<ePortals> findByGroupId(long groupId) throws SystemException,
			PortalException {
		return ePortalsPersistence.findByGroupId(groupId);
	}
	
	public List<ePortals> findEportalByFilter(long groupId, String ePortalName, String ePortalCode, int start, int end) throws SystemException,
		PortalException {
		return ePortalsFinder.findePortalByFilter(groupId, ePortalName, ePortalCode, start, end, null);
	}

	public ePortals findByEPortalCode(String ePortalCode)
			throws SystemException, PortalException {
		return ePortalsPersistence.findByePortalCode(ePortalCode);
	}

	public ePortals findByEPortalDomain(long groupId, String ePortalDomain)
			throws SystemException, PortalException {
		return ePortalsPersistence.findByePortalDomain(ePortalDomain, groupId);
	}

	public void addEPortal(long groupId, long userId, String userName,
			long companyId, String ePortalName, String ePortalCode,
			String ePortalDomain, String ePortalVersion, ServiceContext serviceContext)
			throws SystemException, PortalException {
		long ePortalId = counterLocalService.increment();
		Date now = new Date();

		ePortals portal = ePortalsPersistence.create(ePortalId);

		portal.setGroupId(groupId);
		portal.setCompanyId(companyId);
		portal.setUserId(userId);
		portal.setUserName(userName);
		portal.setEportalName(ePortalName);
		portal.setEportalCode(ePortalCode);
		portal.setEportalDomain(ePortalDomain);
		portal.setEportalVersion(ePortalVersion);
		portal.setCreateDate(now);
		portal.setModifyDate(now);

		ePortalsPersistence.update(portal, false);

		if (serviceContext.isAddGroupPermissions()
				|| serviceContext.isAddGuestPermissions()) {

			addEPortalsResources(portal,
					serviceContext.isAddGroupPermissions(),
					serviceContext.isAddGuestPermissions());
		} else {

			addEPortalsResources(portal, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}
	}

	public void updateEPortal(long ePortalId, String ePortalName,
			String ePortalCode, String ePortalDomain, String ePortalVersion) throws SystemException,
			PortalException {
		Date now = new Date();

		ePortals portal = ePortalsPersistence.fetchByPrimaryKey(ePortalId);

		portal.setEportalName(ePortalName);
		portal.setEportalCode(ePortalCode);
		portal.setEportalDomain(ePortalDomain);
		portal.setEportalVersion(ePortalVersion);
		portal.setCreateDate(now);

		ePortalsPersistence.update(portal, false);
	}

	private void addEPortalsResources(ePortals portal,
			boolean addGroupPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addResources(portal.getCompanyId(),
				portal.getGroupId(), portal.getUserId(),
				ePortals.class.getName(), portal.getPrimaryKey(), false,
				addGroupPermissions, addGuestPermissions);
	}

	private void addEPortalsResources(ePortals portal,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(portal.getCompanyId(),
				portal.getGroupId(), portal.getUserId(),
				ePortals.class.getName(), portal.getPrimaryKey(),
				groupPermissions, guestPermissions);
	}

}