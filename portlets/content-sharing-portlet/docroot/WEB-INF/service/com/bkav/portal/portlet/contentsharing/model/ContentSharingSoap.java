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

package com.bkav.portal.portlet.contentsharing.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.contentsharing.service.http.ContentSharingServiceSoap}.
 *
 * @author    anhbdb
 * @see       com.bkav.portal.portlet.contentsharing.service.http.ContentSharingServiceSoap
 * @generated
 */
public class ContentSharingSoap implements Serializable {
	public static ContentSharingSoap toSoapModel(ContentSharing model) {
		ContentSharingSoap soapModel = new ContentSharingSoap();

		soapModel.setContentId(model.getContentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setContentSharing(model.getContentSharing());

		return soapModel;
	}

	public static ContentSharingSoap[] toSoapModels(ContentSharing[] models) {
		ContentSharingSoap[] soapModels = new ContentSharingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContentSharingSoap[][] toSoapModels(ContentSharing[][] models) {
		ContentSharingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContentSharingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContentSharingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContentSharingSoap[] toSoapModels(List<ContentSharing> models) {
		List<ContentSharingSoap> soapModels = new ArrayList<ContentSharingSoap>(models.size());

		for (ContentSharing model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContentSharingSoap[soapModels.size()]);
	}

	public ContentSharingSoap() {
	}

	public long getPrimaryKey() {
		return _contentId;
	}

	public void setPrimaryKey(long pk) {
		setContentId(pk);
	}

	public long getContentId() {
		return _contentId;
	}

	public void setContentId(long contentId) {
		_contentId = contentId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getContentSharing() {
		return _contentSharing;
	}

	public void setContentSharing(String contentSharing) {
		_contentSharing = contentSharing;
	}

	private long _contentId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _contentSharing;
}