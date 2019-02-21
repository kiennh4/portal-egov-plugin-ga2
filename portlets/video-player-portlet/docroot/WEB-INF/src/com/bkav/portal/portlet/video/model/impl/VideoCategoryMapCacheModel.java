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

package com.bkav.portal.portlet.video.model.impl;

import com.bkav.portal.portlet.video.model.VideoCategoryMap;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing VideoCategoryMap in entity cache.
 *
 * @author hungdx
 * @see VideoCategoryMap
 * @generated
 */
public class VideoCategoryMapCacheModel implements CacheModel<VideoCategoryMap>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{mapId=");
		sb.append(mapId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", entryId=");
		sb.append(entryId);
		sb.append("}");

		return sb.toString();
	}

	public VideoCategoryMap toEntityModel() {
		VideoCategoryMapImpl videoCategoryMapImpl = new VideoCategoryMapImpl();

		videoCategoryMapImpl.setMapId(mapId);
		videoCategoryMapImpl.setCategoryId(categoryId);
		videoCategoryMapImpl.setEntryId(entryId);

		videoCategoryMapImpl.resetOriginalValues();

		return videoCategoryMapImpl;
	}

	public long mapId;
	public long categoryId;
	public long entryId;
}