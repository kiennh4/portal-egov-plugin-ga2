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
	.vbpq-lastest-entries .jcarousel-container-vertical{
		height: 260px;
	}
		
	.vbpq-lastest-entries .jcarousel-clip{
		overflow: hidden;
	}
	
	.vbpq-lastest-entries .jcarousel-clip-vertical{
		height: 260px;
	}
</style>

<%@include file="/html/vbpq_lastest_entry_portlet/init.jsp"%>

<%
	List<VBPQ_Entry> vbpqLastestEntryList = VBPQ_EntryLocalServiceUtil.findByGroup(scopeGroupId, 0, numbersOfEntriesDisplay);
%>

<div class="vbpq-lastest-entries">
	<ul id="<portlet:namespace/>vbpqjcarousel" class="jcarousel-skin-tango">
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
				sb.append(renderResponse.getNamespace());
				sb.append("showVBPQPreviewDialog");
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
		
<script type="text/javascript">

	jQuery(document).ready(function() {
	    var vbpqCarousel = jQuery('#<portlet:namespace/>vbpqjcarousel').jcarousel({        
	    	vertical:true,
	    	scroll:1,
	    	auto:0.001,
	    	rtl: false,
	    	wrap:"circular",
	    	animation:3000,
	    	easing: 'linear',
	    	initCallback : initVBPQCallbackFx
	    });
	});

	function initVBPQCallbackFx(vbpqCarousel, obejctli,liindex,listate){
		
	    $("#<portlet:namespace/>vbpqjcarousel li").mouseenter(function(){
	    	vbpqCarousel.stopAuto();
	    }).mouseleave(function(){
	    	vbpqCarousel.startAuto();
	    });
	}
</script>
		
<script type="text/javascript">
	
	Liferay.provide(
			window,
			'<portlet:namespace/>showVBPQPreviewDialog',
			function(vbpqEntryId) {
				
				var A = AUI();
				
				A.DialogManager.hideAll();
									
				var vbpqPreviewRenderURL = Liferay.PortletURL.createRenderURL();
				
				if(vbpqPreviewRenderURL){
					
					vbpqPreviewRenderURL.setPortletId('<%=portletId %>');
					vbpqPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
					vbpqPreviewRenderURL.setParameter('jspPage', '/html/vbpq_lastest_entry_portlet/vbpq_preview.jsp');
					vbpqPreviewRenderURL.setParameter('vbpqEntryId', vbpqEntryId);
					vbpqPreviewRenderURL.setDoAsGroupId('<%=scopeGroupId %>');
				}
				
				Liferay.Util.openWindow(
					{
						dialog: {
							centered: true,
							constrain: true,
							width:730
						},
						id: '<portlet:namespace/>vbpqPreviewDialog',
						title: '<%= UnicodeLanguageUtil.get(pageContext, "vbpq-preview-content") %>',
						uri: vbpqPreviewRenderURL
					}
				);
			},
			['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
		);
</script>