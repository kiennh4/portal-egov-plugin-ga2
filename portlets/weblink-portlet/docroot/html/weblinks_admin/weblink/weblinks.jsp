<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.util.JavaConstants"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.search.WeblinkSearch"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.portal_egov.portlet.weblinks.permission.WeblinkPermission"%>
<%@page import="com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.Weblink"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.WeblinkCategory"%>
<%@page import="com.portal_egov.portlet.weblinks.permission.WeblinkCategoryPermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/weblinks_admin/init.jsp"%>

<%
	boolean closeDialog = false;

	boolean advancedSearch = false;

	int weblinkIndex = 0;
	
	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		weblinkIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}
	
	//Id cua chuyen muc duoc chon trong select box
	long selectedCategoryId = ParamUtil.getLong(request, "selectedCategoryId",0L);
	
	//Tu khoa nhap vao o tim kiem
	String weblinkSearchKeyword = ParamUtil.getString(request, "weblinkSearchKeyword");
	
	//Tu khoa nhap vao o tim kiem nang cao
	String weblinkAdvanceSearchKeyword = ParamUtil.getString(request, "weblinkAdvanceSearchKeyword");

	List<WeblinkCategory> weblinkCategoryList = WeblinkCategoryLocalServiceUtil.findByGroup(groupId);
	
	if(selectedCategoryId > 0L || weblinkAdvanceSearchKeyword.length() > 0){
		
		advancedSearch = true;
	}
	
	PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);
	
	if(SessionErrors.isEmpty(portletRequest) && !SessionMessages.isEmpty(portletRequest)){
		closeDialog = true;
	}
	
%>

