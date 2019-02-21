<%@page import="javax.portlet.PortletResponse"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.servlet.ServletResponseUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.portalplugins.model.PortalPlugins"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.prefs.Preferences"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.security.permission.PermissionThreadLocal"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>

 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<portlet:defineObjects />

<%
	OutputStream os = resourceResponse.getPortletOutputStream();
	
	long pluginId = ParamUtil.getLong(request, "pluginId");
	PortalPlugins plugin = PortalPluginsLocalServiceUtil.fetchPortalPlugins(pluginId);
	if (plugin!=null)
	{
		FileEntry warFile = DLAppServiceUtil.getFileEntry(plugin.getWarFileId());
		resourceResponse.setContentType(warFile.getMimeType());
		resourceResponse.setContentLength((int) warFile.getSize());
// 		ServletResponseUtil.sendFile(resourceResponse, warFile.getTitle(),  warFile.getContentStream());
		InputStream is = warFile.getContentStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		
		while ((bytesRead = is.read(buffer)) != -1)
		{
			os.write(buffer, 0, bytesRead);
		}

	    is.close();
	    os.close();
	}
	
%>