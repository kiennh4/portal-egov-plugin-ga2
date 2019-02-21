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
 * This class is a wrapper for {@link LegalFAQEntryService}.
 * </p>
 *
 * @author    HungDX
 * @see       LegalFAQEntryService
 * @generated
 */
public class LegalFAQEntryServiceWrapper implements LegalFAQEntryService,
	ServiceWrapper<LegalFAQEntryService> {
	public LegalFAQEntryServiceWrapper(
		LegalFAQEntryService legalFAQEntryService) {
		_legalFAQEntryService = legalFAQEntryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _legalFAQEntryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legalFAQEntryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legalFAQEntryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LegalFAQEntryService getWrappedLegalFAQEntryService() {
		return _legalFAQEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLegalFAQEntryService(
		LegalFAQEntryService legalFAQEntryService) {
		_legalFAQEntryService = legalFAQEntryService;
	}

	public LegalFAQEntryService getWrappedService() {
		return _legalFAQEntryService;
	}

	public void setWrappedService(LegalFAQEntryService legalFAQEntryService) {
		_legalFAQEntryService = legalFAQEntryService;
	}

	private LegalFAQEntryService _legalFAQEntryService;
}