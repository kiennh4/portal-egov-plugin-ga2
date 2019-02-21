/**
 * @author HungDX
 * @time 10:02:56 AM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.conversation.util;


public class CO_Constants {

	//Trang thai mac dinh cua Thread (Chua publish)
	public static final int DEFAULT_THREAD_STATUS_VALUE = 0;
	
	//Trang thai publish cua Thead (Xuat ban hien thi tren Site)
	public static final int PUBLISH_THREAD_STATUS_VALUE = 1;
	
	//Trang thai Open cua Thread (Nhung Thread sap dien ra,cho phep nguoi tham gia gui cau hoi truoc)
	public static final int OPEN_THREAD_STATUS_VALUE = 2;
	
	//Trang thai Online cua Thread (Dang truc tuyen)
	public static final int ONLINE_THREAD_STATUS_VALUE = 3;
	
	//Gia tri view count cua Thread luc moi khoi tao
	public static final int THREAD_STARTED_VIEW_COUNT_VALUE = 0;
	
	//Gia tri conversation entries count cua Thread
	public static final int THREAD_STARTED_CONVERSATION_COUNT_VALUE = 0;
					
	//Trang thai mac dinh cua Conversation Entry khi moi khoi tao,chua qua xu ly
	public static final int DEFAULT_CONVERSATION_STATUS_VALUE = 0;
	
	//Trang thai cua Conversation Entry khi da cap nhat noi dung cau tra loi nhung chua publish
	public static final int ANSWERED_CONVERSATION_STATUS_VALUE = 1;
	
	//Trang thai publish cua Conversation Entry (Da hien thi tren site va duoc phep mapping voi Thead)
	public static final int PUBLISH_CONVERSATION_STATUS_VALUE = 2;
	
	//Id chuyen muc mac dinh cua Thread
	public static final long DEFAULT_CATEGORY_ID = 0;
	
	public static final long DEFAULT_THREAD_ID = 0;
	
	public static final long DEFAULT_PARENT_THREAD_ID = 0;
	
}
