<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="sun.security.acl.GroupImpl"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<style type="text/css">

</style>

<%
	//Tu khoa tim kiem FAQ Entry
	String faqSearchKeyword = ParamUtil.getString(request, "faqSearchKeyword",StringPool.BLANK);
	
	//Danh sach linh vuc hoi dap
	List<LegalFAQCategory> legalFAQCategoryList = LegalFAQCategoryLocalServiceUtil.findByGroup(scopeGroupId);
	
	//Id cua FAQ Category chon tu select box trong form search
	long categoryId = ParamUtil.getLong(request, "categoryId",0L);
	
	//Id cua FAQ Category lay tu URL lien ket voi portlet Legal FAQ Categories
	long legalFAQCategoryId = ParamUtil.getLong(request, "legalFAQCategoryId",0L);
	
	if(legalFAQCategoryId > 0){
		
		categoryId = legalFAQCategoryId;
	}
	
	faqSearchKeyword = HtmlUtil.escapeJS(faqSearchKeyword);
	
	//Ket qua tim kiem FAQ Entry
	List<LegalFAQEntry> legalFAQEntryList = LegalFAQEntryLocalServiceUtil.findByKeywordAndStatus(scopeGroupId, categoryId, faqSearchKeyword, 0, -1);

%>

	<liferay-portlet:renderURL var="FAQHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/view.jsp" />
		<liferay-portlet:param name="legalFAQCategoryId" value="0" />
	</liferay-portlet:renderURL>
			
	<div class="legal-faq-header-row">
		<div class="legal-faq-search-form">
			<div class="search-icon">
				<a href="<%=FAQHomePageURL%>"><img src="/legal-faq-portlet/images/faq_search_icon.jpg"/></a>
			</div>
			
			<div class="search-form">
				<div class="search-form-title">
					<span><liferay-ui:message key="legal-faq-search-form"/></span>
				</div>
				
				<div class="search-form-guide">
					<span><liferay-ui:message key="please-enter-faq-title-faq-content-or-ask-user-name-to-textbox-below"/></span>
				</div>
				
				<div>
					<aui:form name="faq_search_form" method="post" action="<%=FAQHomePageURL %>">
						<input 	type="text" id="<portlet:namespace/>faqSearchKeywordInput" .
								name="faqSearchKeyword" value="<%=faqSearchKeyword%>"/>
						<aui:button type="submit" value="search"/>
						
						<aui:select name="categoryId" label="" >
							<aui:option value="0" selected="<%=(categoryId == 0L) %>" label="faq-categories" />
							<%
							for(LegalFAQCategory searchCategory : legalFAQCategoryList){
							%>
								<aui:option value="<%=searchCategory.getCategoryId()%>" label="<%=searchCategory.getCategoryName() %>" 
											selected="<%=(categoryId == searchCategory.getCategoryId())%>" />
							<%
							}
							%>
						</aui:select>
						
					</aui:form>
				</div>
			</div>
		</div>
						
		<c:if test='<%=legalFAQCategoryId > 0L %>'>
			<%
				String selectedCategoryName = "";
			
				LegalFAQCategory selectedFAQCategory = LegalFAQCategoryLocalServiceUtil.getCategory(legalFAQCategoryId);
				
				if(selectedFAQCategory != null){
					
					selectedCategoryName = selectedFAQCategory.getCategoryName();
				}
			%>
			<div class="category-faqs-title">
				<c:choose>
					<c:when test="<%=legalFAQEntryList.size() > 0 %>">
						<liferay-ui:message arguments="<%= selectedCategoryName %>" key="faq-entries-with-category-x" />
					</c:when>
					
					<c:otherwise>
						<liferay-ui:message arguments="<%= selectedCategoryName %>" key="no-faq-entry-exist-with-category-x" />
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>
		
		<div class="faq-control-row">
									
			<liferay-portlet:renderURL var="giveAskURL" >
				<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/give_ask_form.jsp" />
			</liferay-portlet:renderURL>
	
			<aui:button type="button" cssClass="btn-primary"  value="give-ask" href="<%=giveAskURL %>"/>
			<aui:button type="button"  value="show-all-faqs" href="<%=FAQHomePageURL %>"/>
		</div>
	</div>

	<div style="clear: both;"></div>
	
	<div class="legal-faq-entries-list">
					
		<liferay-portlet:renderURL varImpl="FAQHomePageImplURL">
			<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/view.jsp" />
			<liferay-portlet:param name="faqSearchKeyword" value="<%=faqSearchKeyword %>" />
			<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>" />
		</liferay-portlet:renderURL>
	
		<liferay-ui:search-container emptyResultsMessage="no-search-result-found" delta="10" iteratorURL="<%=FAQHomePageImplURL %>" >
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(legalFAQEntryList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=legalFAQEntryList.size() %>"
			>			
			</liferay-ui:search-container-results>
			
			<liferay-ui:search-container-row className="LegalFAQEntry" keyProperty="entryId" modelVar="legalFAQEntry" >
			<%
				//Tieu de cau hoi
				String askTitle = legalFAQEntry.getAskTitle();

				//Noi dung cau hoi
				String askContent = legalFAQEntry.getAskContent();
				
				if(askContent.length() > 300){
					askContent = StringUtil.shorten(askContent, 300) + "...";
				}
				
				String senderName = legalFAQEntry.getCitizenName();
				
				String sendDate = dateFormat.format(legalFAQEntry.getAskDate());
			%>
							
				<liferay-portlet:renderURL var="viewEntryURL" >
					<liferay-portlet:param name="legalFAQEntryId" value="<%=String.valueOf(legalFAQEntry.getEntryId())%>"/>
					<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/view_faq_entry.jsp" />
				</liferay-portlet:renderURL>
				
				<div class="faq-entry">
					<div class="ask-title">
						<a href="<%=viewEntryURL%>"><%=askTitle %></a>
					</div>
					
					<div style="clear: both;"></div>
					
					<div class="ask-content">
						<%=askContent %>
						<span class="view-full-ask-content-url">
							<a href="<%=viewEntryURL%>"><liferay-ui:message key="view-details"/></a>
						</span>
					</div>
					
					<div style="clear: both;"></div>
					
					<div class="ask-metadata">
						<liferay-ui:message key="send-by"/> :&nbsp; <%=senderName %>
						<br/>
						<liferay-ui:message key="send-date"/> :&nbsp; <%=sendDate %>
					</div>
				</div>
			</liferay-ui:search-container-row>
		
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
									
	<liferay-portlet:renderURL var="giveAskFormURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/give_ask_form.jsp" />
	</liferay-portlet:renderURL>
							
	<script type="text/javascript">
	
		AUI().ready('aui-base',function(A){
			
			var faqSearchKeywordInput = A.one('#<portlet:namespace/>faqSearchKeywordInput');
			
			if(faqSearchKeywordInput){
				
				faqSearchKeywordInput.focus();
			}
		});
	</script>
