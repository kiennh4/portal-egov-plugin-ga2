<%@page import="com.portal_egov.portlet.banner.util.BannerUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.portal_egov.portlet.banner.service.BannerGroupLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.banner.model.BannerGroup"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.banner.search.BannerSearch"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.portal_egov.portlet.banner.service.BannerLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.banner.model.Banner"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	Banner selectedBanner = null;
	
	Image bannerImage = null;
	
	String bannerSearchKeyword = ParamUtil.getString(request, "bannerSearchKeyword");
	
	//Id cua banner duoc chon tu danh sach ben duoi
	long selectedBannerId = ParamUtil.getLong(request, "selectedBannerId",0L);
	
	if(selectedBannerId > 0){
		
		selectedBanner = BannerLocalServiceUtil.getBanner(selectedBannerId);
		
		if(selectedBanner != null){
			bannerTitle = selectedBanner.getBannerTitle();
			bannerLink = selectedBanner.getBannerLink();
			
			long bannerImageId = selectedBanner.getBannerImageId();
			
			if(bannerImageId > 0){
				
				bannerImage = ImageLocalServiceUtil.getImage(bannerImageId);
				
				if(bannerImage != null){
					
					bannerImageHeight = bannerImage.getHeight();
					bannerImageWidth = bannerImage.getWidth();
				}
			}
		}
	}else if(bannerId > 0){
		
		selectedBanner = BannerLocalServiceUtil.getBanner(bannerId);
	}	
%>

<liferay-portlet:actionURL portletConfiguration="true" var="bannerConfigurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true" var="bannerConfigurationRenderURL"  windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
	<liferay-portlet:param name="bannerSearchKeyword" value="<%=bannerSearchKeyword %>"/>
</liferay-portlet:renderURL>
		
<div class="portlet-msg-info">
	<c:choose>
		<c:when test='<%=Validator.isNotNull(bannerTitle) %>'>
			<span class="displaying-article-id-holder">
				<liferay-ui:message key="displayed-banner" />: 
				<span class="displaying-article-id"><%= bannerTitle %></span>
			</span>
		</c:when>
		<c:otherwise>
			<span class="displaying-help-message-holder <%= selectedBanner != null ? "aui-helper-hidden"  : StringPool.BLANK %>">
				<liferay-ui:message key="please-select-a-banner-from-the-list-below-and-click-save-button" />
			</span>
		
			<span class="displaying-article-id-holder <%= selectedBanner != null ?  StringPool.BLANK  :"aui-helper-hidden"%>">
				<liferay-ui:message key="displayed-banner" />: 
				<span class="displaying-article-id"><%= bannerTitle %></span>
			</span>
		</c:otherwise>
	</c:choose>		
</div>

<div class="banner-config-form">
	<aui:form name="banner_config_form" method="post" action="<%=bannerConfigurationActionURL %>">
		
		<div class="<%=selectedBanner!= null ? "" : "aui-helper-hidden"%>">
			<aui:input type="text" name="bannerImageHeight" value="<%=bannerImageHeight %>" />
			
			<aui:input type="text" name="bannerImageWidth" value="<%=bannerImageWidth %>" />
			
			<aui:input type="textarea"  name="bannerLink" value='<%=bannerLink %>'/>
			
			<aui:input name="bannerImageBorder" label="set-border-banner-image" type="checkbox" value="<%= bannerImageBorder %>"/>
			
			<aui:input name="linkToNewTab" label="open-link-in-new-tabs" type="checkbox" value="<%= linkToNewTab %>"/>
		
			<aui:input  type="hidden"  name="selectedBannerId" value="<%= (selectedBannerId > 0) ? selectedBannerId : bannerId %>"/>
			
			<aui:input  type="hidden"  name="bannerTitle" value="<%=bannerTitle %>"/>
						
			<aui:button-row>
				<aui:button type="submit" value="save"/>
				<aui:button name="cancelBtn" value="cancel"/>
			</aui:button-row>
		</div>
	</aui:form>
</div>


