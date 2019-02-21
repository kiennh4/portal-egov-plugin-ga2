<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	if(Validator.isNull(displayStyle)){
		displayStyle="style-1";
	}

	String styleThumbnailImgPath = "/article-publisher-portlet/html/style/" + displayStyle.trim() + "/thumbnail.png";
%>

<liferay-portlet:actionURL portletConfiguration="true" var="portletConfigActionURL" >
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<div class="portlet-config-form">
	<aui:form name="portletConfigForm" method="post" action="<%=portletConfigActionURL%>">
		
		<h3 class="config-title"><liferay-ui:message key="display-setting"/></h3>
		
		<div class="lfr-form-row">
			<aui:select id="styleSelector" name="displayStyle" inlineLabel="left">
				<aui:option label="<%=ArticlePublisherConstants.DISPLAY_STYLE_1 %>" 
							value="<%=ArticlePublisherConstants.DISPLAY_STYLE_1 %>" 
							selected='<%=Validator.equals(displayStyle, ArticlePublisherConstants.DISPLAY_STYLE_1) %>'/>
				<aui:option label="<%=ArticlePublisherConstants.DISPLAY_STYLE_2 %>" 
							value="<%=ArticlePublisherConstants.DISPLAY_STYLE_2 %>" 
							selected='<%=Validator.equals(displayStyle, ArticlePublisherConstants.DISPLAY_STYLE_2) %>'/>
				<aui:option label="<%=ArticlePublisherConstants.DISPLAY_STYLE_3 %>" 
							value="<%=ArticlePublisherConstants.DISPLAY_STYLE_3 %>" 
							selected='<%=Validator.equals(displayStyle, ArticlePublisherConstants.DISPLAY_STYLE_3) %>'/>
				<aui:option label="<%=ArticlePublisherConstants.DISPLAY_STYLE_4 %>" 
							value="<%=ArticlePublisherConstants.DISPLAY_STYLE_4 %>" 
							selected='<%=Validator.equals(displayStyle, ArticlePublisherConstants.DISPLAY_STYLE_4) %>'/>
				<aui:option label="<%=ArticlePublisherConstants.DISPLAY_STYLE_5 %>" 
							value="<%=ArticlePublisherConstants.DISPLAY_STYLE_5 %>" 
							selected='<%=Validator.equals(displayStyle, ArticlePublisherConstants.DISPLAY_STYLE_5) %>'/>
				<aui:option label="<%=ArticlePublisherConstants.DISPLAY_STYLE_6 %>" 
							value="<%=ArticlePublisherConstants.DISPLAY_STYLE_6 %>" 
							selected='<%=Validator.equals(displayStyle, ArticlePublisherConstants.DISPLAY_STYLE_6) %>'/>
				<aui:option label="<%=ArticlePublisherConstants.DISPLAY_STYLE_7 %>" 
							value="<%=ArticlePublisherConstants.DISPLAY_STYLE_7 %>" 
							selected='<%=Validator.equals(displayStyle, ArticlePublisherConstants.DISPLAY_STYLE_7) %>'/>
							
				<aui:option label="<%=ArticlePublisherConstants.DISPLAY_STYLE_8 %>" 
							value="<%=ArticlePublisherConstants.DISPLAY_STYLE_8 %>" 
							selected='<%=Validator.equals(displayStyle, ArticlePublisherConstants.DISPLAY_STYLE_8) %>'/>
							
				<aui:option label="<%=ArticlePublisherConstants.DISPLAY_STYLE_9 %>" 
							value="<%=ArticlePublisherConstants.DISPLAY_STYLE_9 %>" 
							selected='<%=Validator.equals(displayStyle, ArticlePublisherConstants.DISPLAY_STYLE_9) %>'/>
							
				<aui:option label="<%=ArticlePublisherConstants.DISPLAY_STYLE_10 %>" 
							value="<%=ArticlePublisherConstants.DISPLAY_STYLE_10 %>" 
							selected='<%=Validator.equals(displayStyle, ArticlePublisherConstants.DISPLAY_STYLE_10) %>'/>
			</aui:select>
		</div>
		
		<div class="lfr-form-row style-thumbnail">
			<img 
				id="<portlet:namespace/>styleThumbnailImage"  
				src="<%=styleThumbnailImgPath %>"
				onerror="this.src='/article-publisher-portlet/images/default-asset-image.jpg'" 
			/>
		</div>
		
		<h3 class="config-title"><liferay-ui:message key="asset-query-rules"/></h3>
		
		<div class="lfr-form-row">
			<div class="row-fields">
			
				<div class="aui-field-row query-row">
				
					<aui:input label="style-title" cssClass="tab-name-input" name="styleTitle" value="<%=styleTitle%>"/>
				
					<span class="aui-field-label"><liferay-ui:message key="select-asset-categories"/></span>
					
<%-- 					<aui:select inlineField="<%= true %>" name="queryContains" label=""> --%>
<%-- 						<aui:option label="contains" value="true"  selected="<%= queryContains %>" /> --%>
<%-- 						<aui:option label="does-not-contain" value="false" selected="<%= !queryContains %>"/> --%>
<%-- 					</aui:select> --%>
					
