<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.bkav.portal_egov.portlet.asset_statistics.util.AssetStatisticsUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.bkav.portal_egov.portlet.asset_statistics.util.AssetStatisticsUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />

<%
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss"); 

	long groupId = PortalUtil.getScopeGroupId(request);

	long companyId = PortalUtil.getCompanyId(request);
	
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
%>


<%!
	protected void buildCategoryTree(long groupId,long parentCategoryId,int treeLevel,JspWriter jspWriter){
		
		try{
			
			List<AssetCategory> subCategoryList = AssetCategoryLocalServiceUtil.getChildCategories(parentCategoryId);
			
			if(subCategoryList.size() > 0){
				
				for(AssetCategory subCategory : subCategoryList){
					
					String categoryNamePrefix = "";
					String counterPrefix = "";
					
					if(treeLevel > 0){
						
						for(int i = 0; i< treeLevel; i++){
							
							categoryNamePrefix += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
							counterPrefix += "&nbsp;&nbsp;&nbsp;&nbsp;";
						}
					}
					
					String categoryName = categoryNamePrefix + subCategory.getName();
					
					long assetCounter = AssetStatisticsUtil.countByCategory(groupId, subCategory.getCategoryId());
					
					jspWriter.println("<tr class=\"results-row\" >");
					jspWriter.println("<td class=\"first\" ></td>");	
					jspWriter.println("<td>" + categoryName + "</td>");
					jspWriter.println("<td>" + counterPrefix + assetCounter + "</td>");
					jspWriter.println("</tr>");
					
					int nextTreeLevel = treeLevel + 1;
					
					buildCategoryTree(groupId, subCategory.getCategoryId(), nextTreeLevel, jspWriter);
				}
			}
		}catch(Exception e){
			
		}
	}

	protected void buildCategoryTreeSelector(long groupId,long parentCategoryId,long selectedCategoryId,int treeLevel,JspWriter jspWriter){
		
		try{
			
			List<AssetCategory> subCategoryList = AssetCategoryLocalServiceUtil.getChildCategories(parentCategoryId);
			
			if(subCategoryList.size() > 0){
				
				for(AssetCategory subCategory : subCategoryList){
					
					String categoryNamePrefix = "";
					
					if(treeLevel > 0){
						
						for(int i = 0; i< treeLevel; i++){
							
							categoryNamePrefix += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}
					}
					
					String categoryName = categoryNamePrefix + subCategory.getName();
					
					if(subCategory.getCategoryId() == selectedCategoryId){
						
						jspWriter.println("<option selected=\"selected\" value=\"" + subCategory.getCategoryId() + "\">" + categoryName + "</option>");
					}else{
						
						jspWriter.println("<option value=\"" + subCategory.getCategoryId() + "\">" + categoryName + "</option>");
					}
					
					int nextTreeLevel = treeLevel + 1;
					
					buildCategoryTreeSelector(groupId, subCategory.getCategoryId(),selectedCategoryId, nextTreeLevel, jspWriter);
				}
			}
		}catch(Exception e){
			
		}
	}
	
	protected void buildUserCategoryTree(long groupId,long parentCategoryId,long userId,String fromDate,String endDate,int treeLevel,JspWriter jspWriter){
		
		try{
			
			List<AssetCategory> subCategoryList = AssetCategoryLocalServiceUtil.getChildCategories(parentCategoryId);
			
			if(subCategoryList.size() > 0){
				
				for(AssetCategory subCategory : subCategoryList){
					
					int assetCounter = AssetStatisticsUtil.getAssetCounter(groupId, subCategory.getCategoryId(), userId, fromDate, endDate);
					
					if(assetCounter > 0){
						
						String categoryNamePrefix = "";
						String counterPrefix = "";
						
						if(treeLevel > 0){
							
							for(int i = 0; i< treeLevel; i++){
								
								categoryNamePrefix += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
								counterPrefix += "&nbsp;&nbsp;&nbsp;&nbsp;";
							}
						}
						
						String categoryName = categoryNamePrefix + subCategory.getName();
						
						jspWriter.println("<tr class=\"results-row\" >");
						jspWriter.println("<td class=\"first\" ></td>");	
						jspWriter.println("<td>" + categoryName + "</td>");
						jspWriter.println("<td>" + counterPrefix + assetCounter + "</td>");
						jspWriter.println("</tr>");
						
						int nextTreeLevel = treeLevel + 1;
						
						buildUserCategoryTree(groupId, subCategory.getCategoryId(), userId, fromDate, endDate, nextTreeLevel, jspWriter);
					}
				}
			}
		}catch(Exception e){
			
		}
	}
%>