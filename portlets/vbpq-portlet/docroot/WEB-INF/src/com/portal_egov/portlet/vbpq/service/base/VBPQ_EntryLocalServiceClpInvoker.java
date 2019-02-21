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

package com.portal_egov.portlet.vbpq.service.base;

import com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class VBPQ_EntryLocalServiceClpInvoker {
	public VBPQ_EntryLocalServiceClpInvoker() {
		_methodName0 = "addVBPQ_Entry";

		_methodParameterTypes0 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_Entry"
			};

		_methodName1 = "createVBPQ_Entry";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteVBPQ_Entry";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteVBPQ_Entry";

		_methodParameterTypes3 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_Entry"
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

		_methodName9 = "fetchVBPQ_Entry";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getVBPQ_Entry";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getVBPQ_Entries";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getVBPQ_EntriesCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateVBPQ_Entry";

		_methodParameterTypes14 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_Entry"
			};

		_methodName15 = "updateVBPQ_Entry";

		_methodParameterTypes15 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_Entry", "boolean"
			};

		_methodName54 = "getBeanIdentifier";

		_methodParameterTypes54 = new String[] {  };

		_methodName55 = "setBeanIdentifier";

		_methodParameterTypes55 = new String[] { "java.lang.String" };

		_methodName60 = "countAll";

		_methodParameterTypes60 = new String[] {  };

		_methodName61 = "countByCompany";

		_methodParameterTypes61 = new String[] { "long" };

		_methodName62 = "countByGroup";

		_methodParameterTypes62 = new String[] { "long" };

		_methodName63 = "countByCategoryAndCompany";

		_methodParameterTypes63 = new String[] { "long", "long" };

		_methodName64 = "countByCategoryAndGroup";

		_methodParameterTypes64 = new String[] { "long", "long" };

		_methodName65 = "countByDepartmentAndGroup";

		_methodParameterTypes65 = new String[] { "long", "long" };

		_methodName66 = "countByDocTypeAndGroup";

		_methodParameterTypes66 = new String[] { "long", "long" };

		_methodName67 = "findAll";

		_methodParameterTypes67 = new String[] {  };

		_methodName68 = "findByCompany";

		_methodParameterTypes68 = new String[] { "long" };

		_methodName69 = "findByCompany";

		_methodParameterTypes69 = new String[] { "long", "int", "int" };

		_methodName70 = "findByGroup";

		_methodParameterTypes70 = new String[] { "long" };

		_methodName71 = "findByGroup";

		_methodParameterTypes71 = new String[] { "long", "int", "int" };

		_methodName72 = "findByDepartmentAndCompany";

		_methodParameterTypes72 = new String[] { "long", "long" };

		_methodName73 = "findByDepartmentAndCompany";

		_methodParameterTypes73 = new String[] { "long", "long", "int", "int" };

		_methodName74 = "findByDepartmentAndGroup";

		_methodParameterTypes74 = new String[] { "long", "long" };

		_methodName75 = "findByDepartmentAndGroup";

		_methodParameterTypes75 = new String[] { "long", "long", "int", "int" };

		_methodName76 = "findByCategoryAndCompany";

		_methodParameterTypes76 = new String[] { "long", "long" };

		_methodName77 = "findByCategoryAndCompany";

		_methodParameterTypes77 = new String[] { "long", "long", "int", "int" };

		_methodName78 = "findByCategoryAndGroup";

		_methodParameterTypes78 = new String[] { "long", "long" };

		_methodName79 = "findByCategoryAndGroup";

		_methodParameterTypes79 = new String[] { "long", "long", "int", "int" };

		_methodName80 = "findByDocTypeAndCompany";

		_methodParameterTypes80 = new String[] { "long", "long" };

		_methodName81 = "findByDocTypeAndCompany";

		_methodParameterTypes81 = new String[] { "long", "long", "int", "int" };

		_methodName82 = "findByDocTypeAndGroup";

		_methodParameterTypes82 = new String[] { "long", "long" };

		_methodName83 = "findByDocTypeAndGroup";

		_methodParameterTypes83 = new String[] { "long", "long", "int", "int" };

		_methodName84 = "findByExpirationAndCompany";

		_methodParameterTypes84 = new String[] { "long", "boolean" };

		_methodName85 = "findByExpirationAndGroup";

		_methodParameterTypes85 = new String[] { "long", "boolean" };

		_methodName86 = "findByActiveStatusAndCompany";

		_methodParameterTypes86 = new String[] { "long", "boolean" };

		_methodName87 = "findByActiveStatusAndGroup";

		_methodParameterTypes87 = new String[] { "long", "boolean" };

		_methodName88 = "findByKeyword";

		_methodParameterTypes88 = new String[] {
				"java.lang.String", "long", "int", "int"
			};

		_methodName89 = "findByMultiCondition";

		_methodParameterTypes89 = new String[] {
				"long", "java.lang.String", "long", "long", "long",
				"java.lang.String", "java.lang.String", "int", "int", "int"
			};

		_methodName90 = "addVBPQEntry";

		_methodParameterTypes90 = new String[] {
				"long", "long", "long", "long", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.util.Date", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName91 = "updateVBPQEntry";

		_methodParameterTypes91 = new String[] {
				"long", "long", "long", "long", "long", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.lang.String",
				"java.util.Date", "java.util.Date", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName92 = "deactiveVBPQEntry";

		_methodParameterTypes92 = new String[] { "long" };

		_methodName93 = "deleteVBPQEntry";

		_methodParameterTypes93 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.addVBPQ_Entry((com.portal_egov.portlet.vbpq.model.VBPQ_Entry)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.createVBPQ_Entry(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.deleteVBPQ_Entry(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.deleteVBPQ_Entry((com.portal_egov.portlet.vbpq.model.VBPQ_Entry)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.fetchVBPQ_Entry(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.getVBPQ_Entry(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.getVBPQ_Entries(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.getVBPQ_EntriesCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.updateVBPQ_Entry((com.portal_egov.portlet.vbpq.model.VBPQ_Entry)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.updateVBPQ_Entry((com.portal_egov.portlet.vbpq.model.VBPQ_Entry)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			VBPQ_EntryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.countAll();
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.countByCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.countByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.countByCategoryAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.countByCategoryAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.countByDepartmentAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.countByDocTypeAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findAll();
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByCompany(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByDepartmentAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByDepartmentAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByDepartmentAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByDepartmentAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByCategoryAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByCategoryAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByCategoryAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByCategoryAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByDocTypeAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByDocTypeAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByDocTypeAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByDocTypeAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByExpirationAndCompany(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByExpirationAndGroup(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByActiveStatusAndCompany(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByActiveStatusAndGroup(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByKeyword((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.findByMultiCondition(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue());
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.addVBPQEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.util.Date)arguments[10], (java.util.Date)arguments[11],
				(java.util.Date)arguments[12],
				((Boolean)arguments[13]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[14]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return VBPQ_EntryLocalServiceUtil.updateVBPQEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10], (java.util.Date)arguments[11],
				(java.lang.String)arguments[12], (java.util.Date)arguments[13],
				(java.util.Date)arguments[14],
				((Boolean)arguments[15]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[16]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			VBPQ_EntryLocalServiceUtil.deactiveVBPQEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			VBPQ_EntryLocalServiceUtil.deleteVBPQEntry(((Long)arguments[0]).longValue());
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
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
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
	private String _methodName85;
	private String[] _methodParameterTypes85;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName93;
	private String[] _methodParameterTypes93;
}