package com.portal_egov.portlet.legal_faq.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.DuplicateFolderNameException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.portal_egov.portlet.legal_faq.util.FileAttachmentUtil;


public class LegalFAQViewConfigActionImpl extends DefaultConfigurationAction{
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {

			long userId = PortalUtil.getUserId(actionRequest);

			long scopeGroupId = PortalUtil.getScopeGroupId(actionRequest);

			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest);

			long legalAttachmentFolderId = ParamUtil.getLong(actionRequest,
					"legalFaqAttachmentFolderId", 0L);

			String folderName = ParamUtil
					.getString(actionRequest, "folderName");
			if (Validator.isNotNull(folderName) && !folderName.isEmpty()) {// Truong hop tao folder moi
				
				long parentFolderId = ParamUtil.getLong(actionRequest,
						"parentFolderId", 0L);

				ServiceContext serviceContext = ServiceContextFactory
						.getInstance(DLFolder.class.getName(), actionRequest);
				serviceContext
						.setGuestPermissions(new String[] { ActionKeys.VIEW });

				legalAttachmentFolderId = FileAttachmentUtil
						.createAttachmentFolder(userId, scopeGroupId,
								scopeGroupId, parentFolderId, folderName,
								serviceContext);
			}

			preferences.setValue("legalFaqAttachmentFolderId",
					String.valueOf(legalAttachmentFolderId));
			
			preferences.store();

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			if (e instanceof DuplicateFolderNameException) {
				_log.error(e);
				SessionErrors.add(actionRequest, "duplicate-folder-name");

			} else {
				_log.error(e);
			}
		}
		
	}
	
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/legal_faq_view/config.jsp";
	}
	private static Log _log = LogFactory.getLog(LegalFAQViewConfigActionImpl.class);
}
