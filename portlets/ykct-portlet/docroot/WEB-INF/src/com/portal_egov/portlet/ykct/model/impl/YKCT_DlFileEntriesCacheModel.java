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

package com.portal_egov.portlet.ykct.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries;

import java.io.Serializable;

/**
 * The cache model class for representing YKCT_DlFileEntries in entity cache.
 *
 * @author DucDVd
 * @see YKCT_DlFileEntries
 * @generated
 */
public class YKCT_DlFileEntriesCacheModel implements CacheModel<YKCT_DlFileEntries>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ykctEntryId=");
		sb.append(ykctEntryId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append("}");

		return sb.toString();
	}

	public YKCT_DlFileEntries toEntityModel() {
		YKCT_DlFileEntriesImpl ykct_DlFileEntriesImpl = new YKCT_DlFileEntriesImpl();

		ykct_DlFileEntriesImpl.setId(id);
		ykct_DlFileEntriesImpl.setYkctEntryId(ykctEntryId);
		ykct_DlFileEntriesImpl.setFileEntryId(fileEntryId);

		ykct_DlFileEntriesImpl.resetOriginalValues();

		return ykct_DlFileEntriesImpl;
	}

	public long id;
	public long ykctEntryId;
	public long fileEntryId;
}