<%-- 					<aui:select inlineField="<%= true %>" label="" name="queryAndOperator"> --%>
<%-- 						<aui:option label="all" value="true" selected="<%= queryAndOperator %>"  /> --%>
<%-- 						<aui:option label="any" value="false" selected="<%= !queryAndOperator %>"  /> --%>
<%-- 					</aui:select>	 --%>
					
					<aui:select cssClass="tab-asset-query-name" name="queryName" label="" inlineField="<%=true %>" inlineLabel="left">
						<aui:option label="tags" value="assetTags" selected='<%= Validator.equals(queryName, "assetTags") %>' />
						<aui:option label="categories" value="assetCategories" selected='<%= Validator.equals(queryName, "assetCategories")  %>'/>
					</aui:select>
					
					<div class="aui-field tags-selector <%= Validator.equals(queryName, "assetTags") ? StringPool.BLANK : "aui-helper-hidden" %>">
						<liferay-ui:asset-tags-selector
							hiddenInput="selectedTagsNames"
							curTags='<%= Validator.equals(queryName, "assetTags") ? queryValues : null %>'
							focus="<%= false %>"
						/>
					</div>
					
					<div class="aui-field categories-selector <%= Validator.equals(queryName, "assetCategories") ? StringPool.BLANK : "aui-helper-hidden" %>">
						<liferay-ui:asset-categories-selector
							hiddenInput="selectedCategoryIds"
							curCategoryIds='<%= Validator.equals(queryName, "assetCategories") ? queryValues : null %>'
							focus="<%= false %>"
						/>
					</div>	
				</div>
			</div>
		</div>
		
		<div class="lfr-form-row">
			<div class="row-fields">
			
				<aui:select name="numbersOfEntriesDisplay" label="total-assets-display" inlineLabel="left">
					<%
					for(int i = 0;i < numbersOfEntriesDisplayValues.length; i++)
					{
						int numbersOfEntriesDisplayValue = GetterUtil.getInteger(numbersOfEntriesDisplayValues[i]);
					%>
						<aui:option label="<%= String.valueOf(numbersOfEntriesDisplayValue)%>" value="<%= String.valueOf(numbersOfEntriesDisplayValue)%>"
									selected='<%= numbersOfEntriesDisplay == numbersOfEntriesDisplayValue %>'/>
					<%
					}
					%>
				</aui:select>
				
				<div style="clear: both;"></div>
								
				<aui:select inlineField="<%= true %>" name="orderByColumn" label="asset-order-by-column" inlineLabel="left" >
					<aui:option label="by-title" value="title"  selected='<%= Validator.equals(orderByColumn, "title") %>'/>
					<aui:option label="by-publish-date" value="publishDate" selected='<%= Validator.equals(orderByColumn, "publishDate") %>'/>
					<aui:option label="by-view-count" value="viewCount" selected='<%= Validator.equals(orderByColumn, "viewCount") %>'/>
				</aui:select>
									
				<aui:select inlineField="<%= true %>" label="" name="orderByType">
					<aui:option label="ASC" value="ASC" selected='<%= Validator.equals(orderByType, "ASC") %>' />
					<aui:option label="DESC" value="DESC" selected='<%= Validator.equals(orderByType, "DESC") %>'  />
				</aui:select>
				
			</div>
		</div>
				
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:input type="checkbox" name="showPublishDate" value="<%=showPublishDate %>"/>
				
				<aui:input type="checkbox" label="show-rss-icon" name="showRSSIcon" value="<%=showRSSIcon %>"/>
				
				<aui:input type="checkbox" label="show-view-more-asset-url" 
							name="showViewMoreAssetURL" value="<%=showViewMoreAssetURL %>"/>
			</div>
		</div>	
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="cancelBtn" value="cancel"/>
		</aui:button-row>
	</aui:form>
</div>
<aui:script>
	AUI().ready('aui-loading-mask','aui-io-request','liferay-portlet-url',function(A){
		
		var displayStyleSelector = A.one('#<portlet:namespace/>styleSelector');
		
		if(displayStyleSelector){
			
			displayStyleSelector.on('change',function(){
				
				var selectedStyle = this.val().trim();
				
				var styleThumbnailImg = A.one('#<portlet:namespace/>styleThumbnailImage');
				
				if(styleThumbnailImg){
					var selectedStyleThumbnailPath = '/article-publisher-portlet/html/style/' + selectedStyle + '/thumbnail.png';
					
					styleThumbnailImg.setAttribute('src',selectedStyleThumbnailPath);
				}
			});
		}
				
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		if(closeConfigPageBtn){
			
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
				
		var queryNameSelectors = A.one('#_86_queryName');
		
		if (queryNameSelectors) {
			
			var row = queryNameSelectors.ancestor('.query-row');

			if (row) {
				queryNameSelectors.on(
					'change',
					function(event) {
						var tagsSelector = row.one('.tags-selector');
						var categoriesSelector = row.one('.categories-selector');

						if (queryNameSelectors.val() == 'assetTags') {
							if (tagsSelector) {
								tagsSelector.show();
							}

							if (categoriesSelector) {
								categoriesSelector.hide();
							}
						}
						else {
							if (tagsSelector) {
								tagsSelector.hide();
							}

							if (categoriesSelector) {
								categoriesSelector.show();
							}
						}
					}
				);
			}
		}
	});
</aui:script>