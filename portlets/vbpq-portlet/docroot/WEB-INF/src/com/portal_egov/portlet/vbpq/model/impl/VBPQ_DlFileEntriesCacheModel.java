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

package com.portal_egov.portlet.vbpq.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries;

import java.io.Serializable;

/**
 * The cache model class for representing VBPQ_DlFileEntries in entity cache.
 *
 * @author HungDX
 * @see VBPQ_DlFileEntries
 * @generated
 */
public class VBPQ_DlFileEntriesCacheModel implements CacheModel<VBPQ_DlFileEntries>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", vbpqEntryId=");
		sb.append(vbpqEntryId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append("}");

		return sb.toString();
	}

	public VBPQ_DlFileEntries toEntityModel() {
		VBPQ_DlFileEntriesImpl vbpq_DlFileEntriesImpl = new VBPQ_DlFileEntriesImpl();

		vbpq_DlFileEntriesImpl.setId(id);
		vbpq_DlFileEntriesImpl.setVbpqEntryId(vbpqEntryId);
		vbpq_DlFileEntriesImpl.setFileEntryId(fileEntryId);

		vbpq_DlFileEntriesImpl.resetOriginalValues();

		return vbpq_DlFileEntriesImpl;
	}

	public long id;
	public long vbpqEntryId;
	public long fileEntryId;
}