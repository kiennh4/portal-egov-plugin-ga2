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

package com.bkav.portal.portlet.portalplugins.service.base;

import com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalPluginsLocalServiceClpInvoker {
	public PortalPluginsLocalServiceClpInvoker() {
		_methodName0 = "addPortalPlugins";

		_methodParameterTypes0 = new String[] {
				"com.bkav.portal.portlet.portalplugins.model.PortalPlugins"
			};

		_methodName1 = "createPortalPlugins";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deletePortalPlugins";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deletePortalPlugins";

		_methodParameterTypes3 = new String[] {
				"com.bkav.portal.portlet.portalplugins.model.PortalPlugins"
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

		_methodName9 = "fetchPortalPlugins";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getPortalPlugins";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getPortalPluginses";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getPortalPluginsesCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updatePortalPlugins";

		_methodParameterTypes14 = new String[] {
				"com.bkav.portal.portlet.portalplugins.model.PortalPlugins"
			};

		_methodName15 = "updatePortalPlugins";

		_methodParameterTypes15 = new String[] {
				"com.bkav.portal.portlet.portalplugins.model.PortalPlugins",
				"boolean"
			};

		_methodName48 = "getBeanIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName49 = "setBeanIdentifier";

		_methodParameterTypes49 = new String[] { "java.lang.String" };

		_methodName54 = "findByGroupId";

		_methodParameterTypes54 = new String[] { "long" };

		_methodName55 = "findByPluginCode";

		_methodParameterTypes55 = new String[] { "java.lang.String" };

		_methodName56 = "findByEportalId";

		_methodParameterTypes56 = new String[] { "long" };

		_methodName57 = "findByPluginCodeAndVersion";

		_methodParameterTypes57 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName58 = "findPortalPluginsByFilter";

		_methodParameterTypes58 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "long",
				"int", "int"
			};

		_methodName59 = "addPortalPlugin";

		_methodParameterTypes59 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "double", "int", "long", "int",
				"java.lang.String", "java.lang.String", "double", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName60 = "updatePortalPlugin";

		_methodParameterTypes60 = new String[] {
				"long", "java.lang.String", "java.lang.String", "double", "int",
				"long", "int", "java.lang.String", "java.lang.String", "double",
				"long", "long"
			};

		_methodName61 = "deletePortalPlugin";

		_methodParameterTypes61 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.addPortalPlugins((com.bkav.portal.portlet.portalplugins.model.PortalPlugins)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.createPortalPlugins(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.deletePortalPlugins(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.deletePortalPlugins((com.bkav.portal.portlet.portalplugins.model.PortalPlugins)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.fetchPortalPlugins(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.getPortalPlugins(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.getPortalPluginses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.getPortalPluginsesCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.updatePortalPlugins((com.bkav.portal.portlet.portalplugins.model.PortalPlugins)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.updatePortalPlugins((com.bkav.portal.portlet.portalplugins.model.PortalPlugins)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			PortalPluginsLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.findByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.findByPluginCode((java.lang.String)arguments[0]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.findByEportalId(((Long)arguments[0]).longValue());
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.findByPluginCodeAndVersion(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return PortalPluginsLocalServiceUtil.findPortalPluginsByFilter(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			PortalPluginsLocalServiceUtil.addPortalPlugin(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5],
				((Double)arguments[6]).doubleValue(),
				((Integer)arguments[7]).intValue(),
				((Long)arguments[8]).longValue(),
				((Integer)arguments[9]).intValue(),
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				((Double)arguments[12]).doubleValue(),
				((Long)arguments[13]).longValue(),
				((Long)arguments[14]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[15]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			PortalPluginsLocalServiceUtil.updatePortalPlugin(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Double)arguments[3]).doubleValue(),
				((Integer)arguments[4]).intValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				((Double)arguments[9]).doubleValue(),
				((Long)arguments[10]).longValue(),
				((Long)arguments[11]).longValue());
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			PortalPluginsLocalServiceUtil.deletePortalPlugin(((Long)arguments[0]).longValue());
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
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
}