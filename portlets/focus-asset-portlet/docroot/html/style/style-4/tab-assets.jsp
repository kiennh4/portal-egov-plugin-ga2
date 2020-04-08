<%@page import="com.bkav.portal.portlet.focus_asset.cache.AssetEntryCache"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/style/style-4/init.jsp"%>

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
				
				long classPK = focusAsset.getClassPK();	
										
				String viewAssetContentURL = FocusAssetUtil.getViewContentURL(request, focusAsset);
				
				JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK);
		
				JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(articleResource.getGroupId(),articleResource.getArticleId(), 
																					 null, null,languageId, themeDisplay);
				
				String focusAssetTitle = StringUtil.shorten(articleDisplay.getTitle(), 90);
				
				String focusAssetShortContent =(articleDisplay.getDescription()!=null) ? StringUtil.shorten(articleDisplay.getDescription(), 300) : "";
				
				String focusAssetImgPath = FocusAssetUtil.getSmallImagePath(request, classPK);
		%>
				<li data-assetId = "<%=assetEntryId %>" class='focus-asset <%= (i == 0) ? "selected" : StringPool.BLANK%>'>
					<table>
					<tr>
						<td>
							<a  href="<%=viewAssetContentURL%>"
								title="<%=articleDisplay.getTitle() %>"
								data-assetId = "<%=assetEntryId %>" 
								data-assetTitle="<%=focusAssetTitle%>" 
								data-imageSrcPath="<%=focusAssetImgPath%>"
								data-assetShortContent = "<%= focusAssetShortContent%>"
							>
								<img height = "45px" width = "80px" src = "<%=focusAssetImgPath %>" />
							</a>
						</td>
					<td>
						<div>
							<a  href="<%=viewAssetContentURL%>"
								title="<%=articleDisplay.getTitle() %>"
								data-assetId = "<%=assetEntryId %>" 
								data-assetTitle="<%=focusAssetTitle%>" 
								data-imageSrcPath="<%=focusAssetImgPath%>"
								data-assetShortContent = "<%= focusAssetShortContent%>"
							>
								<%=focusAssetTitle %>
							</a>
						</div>
					</td>
					</tr>
					</table>
				</li>
		<%
			}
		%>
		</ul>
	</div>

