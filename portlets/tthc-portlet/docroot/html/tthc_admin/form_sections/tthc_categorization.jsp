<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.util.TTHCConstants"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Category"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Entry"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%	
	//Id cua cap thuc hien
	long levelId = 0L;
	//Id cua co quan thuc hien
	long departmentId = 0L;
	//Id cua linh vuc thong ke
	long categoryId = 0L;
	//Id cua doi tuong thuc hien
	long audienceId = 0L;
	//Id cua loai ket qua	
	long resultTypeId = 0L;
	
	TTHC_Entry tthcEntry = null;
	
	long tthcEntryId = ParamUtil.getLong(request, "tthcEntryId",0L);
	
	if(tthcEntryId > 0){
		
		tthcEntry = TTHC_EntryLocalServiceUtil.getTTHC_Entry(tthcEntryId);
		
		if(tthcEntry != null){
			levelId = tthcEntry.getLevelId();
			departmentId = tthcEntry.getDepartmentId();
			categoryId = tthcEntry.getCategoryId();
			audienceId = tthcEntry.getAudienceId();
			resultTypeId = tthcEntry.getResultTypeId();
		}
	}
	
	//Danh sach cap thuc hien TTHC
	List<TTHC_Category> levelList = TTHC_CategoryLocalServiceUtil.findByTypeAndCompany(TTHCConstants.TTHC_LEVEL_CATEGORY_TYPE_ID, companyId);
	
	//Danh sach co quan thuc hien TTHC
	List<TTHC_Category> departmentList = TTHC_CategoryLocalServiceUtil.findByTypeAndCompany(TTHCConstants.TTHC_DEPARTMENT_CATEGORY_TYPE_ID, companyId);
	
	//Danh sach linh vuc thong ke
	List<TTHC_Category> categoryList = TTHC_CategoryLocalServiceUtil.findByTypeAndCompany(TTHCConstants.TTHC_CATEGORY_CATEGORY_TYPE_ID, companyId);
	
	//Danh sach doi tuong thuc hien TTHC
	List<TTHC_Category> audienceList = TTHC_CategoryLocalServiceUtil.findByTypeAndCompany(TTHCConstants.TTHC_AUDIENCE_CATEGORY_TYPE_ID, companyId);
	
	//Danh sach ket qua thuc hien TTHC
	List<TTHC_Category> resultTypeList = TTHC_CategoryLocalServiceUtil.findByTypeAndCompany(TTHCConstants.TTHC_RESULT_TYPE_CATEGORY_TYPE_ID, companyId);
%>

	<h3><liferay-ui:message key="tthc-categorization" /></h3>

	<aui:select name="levelId" label="tthc-level">
		<aui:option value="0" selected="<%=(levelId == 0L) %>">
			<liferay-ui:message key="others" />
		</aui:option>
		<%
		for(TTHC_Category level : levelList){
		%>
			<aui:option value="<%=level.getCategoryId()%>" selected="<%=(levelId == level.getCategoryId())%>">
				<%=level.getCategoryName() %>
			</aui:option>
		<%
		}
		%>
	</aui:select>

	<aui:select name="departmentId" label="tthc-department">
		<aui:option value="0" selected="<%=(departmentId == 0L) %>">
			<liferay-ui:message key="others" />
		</aui:option>
		<%
		for(TTHC_Category department : departmentList)
		{
		%>
			<aui:option value="<%=department.getCategoryId()%>" selected="<%=(departmentId == department.getCategoryId())%>">
				<%=department.getCategoryName() %>
			</aui:option>
		<%
		}
		%>
	</aui:select>

	<aui:select name="categoryId" label="tthc-category">
		<aui:option value="0" selected="<%=(categoryId == 0L) %>">
			<liferay-ui:message key="others" />
		</aui:option>
		<%
		for(TTHC_Category category :categoryList)
		{
		%>
			<aui:option value="<%=category.getCategoryId()%>" selected="<%=(categoryId == category.getCategoryId())%>">
				<%=category.getCategoryName() %>
			</aui:option>
		<%
		}
		%>
	</aui:select>

	<aui:select name="audienceId" label="tthc-audience">
		<aui:option value="0" selected="<%=(audienceId == 0L) %>">
			<liferay-ui:message key="others" />
		</aui:option>
		<%
		for(TTHC_Category audience : audienceList)
		{
		%>
			<aui:option value="<%=audience.getCategoryId()%>" selected="<%=(audienceId == audience.getCategoryId())%>">
				<%=audience.getCategoryName() %>
			</aui:option>
		<%
		}
		%>
	</aui:select>
	
	<aui:select name="resultTypeId" label="tthc-result-type">
		<aui:option value="0" selected="<%=(resultTypeId == 0L) %>">
			<liferay-ui:message key="others" />
		</aui:option>
		<%
		for(TTHC_Category resultType : resultTypeList)
		{
		%>
			<aui:option value="<%=resultType.getCategoryId()%>" selected="<%=(resultTypeId == resultType.getCategoryId())%>">
				<%=resultType.getCategoryName() %>
			</aui:option>
		<%
		}
		%>
	</aui:select>

			


