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

package com.portal_egov.portlet.conversation.service.base;

import com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class CO_ThreadLocalServiceClpInvoker {
	public CO_ThreadLocalServiceClpInvoker() {
		_methodName0 = "addCO_Thread";

		_methodParameterTypes0 = new String[] {
				"com.portal_egov.portlet.conversation.model.CO_Thread"
			};

		_methodName1 = "createCO_Thread";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteCO_Thread";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteCO_Thread";

		_methodParameterTypes3 = new String[] {
				"com.portal_egov.portlet.conversation.model.CO_Thread"
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

		_methodName9 = "fetchCO_Thread";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getCO_Thread";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getCO_Threads";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getCO_ThreadsCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateCO_Thread";

		_methodParameterTypes14 = new String[] {
				"com.portal_egov.portlet.conversation.model.CO_Thread"
			};

		_methodName15 = "updateCO_Thread";

		_methodParameterTypes15 = new String[] {
				"com.portal_egov.portlet.conversation.model.CO_Thread",
				"boolean"
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

		_methodName63 = "coutByStatusAndCompany";

		_methodParameterTypes63 = new String[] { "int", "long" };

		_methodName64 = "countByStatusAndGroup";

		_methodParameterTypes64 = new String[] { "int", "long" };

		_methodName65 = "coutByParentThreadAndCompany";

		_methodParameterTypes65 = new String[] { "long", "long" };

		_methodName66 = "countByParentThreadAndGroup";

		_methodParameterTypes66 = new String[] { "long", "long" };

		_methodName67 = "countByParentThreadAndCompanyAndStatus";

		_methodParameterTypes67 = new String[] { "long", "long", "int" };

		_methodName68 = "countByParentThreadAndGroupAndStatus";

		_methodParameterTypes68 = new String[] { "long", "long", "int" };

		_methodName69 = "coutByCategoryAndCompany";

		_methodParameterTypes69 = new String[] { "long", "long" };

		_methodName70 = "countByCategoryAndGroup";

		_methodParameterTypes70 = new String[] { "long", "long" };

		_methodName71 = "countByCategoryAndCompanyAndStatus";

		_methodParameterTypes71 = new String[] { "long", "long", "int" };

		_methodName72 = "countByCategoryAndGroupAndStatus";

		_methodParameterTypes72 = new String[] { "long", "long", "int" };

		_methodName73 = "findAll";

		_methodParameterTypes73 = new String[] {  };

		_methodName74 = "findByCompany";

		_methodParameterTypes74 = new String[] { "long" };

		_methodName75 = "findByCompany";

		_methodParameterTypes75 = new String[] { "long", "int", "int" };

		_methodName76 = "findByGroup";

		_methodParameterTypes76 = new String[] { "long" };

		_methodName77 = "findByGroup";

		_methodParameterTypes77 = new String[] { "long", "int", "int" };

		_methodName78 = "findByStatusAndCompany";

		_methodParameterTypes78 = new String[] { "int", "long" };

		_methodName79 = "findByStatusAndCompany";

		_methodParameterTypes79 = new String[] { "int", "long", "int", "int" };

		_methodName80 = "findByStatusAndGroup";

		_methodParameterTypes80 = new String[] { "int", "long" };

		_methodName81 = "findByStatusAndGroup";

		_methodParameterTypes81 = new String[] { "int", "long", "int", "int" };

		_methodName82 = "findByParentThreadAndCompany";

		_methodParameterTypes82 = new String[] { "long", "long" };

		_methodName83 = "findByParentThreadAndCompany";

		_methodParameterTypes83 = new String[] { "long", "long", "int", "int" };

		_methodName84 = "findByParentThreadAndGroup";

		_methodParameterTypes84 = new String[] { "long", "long" };

		_methodName85 = "findByParentThreadAndGroup";

		_methodParameterTypes85 = new String[] { "long", "long", "int", "int" };

		_methodName86 = "findByParentThreadAndCompanyAndStatus";

		_methodParameterTypes86 = new String[] { "long", "long", "int" };

		_methodName87 = "findByParentThreadAndCompanyAndStatus";

		_methodParameterTypes87 = new String[] {
				"long", "long", "int", "int", "int"
			};

		_methodName88 = "findByParentThreadAndGroupAndStatus";

		_methodParameterTypes88 = new String[] { "long", "long", "int" };

		_methodName89 = "findByParentThreadAndGroupAndStatus";

		_methodParameterTypes89 = new String[] {
				"long", "long", "int", "int", "int"
			};

		_methodName90 = "findByCategoryAndCompany";

		_methodParameterTypes90 = new String[] { "long", "long" };

		_methodName91 = "findByCategoryAndCompany";

		_methodParameterTypes91 = new String[] { "long", "long", "int", "int" };

		_methodName92 = "findByCategoryAndGroup";

		_methodParameterTypes92 = new String[] { "long", "long" };

		_methodName93 = "findByCategoryAndGroup";

		_methodParameterTypes93 = new String[] { "long", "long", "int", "int" };

		_methodName94 = "findByCategoryAndCompanyAndStatus";

		_methodParameterTypes94 = new String[] { "long", "long", "int" };

		_methodName95 = "findByCategoryAndCompanyAndStatus";

		_methodParameterTypes95 = new String[] {
				"long", "long", "int", "int", "int"
			};

		_methodName96 = "findByCategoryAndGroupAndStatus";

		_methodParameterTypes96 = new String[] { "long", "long", "int" };

		_methodName97 = "findByCategoryAndGroupAndStatus";

		_methodParameterTypes97 = new String[] {
				"long", "long", "int", "int", "int"
			};

		_methodName98 = "findByKeywordAndStatus";

		_methodParameterTypes98 = new String[] { "long", "java.lang.String", "int" };

		_methodName99 = "addCOThread";

		_methodParameterTypes99 = new String[] {
				"long", "long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.util.Date", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName100 = "updateCOThread";

		_methodParameterTypes100 = new String[] {
				"long", "long", "long", "long", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date", "int"
			};

		_methodName101 = "incrementThreadViewCounter";

		_methodParameterTypes101 = new String[] { "long" };

		_methodName102 = "incrementConversationViewCounter";

		_methodParameterTypes102 = new String[] { "long" };

		_methodName103 = "updateThreadStatus";

		_methodParameterTypes103 = new String[] { "long", "long", "int" };

		_methodName104 = "deleteCOThread";

		_methodParameterTypes104 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.addCO_Thread((com.portal_egov.portlet.conversation.model.CO_Thread)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.createCO_Thread(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.deleteCO_Thread(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.deleteCO_Thread((com.portal_egov.portlet.conversation.model.CO_Thread)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.fetchCO_Thread(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.getCO_Thread(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.getCO_Threads(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.getCO_ThreadsCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.updateCO_Thread((com.portal_egov.portlet.conversation.model.CO_Thread)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.updateCO_Thread((com.portal_egov.portlet.conversation.model.CO_Thread)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			CO_ThreadLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.countAll();
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.countByCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.countByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.coutByStatusAndCompany(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.countByStatusAndGroup(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.coutByParentThreadAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.countByParentThreadAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.countByParentThreadAndCompanyAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.countByParentThreadAndGroupAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.coutByCategoryAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.countByCategoryAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.countByCategoryAndCompanyAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.countByCategoryAndGroupAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findAll();
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByCompany(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByStatusAndCompany(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByStatusAndCompany(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByStatusAndGroup(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByStatusAndGroup(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByParentThreadAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByParentThreadAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByParentThreadAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByParentThreadAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByParentThreadAndCompanyAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByParentThreadAndCompanyAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByParentThreadAndGroupAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByParentThreadAndGroupAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByCategoryAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByCategoryAndCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByCategoryAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByCategoryAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByCategoryAndCompanyAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByCategoryAndCompanyAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByCategoryAndGroupAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByCategoryAndGroupAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.findByKeywordAndStatus(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.addCOThread(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.util.Date)arguments[9], (java.util.Date)arguments[10],
				((Integer)arguments[11]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[12]);
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.updateCOThread(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.util.Date)arguments[10], (java.util.Date)arguments[11],
				((Integer)arguments[12]).intValue());
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.incrementThreadViewCounter(((Long)arguments[0]).longValue());
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			CO_ThreadLocalServiceUtil.incrementConversationViewCounter(((Long)arguments[0]).longValue());
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			return CO_ThreadLocalServiceUtil.updateThreadStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			CO_ThreadLocalServiceUtil.deleteCOThread(((Long)arguments[0]).longValue());
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
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName102;
	private String[] _methodParameterTypes102;
	private String _methodName103;
	private String[] _methodParameterTypes103;
	private String _methodName104;
	private String[] _methodParameterTypes104;
}