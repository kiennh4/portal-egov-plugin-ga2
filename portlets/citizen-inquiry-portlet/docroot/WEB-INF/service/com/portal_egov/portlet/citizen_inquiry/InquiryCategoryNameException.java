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

package com.portal_egov.portlet.citizen_inquiry;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author HungDX
 */
public class InquiryCategoryNameException extends PortalException {

	public InquiryCategoryNameException() {
		super();
	}

	public InquiryCategoryNameException(String msg) {
		super(msg);
	}

	public InquiryCategoryNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InquiryCategoryNameException(Throwable cause) {
		super(cause);
	}

}