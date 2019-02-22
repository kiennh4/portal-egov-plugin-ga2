 package com.bkav.portal.portlet.contentsharing.util.vbpq;

 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.List;

 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;

 import com.liferay.portal.kernel.util.ListUtil;
 import com.liferay.portal.kernel.util.StringPool;
 import com.liferay.portal.kernel.util.Validator;
 import com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;
 import com.portal_egov.portlet.vbpq.model.VBPQ_Category;
 import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;
 import com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil;
 import com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil;


 /**
  * @author HungDX
  *
  */
 public class VBPQUtil {
 	
 	
 	public static List<VBPQ_Entry> getRelatedEntries(long groupId,long vbpqEntryId,String relatedFilterType,int numbersOfRelatedEntries){
 		
 		if(vbpqEntryId > 0L && groupId > 0L){
 			
 			try {
 				
 				List<VBPQ_Entry> unFilteredRelatedList = new ArrayList<VBPQ_Entry>();
 				
 				List<VBPQ_Entry> filteredRelatedList = new ArrayList<VBPQ_Entry>();
 				
 				VBPQ_Entry vbpqEntry = VBPQ_EntryLocalServiceUtil.getVBPQ_Entry(vbpqEntryId);
 				
 				if(vbpqEntry != null){
 					
 					if(Validator.equals(relatedFilterType, "vbpqCategory")){
 						
 						unFilteredRelatedList = VBPQ_EntryLocalServiceUtil.findByCategoryAndGroup(vbpqEntry.getCategoryId(), groupId, 0, numbersOfRelatedEntries + 1);
 						
 					}else if (Validator.equals(relatedFilterType, "vbpqDepartment")) {
 						
 						unFilteredRelatedList = VBPQ_EntryLocalServiceUtil.findByDepartmentAndGroup(vbpqEntry.getDepartmentId(), groupId, 0, numbersOfRelatedEntries + 1);
 					
 					}else if (Validator.equals(relatedFilterType, "vbpqDoctype")) {
 						
 						unFilteredRelatedList = VBPQ_EntryLocalServiceUtil.findByDocTypeAndGroup(vbpqEntry.getDocTypeId(), groupId, 0, numbersOfRelatedEntries + 1);
 					
 					}else{
 						
 						unFilteredRelatedList = VBPQ_EntryLocalServiceUtil.findByGroup(groupId, 0, numbersOfRelatedEntries + 1);
 					}
 				}
 				
 				if(unFilteredRelatedList.size() > 0){
 					
 					for(VBPQ_Entry relatedEntry : unFilteredRelatedList){
 						
 						if(relatedEntry.getEntryId() != vbpqEntryId){
 							
 							filteredRelatedList.add(relatedEntry);
 						}
 					}
 				}
 				
 				if(filteredRelatedList.size() > numbersOfRelatedEntries){
 					
 					filteredRelatedList = ListUtil.subList(filteredRelatedList, 0, numbersOfRelatedEntries);
 				}
 				
 				return filteredRelatedList;
 				
 			}
 			catch (Exception e) {
 				_log.error(e);
 				return Collections.EMPTY_LIST;
 			}
 			
 		}else{
 			
 			return Collections.EMPTY_LIST;
 		}
 	}
 	
 	public static String getVBPQCategoryName(long categoryId){
 		
 		try {
 			String categoryName = "other";
 			
 			VBPQ_Category vbpqCategory = VBPQ_CategoryLocalServiceUtil.getCategory(categoryId);
 						
 			if(vbpqCategory != null){
 				categoryName = vbpqCategory.getCategoryName();
 			}
 			return categoryName;
 		}
 		catch (Exception e) {
 			if (e instanceof NoSuchVBPQ_CategoryException) {
 				
 			}else{
 				_log.error(e);
 				e.printStackTrace();
 			}
 			return StringPool.BLANK;
 		}
 	}
 	
 	
 	private static Log _log = LogFactory.getLog(VBPQUtil.class);
 }
