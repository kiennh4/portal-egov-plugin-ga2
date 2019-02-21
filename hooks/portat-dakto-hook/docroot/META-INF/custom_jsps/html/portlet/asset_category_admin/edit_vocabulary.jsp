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
		
	.asset-category-layer .flag-selector{
		display: none;
	}
	
	.asset-category-layer select,
	.asset-category-layer textarea,
	.asset-category-layer input[type="text"]{
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
	
	.asset-category-layer select:focus,
	.asset-category-layer textarea:focus,
	.asset-category-layer input[type="text"]:focus{
	  border-color: rgba(82, 168, 236, 0.8) !important;
	  outline: 0;
	  outline: thin dotted \9;
	  /* IE6-9 */
	
	  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	     -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	          box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	}

	.asset-category-layer .vocabulary-name input[type="text"]{
		width: 300px !important;
	}
		
	.asset-category-layer .vocabulary-desc textarea{
		width: 300px !important;
		height: 70px !important;
	}
	
	.asset-category-layer .aui-form-validator-message{
		border-radius: 3px;
		width: 91%;
	}
	
</style>

<%@ include file="/html/portlet/asset_category_admin/init.jsp" %>

<%
String randomNamespace = PortalUtil.generateRandomKey(request, "portlet_asset_category_admin_edit_vocabulary") + StringPool.UNDERLINE;

AssetVocabulary vocabulary = (AssetVocabulary)request.getAttribute(WebKeys.ASSET_VOCABULARY);

long vocabularyId = BeanParamUtil.getLong(vocabulary, request, "vocabularyId");
%>

<portlet:actionURL var="editVocabularyURL">
	<portlet:param name="struts_action" value="/asset_category_admin/edit_vocabulary" />
</portlet:actionURL>

<aui:form name='<%= randomNamespace + "fm" %>' action="<%= editVocabularyURL %>" method="get" cssClass="update-vocabulary-form" >
	
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= vocabulary == null ? Constants.ADD : Constants.UPDATE %>" />
	
	<aui:input name="vocabularyId" type="hidden" value="<%= vocabularyId %>" />

	<aui:model-context bean="<%= vocabulary %>" model="<%= AssetVocabulary.class %>" />

	<aui:fieldset>
		<div>
			<div class="add-vocabulary-layer asset-category-layer">
				<aui:input name="title" label="name" cssClass="vocabulary-name" />

				<aui:input name="description" cssClass="vocabulary-desc"/>
				
				<!-- HungDX them class aui-helper-hidden de an cac thuoc tinh nang cao -->
				<div class="aui-helper-hidden">
					<%@ include file="/html/portlet/asset_category_admin/edit_vocabulary_settings.jspf" %>
	
					<c:choose>
						<c:when test="<%= vocabulary == null %>">
							<aui:field-wrapper cssClass="vocabulary-permissions-actions" label="permissions">
								<liferay-ui:input-permissions
									modelName="<%= AssetVocabulary.class.getName() %>"
								/>
							</aui:field-wrapper>
						</c:when>
					</c:choose>
				</div>
				
				<aui:button-row>
					<aui:button type="submit" />

					<c:if test="<%= vocabulary != null %>">
						<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetVocabulary.class.getName(), vocabulary.getVocabularyId(), ActionKeys.PERMISSIONS) %>">
							<liferay-security:permissionsURL
								modelResource="<%= AssetVocabulary.class.getName() %>"
								modelResourceDescription="<%= vocabulary.getTitle(locale) %>"
								resourcePrimKey="<%= String.valueOf(vocabulary.getVocabularyId()) %>"
								var="permissionsURL"
								windowState="<%= LiferayWindowState.POP_UP.toString() %>"
							/>

							<aui:button data-url="<%= permissionsURL %>" id="vocabulary-change-permissions" value="permissions" />
						</c:if>
						
						<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetVocabulary.class.getName(), vocabulary.getVocabularyId(), ActionKeys.DELETE) %>">
							<aui:button id="deleteVocabularyButton" value="delete" />
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
            <portlet:namespace />title_vi_VN: {
                required: true,
                rangeLength: ['1','75']
            },
            <portlet:namespace />description_vi_VN: {
                required: false,
                rangeLength: ['0','500']
            }
        }
    });

</aui:script>