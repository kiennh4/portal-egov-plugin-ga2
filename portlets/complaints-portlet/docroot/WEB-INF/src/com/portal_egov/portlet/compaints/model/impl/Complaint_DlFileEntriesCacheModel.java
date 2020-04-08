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

package com.portal_egov.portlet.compaints.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries;

import java.io.Serializable;

/**
 * The cache model class for representing Complaint_DlFileEntries in entity cache.
 *
 * @author HungDX
 * @see Complaint_DlFileEntries
 * @generated
 */
public class Complaint_DlFileEntriesCacheModel implements CacheModel<Complaint_DlFileEntries>,
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

	public Complaint_DlFileEntries toEntityModel() {
		Complaint_DlFileEntriesImpl complaint_DlFileEntriesImpl = new Complaint_DlFileEntriesImpl();

		complaint_DlFileEntriesImpl.setId(id);
		complaint_DlFileEntriesImpl.setComplaintId(complaintId);
		complaint_DlFileEntriesImpl.setFileEntryId(fileEntryId);

		complaint_DlFileEntriesImpl.resetOriginalValues();

		return complaint_DlFileEntriesImpl;
	}

	public long id;
	public long complaintId;
	public long fileEntryId;
}