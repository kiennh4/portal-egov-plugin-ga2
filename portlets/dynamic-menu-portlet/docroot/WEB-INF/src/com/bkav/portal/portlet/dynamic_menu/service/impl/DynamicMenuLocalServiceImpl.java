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

package com.bkav.portal.portlet.dynamic_menu.service.impl;

import java.util.Date;
import java.util.List;

import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu;
import com.bkav.portal.portlet.dynamic_menu.service.base.DynamicMenuLocalServiceBaseImpl;
import com.bkav.portal.portlet.dynamic_menu.service.persistence.DynamicMenuFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the dynamic menu local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author hungdx
 * @see com.bkav.portal.portlet.dynamic_menu.service.base.DynamicMenuLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuLocalServiceUtil
 */
public class DynamicMenuLocalServiceImpl extends DynamicMenuLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuLocalServiceUtil}
	 * to access the dynamic menu local service.
	 */
	
	public List<DynamicMenu> findByGroup(long groupId) throws SystemException{
		
		return dynamicMenuPersistence.findByGroup(groupId);
	}
	
	public List<DynamicMenu> findByKeyword(long groupId,String keyword,int start,int end) throws SystemException{
		
		return DynamicMenuFinderUtil.findByKeyword(groupId, keyword, start, end);
	}
	
	public DynamicMenu addMenu(long companyId,long groupId,long userId,String userName,
			String name,String description,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long menuId = counterLocalService.increment();
		
		DynamicMenu dynamicMenu = dynamicMenuPersistence.create(menuId);
		
		dynamicMenu.setCompanyId(companyId);
		dynamicMenu.setGroupId(groupId);
		dynamicMenu.setUserId(userId);
		dynamicMenu.setUserName(userName);
		dynamicMenu.setCreateDate(now);
		dynamicMenu.setModifiedDate(now);
		dynamicMenu.setName(name);
		dynamicMenu.setDescription(description);
		dynamicMenu.setItemCount(0);
		
		resourceLocalService.addModelResources(dynamicMenu, serviceContext);
		
		return dynamicMenuPersistence.update(dynamicMenu, false);
	}
	
	public DynamicMenu updateMenu(long companyId,long groupId,long userId,String userName,long menuId,
			String name,String description,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		DynamicMenu dynamicMenu = dynamicMenuPersistence.fetchByPrimaryKey(menuId);
		
		dynamicMenu.setCompanyId(companyId);
		dynamicMenu.setGroupId(groupId);
		dynamicMenu.setUserId(userId);
		dynamicMenu.setUserName(userName);
		dynamicMenu.setModifiedDate(now);
		dynamicMenu.setName(name);
		dynamicMenu.setDescription(description);
		
		if ((serviceContext.getGroupPermissions() != null) ||
			(serviceContext.getGuestPermissions() != null)) {

			updateFeedResource(
				dynamicMenu, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}
		
		return dynamicMenuPersistence.update(dynamicMenu, false);
	}
	
	protected void updateFeedResource(DynamicMenu dynamicMenu, String[] groupPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		resourceLocalService.updateResources(dynamicMenu.getCompanyId(),
			dynamicMenu.getGroupId(), DynamicMenu.class.getName(),
			dynamicMenu.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
