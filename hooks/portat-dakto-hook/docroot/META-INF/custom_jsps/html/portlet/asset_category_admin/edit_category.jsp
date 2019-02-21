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

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategoryProperty"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.util.LayoutView"%>
<%@page import="com.liferay.portal.util.LayoutLister"%>
<%@page import="com.liferay.portal.model.LayoutListener"%>

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
	
	.asset-category-layer .category-name input[type="text"]{
		width: 300px !important;
	}
		
	.asset-category-layer .category-desc textarea{
		width: 300px !important;
		height: 70px !important;
	}
			
	.asset-category-layer .lfr-panel-content{
		padding: 0px !important;
		border-radius: 2px !important;
	}
				
	.asset-category-layer .lfr-panel-content .lfr-form-row{
		padding: 0px !important;
		margin: 0px !important;
	}
		
	.asset-category-layer .aui-form-validator-message{
		border-radius: 2px;
		width: 91%;
	}
	
	.lfr-autorow-controls.aui-toolbar{
		display: none;
	}
</style>

<%@ include file="/html/portlet/asset_category_admin/init.jsp" %>

<%
String randomNamespace = PortalUtil.generateRandomKey(request, "portlet_asset_category_admin_edit_category") + StringPool.UNDERLINE;

AssetCategory category = (AssetCategory)request.getAttribute(WebKeys.ASSET_CATEGORY);

long categoryId = BeanParamUtil.getLong(category, request, "categoryId");

long parentCategoryId = BeanParamUtil.getLong(category, request, "parentCategoryId");

if(category != null){
	
	parentCategoryId = category.getParentCategoryId();
}

List<AssetVocabulary> vocabularies = (List<AssetVocabulary>)request.getAttribute(WebKeys.ASSET_VOCABULARIES);

long vocabularyId = ParamUtil.getLong(request, "vocabularyId");

int[] categoryPropertiesIndexes = null;

List<AssetCategoryProperty> categoryProperties = Collections.emptyList();

String categoryPropertiesIndexesParam = ParamUtil.getString(request, "categoryPropertiesIndexes");

if (Validator.isNotNull(categoryPropertiesIndexesParam)) {
	categoryProperties = new ArrayList<AssetCategoryProperty>();

	categoryPropertiesIndexes = StringUtil.split(categoryPropertiesIndexesParam, 0);

	for (int categoryPropertiesIndex : categoryPropertiesIndexes) {
		categoryProperties.add(new AssetCategoryPropertyImpl());
	}
}
else {
	if (category != null) {
		categoryProperties = AssetCategoryPropertyServiceUtil.getCategoryProperties(category.getCategoryId());

		categoryPropertiesIndexes = new int[categoryProperties.size()];

		for (int i = 0; i < categoryProperties.size(); i++) {
			categoryPropertiesIndexes[i] = i;
		}
	}

	if (categoryProperties.isEmpty()) {
		categoryProperties = new ArrayList<AssetCategoryProperty>();

		categoryProperties.add(new AssetCategoryPropertyImpl());

		categoryPropertiesIndexes = new int[] {0};
	}

	if (categoryPropertiesIndexes == null) {
		categoryPropertiesIndexes = new int[0];
	}
}

%>


<portlet:actionURL var="editCategoryURL">
	<portlet:param name="struts_action" value="/asset_category_admin/edit_category" />
</portlet:actionURL>

