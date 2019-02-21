/**
 * @author HUNGDX
 * @time 8:31:33 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.contacts;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public class ContactsSettingUtil {

	/**
	 * @todo Cap nhat cau hinh co ban cho Contacts
	 * @author HUNGDX	
	 * @date Oct 4, 2012
	 * @return void
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws ReadOnlyException 
	 * @throws IOException 
	 * @throws ValidatorException 
	 */
	public static void updateContactsGeneralSettings(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, 
	SystemException, ReadOnlyException, ValidatorException, IOException{
		
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
		
		long groupId = PortalUtil.getScopeGroupId(actionRequest);
		
		long repositoryId = ParamUtil.getLong(actionRequest, "repositoryId",groupId);
		
		long userId = PortalUtil.getUserId(actionRequest);
		
		//Id cua folder luu anh avatar hoac logo cua Contact/Department
		long uploadFolderId = ParamUtil.getLong(actionRequest, "uploadFolderId",DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		
		long parentFolderId = ParamUtil.getLong(actionRequest, "parentFolderId",DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		
		String uploadFolderName = ParamUtil.getString(actionRequest, "uploadFolderName",StringPool.BLANK);
		
		if(Validator.isNotNull(uploadFolderName)){//Truong hop luu anh vao custom folder
			
			//Kiem tra ton tai folder tuong ung voi uploadFolderName va parentFolderId
			if(checkExistDLFolder(groupId, parentFolderId, uploadFolderName)){//Da ton tai folder
				
				//Get folder chua anh
				DLFolder uploadFolder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, uploadFolderName);
				
				uploadFolderId = uploadFolder.getFolderId();
			
			}else{//Chua ton tai folder chua anh
				
				//Tao moi folder chua anh					
				ServiceContext folderServiceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				
				folderServiceContext.setGroupPermissions(new String[] {ActionKeys.VIEW});
				folderServiceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
				
				DLFolder uploadFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, false, 
																				parentFolderId, uploadFolderName, "", folderServiceContext);
				
				uploadFolderId = uploadFolder.getFolderId();
			}
		}
		
		preferences.setValue("uploadFolderId", String.valueOf(uploadFolderId));
		
		if(SessionErrors.isEmpty(actionRequest)){
		
			preferences.store();								
		}
	}
	
	/**
	 * @todo Cap nhat form nhap du lieu Contacts
	 * @author HUNGDX	
	 * @date Oct 4, 2012
	 * @return void
	 */
	public static void updateContactsEntryFormProperty(ActionRequest actionRequest, ActionResponse actionResponse) 
					throws PortalException, SystemException, ReadOnlyException, ValidatorException, IOException{
		
		//Mang luu chi so cac thanh phan cua form
		int[] contactsFormPropertyIndexes = new int[0];
		
		//String luu chi so cac thanh phan cua form lay tu trang cau hinh
		String contactsFormPropertyIndexesStr = ParamUtil.getString(actionRequest, "contactsFormPropertyIndexes");
		
		if(Validator.isNotNull(contactsFormPropertyIndexesStr)){
			contactsFormPropertyIndexes = StringUtil.split(contactsFormPropertyIndexesStr, 0);
		}
		
		if(contactsFormPropertyIndexes.length > 0){
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			
			//Mang String luu ten cac thanh phan cua form
			String[] contactsFormPropertyNames = new String[contactsFormPropertyIndexes.length];
			
			//Mang String luu kieu thanh phan cua form
			String[] contactsFormPropertyTypes = new String[contactsFormPropertyIndexes.length];
			
			for(int i = 0;i < contactsFormPropertyIndexes.length; i ++){
				
				int contactsFormPropertyIndex = contactsFormPropertyIndexes[i];
				
				String contactFormPropertyName = ParamUtil.getString(actionRequest, "contactFormPropertyName" + contactsFormPropertyIndex);
				
				if(Validator.isNotNull(contactFormPropertyName)){
					contactsFormPropertyNames[i] = contactFormPropertyName;
				}
				
				String contactFormPropertyType = ParamUtil.getString(actionRequest, "contactFormPropertyType" + contactsFormPropertyIndex);
				
				if(Validator.isNotNull(contactFormPropertyType)){
					contactsFormPropertyTypes[i] = contactFormPropertyType;
				}
			}
			
			preferences.setValues("contactsFormPropertyNames", contactsFormPropertyNames);
			preferences.setValues("contactsFormPropertyTypes", contactsFormPropertyTypes);
			
			if(SessionErrors.isEmpty(actionRequest)){
			
				preferences.store();								
			}
		}
	}
	
	/**
	 * @todo Cap nhat form nhap thong tin Phong ban/Don vi
	 * @author HUNGDX	
	 * @date Oct 4, 2012
	 * @return void
	 */
	public static void updateDepartmentFormProperty(ActionRequest actionRequest, ActionResponse actionResponse) 
					throws PortalException, SystemException, ReadOnlyException, ValidatorException, IOException{
		
		//Mang luu chi so cac thanh phan cua form
		int[] departmentFormPropertyIndexes = new int[0];
		
		//String luu chi so cac thanh phan cua form lay tu trang cau hinh
		String departmentFormPropertyIndexesStr = ParamUtil.getString(actionRequest, "departmentFormPropertyIndexes");
		
		if(Validator.isNotNull(departmentFormPropertyIndexesStr)){
			departmentFormPropertyIndexes = StringUtil.split(departmentFormPropertyIndexesStr, 0);
		}
		
		if(departmentFormPropertyIndexes.length > 0){
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			
			//Mang String luu ten cac thanh phan cua form
			String[] departmentFormPropertyNames = new String[departmentFormPropertyIndexes.length];
			
			//Mang String luu kieu thanh phan cua form
			String[] departmentFormPropertyTypes = new String[departmentFormPropertyIndexes.length];
			
			for(int i = 0;i < departmentFormPropertyIndexes.length; i ++){
				
				int departmentFormPropertyIndex = departmentFormPropertyIndexes[i];
				
				String departmentFormPropertyName = ParamUtil.getString(actionRequest, "departmentFormPropertyName" + departmentFormPropertyIndex);
				
				if(Validator.isNotNull(departmentFormPropertyName)){
					departmentFormPropertyNames[i] = departmentFormPropertyName;
				}
				
				String departmentFormPropertyType = ParamUtil.getString(actionRequest, "departmentFormPropertyType" + departmentFormPropertyIndex);
				
				if(Validator.isNotNull(departmentFormPropertyType)){
					departmentFormPropertyTypes[i] = departmentFormPropertyType;
				}
			}
			
			preferences.setValues("departmentFormPropertyNames", departmentFormPropertyNames);
			preferences.setValues("departmentFormPropertyTypes", departmentFormPropertyTypes);
			
			if(SessionErrors.isEmpty(actionRequest)){
			
				preferences.store();								
			}
		}
	}
	
	
	/**
	 * @todo Kiem tra ton tai Folder theo ten folder va Id cua folder cha
	 * @author HUNGDX	
	 * @date Oct 4, 2012
	 * @return true neu ton tai folder
	 */
	private static boolean checkExistDLFolder(long groupId,long parentFolderId,String folderName){
		try {
			
			if(Validator.equals(folderName, StringPool.BLANK)){
				return false;
			}else {
				DLFolder uploadFolder = null;
				
				uploadFolder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);
				
				if(uploadFolder != null){
					return true;
				}else{
					return false;
				}
			}
						
		}catch (NoSuchFolderException e) {
			_log.info("No such Document Library folder exist with folderName = " + folderName +" and parentFolderId = " + String.valueOf(parentFolderId));
			return false;
		}
		catch (PortalException e) {
			_log.error(e);
			return false;
		}
		catch (SystemException e) {
			_log.error(e);
			return false;
		}
	}
	
	private static Log _log = LogFactory.getLog(ContactsSettingUtil.class);
}