<div class="weblink_admin">

	<liferay-portlet:renderURL var="weblinkAdminHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/weblinks_admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="Weblinks"/>
	</liferay-portlet:renderURL>
	
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="add_new_weblink_button" align="left">
				<c:if test="<%=WeblinkPermission.contains(permissionChecker, groupId, WeblinkPermission.ADD)%>">
					<aui:button type="button" value="add-new-weblink" onClick="showWeblinkUpdateForm(0);"/>
				</c:if>
				<c:if test="<%=WeblinkPermission.contains(permissionChecker, groupId, WeblinkPermission.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=Weblink.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button name="weblinkPermissionsBtn" href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>			
			
			<div class="weblink_search_form" align="right">
				<aui:form name="weblink_search_form" method="post" action="<%=weblinkAdminHomePageURL %>">
				
					<input type="text" id="<portlet:namespace/>weblinkSearchKeywordInput" name="weblinkSearchKeyword" value='<%= weblinkSearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					<aui:button type="button" name="showAdvancedSearchFormBtn" value="advance-search" />
					<aui:button type="button" value="show-all-weblinks" href="<%=weblinkAdminHomePageURL %>"/>
				</aui:form>	
			</div>
		</div>
	</div>
	
	<div id="<portlet:namespace/>advancedSearchFormContainer" class="weblink_advance_search_form aui-helper-hidden" align="center">
		<aui:form name="weblink_search_form" method="post" action="<%=weblinkAdminHomePageURL %>">
			<table>
				<tr>
					<td><liferay-ui:message key="keyword"/></td>
					<td>
						<aui:input name="weblinkAdvanceSearchKeyword" value="<%=weblinkAdvanceSearchKeyword %>" label=""/>
					</td>
				</tr>
							
				<tr>
					<td><liferay-ui:message key="weblink-category"/></td>
					<td>
						<aui:select name="selectedCategoryId" label="">
							<aui:option label="all" value="0" selected="<%=selectedCategoryId == 0 %>"/>
							<%
							for(WeblinkCategory weblinkCategory : weblinkCategoryList){
							%>
							<aui:option label="<%=weblinkCategory.getCategoryName() %>" value="<%=weblinkCategory.getCategoryId() %>" 
										selected="<%=selectedCategoryId == weblinkCategory.getCategoryId() %>"
							/>
							<%
							}
							%>
						</aui:select>
					</td>
				</tr>
							
				<tr>
					<td><liferay-ui:message key=""/></td>
					<td>
						<div class="aui-button-holder">
							<aui:button type="submit" value="search"/>
							<aui:button type="button" name="closeAdvancedSearchFormBtn" value="close"/>
						</div>
					</td>
				</tr>
			</table>
		</aui:form>
	</div>
	
	<div class="weblink_list">
	
		<liferay-portlet:renderURL varImpl="weblinkAdminHomePageImplURL" var="">
			<liferay-portlet:param name="jspPage" value="/html/weblinks_admin/view.jsp"/>
			<liferay-portlet:param name="tabs1" value="Weblinks"/>
			<liferay-portlet:param name="weblinkSearchKeyword" value="<%=weblinkSearchKeyword %>"/>
		</liferay-portlet:renderURL>
		
		<%
			if(advancedSearch){
				
				weblinkAdminHomePageImplURL.setParameter("weblinkSearchKeyword", StringPool.BLANK);
				weblinkAdminHomePageImplURL.setParameter("weblinkAdvanceSearchKeyword", weblinkAdvanceSearchKeyword);
				weblinkAdminHomePageImplURL.setParameter("selectedCategoryId", String.valueOf(selectedCategoryId));
			}
		%>
		
		<liferay-ui:search-container 
			searchContainer="<%=new WeblinkSearch(renderRequest,weblinkAdminHomePageImplURL) %>"
		>
			<%	
				List<Weblink> weblinkList = WeblinkLocalServiceUtil.findByKeyword(groupId, selectedCategoryId, weblinkAdvanceSearchKeyword,
						searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			%>
			
			<liferay-ui:search-container-results results="<%=weblinkList %>" total="<%=weblinkList.size() %>"/>
			
			<liferay-ui:search-container-row className="Weblink" keyProperty="weblinkId" modelVar="weblink" escapedModel="<%=true %>">
				<%
				weblinkIndex ++;
				
				String weblinkCategoryName = "others";
				
				long categoryId = weblink.getWeblinkCategoryId();
				
				if(categoryId > 0){
					
					WeblinkCategory weblinkCategory = WeblinkCategoryLocalServiceUtil.getWeblinkCategory(categoryId);
					
					if(weblinkCategory != null){
						weblinkCategoryName = weblinkCategory.getCategoryName();
					}
				}
				
				StringBundler weblinkPreviewBundle = new StringBundler();

				weblinkPreviewBundle.append("javascript:");
				weblinkPreviewBundle.append("showWeblinkPreviewDialog");
				weblinkPreviewBundle.append("('");
				weblinkPreviewBundle.append(weblink.getWeblinkId());
				weblinkPreviewBundle.append("')");

				String	weblinkPreviewURL = weblinkPreviewBundle.toString();
				
				StringBundler weblinkUpdateFormBundle = new StringBundler();

				weblinkUpdateFormBundle.append("javascript:");
				weblinkUpdateFormBundle.append("showWeblinkUpdateForm");
				weblinkUpdateFormBundle.append("('");
				weblinkUpdateFormBundle.append(weblink.getWeblinkId());
				weblinkUpdateFormBundle.append("')");

				String	weblinkUpdateFormURL = weblinkUpdateFormBundle.toString();
				
				%>
												
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(weblinkIndex)%>" href="<%=weblinkPreviewURL %>"
					title="<%=weblink.getWeblinkURL() %>"
				/>
								
				<liferay-ui:search-container-column-text name="weblink-name" orderable="<%=true %>" value="<%=weblink.getWeblinkName()%>" 
					href="<%=weblinkPreviewURL %>"
					title="<%=weblink.getWeblinkURL() %>"
				/>
				
				<liferay-ui:search-container-column-text name="weblink-category-name" value="<%=weblinkCategoryName%>"
					orderable="<%=true %>"
					orderableProperty="weblink-category-id"
				/>
								
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(weblink.getCreateDate())%>"
					orderable="<%=true %>"
					orderableProperty="create-date"
				/>
												
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=weblink.getUserName()%>" />
				
				<liferay-ui:search-container-column-text name="edit">
					<c:if test="<%=WeblinkPermission.contains(permissionChecker, groupId, WeblinkPermission.UPDATE)%>">														
						<liferay-ui:icon image="edit" message="edit"  url="<%=weblinkUpdateFormURL %>"/>
					</c:if>
				</liferay-ui:search-container-column-text>
								
				<liferay-ui:search-container-column-text name="delete">
					<c:if test="<%=WeblinkPermission.contains(permissionChecker, groupId, WeblinkPermission.DELETE)%>">															
						<liferay-portlet:actionURL  name="deleteWeblink" var="deleteWeblinkURL">
							<liferay-portlet:param name="weblinkId" value="<%=String.valueOf(weblink.getWeblinkId())%>"/>	
							<liferay-portlet:param name="redirectURL" value="<%=weblinkAdminHomePageURL%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteWeblinkURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>

<script type="text/javascript">

	AUI().ready('aui-dialog', function(A) {
		
		var HIDDEN_CSS_CLASS = 'aui-helper-hidden';
		
		if(<%=closeDialog %>){
			
			Liferay.fire(
				'closeWindow',
				{
					id: '<portlet:namespace/>weblinkAdminDialog',
				},window.top.location.reload(true)
			);
		}
		
		var weblinkBasicSearchInput = A.one('#<portlet:namespace/>weblinkSearchKeywordInput');
		
		var weblinkAdvanceSearchInput= A.one('#<portlet:namespace/>weblinkAdvanceSearchKeyword');
		
		var advanceSearchFormContainer = A.one('#<portlet:namespace/>advancedSearchFormContainer');
		
		if(<%=advancedSearch %>){
			
			advanceSearchFormContainer.show();
			weblinkAdvanceSearchInput.focus();
		
		}else{
			
			weblinkBasicSearchInput.focus();
		}
		
		var showAdvancedSearchFormBtn = A.one('#<portlet:namespace/>showAdvancedSearchFormBtn');
		
		if(showAdvancedSearchFormBtn){
			
			showAdvancedSearchFormBtn.on('click',function(){
				
				if(advanceSearchFormContainer.hasClass(HIDDEN_CSS_CLASS)){
					
					advanceSearchFormContainer.show();
					weblinkAdvanceSearchInput.val(weblinkBasicSearchInput.val());
					weblinkAdvanceSearchInput.focus();
				}else{
					
					advanceSearchFormContainer.hide();
					weblinkBasicSearchInput.val(weblinkAdvanceSearchInput.val());
					weblinkBasicSearchInput.focus();
				}
			});
		}
		
		var closeAdvancedSearchFormBtn = A.one('#<portlet:namespace/>closeAdvancedSearchFormBtn');
		
		if(closeAdvancedSearchFormBtn){
			
			closeAdvancedSearchFormBtn.on('click',function(){
				
				advanceSearchFormContainer.hide();
				weblinkBasicSearchInput.val(weblinkAdvanceSearchInput.val());
				weblinkBasicSearchInput.focus();
			});
		}
		
		Liferay.provide(window,'showWeblinkPreviewDialog',function(weblinkId) {
				
				A.DialogManager.hideAll();
									
				var weblinkUpdateFormURL = Liferay.PortletURL.createRenderURL();
				
				if(weblinkUpdateFormURL){
					
					weblinkUpdateFormURL.setPortletId('<%=portletId %>');
					weblinkUpdateFormURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
					weblinkUpdateFormURL.setParameter('jspPage', '/html/weblinks_admin/weblink/weblink_preview.jsp');
					weblinkUpdateFormURL.setParameter('weblinkId', weblinkId);
					weblinkUpdateFormURL.setDoAsGroupId('<%=groupId %>');
				}
																				
				var dialogAlignConfig = {
						node: '#<portlet:namespace/>showAdvancedSearchFormBtn',
						points: ['tr', 'tl']
				};
									   
				Liferay.Util.openWindow(
					{
						dialog: {
							align: dialogAlignConfig,
							constrain: true,
							width:400,
							destroyOnClose:true
						},
						id: '<portlet:namespace/>weblinkAdminDialog',
						title: '<%= UnicodeLanguageUtil.get(pageContext, "weblink-information") %>',
						uri: weblinkUpdateFormURL
					}
				);
			},
			['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
		);
		
		Liferay.provide(window,'showWeblinkUpdateForm',function(weblinkId) {
				
				A.DialogManager.hideAll();
									
				var weblinkUpdateFormURL = Liferay.PortletURL.createRenderURL();
				
				if(weblinkUpdateFormURL){
					
					weblinkUpdateFormURL.setPortletId('<%=portletId %>');
					weblinkUpdateFormURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
					weblinkUpdateFormURL.setParameter('jspPage', '/html/weblinks_admin/weblink/weblinks_update_form.jsp');
					weblinkUpdateFormURL.setParameter('weblinkId', weblinkId);
					weblinkUpdateFormURL.setDoAsGroupId('<%=groupId %>');
				}
				
				var dialogTitle = '<%= UnicodeLanguageUtil.get(pageContext, "add-new-weblink") %>';
				
				if(weblinkId > 0){
					
					dialogTitle = '<%= UnicodeLanguageUtil.get(pageContext, "update-weblink") %>';
				}
				
				var dialogAlignConfig = {
						node: '#<portlet:namespace/>showAdvancedSearchFormBtn',
						points: ['tr', 'tl']
				};
									   
				Liferay.Util.openWindow(
					{
						dialog: {
							align: dialogAlignConfig,
							constrain: true,
							height:390,
							width:370,
							destroyOnClose:true
						},
						id: '<portlet:namespace/>weblinkAdminDialog',
						title: dialogTitle,
						uri: weblinkUpdateFormURL
					}
				);
			},
			['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
		);
	});
</script>