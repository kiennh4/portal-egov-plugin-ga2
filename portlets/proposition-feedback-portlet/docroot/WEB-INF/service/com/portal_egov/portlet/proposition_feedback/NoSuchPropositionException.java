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

package com.portal_egov.portlet.proposition_feedback;

import com.liferay.portal.NoSuchModelException;

/**
 * @author HungDX
 */
public class NoSuchPropositionException extends NoSuchModelException {

	public NoSuchPropositionException() {
		super();
	}

	public NoSuchPropositionException(String msg) {
		super(msg);
	}

	public NoSuchPropositionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPropositionException(Throwable cause) {
		super(cause);
	}

}