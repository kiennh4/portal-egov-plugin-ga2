package com.portal_egov.public_sevice.portlet;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PublicServiceRegistry
 */
public class PublicServiceRegistry extends MVCPortlet {

	public void updateRegistryContent(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {

			String citizenName = ParamUtil.getString(actionRequest,
					"citizenName");

			long citizenCode = ParamUtil.getLong(actionRequest, "citizenCode");

			String citizenEmail = HtmlUtil.stripHtml(ParamUtil.getString(
					actionRequest, "citizenEmail"));

			String citizenAddress = HtmlUtil.stripHtml(ParamUtil.getString(
					actionRequest, "citizenAddress"));

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			String citizenPhone = ParamUtil.getString(actionRequest,
					"citizenPhone");
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("IdCard", Integer.valueOf(String.valueOf(citizenCode)));
			jsonObject.put("Email", citizenEmail);
			jsonObject.put("Phone", citizenPhone);
			jsonObject.put("Id", 463455);
			jsonObject.put("Address", citizenAddress);
			jsonObject.put("FullName", citizenName);
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost("http://13.250.173.193:8280/services/PublicService");
			postRequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8");
			postRequest.setEntity(new StringEntity(jsonObject.toString(),"UTF-8"));
			CloseableHttpResponse httpResponse = httpClient.execute(postRequest);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if(statusCode == 200){
				SessionMessages.add(actionRequest, "send-success");
			}
			else{
				SessionErrors.add(actionRequest, "send-error");
			}
			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "give-registry-content");
			_log.error(e);
		}
	}
	private static final Log _log = LogFactoryUtil.getLog(PublicServiceRegistry.class);
}
