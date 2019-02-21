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

package com.portal_egov.portlet.contacts.service.base;

import com.portal_egov.portlet.contacts.service.ContactsDepartmentPropertyLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class ContactsDepartmentPropertyLocalServiceClpInvoker {
	public ContactsDepartmentPropertyLocalServiceClpInvoker() {
		_methodName0 = "addContactsDepartmentProperty";

		_methodParameterTypes0 = new String[] {
				"com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty"
			};

		_methodName1 = "createContactsDepartmentProperty";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteContactsDepartmentProperty";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteContactsDepartmentProperty";

		_methodParameterTypes3 = new String[] {
				"com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "fetchContactsDepartmentProperty";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getContactsDepartmentProperty";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getContactsDepartmentProperties";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getContactsDepartmentPropertiesCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateContactsDepartmentProperty";

		_methodParameterTypes14 = new String[] {
				"com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty"
			};

		_methodName15 = "updateContactsDepartmentProperty";

		_methodParameterTypes15 = new String[] {
				"com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty",
				"boolean"
			};

		_methodName64 = "getBeanIdentifier";

		_methodParameterTypes64 = new String[] {  };

		_methodName65 = "setBeanIdentifier";

		_methodParameterTypes65 = new String[] { "java.lang.String" };

		_methodName70 = "countAll";

		_methodParameterTypes70 = new String[] {  };

		_methodName71 = "countByCompany";

		_methodParameterTypes71 = new String[] { "long" };

		_methodName72 = "countByGroup";

		_methodParameterTypes72 = new String[] { "long" };

		_methodName73 = "countByContactsDepartment";

		_methodParameterTypes73 = new String[] { "long" };

		_methodName74 = "findAll";

		_methodParameterTypes74 = new String[] {  };

		_methodName75 = "findByCompany";

		_methodParameterTypes75 = new String[] { "long" };

		_methodName76 = "findByCompany";

		_methodParameterTypes76 = new String[] { "long", "int", "int" };

		_methodName77 = "findByGroup";

		_methodParameterTypes77 = new String[] { "long" };

		_methodName78 = "findByGroup";

		_methodParameterTypes78 = new String[] { "long", "int", "int" };

		_methodName79 = "findByContactsDepartment";

		_methodParameterTypes79 = new String[] { "long" };

		_methodName80 = "findByContactsDepartment";

		_methodParameterTypes80 = new String[] { "long", "int", "int" };

		_methodName81 = "findByPropertyKey";

		_methodParameterTypes81 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName82 = "addDepartmentProperty";

		_methodParameterTypes82 = new String[] {
				"long", "long", "long", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName83 = "addDepartmentProperty";

		_methodParameterTypes83 = new String[] {
				"long", "long", "long", "long", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName84 = "deleteDepartmentProperty";

		_methodParameterTypes84 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.addContactsDepartmentProperty((com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.createContactsDepartmentProperty(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.deleteContactsDepartmentProperty(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.deleteContactsDepartmentProperty((com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.fetchContactsDepartmentProperty(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.getContactsDepartmentProperty(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.getContactsDepartmentProperties(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.getContactsDepartmentPropertiesCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.updateContactsDepartmentProperty((com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.updateContactsDepartmentProperty((com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			ContactsDepartmentPropertyLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.countAll();
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.countByCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.countByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.countByContactsDepartment(((Long)arguments[0]).longValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.findAll();
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.findByCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.findByCompany(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.findByContactsDepartment(((Long)arguments[0]).longValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.findByContactsDepartment(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.findByPropertyKey(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.addDepartmentProperty(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7]);
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return ContactsDepartmentPropertyLocalServiceUtil.addDepartmentProperty(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8]);
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			ContactsDepartmentPropertyLocalServiceUtil.deleteDepartmentProperty(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
}