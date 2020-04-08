<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.Weblink"%>
<%@page import="com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.WeblinkCategory"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/weblinks_admin/init.jsp"%>

<%
	//Id cua lien ket lay tu URL (truong hop update)
	long weblinkId = ParamUtil.getLong(request, "weblinkId",0L);
	
	long weblinkCategoryId = 0L;
	
	//Lien ket
	Weblink weblink = null;
	
	if(weblinkId > 0L){//truong hop update chuyen muc
		
		weblink = WeblinkLocalServiceUtil.getWeblink(weblinkId);
	
		if(weblink != null){
			
			weblinkCategoryId = weblink.getWeblinkCategoryId();
		}
	}
	
	//Danh sach chuyen muc lien ket lay theo group
	List<WeblinkCategory> weblinkCategoryList = WeblinkCategoryLocalServiceUtil.findByGroup(groupId);
%>
	
	<liferay-portlet:renderURL var="weblinkUpdateFormURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
		<liferay-portlet:param name="jspPage" value="/html/weblinks_admin/view.jsp"/>
	</liferay-portlet:renderURL>

	<liferay-portlet:actionURL name="updateWeblink" var="updateWeblinkActionURL">
		<liferay-portlet:param name="weblinkId" value="<%=String.valueOf(weblinkId) %>"/>
		<liferay-portlet:param name="redirectURL" value="<%=weblinkUpdateFormURL %>"/>
	</liferay-portlet:actionURL>
	
	<aui:form name="weblink_update_form" method="post" action="<%=updateWeblinkActionURL %>">
	
		<div class="weblink-update-form" style="border: none;padding: 0px;">			
		
			<aui:input name="weblinkName" value='<%=(weblink != null) ? weblink.getWeblinkName() : "" %>'/>
					
			<aui:input  name="weblinkURL" label="weblink-url" value='<%=(weblink != null) ? weblink.getWeblinkURL() : "http://" %>'/>
			
			<aui:select name="weblinkCategoryId" label="weblink-category">
				<aui:option label="others" value="0" selected="<%=weblinkCategoryId == 0L %>"/>
				<%
				for(WeblinkCategory weblinkCategory : weblinkCategoryList){
				%>
				<aui:option label="<%=weblinkCategory.getCategoryName() %>" value="<%=weblinkCategory.getCategoryId() %>" 
							selected="<%=weblinkCategoryId == weblinkCategory.getCategoryId() %>"/>
				<%
				}
				%>
			</aui:select>
	
			<aui:input  name="weblinkDesc" type="textarea" value='<%=(weblink != null) ? weblink.getWeblinkDesc() : "" %>'/>
		</div>
		
		<div class="aui-button-holder">
			<aui:button type="submit" value="save" />
			<aui:button name="closeWeblinkUpdateFormBtn" value="cancel"/>
		</div>	
	</aui:form>
	
	<script type="text/javascript">
		
		AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
			
			var weblinkNameInput = A.one('#<portlet:namespace/>weblinkName');
			
			if(weblinkNameInput){
				weblinkNameInput.focus();
			}
			
			var closeWeblinkUpdateFormBtn = A.one('#<portlet:namespace/>closeWeblinkUpdateFormBtn');
			
			if(closeWeblinkUpdateFormBtn){
				
				closeWeblinkUpdateFormBtn.on('click',function(){
					
					Liferay.Util.getWindow().close();
				});
			}
			
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />weblink_update_form,
		
		        rules: {
		            <portlet:namespace />weblinkName: {
		                required: true,
		                rangeLength: ['3','300']
		            },
		            <portlet:namespace />weblinkURL: {
		                required: true,
		                url:true,
		                rangeLength: ['3','300']
		            },
		            <portlet:namespace />weblinkDesc: {
		                required: false,
		                rangeLength: ['0','450']
		            }
		        }
		    });
		});
	</script>