<div class="banner-config-search-form">
	<aui:form name="banner_config_form" method="post" action="<%=bannerConfigurationRenderURL %>">
		
		<input type="text" id="<portlet:namespace/>bannerSearchKeywordInput" name="bannerSearchKeyword" value="<%=bannerSearchKeyword %>"/>
		
		<aui:button type="submit" value="search"/>
		
		<aui:button name="addNewBannerBtn" value="add-new-banner"/>
	</aui:form>
</div>

<div style="clear: both;"></div>

<liferay-portlet:renderURL portletConfiguration="true" varImpl="bannerConfigurationRenderImplURL">
	<liferay-portlet:param name="bannerSearchKeyword" value="<%=bannerSearchKeyword %>"/>
</liferay-portlet:renderURL>

<liferay-ui:search-container searchContainer="<%= new BannerSearch(renderRequest,bannerConfigurationRenderImplURL) %>">
<%
	int bannerIndex = 0;
	List<Banner> bannerList = BannerLocalServiceUtil.findByTitle(groupId, 0,
		bannerSearchKeyword, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
%>
	<liferay-ui:search-container-results 
		results="<%=ListUtil.subList(bannerList, searchContainer.getStart(), searchContainer.getEnd()) %>" 
		total="<%=bannerList.size() %>"
	/>
	<liferay-ui:search-container-row className="Banner" keyProperty="bannerId" modelVar="banner">
		<%
			bannerIndex ++;
			String bannerImageSrcPath =  BannerUtil.getBannerImagePath(request, banner.getBannerImageId());
		%>
		<liferay-portlet:renderURL portletConfiguration="true" var="selectBannerURL" >
			<liferay-portlet:param name="selectedBannerId" value="<%=String.valueOf(banner.getBannerId()) %>"/>
		</liferay-portlet:renderURL>
												
		<liferay-ui:search-container-column-text 
			name="" 
			value="<%=String.valueOf(bannerIndex)%>" 
			href="<%=selectBannerURL %>"
			title="select"
		/>
				
		<liferay-ui:search-container-column-text
			name="banner-image"
			title="banner-image"
			href="<%=selectBannerURL %>"
		>
			<div class="banner-thumbnail">
				<img src="<%=bannerImageSrcPath%>"/>
			</div>
		</liferay-ui:search-container-column-text>
								
		<liferay-ui:search-container-column-text 
			name="banner-title" 
			orderable="<%=true %>"  
			value="<%=banner.getBannerTitle()%>" 
			href="<%=selectBannerURL %>"
			title="select"
		/>
										
		<liferay-ui:search-container-column-text 
			name="create-date" 
			value="<%=dateTimeFormat.format(banner.getCreateDate())%>"
			orderable="<%=true %>"
			href="<%=selectBannerURL %>"
			title="select"
		/>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%=true %>"/>
	
</liferay-ui:search-container>

<aui:script>

	AUI().ready('aui-base','liferay-portlet-url',function(A){
		
		var bannerSearchKeywordInput = A.one('#<portlet:namespace/>bannerSearchKeywordInput');
		
		if(bannerSearchKeywordInput){
			bannerSearchKeywordInput.focus();
		}
		
		var addNewBannerBtn = A.one('#<portlet:namespace/>addNewBannerBtn');
		
		if(addNewBannerBtn){
			
			addNewBannerBtn.on('click',function(){

				var addBannerURL = Liferay.PortletURL.createRenderURL();
											
				addBannerURL.setPortletId('banner_admin_WAR_bannerportlet');
				addBannerURL.setWindowState('pop_up');
				addBannerURL.setParameter('jspPage', '/html/admin/banner_update_form.jsp');
				addBannerURL.setParameter('portletInstanceResource', '<%=portletResource %>');
				addBannerURL.setDoAsGroupId('<%=groupId %>');
							
				var dialogWidow = {
					dialog: {
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: 400,
						cache: false
					},
					title: Liferay.Language.get('add-new-banner'),
					uri: addBannerURL
				};
				
				Liferay.Util.openWindow(dialogWidow);				
			});
		}
								
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		if(closeConfigPageBtn){
			
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</aui:script>
