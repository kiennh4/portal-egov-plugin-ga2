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

package com.portal_egov.portlet.ykct.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the YKCT_DlFileEntries service. Represents a row in the &quot;ykct_dlfileentries&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.portal_egov.portlet.ykct.model.impl.YKCT_DlFileEntriesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.portal_egov.portlet.ykct.model.impl.YKCT_DlFileEntriesImpl}.
 * </p>
 *
 * @author DucDVd
 * @see YKCT_DlFileEntries
 * @see com.portal_egov.portlet.ykct.model.impl.YKCT_DlFileEntriesImpl
 * @see com.portal_egov.portlet.ykct.model.impl.YKCT_DlFileEntriesModelImpl
 * @generated
 */
public interface YKCT_DlFileEntriesModel extends BaseModel<YKCT_DlFileEntries> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a y k c t_ dl file entries model instance should use the {@link YKCT_DlFileEntries} interface instead.
	 */

	/**
	 * Returns the primary key of this y k c t_ dl file entries.
	 *
	 * @return the primary key of this y k c t_ dl file entries
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this y k c t_ dl file entries.
	 *
	 * @param primaryKey the primary key of this y k c t_ dl file entries
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this y k c t_ dl file entries.
	 *
	 * @return the ID of this y k c t_ dl file entries
	 */
	public long getId();

	/**
	 * Sets the ID of this y k c t_ dl file entries.
	 *
	 * @param id the ID of this y k c t_ dl file entries
	 */
	public void setId(long id);

	/**
	 * Returns the ykct entry ID of this y k c t_ dl file entries.
	 *
	 * @return the ykct entry ID of this y k c t_ dl file entries
	 */
	public long getYkctEntryId();

	/**
	 * Sets the ykct entry ID of this y k c t_ dl file entries.
	 *
	 * @param ykctEntryId the ykct entry ID of this y k c t_ dl file entries
	 */
	public void setYkctEntryId(long ykctEntryId);

	/**
	 * Returns the file entry ID of this y k c t_ dl file entries.
	 *
	 * @return the file entry ID of this y k c t_ dl file entries
	 */
	public long getFileEntryId();

	/**
	 * Sets the file entry ID of this y k c t_ dl file entries.
	 *
	 * @param fileEntryId the file entry ID of this y k c t_ dl file entries
	 */
	public void setFileEntryId(long fileEntryId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(YKCT_DlFileEntries ykct_DlFileEntries);

	public int hashCode();

	public CacheModel<YKCT_DlFileEntries> toCacheModel();

	public YKCT_DlFileEntries toEscapedModel();

	public String toString();

	public String toXmlString();
}