<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.PropositionCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.Proposition"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionConstants"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	//Id cua chuyen muc,linh vuc
	long categoryId = 0L;
	
	//Id cua co quan soan thao du luat
	long compilationDepartmentId = 0L;		
	
	//Id cua Uy ban tham tra du thao luat
	long verificationDepartmentId = 0L;

	//Id cua du thao hien tai
	long propositionId = ParamUtil.getLong(request, "propositionId",0L);
	
	Proposition currentProposition = null;
	
	if(propositionId > 0){
		currentProposition = PropositionLocalServiceUtil.getProposition(propositionId);
		
		if(currentProposition != null){
			
			categoryId = currentProposition.getCategoryId();
			compilationDepartmentId = currentProposition.getCompilationDepartmentId();
			verificationDepartmentId = currentProposition.getVerificationDepartmentId();
		}
	}
	
	//Danh sach chuyen muc,linh vuc cua du thao
	List<PropositionCategory> categoryList = PropositionCategoryLocalServiceUtil.findByTypeAndGroup(scopeGroupId,
																					PropositionConstants.PROPOSITION_CATEGORY_TYPE_ID);	
	//Danh sach Co quan soan thao du luat
	List<PropositionCategory> compilationDepartmentList = PropositionCategoryLocalServiceUtil.findByTypeAndGroup(scopeGroupId,
																					PropositionConstants.COMPILATION_DEPARTMENT_CATEGORY_TYPE_ID);	
	//Danh sach Uy ban tham tra noi dung du thao luat
	List<PropositionCategory> verificationDepartmentList = PropositionCategoryLocalServiceUtil.findByTypeAndGroup(scopeGroupId,
																					PropositionConstants.VERIFICATION_DEPARTMENT_CATEGORY_TYPE_ID);	
%>

	<h3><liferay-ui:message key="proposition-categorization" /></h3>
	
	<aui:select name="categoryId" label="proposition-category">
		<aui:option value="0" label="other" selected="<%=categoryId == 0L %>"/>
		<%
		for(PropositionCategory propositionCategory : categoryList){
		%>
			<aui:option value="<%=propositionCategory.getCategoryId() %>" label="<%=propositionCategory.getCategoryName() %>" 
						selected="<%=categoryId == propositionCategory.getCategoryId() %>"/>
		<%
		}
		%>
	</aui:select>
	
	<aui:select name="compilationDepartmentId" label="compilation-department">
		<aui:option value="0" label="other" selected="<%=compilationDepartmentId == 0L %>"/>
		<%
		for(PropositionCategory compilationDepartment : compilationDepartmentList){
		%>
			<aui:option value="<%=compilationDepartment.getCategoryId() %>" label="<%=compilationDepartment.getCategoryName() %>" 
						selected="<%=compilationDepartmentId == compilationDepartment.getCategoryId() %>"/>
		<%
		}
		%>
	</aui:select>
		
	<aui:select name="verificationDepartmentId" label="verification-department">
		<aui:option value="0" label="other" selected="<%=verificationDepartmentId == 0L %>"/>
		<%
		for(PropositionCategory verificationDepartment : verificationDepartmentList){
		%>
			<aui:option value="<%=verificationDepartment.getCategoryId() %>" label="<%=verificationDepartment.getCategoryName() %>" 
						selected="<%=verificationDepartmentId == verificationDepartment.getCategoryId() %>"/>
		<%
		}
		%>
	</aui:select>
	
	
	
	
	
	
	
	