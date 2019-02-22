package com.bkav.portal.portlet.contentsharing.util.vbpq;

public class VBPQConstants {
	/**
	 * Co quan ban hanh,Linh vuc thong ke va Loai VBPQ duoc luu chung vao 1 bang VBPQ_Category trong database
	 * phan biet theo column typeId.
	 * typeId = 1 Tuong ung voi Co quan ban hanh VBPQ
	 * typeId = 2 Tuong ung voi Loai VBPQ
	 * typeId = 3 Tuong ung voi Linh vuc thong ke VBPQ
	 */
	
	//TypeId tuong ung voi Co quan ban hanh VBPQ
	public static final int DEPARTMENT_ID = 1;
	
	//TypeId tuong ung voi Loai VBPQ
	public static final int  CATEGORY_ID= 2;
	
	//TypeId tuong ung voi Linh vuc thong ke VBPQ
	public static final int DOCUMENT_TYPE_ID = 3;
	
	public static final long DL_ROOT_FOLDER_ID = 0L;
	
	public static final String DOCUMENT_LIBRARY_FOLDER = "DOCUMENT_LIBRARY_FOLDER";
	
	public static final String DEFAULT_VBPQ_FILE_ATTACHMENT_FOLDER_NAME = "VBPQ_FILE_ATTACHMENT";
}
