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

package com.portal_egov.portlet.contacts.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.portal_egov.portlet.contacts.model.ContactsClp;
import com.portal_egov.portlet.contacts.model.ContactsDepartmentClp;
import com.portal_egov.portlet.contacts.model.ContactsDepartmentPropertyClp;
import com.portal_egov.portlet.contacts.model.ContactsPropertyClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"contacts-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"contacts-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "contacts-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ContactsClp.class.getName())) {
			return translateInputContacts(oldModel);
		}

		if (oldModelClassName.equals(ContactsDepartmentClp.class.getName())) {
			return translateInputContactsDepartment(oldModel);
		}

		if (oldModelClassName.equals(
					ContactsDepartmentPropertyClp.class.getName())) {
			return translateInputContactsDepartmentProperty(oldModel);
		}

		if (oldModelClassName.equals(ContactsPropertyClp.class.getName())) {
			return translateInputContactsProperty(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputContacts(BaseModel<?> oldModel) {
		ContactsClp oldClpModel = (ContactsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContactsDepartment(BaseModel<?> oldModel) {
		ContactsDepartmentClp oldClpModel = (ContactsDepartmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactsDepartmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContactsDepartmentProperty(
		BaseModel<?> oldModel) {
		ContactsDepartmentPropertyClp oldClpModel = (ContactsDepartmentPropertyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactsDepartmentPropertyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContactsProperty(BaseModel<?> oldModel) {
		ContactsPropertyClp oldClpModel = (ContactsPropertyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactsPropertyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.portal_egov.portlet.contacts.model.impl.ContactsImpl")) {
			return translateOutputContacts(oldModel);
		}

		if (oldModelClassName.equals(
					"com.portal_egov.portlet.contacts.model.impl.ContactsDepartmentImpl")) {
			return translateOutputContactsDepartment(oldModel);
		}

		if (oldModelClassName.equals(
					"com.portal_egov.portlet.contacts.model.impl.ContactsDepartmentPropertyImpl")) {
			return translateOutputContactsDepartmentProperty(oldModel);
		}

		if (oldModelClassName.equals(
					"com.portal_egov.portlet.contacts.model.impl.ContactsPropertyImpl")) {
			return translateOutputContactsProperty(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.portal_egov.portlet.contacts.NoSuchContactsException")) {
			return new com.portal_egov.portlet.contacts.NoSuchContactsException();
		}

		if (className.equals(
					"com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException")) {
			return new com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException();
		}

		if (className.equals(
					"com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException")) {
			return new com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException();
		}

		if (className.equals(
					"com.portal_egov.portlet.contacts.NoSuchContactsPropertyException")) {
			return new com.portal_egov.portlet.contacts.NoSuchContactsPropertyException();
		}

		return throwable;
	}

	public static Object translateOutputContacts(BaseModel<?> oldModel) {
		ContactsClp newModel = new ContactsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContactsDepartment(
		BaseModel<?> oldModel) {
		ContactsDepartmentClp newModel = new ContactsDepartmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactsDepartmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContactsDepartmentProperty(
		BaseModel<?> oldModel) {
		ContactsDepartmentPropertyClp newModel = new ContactsDepartmentPropertyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactsDepartmentPropertyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContactsProperty(BaseModel<?> oldModel) {
		ContactsPropertyClp newModel = new ContactsPropertyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactsPropertyRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}