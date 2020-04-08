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

package com.bkav.portal.portlet.contentsharing.model.impl;

import com.bkav.portal.portlet.contentsharing.model.ContentSharing;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing ContentSharing in entity cache.
 *
 * @author anhbdb
 * @see ContentSharing
 * @generated
 */
public class ContentSharingCacheModel implements CacheModel<ContentSharing>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{contentId=");
		sb.append(contentId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", contentSharing=");
		sb.append(contentSharing);
		sb.append("}");

		return sb.toString();
	}

	public ContentSharing toEntityModel() {
		ContentSharingImpl contentSharingImpl = new ContentSharingImpl();

		contentSharingImpl.setContentId(contentId);
		contentSharingImpl.setCompanyId(companyId);
		contentSharingImpl.setGroupId(groupId);
		contentSharingImpl.setUserId(userId);

		if (contentSharing == null) {
			contentSharingImpl.setContentSharing(StringPool.BLANK);
		}
		else {
			contentSharingImpl.setContentSharing(contentSharing);
		}

		contentSharingImpl.resetOriginalValues();

		return contentSharingImpl;
	}

	public long contentId;
	public long companyId;
	public long groupId;
	public long userId;
	public String contentSharing;
}