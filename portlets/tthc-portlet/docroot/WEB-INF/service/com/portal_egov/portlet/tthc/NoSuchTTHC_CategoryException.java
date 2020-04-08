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

package com.portal_egov.portlet.tthc;

import com.liferay.portal.NoSuchModelException;

/**
 * @author HungDX
 */
public class NoSuchTTHC_CategoryException extends NoSuchModelException {

	public NoSuchTTHC_CategoryException() {
		super();
	}

	public NoSuchTTHC_CategoryException(String msg) {
		super(msg);
	}

	public NoSuchTTHC_CategoryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTTHC_CategoryException(Throwable cause) {
		super(cause);
	}

}