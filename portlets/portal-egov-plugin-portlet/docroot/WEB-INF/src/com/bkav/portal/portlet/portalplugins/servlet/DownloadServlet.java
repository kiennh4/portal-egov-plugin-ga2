package com.bkav.portal.portlet.portalplugins.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;
import com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet {
	@SuppressWarnings("deprecation")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		long pluginId = ParamUtil.getLong(request, "pluginId");
		int downloadType = ParamUtil.getInteger(request, "dwType");
		String emailAddress = ParamUtil.getString(request, "emailAddress");
		String password = ParamUtil.getString(request, "pw");
		
		FileEntry dwFile = null;
		PortalPlugins plugin;
		
		try {
			
			plugin = PortalPluginsLocalServiceUtil.fetchPortalPlugins(pluginId);
			
			if (plugin!=null)
			{
				if(UserLocalServiceUtil.authenticateForBasic(1, CompanyConstants.AUTH_TYPE_EA, emailAddress, password)>0)
				{
					User user = UserLocalServiceUtil.getUserByEmailAddress(1, "admin@update.portal-egov.com");
	
		            PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user, false);
		            
		            PermissionThreadLocal.setPermissionChecker(permissionChecker);
		            
		            if (downloadType == 1)
		            {
		            	dwFile = DLAppServiceUtil.getFileEntry(plugin.getWarFileId());
		            }
		            else if (downloadType==2)
		            {
		            	dwFile = DLAppServiceUtil.getFileEntry(plugin.getSignFileId());
		            }
		            
		            if (dwFile!=null)
		            {
				        InputStream inStream = dwFile.getContentStream();
				         
				        String mimeType = dwFile.getMimeType();
				        if (mimeType == null) {        
				            // set to binary type if MIME mapping not found
				            mimeType = "application/octet-stream";
				        }
				         
				        // modifies response
				        response.setContentType(mimeType);
				        response.setContentLength((int) dwFile.getSize());
				         
				        // forces download
				        String headerKey = "Content-Disposition";
				        String headerValue = String.format("attachment; filename=\"%s\"", dwFile.getTitle());
				        response.setHeader(headerKey, headerValue);
				         
				        // obtains response's output stream
				        OutputStream outStream = response.getOutputStream();
				         
				        byte[] buffer = new byte[4096];
				        int bytesRead = -1;
				         
				        while ((bytesRead = inStream.read(buffer)) != -1) {
				            outStream.write(buffer, 0, bytesRead);
				        }
				         
				        inStream.close();
				        outStream.close(); 
		            }
				}
			}
			
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}
}
