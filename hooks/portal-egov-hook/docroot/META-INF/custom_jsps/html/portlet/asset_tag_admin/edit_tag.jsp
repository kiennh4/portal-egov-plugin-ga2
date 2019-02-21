<%--
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
--%>

<style type="text/css">
		
	.asset-tag-layer .flag-selector{
		display: none;
	}
	
	.asset-tag-layer input[type="text"]{
		width: 300px !important;
		display: inline-block;
		padding: 6px 5px !important;
		color: #555555;
		vertical-align: middle;
		-webkit-border-radius: 3px !important;
		   -moz-border-radius: 3px !important;
		        border-radius: 3px !important;
		background-color: #ffffff !important;
		border: 1px solid #cccccc ;
		-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075) !important;
		   -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075) !important;
		        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075) !important;
		-webkit-transition: border linear 0.2s, box-shadow linear 0.2s !important;
		   -moz-transition: border linear 0.2s, box-shadow linear 0.2s !important;
		     -o-transition: border linear 0.2s, box-shadow linear 0.2s !important;
		        transition: border linear 0.2s, box-shadow linear 0.2s !important;
	}
	
	.asset-tag-layer input[type="text"]:focus{
	  border-color: rgba(82, 168, 236, 0.8) !important;
	  outline: 0;
	  outline: thin dotted \9;
	  /* IE6-9 */
	
	  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	     -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	          box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	}
			
	.asset-tag-layer .aui-form-validator-message{
		border-radius: 2px;
		width: 91%;
	}
</style>

<%@ include file="/html/portlet/asset_tag_admin/init.jsp" %>

<%
	String randomNamespace = PortalUtil.generateRandomKey(request, "portlet_asset_tad_admin_edit_tag") + StringPool.UNDERLINE;
	
	AssetTag tag = (AssetTag)request.getAttribute(WebKeys.ASSET_TAG);
	
	long tagId = BeanParamUtil.getLong(tag, request, "tagId");
%>

<portlet:actionURL var="editTagURL">
	<portlet:param name="struts_action" value="/asset_tag_admin/edit_tag" />
</portlet:actionURL>

<aui:form action="<%= editTagURL %>" cssClass="update-tag-form" method="get" name='<%= randomNamespace + "fm" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= tag == null ? Constants.ADD : Constants.UPDATE %>" />

	<aui:model-context bean="<%= tag %>" model="<%= AssetTag.class %>" />

	<aui:fieldset>
		<div>
			<div class="add-tag-layer asset-tag-layer">
				<aui:input name="tagId" type="hidden" value="<%= tagId %>" />

				<aui:input cssClass="tag-name" name="name" />

				<aui:button-row>
					<aui:button type="submit" />

					<c:if test="<%= tag != null %>">
						<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetTag.class.getName(), tag.getTagId(), ActionKeys.DELETE) %>">
							<aui:button id="deleteTagButton" value="delete" />
						</c:if>

						<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetTag.class.getName(), tag.getTagId(), ActionKeys.PERMISSIONS) %>">
							<liferay-security:permissionsURL
								modelResource="<%= AssetTag.class.getName() %>"
								modelResourceDescription="<%= tag.getName() %>"
								resourcePrimKey="<%= String.valueOf(tag.getTagId()) %>"
								var="permissionsURL"
								windowState="<%= LiferayWindowState.POP_UP.toString() %>"
							/>

							<aui:button data-url="<%= permissionsURL %>" id="updateTagPermissions" value="permissions" />
						</c:if>
					</c:if>

					<aui:button cssClass="close-panel" type="cancel" value="close" />
				</aui:button-row>
			</div>
		</div>
	</aui:fieldset>
</aui:form>


<aui:script use='aui-form-validator,aui-overlay-context-panel'>
	
	var randomNameSpace = '<%=randomNamespace %>';
	
	var randomFormId = '#<portlet:namespace />' + randomNameSpace + 'fm';
	
	window.validator = new A.FormValidator({

        boundingBox: randomFormId,
        rules: {
            <portlet:namespace />name: {
                required: true,
                rangeLength: ['1','75']
            }
        }
    });

</aui:script>