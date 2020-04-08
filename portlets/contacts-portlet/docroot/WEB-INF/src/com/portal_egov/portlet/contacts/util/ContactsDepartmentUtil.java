/**
 * @author HUNGDX
 * @time 2:44:38 PM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.contacts.util;

import java.util.List;

import javax.portlet.ActionRequest;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.portal_egov.portlet.contacts.model.ContactsDepartment;
import com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty;
import com.portal_egov.portlet.contacts.permission.ContactsDepartmentPermission;
import com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil;
import com.portal_egov.portlet.contacts.service.ContactsDepartmentPropertyLocalServiceUtil;


public class ContactsDepartmentUtil {

	
	public static void updateDepartment(ActionRequest actionRequest) throws Exception{
		
		long companyId = PortalUtil.getCompanyId(actionRequest);

		long groupId = PortalUtil.getScopeGroupId(actionRequest);

		long userId = PortalUtil.getUserId(actionRequest);
		
		String userName = PortalUtil.getUserName(userId, "userName");
		
		long departmentId = ParamUtil.getLong(actionRequest, "departmentId",0L);
		
		long parentDepartmentId = ParamUtil.getLong(actionRequest, "parentDepartmentId",0L);
		
		String departmentName = ParamUtil.getString(actionRequest, "departmentName");
		
		String departmentAddress = ParamUtil.getString(actionRequest, "departmentAddress");
		
		String departmentPhone = ParamUtil.getString(actionRequest, "departmentPhone");
		
		String departmentWebsite = ParamUtil.getString(actionRequest, "departmentWebsite");
		
		String departmentEmail = ParamUtil.getString(actionRequest, "departmentEmail");
		
		ContactsDepartment contactDepartment = null;
		
		if(departmentId > 0){//Update department
			
			//update department
			contactDepartment = ContactsDepartmentLocalServiceUtil.updateDepartment(departmentId, groupId, companyId, userId,
				userName, parentDepartmentId, departmentName, departmentAddress, departmentPhone, departmentWebsite,
				departmentEmail,DEFAULT_DEPARTMENT_DISPLAY_PRIORITY, DEFAULT_DEPARTMENT_STATUS);
			
		}else{//Add department

			ServiceContext serviceContext = ServiceContextFactory.getInstance(ContactsDepartment.class.getName(), actionRequest);
			
			serviceContext.setGroupPermissions(new String[] {ContactsDepartmentPermission.VIEW});
			serviceContext.setGuestPermissions(new String[] {ContactsDepartmentPermission.VIEW});
			
			//add department
			contactDepartment = ContactsDepartmentLocalServiceUtil.addDepartment(groupId, companyId, userId, userName, parentDepartmentId,
				departmentName, departmentAddress, departmentPhone, departmentWebsite, departmentEmail,
				DEFAULT_DEPARTMENT_DISPLAY_PRIORITY, DEFAULT_DEPARTMENT_STATUS, serviceContext);
		}
		
		if(contactDepartment != null){
			
			updateDepartmentProperty(actionRequest, contactDepartment);
		}
		
	}
	
	public static void deleteDepartment(long groupId,long departmentId) throws PortalException, SystemException{
		
		
		if(departmentId > 0){
			
			List<ContactsDepartment> childDepartmentList = ContactsDepartmentLocalServiceUtil.findByParentAndGroup(groupId, departmentId);
			
			for(ContactsDepartment childDepartment : childDepartmentList){
				
				List<ContactsDepartmentProperty> childDepartmentPropertyList = 
								ContactsDepartmentPropertyLocalServiceUtil.findByContactsDepartment(childDepartment.getDepartmentId());
				
				for(ContactsDepartmentProperty childDepartmentProperty : childDepartmentPropertyList){
					
					ContactsDepartmentPropertyLocalServiceUtil.deleteContactsDepartmentProperty(childDepartmentProperty);
				}
				
				ContactsDepartmentLocalServiceUtil.deleteContactsDepartment(childDepartment);
			}
			
			List<ContactsDepartmentProperty> departmentPropertyList = ContactsDepartmentPropertyLocalServiceUtil.findByContactsDepartment(departmentId);
			
			
			for(ContactsDepartmentProperty departmentProperty : departmentPropertyList){
				
				ContactsDepartmentPropertyLocalServiceUtil.deleteContactsDepartmentProperty(departmentProperty);
			}
			
			ContactsDepartmentLocalServiceUtil.deleteContactsDepartment(departmentId);
		}
	}
	
	
	/**
	 * @todo Cap nhat thuoc tinh cho Department
	 * @author HUNGDX	
	 * @date Oct 5, 2012
	 * @return void
	 */
	private static void updateDepartmentProperty(ActionRequest actionRequest,ContactsDepartment contactDepartment) 
					throws SystemException{
		
		if(Validator.isNotNull(contactDepartment)){
			
			long departmentId = contactDepartment.getDepartmentId();
			
			long groupId = contactDepartment.getGroupId();
			
			long companyId = contactDepartment.getCompanyId();
			
			long userId = contactDepartment.getUserId();
			
			String userName = contactDepartment.getUserName();
			
			//Danh sach cac thuoc tinh tuong ung voi departmentId va propertyKey
			List<ContactsDepartmentProperty> departmentPropertyList = 
							ContactsDepartmentPropertyLocalServiceUtil.findByContactsDepartment(departmentId);
			
			for(ContactsDepartmentProperty departmentProperty : departmentPropertyList){
				
				ContactsDepartmentPropertyLocalServiceUtil.deleteContactsDepartmentProperty(departmentProperty);
			}
			
			int[] departmentPropertyIndexes = new int[0];
			
			//String luu chi so cac thanh phan cua form lay tu trang cau hinh
			String departmentPropertyIndexesStr = ParamUtil.getString(actionRequest, "departmentPropertyIndexes");
			
			if(Validator.isNotNull(departmentPropertyIndexesStr)){
				departmentPropertyIndexes = StringUtil.split(departmentPropertyIndexesStr, 0);
			}
			
			if(departmentPropertyIndexes.length > 0){
				
				for (int i = 0; i < departmentPropertyIndexes.length; i++) {
					
					String departmentPropertyKey = ParamUtil.getString(actionRequest, "departmentPropertyKey");
					
					String departmentPropertyValue = ParamUtil.getString(actionRequest, "departmentPropertyValue");
					
					if(Validator.isNotNull(departmentPropertyKey)){
						
						ContactsDepartmentPropertyLocalServiceUtil.addDepartmentProperty(companyId, groupId, userId, userName,
							departmentId, departmentPropertyKey, departmentPropertyValue, StringPool.BLANK);
					}
				}
			}
		}
	}

	private static final int DEFAULT_DEPARTMENT_DISPLAY_PRIORITY = 0;
	private static final int DEFAULT_DEPARTMENT_STATUS = 1;
}


