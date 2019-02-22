<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.bkav.portal.portlet.contentsharing.util.ContentSharingAdminUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.TempFileUtil"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="org.apache.commons.io.FileUtils"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppService"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil"%>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="com.liferay.portal.kernel.util.FileUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.store.DLStoreUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="java.io.File"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleResource"%>
<%@page import="com.mysql.jdbc.StringUtils"%>
<%@page import="com.liferay.counter.service.CounterLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@include file="/html/admin/init.jsp"%>
<%
	Long classPK = ParamUtil.getLong(request, "classPK",0);

	Long objectId = ParamUtil.getLong(request, "objectId",0);
	
	AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchAssetEntry(objectId);
	
%>
<c:if test="<%=(classPK>0) %>">
	<%
		JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK);
	
// 		JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(articleResource.getGroupId(), 
// 				articleResource.getArticleId());//(19, articleResource.getArticleId(), 0);
	
// 		ServiceContext serviceContext = ServiceContextFactory.getInstance(
// 				JournalArticle.class.getName(), renderRequest);
		
		
// 		JournalArticle duplicateArticle = null;
		
// 		if (journalArticle!=null)
// 		{
	
// 			Image image = ImageLocalServiceUtil.fetchImage(journalArticle.getSmallImageId());
			
// 			File fileCopy = null;
			
// 			if (image!=null)
// 			{
// 				fileCopy = ContentSharingAdminUtil.copySmallImageArticle(image);
// 			}
	
// 			duplicateArticle = JournalArticleLocalServiceUtil.addArticle(userId, 
// 					groupId, journalArticle.getClassNameId()
// 					, journalArticle.getClassPK(), journalArticle.getArticleId() 
// 					, true, 1.0, journalArticle.getTitleMap(), journalArticle.getDescriptionMap() 
// 					, journalArticle.getContent(), journalArticle.getType(), journalArticle.getStructureId() 
// 					, journalArticle.getTemplateId(), journalArticle.getLayoutUuid() 
// 					, (journalArticle.getDisplayDate()!=null)? journalArticle.getDisplayDate().getMonth() : null
// 					, (journalArticle.getDisplayDate()!=null)? journalArticle.getDisplayDate().getDate() : null
// 					, (journalArticle.getDisplayDate()!=null)? journalArticle.getDisplayDate().getYear() : null 
// 					, (journalArticle.getDisplayDate()!=null)? journalArticle.getDisplayDate().getHours() : null 
// 					, (journalArticle.getDisplayDate()!=null)? journalArticle.getDisplayDate().getMinutes() : null 
// 					, (Validator.isNotNull(journalArticle.getExpirationDate())) ? journalArticle.getExpirationDate().getMonth() :0 
// 					, (Validator.isNotNull(journalArticle.getExpirationDate())) ? journalArticle.getExpirationDate().getDate() :0 
// 					, (Validator.isNotNull(journalArticle.getExpirationDate())) ? journalArticle.getExpirationDate().getYear() :0  
// 					, (Validator.isNotNull(journalArticle.getExpirationDate())) ? journalArticle.getExpirationDate().getHours() :0  
// 					, (Validator.isNotNull(journalArticle.getExpirationDate())) ? journalArticle.getExpirationDate().getMinutes() :0
// 					, (Validator.isNotNull(journalArticle.getExpirationDate())) ? false : true
// 					, (journalArticle.getReviewDate()!=null)? journalArticle.getReviewDate().getMonth() : 0 
// 					, (journalArticle.getReviewDate()!=null)? journalArticle.getReviewDate().getDate() : 0 
// 					, (journalArticle.getReviewDate()!=null)? journalArticle.getReviewDate().getYear() : 0
// 					, (journalArticle.getReviewDate()!=null)? journalArticle.getReviewDate().getHours() : 0
// 					, (journalArticle.getReviewDate()!=null)? journalArticle.getReviewDate().getMinutes() : 0
// 					, (Validator.isNotNull(journalArticle.getReviewDate()))? false : true
// 					, journalArticle.getIndexable()
// 					, journalArticle.getSmallImage(), journalArticle.getSmallImageURL()
// 					, fileCopy, null, StringPool.BLANK, serviceContext);
			
			
// 			if ((Validator.isNotNull(duplicateArticle))&&(fileCopy!=null))
// 			{
// 				fileCopy.delete();
// 			}
			
// 		}
	%>
	<c:choose>
		<c:when test='<%= SessionMessages.contains(renderRequest, "copy-success") %>'>
			   <div class="portlet-msg-success"><liferay-ui:message key="copy-success"/></div>
		</c:when>
		<c:when test='<%= SessionErrors.contains(renderRequest, "copy-error") %>'>
			   <div class="portlet-msg-success"><liferay-ui:message key="copy-error"/></div>
		</c:when>
	</c:choose>
	
	<liferay-portlet:actionURL portletName="<%=contentSharingAdminPortletId %>"  name="copyRelativeContentArticle" 
								var = "copyJournalActionURL">
			<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
	</liferay-portlet:actionURL>
	<c:choose>
		<c:when test="<%=(Validator.isNotNull(assetEntry)) %>">
			<aui:form action = "<%=copyJournalActionURL %>" method = "post">
			<div class = "relative-content">
				<aui:input name="classPK" type = "hidden" value = "<%=classPK %>"/>
				<aui:input name="originGroupId" type = "hidden" value = "<%=articleResource.getGroupId() %>"/>
<%-- 				<aui:input name="copyArticleId" type = "hidden" value = "<%=duplicateArticle.getArticleId() %>"/> --%>
<%-- 				<aui:input name="originArticleId" type = "hidden" value = "<%=journalArticle.getArticleId() %>"/> --%>
<%-- 				<aui:input name="originAssetEntryId" type = "hidden" value = "<%=duplicateArticle.getArticleId() %>"/> --%>
				
				<h1><liferay-ui:message key = "relative-content"/></h1>
				<hr>
				<table style = "width:100%;height:350px;">
					<tr style = "height:60px;">
						<td width = "20%">
							<liferay-ui:message key="categories"/>:
						</td>
						<td width = "80%" >
							<aui:fieldset>
								<liferay-ui:asset-categories-selector 
									hiddenInput="categoryIds"  
									curCategoryIds="<%=ContentSharingAdminUtil.buildCategoriesStr(assetEntry.getCategoryIds()) %>"
								/>
							</aui:fieldset>
						</td>
					</tr>
					<tr style = "height:60px;">
						<td width = "30%">
							<liferay-ui:message key="tags"/>:
						</td>
						<td >
							<liferay-ui:asset-tags-selector 
									hiddenInput="tagIds" 
								   curTags = "<%=StringUtil.merge(assetEntry.getTagNames()) %>"
								/>
						</td>
					</tr>
				</table>
			</div>
			<div style = "clear:both;"></div>
			<center>
			<aui:button-row>
				<aui:button type = "submit" value = "copy"/>
				<aui:button name = "cancelCopy" value = "cancel"/>
			</aui:button-row>
			</aui:form>
			</center>
		</c:when>
		<c:otherwise>
			<div class="portlet-msg-success"><liferay-ui:message key="copy-error"/></div>
		</c:otherwise>
	</c:choose>
</c:if>

