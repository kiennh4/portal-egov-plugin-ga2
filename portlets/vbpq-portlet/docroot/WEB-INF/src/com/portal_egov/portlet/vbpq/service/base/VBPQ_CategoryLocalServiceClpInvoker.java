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

import com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class VBPQ_CategoryLocalServiceClpInvoker {
	public VBPQ_CategoryLocalServiceClpInvoker() {
		_methodName0 = "addVBPQ_Category";

		_methodParameterTypes0 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_Category"
			};

		_methodName1 = "createVBPQ_Category";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteVBPQ_Category";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteVBPQ_Category";

		_methodParameterTypes3 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_Category"
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

		_methodName9 = "fetchVBPQ_Category";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getVBPQ_Category";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getVBPQ_Categories";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getVBPQ_CategoriesCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateVBPQ_Category";

		_methodParameterTypes14 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_Category"
			};

		_methodName15 = "updateVBPQ_Category";

		_methodParameterTypes15 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_Category", "boolean"
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

		_methodName63 = "countByParentAndCompany";

		_methodParameterTypes63 = new String[] { "long", "long" };

		_methodName64 = "countByParentAndGroup";

		_methodParameterTypes64 = new String[] { "long", "long" };

		_methodName65 = "findAll";

		_methodParameterTypes65 = new String[] {  };

		_methodName66 = "findByCompany";

		_methodParameterTypes66 = new String[] { "long" };

		_methodName67 = "findByCompany";

		_methodParameterTypes67 = new String[] { "long", "int", "int" };

		_methodName68 = "findByGroup";

		_methodParameterTypes68 = new String[] { "long" };

		_methodName69 = "findByGroup";

		_methodParameterTypes69 = new String[] { "long", "int", "int" };

		_methodName70 = "findByParentAndCompany";

		_methodParameterTypes70 = new String[] { "long", "long" };

		_methodName71 = "findByParentAndCompany";

		_methodParameterTypes71 = new String[] { "long", "long", "int", "int" };

		_methodName72 = "findByParentAndGroup";

		_methodParameterTypes72 = new String[] { "long", "long" };

		_methodName73 = "findByParentAndGroup";

		_methodParameterTypes73 = new String[] { "long", "long", "int", "int" };

		_methodName74 = "findByTypeAndCompany";

		_methodParameterTypes74 = new String[] { "int", "long" };

		_methodName75 = "findByTypeAndCompany";

		_methodParameterTypes75 = new String[] { "int", "long", "int", "int" };

		_methodName76 = "findByTypeAndGroup";

		_methodParameterTypes76 = new String[] { "int", "long" };

		_methodName77 = "findByTypeAndGroup";

		_methodParameterTypes77 = new String[] { "int", "long", "int", "int" };

		_methodName78 = "findByKeyword";

		_methodParameterTypes78 = new String[] {
				"long", "int", "java.lang.String", "int", "int"
			};

		_methodName79 = "getCategory";

		_methodParameterTypes79 = new String[] { "long" };

		_methodName80 = "addCategoryResources";

		_methodParameterTypes80 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_Category", "boolean",
				"boolean"
			};

		_methodName81 = "addCategoryResources";

		_methodParameterTypes81 = new String[] {
				"com.portal_egov.portlet.vbpq.model.VBPQ_Category",
				"java.lang.String[][]", "java.lang.String[][]"
			};

		_methodName82 = "addCategory";

		_methodParameterTypes82 = new String[] {
				"long", "long", "long", "long", "int", "java.lang.String",
				"java.lang.String", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName83 = "updateCategory";

		_methodParameterTypes83 = new String[] {
				"long", "long", "long", "long", "long", "int",
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName84 = "deactiveCategory";

		_methodParameterTypes84 = new String[] { "long" };

		_methodName85 = "deleteCategory";

		_methodParameterTypes85 = new String[] { "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.addVBPQ_Category((com.portal_egov.portlet.vbpq.model.VBPQ_Category)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.createVBPQ_Category(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.deleteVBPQ_Category(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.deleteVBPQ_Category((com.portal_egov.portlet.vbpq.model.VBPQ_Category)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.fetchVBPQ_Category(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.getVBPQ_Category(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.getVBPQ_Categories(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.getVBPQ_CategoriesCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.updateVBPQ_Category((com.portal_egov.portlet.vbpq.model.VBPQ_Category)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.updateVBPQ_Category((com.portal_egov.portlet.vbpq.model.VBPQ_Category)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			VBPQ_CategoryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.countAll();
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.countByCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.countByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.countByParentAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.countByParentAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findAll();
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByCompany(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByParentAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByParentAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByParentAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByParentAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByTypeAndCompany(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByTypeAndCompany(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.findByKeyword(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return VBPQ_CategoryLocalServiceUtil.getCategory(((Long)arguments[0]).longValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			VBPQ_CategoryLocalServiceUtil.addCategoryResources((com.portal_egov.portlet.vbpq.model.VBPQ_Category)arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			VBPQ_CategoryLocalServiceUtil.addCategoryResources((com.portal_egov.portlet.vbpq.model.VBPQ_Category)arguments[0],
				(java.lang.String[])arguments[1],
				(java.lang.String[])arguments[2]);
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			VBPQ_CategoryLocalServiceUtil.addCategory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			VBPQ_CategoryLocalServiceUtil.updateCategory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				((Integer)arguments[8]).intValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			VBPQ_CategoryLocalServiceUtil.deactiveCategory(((Long)arguments[0]).longValue());
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			VBPQ_CategoryLocalServiceUtil.deleteCategory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
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
}