<%--
/**
 * HungDX Hook 20/09/2012
 * Nội dung: Sửa lại trang cấu hình của portlet.Thêm chức năng tùy chọn phạm vi tìm kiếm theo từng kiểu tài nguyên,dữ liệu
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ include file="/html/portlet/search/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />

	<aui:fieldset label="configuration-style-selection">
		<div class="configuration-style" id="<portlet:namespace />configurationStyle">
			<aui:field-wrapper>
				<aui:input checked="<%= !advancedConfiguration %>" id="basic" label="basic" name="preferences--advancedConfiguration--" type="radio" value="false" />
				<aui:input checked="<%= advancedConfiguration %>" id="advanced" label="advanced" name="preferences--advancedConfiguration--" type="radio" value="true" />
			</aui:field-wrapper>
		</div>

		<div class="basic-configuration <%= (advancedConfiguration ? "aui-helper-hidden" : "") %>" id="<portlet:namespace />basicConfiguration">
			
			<aui:fieldset label="search-entities-selection">
				<aui:input name="preferences--searchOnJournalArticle--" type="checkbox" value="<%= searchOnJournalArticle %>" />
		
				<aui:input name="preferences--searchOnVBPQ--" type="checkbox" value="<%= searchOnVBPQ %>" />
		
<%-- 				<aui:input name="preferences--searchOnTTHC--" type="checkbox" value="<%= searchOnTTHC %>" /> --%>
		
<%-- 				<aui:input name="preferences--searchOnPublicDocType--" type="checkbox" value="<%= searchOnPublicDocType %>" /> --%>
				
<%-- 				<aui:input name="preferences--searchOnProposition--" type="checkbox" value="<%= searchOnProposition %>" /> --%>
		
<%-- 				<aui:input name="preferences--searchOnLegalFAQ--" type="checkbox" value="<%= searchOnLegalFAQ %>" /> --%>
		
				<aui:input name="preferences--searchOnDLFileEntry--" type="checkbox" value="<%= searchOnDLFileEntry %>" />
			</aui:fieldset>
			
			<aui:fieldset label="display-settings">
				<aui:input name="preferences--displayAssetTypeFacet--" type="checkbox" value="<%= displayAssetTypeFacet %>" />

<%-- 				<aui:input name="preferences--displayAssetTagsFacet--" type="checkbox" value="<%= displayAssetTagsFacet %>" /> --%>

<%-- 				<aui:input name="preferences--displayAssetCategoriesFacet--" type="checkbox" value="<%= displayAssetCategoriesFacet %>" /> --%>

				<aui:input name="preferences--displayModifiedRangeFacet--" type="checkbox" value="<%= displayModifiedRangeFacet %>" />
			</aui:fieldset>
		</div>
		<div class="advanced-configuration <%= (!advancedConfiguration ? "aui-helper-hidden" : "") %>" id="<portlet:namespace />advancedConfiguration">
			<aui:input helpMessage="search-configuration-help" inputCssClass="search-configuration-text" name="preferences--searchConfiguration--" type="textarea" value="<%= searchConfiguration %>" />
		</div>
	</aui:fieldset>

	<br />

	<aui:fieldset label="search-results-data-settings">
		<c:if test="<%= permissionChecker.isCompanyAdmin() %>">
			<aui:input helpMessage="display-results-in-document-form-help" name="preferences--displayResultsInDocumentForm--" type="checkbox" value="<%= displayResultsInDocumentForm %>" />
		</c:if>

<%-- 		<aui:input name="preferences--viewInContext--" type="checkbox" value="<%= viewInContext %>" /> --%>

		<aui:input helpMessage="display-main-query-help" name="preferences--displayMainQuery--" type="checkbox" value="<%= displayMainQuery %>" />

		<aui:input helpMessage="display-open-search-results-help" name="preferences--displayOpenSearchResults--" type="checkbox" value="<%= displayOpenSearchResults %>" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base">
	var basicConfiguration = A.one('#<portlet:namespace />basicConfiguration');
	var advancedConfiguration = A.one('#<portlet:namespace />advancedConfiguration');

	var configurationStyles = A.all('#<portlet:namespace />configurationStyle input');

	configurationStyles.on(
		'change',
		function(event) {
			var value = event.currentTarget.val();

			basicConfiguration.toggle(value != 'true');

			advancedConfiguration.toggle(value == 'true');
		}
	);
</aui:script>
