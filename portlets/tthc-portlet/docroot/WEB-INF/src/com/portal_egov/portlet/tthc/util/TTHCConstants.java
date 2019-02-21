/**
 * @author HungDX
 * @time 9:00:31 AM
 * @project tthc-portlet
 */
package com.portal_egov.portlet.tthc.util;

import com.portal_egov.portlet.tthc.TTHCAdmin;


/**
 * @author HungDX
 *
 */
public class TTHCConstants {

	//Folder upload goc cua Document and Media
	public static final long DL_ROOT_FOLDER_ID = 0L;
	
	//Ten folder chua file dinh kem cua thu tuc khi upload len server
	public static final String DEFAULT_TTHC_FILE_ATTACHMENT_FOLDER_NAME = "THU TUC HANH CHINH";
	
	//Ten folder chua file dinh kem cua thu tuc khi upload len server
	public static final String DEFAULT_TTHC_FILE_ATTACHMENT_TEMP_FOLDER_NAME = TTHCAdmin.class.getName();
	
	public static final String DOCUMENT_LIBRARY_FOLDER = "DOCUMENT_LIBRARY_FOLDER";
	
	/**
	 * 	
	 *	Thong tin ve Cap thuc hien TTHC,Co quan thuc hien,Linh vuc thong ke,Doi tuong thuc hien,ket qua thuc hien TTHC
	 *	deu duoc luu chung vao Entity TTHC_Category.
	 *	Phan biet thong qua categoryTypeId
	 *	categoryType = 1 tuong ung voi Cap thuc hien TTHC (Cap TW,Cap Tinh/TP,Cap Huyen/ThiXa,Cap Xa/Phuong,...)
	 *	categoryType = 2 tuong ung voi Co quan thuc hien TTHC 
	 *	categoryType = 3 tuong ung voi Linh vuc thong ke TTHC
	 *	categoryType = 4 tuong ung voi Doi tuong thuc hien TTHC (Ca nhan,to chuc,doanh nghiep,...)
	 *	categoryType = 5 tuong ung voi Ket qua thuc hien TTHC TTHC (Quyet dinh,Xac nhan,...)
	 */
	
	//categoryType tuong ung voi Cap thuc hien TTHC
	public static final int TTHC_LEVEL_CATEGORY_TYPE_ID = 1;
	
	//categoryType tuong ung voi Cap thuc hien TTHC
	public static final int TTHC_DEPARTMENT_CATEGORY_TYPE_ID = 2;
	
	//categoryType tuong ung voi Cap thuc hien TTHC
	public static final int TTHC_CATEGORY_CATEGORY_TYPE_ID = 3;
	
	//categoryType tuong ung voi Cap thuc hien TTHC
	public static final int TTHC_AUDIENCE_CATEGORY_TYPE_ID = 4;
	
	//categoryType tuong ung voi Cap thuc hien TTHC
	public static final int TTHC_RESULT_TYPE_CATEGORY_TYPE_ID = 5;
	
	public static final int DEFAULT_CATEGORY_ID = 0;
	
	
	/**
	 * 
		Phan loai thuoc tinh cua TTHC dua vao attributeTypeId
		attributeTypeId = 1 tuong ung voi Id cua van ban phap quy quy dinh TTHC
		attributeTypeId = 2 tuong ung voi Thanh phan ho so can thiet de thuc hien thu tuc
		attributeTypeId = 3 tuong ung voi Id cua bieu mau,file dinh kem thu tuc
	 */
	
	//attributeTypeId tuong ung voi Id cua VBPQ quy dinh thu tuc
	public static final int VBPQ_ID_ATTRIBUTE_TYPE_ID = 1;
	
	//attributeTypeId tuong ung voi Thanh phan ho so
	public static final int REQUIRED_DOC_ATTRIBUTE_TYPE_ID = 2;
	
	//attributeTypeId tuong ung voi Tai lieu,bieu mau dinh kem TTHC
	public static final int FILE_ATTACHMENT_ATTRIBUTE_TYPE_ID = 3;
	
	public static final int DEFAULT_ATTRIBUTE_TYPE_ID = 0;
	
	//Attribute name cua Van ban phap quy quy dinh thu tuc
	public static final String VBPQ_MAPPING_ID_ATTRIBUTE_NAME = "VBPQ_MAPPING_ID";
	
	//Attribute name cua Thanh phan ho so
	public static final String REQUIRED_DOCUMENT_ATTRIBUTE_NAME = "REQUIRED_DOCUMENT";
	
	//Attribute name cua Van ban dinh kem thu tuc
	public static final String FILE_ATTACHMENT_ATTRIBUTE_NAME = "FILE_ATTACHMENT";
}
