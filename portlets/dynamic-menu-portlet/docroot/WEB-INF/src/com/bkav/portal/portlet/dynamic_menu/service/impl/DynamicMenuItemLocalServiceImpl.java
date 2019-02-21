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

import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem;
import com.bkav.portal.portlet.dynamic_menu.service.base.DynamicMenuItemLocalServiceBaseImpl;
import com.bkav.portal.portlet.dynamic_menu.service.persistence.DynamicMenuItemFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the dynamic menu item local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuItemLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author hungdx
 * @see com.bkav.portal.portlet.dynamic_menu.service.base.DynamicMenuItemLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuItemLocalServiceUtil
 */
public class DynamicMenuItemLocalServiceImpl extends DynamicMenuItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuItemLocalServiceUtil
	 * } to access the dynamic menu item local service.
	 */
	
	public List<DynamicMenuItem> findByGroup(long groupId) throws SystemException{
		return dynamicMenuItemPersistence.findByGroup(groupId);
	}
	
	public List<DynamicMenuItem> findByParent(long groupId,long parentId) throws SystemException{
		return dynamicMenuItemPersistence.findByParent(groupId, parentId);
	}
	
	public List<DynamicMenuItem> findByMenu(long groupId,long menuId) throws SystemException{
		return dynamicMenuItemPersistence.findByMenu(groupId, menuId);
	}
	
	public List<DynamicMenuItem> findByG_M_P(long groupId,long menuId,long parentId) throws SystemException{
		return dynamicMenuItemPersistence.findByG_M_P(groupId, menuId, parentId);
	}
	
	public List<DynamicMenuItem> filterMenuItemList(long groupId,long filterItemId) throws SystemException{
		return DynamicMenuItemFinderUtil.filterMenuItemList(groupId, filterItemId);
	}
	
	public DynamicMenuItem addItem(long companyId,long groupId,long userId,String userName,
		long menuId,long parentId,String name,String url,String urlType,int position,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		long itemId = counterLocalService.increment();
		
		DynamicMenuItem menuItem = dynamicMenuItemPersistence.create(itemId);
		
		menuItem.setCompanyId(companyId);
		menuItem.setGroupId(groupId);
		menuItem.setUserName(userName);
		menuItem.setUserId(userId);
		menuItem.setCreateDate(now);
		menuItem.setModifiedDate(now);
		menuItem.setMenuId(menuId);
		menuItem.setParentId(parentId);
		menuItem.setName(name);
		menuItem.setUrl(url);
		menuItem.setUrlType(urlType);
		menuItem.setPosition(position);
		
		resourceLocalService.addModelResources(menuItem, serviceContext);
		
		return dynamicMenuItemPersistence.update(menuItem, false);
	}
	
	public DynamicMenuItem updateItem(long companyId,long groupId,long userId,String userName,
		long itemId,long menuId,long parentId,String name,String url,String urlType,int position,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		Date now = new Date();
		
		DynamicMenuItem menuItem = dynamicMenuItemPersistence.fetchByPrimaryKey(itemId);
		
		menuItem.setCompanyId(companyId);
		menuItem.setGroupId(groupId);
		menuItem.setUserName(userName);
		menuItem.setUserId(userId);
		menuItem.setModifiedDate(now);
		menuItem.setMenuId(menuId);
		menuItem.setParentId(parentId);
		menuItem.setName(name);
		menuItem.setUrl(url);
		menuItem.setUrlType(urlType);
		menuItem.setPosition(position);
		
		if ((serviceContext.getGroupPermissions() != null) ||
			(serviceContext.getGuestPermissions() != null)) {

			updateFeedResource(
				menuItem, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}
		
		return dynamicMenuItemPersistence.update(menuItem, false);
	}
	
	protected void updateFeedResource(DynamicMenuItem menuItem, String[] groupPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		resourceLocalService.updateResources(menuItem.getCompanyId(),
			menuItem.getGroupId(), DynamicMenuItem.class.getName(),
			menuItem.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}