<aui:form   name='<%= randomNamespace + "fm" %>' action="<%= editCategoryURL %>" cssClass="update-category-form" method="get" >
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= category == null ? Constants.ADD : Constants.UPDATE %>" />

	<aui:model-context bean="<%= category %>" model="<%= AssetCategory.class %>" />

	<aui:fieldset>
		<div>
			<div class="add-category-layer asset-category-layer">
				<aui:input name="categoryId" type="hidden" value="<%= categoryId %>" />
				<aui:input name="parentCategoryId" type="hidden" value="<%= parentCategoryId %>" />

				<aui:select inputCssClass="vocabulary-select-list" label="vocabulary" name="vocabularyId" cssClass="vocabulary-selector">

					<%
					for (AssetVocabulary vocabulary : vocabularies) {
						vocabulary = vocabulary.toEscapedModel();
					%>

						<aui:option label="<%= vocabulary.getTitle(locale) %>" selected="<%= vocabulary.getVocabularyId() == vocabularyId %>" value="<%= vocabulary.getVocabularyId() %>" />

					<%
					}
					%>

				</aui:select>
				
				<aui:input cssClass="category-name" label="portal-category-name" name="title" />

				<liferay-ui:panel-container extended="<%= false %>" id="assetCategoryPanelContainer" persistState="<%= true %>">
					<div class="aui-helper-hidden">
						<c:if test="<%= category == null %>">
							<liferay-ui:panel collapsible="<%= true %>" cssClass="category-permissions-actions" defaultState="open" extended="<%= true %>" id="assetCategoryPermissionsPanel" persistState="<%= true %>" title="permissions">
								<liferay-ui:input-permissions
									modelName="<%= AssetCategory.class.getName() %>"
								/>
							</liferay-ui:panel>
						</c:if>
					</div>
					<liferay-ui:panel collapsible="<%= true %>" defaultState="closed" extended="<%= true %>"  id="assetCategoryPropertiesPanel" persistState="<%= true %>" title="properties">
						<aui:fieldset cssClass="category-categoryProperties" id="categoryProperties">
							<%
							for (int i = 0; i < categoryPropertiesIndexes.length; i++) 
							{
								int categoryPropertiesIndex = categoryPropertiesIndexes[i];
								
								AssetCategoryProperty categoryProperty = categoryProperties.get(i);
								
								String propertyKey = categoryProperty.getKey();
								
								String propertyValue = categoryProperty.getValue();
								
								//Property key tuong ung voi plId cua page hien thi tin bai thuoc Category
								String linkToPagePropertyKey = "link-to-page";
								
								//Property key tuong ung voi ten hien thi cua Tag
								String displayNamePropertyKey = "display-name";	
								
								//Property key tuong ung voi Id anh icon cua Tag
								String iconImageIdPropertyKey = "icon-image-id";
								
								//Property key tuong ung custom url cua Tag
								String customURLPropertyKey = "custom-url";
							%>
							<%--
							/**
							@INF: HOOK by HUNGDX at 15/05/2012 
							@Noidung: Them phan chon Trang web hien thi tin bai theo Category su dung CategoryProperty
							*/
							--%>
							<aui:model-context bean="<%= categoryProperty %>" model="<%= AssetCategoryProperty.class %>" />
							
								<div class="lfr-form-row lfr-form-row-inline">
									<div class="row-fields">
									
										<c:choose>
																						
											<c:when test='<%=Validator.equals(propertyKey, displayNamePropertyKey) %>'>																				
												<aui:input fieldParam='<%= "key" + categoryPropertiesIndex %>' 
														   name="key" value="<%= displayNamePropertyKey %>" label=""/>

												<aui:input fieldParam='<%= "value" + categoryPropertiesIndex %>' name="value" label=""/>
											</c:when>
											
																						
											<c:when test='<%=Validator.equals(propertyKey, iconImageIdPropertyKey) %>'>																				
												<aui:input fieldParam='<%= "key" + categoryPropertiesIndex %>'
														   name="key" value="<%= iconImageIdPropertyKey %>" label=""/>

												<aui:input fieldParam='<%= "value" + categoryPropertiesIndex %>' name="value" label="" />
											</c:when>
											
																				
											<c:when test='<%=Validator.equals(propertyKey, customURLPropertyKey) %>'>																				
												<aui:input fieldParam='<%= "key" + categoryPropertiesIndex %>'
														   name="key" value="<%= customURLPropertyKey %>" label=""/>

												<aui:input fieldParam='<%= "value" + categoryPropertiesIndex %>' name="value" label=""/>
											</c:when>
											
											
											<c:otherwise>																																																				
												<aui:select name='<%= "key" + categoryPropertiesIndex %>' label="" >											
													<aui:option label="link-to-page" selected="" value="link-to-page" />
												</aui:select>
												
												<aui:select name='<%= "value" + categoryPropertiesIndex %>' label="">
													<aui:option label="none" selected="" value="0" />
													
													<%
														
														String selectedPlId = categoryProperty.getValue();
													
														LayoutView layoutView = null;
														List layoutList = null;
														LayoutLister layoutLister = new LayoutLister();
														
														layoutView = layoutLister.getLayoutView(scopeGroupId,false,"root",locale);
														
														//Danh sach cac trang web public
														layoutList = layoutView.getList();
														
														// id | parentId | ls | obj id | name | img | depth
														
														if(!layoutList.isEmpty())
														{
															for(int j = 0;j< layoutList.size(); j ++)
															{
																
																String layoutDesc = (String)layoutList.get(j);
																
																String[] nodeValues = StringUtil.split(layoutDesc, "|");
																
																long objId = GetterUtil.getLong(nodeValues[3]);
																
																String name = nodeValues[4];
																
																int depth2 = 0;
																
																if (j != 0) {
																	depth2 = GetterUtil.getInteger(nodeValues[6]);
																}
																
																for (int k = 0; k < depth2; k++){
																	name = "-&nbsp;" + name; 
																}
																
																Layout linkableLayout = null;
																
																try{
																	
																	linkableLayout = LayoutLocalServiceUtil.getLayout(objId);
																}catch(Exception e){
																	
																}
																
																
																if (linkableLayout != null)
																{
													%>
																	<aui:option label="<%=name %>" selected='<%=Validator.equals(String.valueOf(linkableLayout.getPlid()),selectedPlId)%>' value="<%= linkableLayout.getPlid() %>" />
													
													<%				
																}// End if (linkableLayout != null)
															}// End for(int j = 0;j< layoutList.size(); j ++)
														} //End if(!layoutList.isEmpty())
													%>
												</aui:select>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
													
							<!-- End HOOK -->
							<%
							}
							%>
							<aui:input name="categoryPropertiesIndexes" type="hidden" value="<%= StringUtil.merge(categoryPropertiesIndexes) %>" />
						</aui:fieldset>
					</liferay-ui:panel>
				</liferay-ui:panel-container>

				<aui:button-row>
					<aui:button type="submit" />

					<c:if test="<%= category != null %>">

						<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetCategory.class.getName(), category.getCategoryId(), ActionKeys.PERMISSIONS) %>">
							<liferay-security:permissionsURL
								modelResource="<%= AssetCategory.class.getName() %>"
								modelResourceDescription="<%= category.getTitle(locale) %>"
								resourcePrimKey="<%= String.valueOf(category.getCategoryId()) %>"
								var="permissionsURL"
								windowState="<%= LiferayWindowState.POP_UP.toString() %>"
							/>

							<aui:button data-url="<%= permissionsURL %>" id="updateCategoryPermissions" value="permissions" />
						</c:if>
						
						<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetCategory.class.getName(), category.getCategoryId(), ActionKeys.DELETE) %>">
							<aui:button id="deleteCategoryButton" value="delete" />
						</c:if>
					</c:if>

					<aui:button cssClass="close-panel" type="cancel" value="close" />
				</aui:button-row>
			</div>
		</div>
	</aui:fieldset>
</aui:form>
	
<aui:script use="liferay-auto-fields">
	var autoFields = new Liferay.AutoFields(
		{
			contentBox: 'fieldset#<portlet:namespace />categoryProperties',
			fieldIndexes: '<portlet:namespace />categoryPropertiesIndexes'
		}
	).render();

	var categoryPropertiesTrigger = A.one('fieldset#<portlet:namespace />categoryProperties');

	if (categoryPropertiesTrigger) {
		categoryPropertiesTrigger.setData('autoFieldsInstance', autoFields);
	}
</aui:script>


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