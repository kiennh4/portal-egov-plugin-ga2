
package com.portal_egov.portlet.vbpq;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.vbpq.model.VBPQ_Category;
import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;
import com.portal_egov.portlet.vbpq.permission.VBPQCategoryPermission;
import com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil;
import com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil;
import com.portal_egov.portlet.vbpq.util.VBPQConstants;

/**
 * Portlet implementation class VBPQManagement
 */
public class VBPQCategoryAdminPortlet extends MVCPortlet {

	public void updateCategory(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0L);

			long parentCategoryId = ParamUtil.getLong(actionRequest, "parentCategoryId", 0L);

			int categoryTypeId = ParamUtil.getInteger(actionRequest, "categoryTypeId", VBPQConstants.CATEGORY_ID);

			String categoryName = ParamUtil.getString(actionRequest, "categoryName", StringPool.BLANK);

			String categoryDesc = ParamUtil.getString(actionRequest, "categoryDesc", StringPool.BLANK);
			
			int displayPriority = ParamUtil.getInteger(actionRequest, "displayPriority", 0);

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL", StringPool.BLANK);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(VBPQ_Category.class.getName(), actionRequest);
			
			serviceContext.setGroupPermissions(new String[] {VBPQCategoryPermission.VIEW_CATEGORY});
			serviceContext.setGuestPermissions(new String[] {VBPQCategoryPermission.VIEW_CATEGORY});
			
			if (categoryId > 0) {

				VBPQ_CategoryLocalServiceUtil.updateCategory(
					categoryId, companyId, groupId, userId, parentCategoryId, categoryTypeId, categoryName, categoryDesc,displayPriority);
			}
			else {

				VBPQ_CategoryLocalServiceUtil.addCategory(
					companyId, groupId, userId, parentCategoryId, categoryTypeId, categoryName, categoryDesc,displayPriority,serviceContext);
			}

			actionResponse.sendRedirect(redirectURL);

		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteCategory(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0L);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL", StringPool.BLANK);

			if (categoryId > 0) {

				List<VBPQ_Entry> vbpqEntryList = VBPQ_EntryLocalServiceUtil.findByCategoryAndGroup(categoryId, groupId);

				VBPQ_Category vbpqCategory = VBPQ_CategoryLocalServiceUtil.getCategory(categoryId);

				for (VBPQ_Entry vbpqEntry : vbpqEntryList) {

					if (vbpqCategory.getTypeId() == VBPQConstants.DEPARTMENT_ID) {

						vbpqEntry.setDepartmentId(0);

					}
					else if (vbpqCategory.getTypeId() == VBPQConstants.CATEGORY_ID) {

						vbpqEntry.setCategoryId(0);

					}
					else if (vbpqCategory.getTypeId() == VBPQConstants.DOCUMENT_TYPE_ID) {

						vbpqEntry.setDocTypeId(0);

					}
					else {
						vbpqEntry.setDepartmentId(0);
						vbpqEntry.setCategoryId(0);
						vbpqEntry.setDocTypeId(0);
					}

					VBPQ_EntryLocalServiceUtil.updateVBPQ_Entry(vbpqEntry);
				}

				VBPQ_CategoryLocalServiceUtil.deleteCategory(companyId, categoryId);
			}

			actionResponse.sendRedirect(redirectURL);

		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactory.getLog(VBPQCategoryAdminPortlet.class);
}
