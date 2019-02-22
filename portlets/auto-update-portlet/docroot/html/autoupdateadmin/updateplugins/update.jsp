<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.bkav.portal.autoupdate.admin.util.AutoUpdateConstant"%>
<%@page import="com.bkav.portal.autoupdate.admin.util.AutoUpdateAdminUtil"%>
<%@page import="com.bkav.portal.autoupdate.admin.util.AutoUpdateConnector"%>
<%@include file = "/html/autoupdateadmin/updateplugins/init.jsp" %>
<%
	String[] pluginId = ParamUtil.getParameterValues(request, "pluginId");
	String[] serverCompanyId = ParamUtil.getParameterValues(request, "serverCompanyId");
	String[] pluginVersion = ParamUtil.getParameterValues(request, "pluginVersion");
	String[] pluginCode = ParamUtil.getParameterValues(request, "pluginCode");
	String[] pluginName = ParamUtil.getParameterValues(request, "pluginName");
	String[] currentSize = ParamUtil.getParameterValues(request, "pluginSize");
	String[] pluginType = ParamUtil.getParameterValues(request, "pluginType");
	
	
	if ((pluginId!=null)&&(pluginId.length>0)&&(serverCompanyId!=null)&&(serverCompanyId.length>0)&&(pluginId.length==serverCompanyId.length))
	{
		for (int i = 0; i < pluginId.length; i++)
		{
			String dwFileSignUrl = AutoUpdateAdminUtil.getDownloadServiceUrl(
					serverUpdateDomain
					, AutoUpdateConstant.PORTAL_DOWNLOAD_SERVICE_URL
					, pluginId[i]
					, AutoUpdateConstant.EPORTAL_CODE+StringPool.AT+AutoUpdateConstant.EPORTAL_EMAIL_SURFIX
					, AutoUpdateConstant.EPORTAL_CODE+StringPool.AT+AutoUpdateConstant.EPORTAL_PASSWORD_SURFIX
					, "2");
			
			String[] resultDwFileSignArr = AutoUpdateConnector.downloadPlugin(dwFileSignUrl, "");
			
			String dwFileWarUrl = AutoUpdateAdminUtil.getDownloadServiceUrl(
					serverUpdateDomain
					, AutoUpdateConstant.PORTAL_DOWNLOAD_SERVICE_URL
					, pluginId[i]
					, AutoUpdateConstant.EPORTAL_CODE+StringPool.AT+AutoUpdateConstant.EPORTAL_EMAIL_SURFIX
					, AutoUpdateConstant.EPORTAL_CODE+StringPool.AT+AutoUpdateConstant.EPORTAL_PASSWORD_SURFIX
					, "1");
			
			String[] resultDwFileWarArr = AutoUpdateConnector.downloadPlugin(dwFileWarUrl, "");
			
			boolean moveFileSignResult = false;
			boolean moveFileWarResult = false;
			
			if ((resultDwFileSignArr.length==2)&&(resultDwFileWarArr.length==2))
			{
				if (AutoUpdateAdminUtil.isValidSignatureDigital(resultDwFileWarArr[0], resultDwFileSignArr[0]))
				{
					moveFileSignResult = AutoUpdateAdminUtil.isMoveFileToDeployFolder(resultDwFileSignArr[0], resultDwFileSignArr[1]);
					moveFileWarResult = AutoUpdateAdminUtil.isMoveFileToDeployFolder(resultDwFileWarArr[0], resultDwFileWarArr[1]);
				}
				else
				{
					response.getWriter().println("Invalid signature");
				}
			}
			
			if ((moveFileSignResult)&&(moveFileWarResult))
			{
				AutoUpdateAdminUtil.createBackupPlugin(resultDwFileSignArr[0]
						, resultDwFileWarArr[0], pluginVersion[i], resultDwFileSignArr[1]
						, resultDwFileWarArr[1], pluginCode[i]);
				
				AutoUpdateAdminUtil.updatePluginToDB(pluginCode[i]
								, pluginName[i]
								, Long.valueOf(serverCompanyId[i])
								, Double.valueOf(pluginVersion[i])
								,  Double.valueOf(currentSize[i])
								, Integer.valueOf(pluginType[i]));
			}
		}
	}
%>
