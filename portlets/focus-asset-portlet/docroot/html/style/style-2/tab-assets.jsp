<%@page import="com.bkav.portal.portlet.focus_asset.cache.AssetEntryCache"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/style/style-2/init.jsp"%>

<%
	String tabParamPrefix = ParamUtil.getString(request, "tabParamPrefix","first");

	List<AssetEntryCache> tabAssetList = FocusAssetUtil.getTabAssetList(request, tabParamPrefix);
%>
	<div class="tab-asset-list">
		<ul>
		<%
			for(int i = 0; i < tabAssetList.size(); i++){
				
				 AssetEntryCache focusAsset = tabAssetList.get(i);
				
				long assetEntryId = focusAsset.getEntryId();
				String fullAssetTitle = focusAsset.getTitle().trim();
				String focusAssetTitle = StringUtil.shorten(focusAsset.getTitle(), 70);
				
				String fullFocusAssetTitle = focusAsset.getTitle();
				
				String viewAssetContentURL = FocusAssetUtil.getViewContentURL(request, focusAsset);
				
				String focusAssetImgPath = focusAsset.getSmallImagePath();
		%>
				<li data-assetId = "<%=assetEntryId %>" class='focus-asset <%= (i == 0) ? "selected" : StringPool.BLANK%>'>
					<a  href="<%=viewAssetContentURL%>"
						title="<%=focusAsset.getTitle() %>"
						data-assetId = "<%=assetEntryId %>" 
						data-assetTitle="<%=fullFocusAssetTitle%>" 
						data-imageSrcPath="<%=focusAssetImgPath%>"
					>
						<span class="focus-asset-title">
							<%=focusAssetTitle %>
						</span>
						
						<span class="focus-asset-title-mobile"><%=fullAssetTitle%></span>
					</a>
				</li>
		<%
			}
		%>
		</ul>
	</div>

