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

package com.portal_egov.portlet.legal_faq.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LegalFAQCategoryService}.
 * </p>
 *
 * @author    HungDX
 * @see       LegalFAQCategoryService
 * @generated
 */
public class LegalFAQCategoryServiceWrapper implements LegalFAQCategoryService,
	ServiceWrapper<LegalFAQCategoryService> {
	public LegalFAQCategoryServiceWrapper(
		LegalFAQCategoryService legalFAQCategoryService) {
		_legalFAQCategoryService = legalFAQCategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _legalFAQCategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legalFAQCategoryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legalFAQCategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LegalFAQCategoryService getWrappedLegalFAQCategoryService() {
		return _legalFAQCategoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLegalFAQCategoryService(
		LegalFAQCategoryService legalFAQCategoryService) {
		_legalFAQCategoryService = legalFAQCategoryService;
	}

	public LegalFAQCategoryService getWrappedService() {
		return _legalFAQCategoryService;
	}

	public void setWrappedService(
		LegalFAQCategoryService legalFAQCategoryService) {
		_legalFAQCategoryService = legalFAQCategoryService;
	}

	private LegalFAQCategoryService _legalFAQCategoryService;
}