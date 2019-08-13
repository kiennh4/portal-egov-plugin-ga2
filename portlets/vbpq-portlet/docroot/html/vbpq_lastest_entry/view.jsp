<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Entry"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<style type="text/css">
	.vbpq-lastest-entries{
		height: 250px;
	}
</style>
<script src="/vbpq-portlet/js/jquery.marquee.js"></script>
<%@include file="/html/vbpq_lastest_entry/init.jsp"%>

<%
	List<VBPQ_Entry> vbpqLastestEntryList = VBPQ_EntryLocalServiceUtil.findByGroup(scopeGroupId, 0, numbersOfEntriesDisplay);
%>

<div class="vbpq-lastest-entries">
	<ul id="documentList" class="jcarousel-skin-tango">
		<%
			for(int i = 0; i < vbpqLastestEntryList.size(); i++)
			{
				VBPQ_Entry vbpqEntry = vbpqLastestEntryList.get(i);
				
				long vbpqEntryId = vbpqEntry.getEntryId();
				
				String vbpqEntryName = StringUtil.shorten(vbpqEntry.getEntryName(), 60);
				
				String vbpqPublishDate = "";
				
				if(vbpqEntry.getPublishDate() != null){
					
					vbpqPublishDate = dateFormat.format(vbpqEntry.getPublishDate());
				}
				
				StringBundler sb = new StringBundler();

				sb.append("javascript:");
				sb.append("showNewVBDialog");
				sb.append("('");
				sb.append(vbpqEntryId);
				sb.append("')");

				String	vbpqPreviewURL = sb.toString();
		%>
				<li>
					<div>
						<span class="vbpq_name">
							<a href="<%= vbpqPreviewURL%>" title='<%=vbpqEntry.getEntryName()%>'><%=vbpqEntryName%></a>
						</span>	  		  
			  		  		  		  				
						<c:if test='<%=displayPublishDate && Validator.isNotNull(vbpqPublishDate) %>'>
							<span class="vbpq_publish_date">
								(<%=vbpqPublishDate %>)
							</span>
						</c:if>
					</div>
			    </li>
		<%
			}
		%>
	</ul>
</div>
<script>
	$('#documentList').marquee();  
</script>
<script type="text/javascript">
	
	Liferay.provide(
			window,
			'showNewVBDialog',
			function(vbpqEntryId) {
				
				var A = AUI();
				
				A.DialogManager.hideAll();
									
				var vbpqPreviewRenderURL = Liferay.PortletURL.createRenderURL();
				
				if(vbpqPreviewRenderURL){
					
					vbpqPreviewRenderURL.setPortletId('<%= portletId %>');
					vbpqPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
					vbpqPreviewRenderURL.setParameter('jspPage', '/html/vbpq_lastest_entry/vbpq_new_preview.jsp');
					vbpqPreviewRenderURL.setParameter('vbpqEntryId', vbpqEntryId);
					vbpqPreviewRenderURL.setDoAsGroupId('<%=scopeGroupId %>');
				}
				console.log(vbpqPreviewRenderURL);		   
				var dialogAlignConfig = {
						node: '.vbpq_search_form_wrapper',
						points: ['tl', 'tl']
				};
				Liferay.Util.openWindow(
					{
						dialog: {
							align: dialogAlignConfig,
							constrain: true,
							width:708
						},
						id: '<portlet:namespace/>VbNewDialog',
						title: '<%= UnicodeLanguageUtil.get(pageContext, "vbpq-preview-content") %>',
						uri: vbpqPreviewRenderURL
					}
				);
			},
			['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
		);
</script>