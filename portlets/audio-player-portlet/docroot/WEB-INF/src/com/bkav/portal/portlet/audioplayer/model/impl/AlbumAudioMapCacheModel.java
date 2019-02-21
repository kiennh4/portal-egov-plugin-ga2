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

package com.bkav.portal.portlet.audioplayer.model.impl;

import com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing AlbumAudioMap in entity cache.
 *
 * @author anhbdb
 * @see AlbumAudioMap
 * @generated
 */
public class AlbumAudioMapCacheModel implements CacheModel<AlbumAudioMap>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{mapId=");
		sb.append(mapId);
		sb.append(", albumId=");
		sb.append(albumId);
		sb.append(", audioId=");
		sb.append(audioId);
		sb.append("}");

		return sb.toString();
	}

	public AlbumAudioMap toEntityModel() {
		AlbumAudioMapImpl albumAudioMapImpl = new AlbumAudioMapImpl();

		albumAudioMapImpl.setMapId(mapId);
		albumAudioMapImpl.setAlbumId(albumId);
		albumAudioMapImpl.setAudioId(audioId);

		albumAudioMapImpl.resetOriginalValues();

		return albumAudioMapImpl;
	}

	public long mapId;
	public long albumId;
	public long audioId;
}