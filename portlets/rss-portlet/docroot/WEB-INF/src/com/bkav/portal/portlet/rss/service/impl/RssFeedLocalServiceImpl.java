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

package com.bkav.portal.portlet.rss.service.impl;

import java.util.Date;
import java.util.List;

import com.bkav.portal.portlet.rss.model.RssFeed;
import com.bkav.portal.portlet.rss.service.base.RssFeedLocalServiceBaseImpl;
import com.bkav.portal.portlet.rss.service.persistence.RssFeedFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the rss feed local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.bkav.portal.portlet.rss.service.RssFeedLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author hungdx
 * @see com.bkav.portal.portlet.rss.service.base.RssFeedLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.rss.service.RssFeedLocalServiceUtil
 */
public class RssFeedLocalServiceImpl extends RssFeedLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.bkav.portal.portlet.rss.service.RssFeedLocalServiceUtil} to access
	 * the rss feed local service.
	 */

	public List<RssFeed> findByGroup(long groupId) throws SystemException {
		return rssFeedPersistence.findByGroup(groupId);
	}

	public List<RssFeed> findByKeyword(long groupId, String keyword, int start,
			int end) throws SystemException {

		return RssFeedFinderUtil.findByKeyword(groupId, keyword, start, end);
	}

	public RssFeed addFeed(long companyId, long groupId, long userId,
			String userName, String name, String url, String description,
			int status, ServiceContext serviceContext) throws SystemException,
			PortalException {

		Date now = new Date();

		long id = counterLocalService.increment();

		RssFeed feed = rssFeedPersistence.create(id);

		feed.setCompanyId(companyId);
		feed.setGroupId(groupId);
		feed.setUserId(userId);
		feed.setUserName(userName);
		feed.setCreateDate(now);
		feed.setModifiedDate(now);
		feed.setName(name);
		feed.setUrl(url);
		feed.setDescription(description);
		feed.setStatus(status);

		if (serviceContext.isAddGroupPermissions()
				|| serviceContext.isAddGuestPermissions()) {
			addFeedResource(feed, serviceContext.isAddGroupPermissions(),
					serviceContext.isAddGroupPermissions());
		} else {
			addFeedResource(feed, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}

		return rssFeedPersistence.update(feed, false);
	}

	public RssFeed updateFeed(long id, long companyId, long groupId,
			long userId, String userName, String name, String url,
			String description, int status, ServiceContext serviceContext)
			throws SystemException, PortalException {

		Date now = new Date();

		RssFeed feed = rssFeedPersistence.fetchByPrimaryKey(id);

		feed.setCompanyId(companyId);
		feed.setGroupId(groupId);
		feed.setUserId(userId);
		feed.setUserName(userName);
		feed.setModifiedDate(now);
		feed.setName(name);
		feed.setUrl(url);
		feed.setDescription(description);
		feed.setStatus(status);
		rssFeedPersistence.update(feed, false);
		// Lucene Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(RssFeed.class);

		if (indexer != null) {
			indexer.reindex(feed);
		}

		return feed;
	}

	protected void addFeedResource(RssFeed feed, boolean addGroupPermissions,
			boolean addGuestPermissions) throws PortalException,
			SystemException {

		resourceLocalService.addResources(feed.getCompanyId(),
				feed.getGroupId(), feed.getUserId(), RssFeed.class.getName(),
				feed.getPrimaryKey(), false, addGroupPermissions,
				addGuestPermissions);
	}

	private void addFeedResource(RssFeed feed, String[] groupPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		resourceLocalService.addModelResources(feed.getCompanyId(),
				feed.getGroupId(), feed.getUserId(), RssFeed.class.getName(),
				feed.getId_(), groupPermissions, guestPermissions);
	}
}