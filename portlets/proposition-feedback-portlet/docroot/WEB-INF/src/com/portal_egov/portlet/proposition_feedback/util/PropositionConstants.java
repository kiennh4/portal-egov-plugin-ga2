/**
 * @author HungDX
 * @time 9:31:13 AM
 * @project proposition_feedback-portlet
 */
package com.portal_egov.portlet.proposition_feedback.util;


public class PropositionConstants {

	public static final int DEFAULT_PROPOSITION_VIEW_COUNT = 0;
	
	public static final int DEFAULT_PROPOSITION_FEEDBACK_COUNT = 0;
	
	public static final int DEFAULT_PROPOSITION_COUNT = 0;
	
	//Trang thai mac dinh cua du thao luat khi moi khoi tao (chua publish - chua hien thi tren site)
	public static final int DEFAULT_PROPOSITION_STATUS_VALUE = 0;
	
	//Trang thai publish cua du thao - Hien thi public tren site va cho phep nguoi dan tham gia gop y
	public static final int PUBLISH_PROPOSITION_STATUS_VALUE = 1;
	
	//Trang thai cua du thao luat da publish va chua duoc thong qua
	public static final int UNRELEASE_PROPOSITION_STATUS_VALUE = 2;
	
	//Trang thai cua du thao luat da duoc thong qua
	public static final int RELEASED_PROPOSITION_STATUS_VALUE = 3;
	
	//Trang thai mac dinh (chua kiem duyet noi dung) cua feedback
	public static final int DEFAULT_FEEDBACK_STATUS_VALUE = 0;
	
	//Trang thai da kiem duyet noi dung va publish hien thi tren site cua feedback
	public static final int PUBLISH_FEEDBACK_STATUS_VALUE = 1;
	
	//CategoryTypeId tuong ung voi Linh vuc cua du thao luat
	public static final int PROPOSITION_CATEGORY_TYPE_ID = 1;
	
	//categoryTypeId tuong ung voi Co quan soan thao du luat
	public static final int COMPILATION_DEPARTMENT_CATEGORY_TYPE_ID = 2;
	
	//categoryTypeId tuong ung voi Co quan/Uy ban tham tra du luat
	public static final int VERIFICATION_DEPARTMENT_CATEGORY_TYPE_ID = 3;
	
	//
	public static final int ALL_PUBLISH_PROPOSITION_STATUS = -1;
	
	public static final long DEFAULT_PROPOSITION_CATEGORY_ID = 0;
	
	public static final String ORDER_BY_CREATE_DATE = "proposition.createDate";
	
	public static final String ORDER_BY_PROPOSITION_NAME = "proposition.propositionName";
	
	public static final String ORDER_BY_VIEW_COUNT = "proposition.viewCount";
	
	public static final String ORDER_BY_FEEDBACK_COUNT = "proposition.feedbackCount";
	
	public static final String ORDER_BY_TYPE_DESC = "DESC";
	
	public static final String ORDER_BY_TYPE_ASC = "ASC";
}
