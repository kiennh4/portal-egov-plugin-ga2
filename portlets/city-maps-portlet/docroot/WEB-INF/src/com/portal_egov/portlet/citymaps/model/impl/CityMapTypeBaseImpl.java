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

package com.portal_egov.portlet.citymaps.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.portal_egov.portlet.citymaps.model.CityMapType;
import com.portal_egov.portlet.citymaps.service.CityMapTypeLocalServiceUtil;

/**
 * The extended model base implementation for the CityMapType service. Represents a row in the &quot;CityMapType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CityMapTypeImpl}.
 * </p>
 *
 * @author HungDX
 * @see CityMapTypeImpl
 * @see com.portal_egov.portlet.citymaps.model.CityMapType
 * @generated
 */
public abstract class CityMapTypeBaseImpl extends CityMapTypeModelImpl
	implements CityMapType {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a city map type model instance should use the {@link CityMapType} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			CityMapTypeLocalServiceUtil.addCityMapType(this);
		}
		else {
			CityMapTypeLocalServiceUtil.updateCityMapType(this);
		}
	}
}