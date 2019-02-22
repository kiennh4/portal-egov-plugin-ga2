/**
 * @author HungDX
 * @time 2:46:00 PM
 * @project tthc-portlet
 */
package com.portal_egov.portlet.tthc;


import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.portal_egov.portlet.tthc.model.TTHC_Attribute;
import com.portal_egov.portlet.tthc.model.TTHC_Entry;
import com.portal_egov.portlet.tthc.permission.TTHCAttributePermission;
import com.portal_egov.portlet.tthc.permission.TTHCEntryPermission;
import com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil;
import com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil;
import com.portal_egov.portlet.tthc.util.TTHCConstants;
import com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;
import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;
import com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil;


public class ActionUtil {
	
	/**
	 * 
	 * @todo CAP NHAT THONG TIN CO BAN CUA THU TUC HANH CHINH
	 * @author HungDX	
	 * @date Jul 2, 2012
	 * @return void
	 * @param actionRequest
	 * @param actionResponse
	 */
	public static TTHC_Entry updateTTHCInfomation(long tthcEntryId,ActionRequest actionRequest,ActionResponse actionResponse){
		
		TTHC_Entry tthcEntry = null;
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			
			long userId = PortalUtil.getUserId(actionRequest);
			
			//Ma so thu tuc						
			String entryCode = ParamUtil.getString(actionRequest, "entryCode",StringPool.BLANK);
			
			//Ten thu tuc
			String entryName = ParamUtil.getString(actionRequest, "entryName",StringPool.BLANK);
			
			//Mo ta thu tuc
			String entryDesc = ParamUtil.getString(actionRequest, "entryDesc",StringPool.BLANK);
			
			//Id cap thu tuc
			long levelId = ParamUtil.getLong(actionRequest, "levelId",0L);
			
			//Id cua co quan thuc hien thu tuc
			long departmentId = ParamUtil.getLong(actionRequest, "departmentId",0L);
			
			//Id cua linh vuc thong ke
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			//Id cua doi tuong thuc hien
			long audienceId = ParamUtil.getLong(actionRequest, "audienceId",0L);
			
			//Id cua ket qua thuc hien
			long resultTypeId = ParamUtil.getLong(actionRequest, "resultTypeId",0L);
			
			//Cac buoc thuc hien (huong dan thuc hien thu tuc)
			String processGuide = ParamUtil.getString(actionRequest, "processGuide",StringPool.BLANK);
			
			//Cach thuc thuc hien thu tuc
			String processType = ParamUtil.getString(actionRequest, "processType",StringPool.BLANK);
			
			//Thoi gian thuc hien thu tuc
			String processTime = ParamUtil.getString(actionRequest, "processTime",StringPool.BLANK);
			
			//Phi thuc hien thu tuc
			String processFee = ParamUtil.getString(actionRequest, "processFee",StringPool.BLANK);
			
			//Yeu cau thuc hien thu tuc,thanh phan va so luong ho so
			String processRequirement = ParamUtil.getString(actionRequest, "processRequirement",StringPool.BLANK);
			
			//Can cu phap ly cua thu tuc (Ten cac bo luat,cac van ban quy dinh)
			String processFoundationDocument = ParamUtil.getString(actionRequest, "processFoundationDocument",StringPool.BLANK);
			
			if(tthcEntryId > 0){
				
				tthcEntry = TTHC_EntryLocalServiceUtil.getTTHC_Entry(tthcEntryId);
				//update thu tuc
				TTHC_EntryLocalServiceUtil.updateTTHCEntry(tthcEntryId, companyId, groupId, userId, levelId, departmentId, 
					categoryId, audienceId, resultTypeId, entryCode, entryName, entryDesc, processGuide, processType,
					processTime, processFee, processRequirement,processFoundationDocument);
			}else{
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(TTHC_Entry.class.getName(), actionRequest);
				
				serviceContext.setGuestPermissions(new String[]{TTHCEntryPermission.VIEW_TTHC});
				serviceContext.setGroupPermissions(new String[]{TTHCEntryPermission.VIEW_TTHC});
				
				//Them moi thu tuc
				tthcEntry = TTHC_EntryLocalServiceUtil.addTTHCEntry(companyId, groupId, userId, levelId, departmentId,
					categoryId, audienceId, resultTypeId, entryCode, entryName, entryDesc, processType, processGuide,
					processTime, processFee, processRequirement,processFoundationDocument, serviceContext);
			}
			
		}
		catch (Exception e) {
			
			if(e instanceof NoSuchTTHC_EntryException){
				System.out.println(e.getClass().getName());
			}else{
				_log.error(e);
			}
		}
		return tthcEntry;
	}

	/**
	 * @todo CAP NHAT DANH SACH VAN BAN PHAP QUY QUY DINH THU TUC
	 * @author HungDX	
	 * @date Aug 20, 2012
	 * @return void
	 * @param tthcEntryId
	 * @param actionRequest
	 * @param actionResponse
	 */
	public static void updateVBPQMapping(long tthcEntryId,ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			
			//Danh sach Id cua vbpq duoc luu duoi dang String.VD 80001,80002
			String vbpqMappingSearchContainerPrimaryKeys = ParamUtil.getString(actionRequest, "vbpqMappingSearchContainerPrimaryKeys",StringPool.BLANK);
			
			//Mang string chua cac Id cua vbpq duoc split tu vbpqMappingSearchContainerPrimaryKeys theo dau "," (COMMA)
			String[] vbpqMappingIds = StringUtil.split(vbpqMappingSearchContainerPrimaryKeys, StringPool.COMMA);
			
			if(vbpqMappingIds.length > 0){
				
				//Danh sach mapping hien tai
				List<TTHC_Attribute> vbpqMappingAttributeList = TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndAttrTypeAndGroup(groupId, 
					tthcEntryId, TTHCConstants.VBPQ_ID_ATTRIBUTE_TYPE_ID);
				
				//Remove mapping cu
				for(TTHC_Attribute vbpqMappingAttribute : vbpqMappingAttributeList){
					
					TTHC_AttributeLocalServiceUtil.deleteTTHC_Attribute(vbpqMappingAttribute);
				}
				
				//Add mapping moi
				for(int vbpqMappingIndex = 0;vbpqMappingIndex < vbpqMappingIds.length;vbpqMappingIndex++){
					
					long vbpqId = GetterUtil.getLong(vbpqMappingIds[vbpqMappingIndex],0L);
					
					if(vbpqId > 0){
						
						//Kiem tra co ton tai vbpq tuong ung voi Id hay khong
						VBPQ_Entry vbpqEntry = VBPQ_EntryLocalServiceUtil.getVBPQ_Entry(vbpqId);
						
						if(vbpqEntry != null){
							
							String vbpqMappingAttributeValue = String.valueOf(vbpqId);
							
							long companyId = PortalUtil.getCompanyId(actionRequest);
							
							long userId = PortalUtil.getUserId(actionRequest);
							
							ServiceContext serviceContext = ServiceContextFactory.getInstance(TTHC_Attribute.class.getName(), actionRequest);
							
							serviceContext.setGuestPermissions(new String[]{TTHCAttributePermission.VIEW_ATTRIBUTE});
							serviceContext.setGroupPermissions(new String[]{TTHCAttributePermission.VIEW_ATTRIBUTE});
							
							TTHC_AttributeLocalServiceUtil.addTTHCAttribute(companyId, groupId, userId, tthcEntryId,TTHCConstants.VBPQ_ID_ATTRIBUTE_TYPE_ID,
								vbpqMappingIndex, TTHCConstants.VBPQ_MAPPING_ID_ATTRIBUTE_NAME, vbpqMappingAttributeValue, serviceContext);
						}
					}
				}
			}
		}
		catch (Exception e) {
			if(e instanceof NoSuchVBPQ_EntryException){
				_log.info(e);
			}else {
				_log.error(e);
			}
		}
	}
	
	private static Log _log = LogFactory.getLog(ActionUtil.class);
}
