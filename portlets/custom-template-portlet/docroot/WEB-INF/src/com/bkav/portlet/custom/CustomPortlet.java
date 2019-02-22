package com.bkav.portlet.custom;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CustomPortlet
 */
public class CustomPortlet extends MVCPortlet {
	
	public void fixExpandoTable(ActionRequest request, ActionResponse response){
		String name = ParamUtil.get(request, "name", "test");
		try {
			System.out.println(name);
			ExpandoTableLocalServiceUtil.addTable(1, 59005, "CUSTOM_FIELDS");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
