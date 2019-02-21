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

package com.bkav.portal.portlet.complaints.model.impl;

import com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Complaints_DLFileEntries in entity cache.
 *
 * @author AnhBDb
 * @see Complaints_DLFileEntries
 * @generated
 */
public class Complaints_DLFileEntriesCacheModel implements CacheModel<Complaints_DLFileEntries>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", complaintId=");
		sb.append(complaintId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append("}");

		return sb.toString();
	}

	public Complaints_DLFileEntries toEntityModel() {
		Complaints_DLFileEntriesImpl complaints_DLFileEntriesImpl = new Complaints_DLFileEntriesImpl();

		complaints_DLFileEntriesImpl.setId(id);
		complaints_DLFileEntriesImpl.setComplaintId(complaintId);
		complaints_DLFileEntriesImpl.setFileEntryId(fileEntryId);

		complaints_DLFileEntriesImpl.resetOriginalValues();

		return complaints_DLFileEntriesImpl;
	}

	public long id;
	public long complaintId;
	public long fileEntryId;
}