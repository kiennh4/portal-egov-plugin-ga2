/**
 * @author HUNGDX
 * @time 10:51:55 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.contacts.util;

import java.awt.image.RenderedImage;
import java.io.InputStream;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.UserPortraitSizeException;
import com.liferay.portal.UserPortraitTypeException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.portal_egov.portlet.contacts.model.Contacts;
import com.portal_egov.portlet.contacts.model.ContactsProperty;
import com.portal_egov.portlet.contacts.permission.ContactsPermission;
import com.portal_egov.portlet.contacts.service.ContactsLocalServiceUtil;
import com.portal_egov.portlet.contacts.service.ContactsPropertyLocalServiceUtil;


public class ContactsUtil {

	public static void updateContact(ActionRequest actionRequest) throws Exception{
		
		long companyId = PortalUtil.getCompanyId(actionRequest);

		long groupId = PortalUtil.getScopeGroupId(actionRequest);

		long userId = PortalUtil.getUserId(actionRequest);
		
		String userName = PortalUtil.getUserName(userId, "userName");
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		long contactId = ParamUtil.getLong(uploadRequest, "contactId",0L);
		
		long departmentId = ParamUtil.getLong(uploadRequest, "departmentId",0L);
		
		String contactName = ParamUtil.getString(uploadRequest, "contactName");
		
		String jobTitle = ParamUtil.getString(uploadRequest, "jobTitle");
		
		String phoneNumbers = ParamUtil.getString(uploadRequest, "phoneNumbers");
		
		String homePhone = ParamUtil.getString(uploadRequest, "homePhone");
		
		String mobile = ParamUtil.getString(uploadRequest, "mobile");
		
		String email = ParamUtil.getString(uploadRequest, "email");
		
		Contacts contact = null;
		
		long contactAvatarImageId = 0L;
		
		if(contactId > 0){

			contact = ContactsLocalServiceUtil.getContacts(contactId);
		}
		
		if(contact != null){
			
			contactAvatarImageId = contact.getImageId();
			
		}else{
			
			contactAvatarImageId = CounterLocalServiceUtil.increment();
		}
		
		InputStream contactAvatarStream = uploadRequest.getFileAsStream("contactAvatarFile");
		
		if(contactAvatarStream != null){//Truong hop upload avatar
			
			byte[] contactAvatarBytes = FileUtil.getBytes(contactAvatarStream);
			
			updateContactAvatar(groupId, contactAvatarImageId, contactAvatarBytes);
		}
		
		if(contactId > 0){
			
			//update contact
			contact = ContactsLocalServiceUtil.updateContact(contactId, groupId, companyId, userId, userName, departmentId,
				contactName, contactAvatarImageId, jobTitle, phoneNumbers,homePhone, mobile, email,
				DEFAULT_CONTACT_DISPLAY_PRIORITY_VALUE, DEFAULT_CONTACT_DISPLAY_STATUS_VALUE);
			
		}else{
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Contacts.class.getName(), actionRequest);
			
			serviceContext.setGroupPermissions(new String[] {ContactsPermission.VIEW});
			serviceContext.setGuestPermissions(new String[] {ContactsPermission.VIEW});
			
			//add contact
			contact = ContactsLocalServiceUtil.addContact(groupId, companyId, userId, userName, departmentId, 
				contactName,contactAvatarImageId, jobTitle, phoneNumbers,homePhone, mobile, email, 
				DEFAULT_CONTACT_DISPLAY_PRIORITY_VALUE, DEFAULT_CONTACT_DISPLAY_STATUS_VALUE, serviceContext);
		}
		
		updateContactProperty(actionRequest, contact);
	}
	

	public static long updateContactAvatar(long groupId,long contactAvatarImageId,byte[] bytes) throws Exception{
		
		if(bytes != null && bytes.length > 0){
			
			if(contactAvatarImageId <= 0L){
				
				contactAvatarImageId = CounterLocalServiceUtil.increment();
			}
			
			long userImageMaxSize = PrefsPropsUtil.getLong(PropsKeys.USERS_IMAGE_MAX_SIZE);

			if ((userImageMaxSize > 0) &&
				((bytes == null) || (bytes.length > userImageMaxSize))) {

				throw new UserPortraitSizeException();
			}
			
			ImageBag imageBag = ImageToolUtil.read(bytes);

			RenderedImage renderedImage = imageBag.getRenderedImage();

			if (renderedImage == null) {
				throw new UserPortraitTypeException();
			}

			int USERS_IMAGE_MAX_HEIGHT = GetterUtil.getInteger(PropsUtil.get(PropsKeys.USERS_IMAGE_MAX_HEIGHT));

			int USERS_IMAGE_MAX_WIDTH = GetterUtil.getInteger(PropsUtil.get(PropsKeys.USERS_IMAGE_MAX_WIDTH));
			
			renderedImage = ImageToolUtil.scale(renderedImage, USERS_IMAGE_MAX_HEIGHT,USERS_IMAGE_MAX_WIDTH);

			String contentType = imageBag.getType();
			
			byte[] contactAvatarImageBytes = ImageToolUtil.getBytes(renderedImage, contentType);
			
			ImageLocalServiceUtil.updateImage(contactAvatarImageId, contactAvatarImageBytes);
		}
		
		return contactAvatarImageId;
	}
	
	
	public static void deleteContact(ActionRequest actionRequest) throws PortalException, SystemException{
		
		long contactId = ParamUtil.getLong(actionRequest, "contactId",0L);
		
		if(contactId > 0){
			
			Contacts contact = ContactsLocalServiceUtil.getContacts(contactId);
			
			if(contact != null){
				
				long contactAvatarImageId = contact.getImageId();
				
				if(contactAvatarImageId > 0){
					
					ImageLocalServiceUtil.deleteImage(contactAvatarImageId);
				}
				
				List<ContactsProperty> contactPropertyList = ContactsPropertyLocalServiceUtil.findByContact(contactId);
				
				for(ContactsProperty contactProperty : contactPropertyList){
					
					ContactsPropertyLocalServiceUtil.deleteContactsProperty(contactProperty);
				}
				
				ContactsLocalServiceUtil.deleteContacts(contact);
			}
		}
	}
	
	
	private static void updateContactProperty(ActionRequest actionRequest,Contacts contact) 
					throws SystemException{
		
		if(Validator.isNotNull(contact)){
			
			long contactId = contact.getContactId();
			
			long groupId = contact.getGroupId();
			
			long companyId = contact.getCompanyId();
			
			long userId = contact.getUserId();
			
			String userName = contact.getUserName();
			
			List<ContactsProperty> contactPropertyList = ContactsPropertyLocalServiceUtil.findByContact(contactId);
			
			for(ContactsProperty contactProperty : contactPropertyList){
				
				ContactsPropertyLocalServiceUtil.deleteContactsProperty(contactProperty);
			}
			
			int[] contactPropertyIndexes = new int[0];
			
			//String luu chi so cac thanh phan cua form lay tu trang cau hinh
			String contactPropertyIndexesStr = ParamUtil.getString(actionRequest, "contactPropertyIndexes");
			
			if(Validator.isNotNull(contactPropertyIndexesStr)){
				contactPropertyIndexes = StringUtil.split(contactPropertyIndexesStr, 0);
			}
			
			if(contactPropertyIndexes.length > 0){
				
				for (int i = 0; i < contactPropertyIndexes.length; i++) {
					
					String contactPropertyKey = ParamUtil.getString(actionRequest, "contactPropertyKey");
					
					String contactPropertyValue = ParamUtil.getString(actionRequest, "contactPropertyValue");
					
					if(Validator.isNotNull(contactPropertyKey)){
						
						ContactsPropertyLocalServiceUtil.addContactProperty(groupId, companyId, userId, userName,
							contactId, contactPropertyKey, contactPropertyValue, StringPool.BLANK);
					}
				}
			}
		}
	}
	
	private static final int DEFAULT_CONTACT_DISPLAY_PRIORITY_VALUE = 1;
	
	private static final int DEFAULT_CONTACT_DISPLAY_STATUS_VALUE = 1 ;
}