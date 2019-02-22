package com.bkav.portal.autoupdate.admin.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.autoupdate.model.UpdatePlugins;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.StringPool;

/**
 * Lop cac phuong thuc ket noi service cua server update lay thong tin cap nhat
 * @author anhbdb
 *
 */
public class AutoUpdateConnector {
	
	/**
	 * Lay danh sach tat ca cac goi ung dung tren server
	 * @param portalUpdateServerDomain
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static List<UpdatePlugins> getAllAvailablePlugins (String portalUpdateServerDomain)
	{
		List<UpdatePlugins> listPlugins = new ArrayList<UpdatePlugins>();
		
		try {
			String url = AutoUpdateAdminUtil.getServiceUrl(portalUpdateServerDomain
					, AutoUpdateConstant.PORTAL_UPDATE_SERVICE_URL
					, AutoUpdateConstant.PORTAL_UPDATE_SERVICE_CLASS
					, AutoUpdateConstant.PORTAL_UPDATE_SERVICE_FUNCTION
					, AutoUpdateConstant.EPORTAL_CODE
					, new String[]{"ePortalCode"}
					, new String[]{AutoUpdateConstant.EPORTAL_CODE});
			URL serviceUrl = new URL(url);
			HttpURLConnection serviceUrlConnection = (HttpURLConnection)serviceUrl.openConnection();
			String userCredentials = AutoUpdateAdminUtil.getUserCredentials(AutoUpdateConstant.EPORTAL_CODE
					, AutoUpdateConstant.EPORTAL_EMAIL_SURFIX
					, AutoUpdateConstant.EPORTAL_PASSWORD_SURFIX);
			
			String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
			serviceUrlConnection.setRequestProperty ("Authorization", basicAuth);
			
			InputStream is = serviceUrlConnection.getInputStream();
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		    String jsonResult = AutoUpdateAdminUtil.getStringFromReader(rd);
		    
		    listPlugins = AutoUpdateAdminUtil.getListPluginsFromJSONString(jsonResult);
		    
		    is.close();
		    
		    return listPlugins;
		}
		catch (Exception e)
		{
			_log.error(e);
			return listPlugins;
		}
	}
	
	/**
	 * Tra ve mang path cac file sau khi download ve server client
	 * @param urlPlugin
	 * @param saveDir
	 * @return
	 */
	public static String[] downloadPlugin (String urlPlugin, String saveDir)
	{
		try {
			URL url = new URL(urlPlugin);
	        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
	        int responseCode = httpConn.getResponseCode();
	        String saveFilePath = StringPool.BLANK;
	        String fileName = StringPool.BLANK;
	        
	        // always check HTTP response code first
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            String disposition = httpConn.getHeaderField("Content-Disposition");
	            String contentType = httpConn.getContentType();
	            int contentLength = httpConn.getContentLength();
	 
	            if (disposition != null) {
	                // extracts file name from header field
	                int index = disposition.indexOf("filename=");
	                if (index > 0) {
	                    fileName = disposition.substring(index + 10,
	                            disposition.length() - 1);
	                }
	            } else {
	                // extracts file name from URL
	                fileName = urlPlugin.substring(urlPlugin.lastIndexOf("/") + 1,
	                		urlPlugin.length());
	            }
	 
	            System.out.println("Content-Type = " + contentType);
	            System.out.println("Content-Disposition = " + disposition);
	            System.out.println("Content-Length = " + contentLength);
	            System.out.println("fileName = " + fileName);
	 
	            // opens input stream from the HTTP connection
	            InputStream inputStream = httpConn.getInputStream();
	            saveFilePath = AutoUpdateConstant.TEMPLATE_DOWNLOAD_FOLDER + File.separator + fileName;
	             
	            // opens an output stream to save into file
	            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
	 
	            int bytesRead = -1;
	            byte[] buffer = new byte[BUFFER_SIZE];
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);
	            }
	 
	            outputStream.close();
	            inputStream.close();
	            
	            System.out.println("File downloaded");
	        } else {
	            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
	            return new String[]{};
	        }
	        httpConn.disconnect();
	        
	        return new String[]{saveFilePath,fileName};
		} 
		catch (Exception e) {
			_log.error(e);
			return new String[]{};
		}
	}
	
	private static final int BUFFER_SIZE = 4096;
	
	private static Log _log = LogFactory.getLog(AutoUpdateConnector.class);
}
