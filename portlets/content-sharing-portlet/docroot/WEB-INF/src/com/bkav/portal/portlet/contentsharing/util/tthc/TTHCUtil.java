/**
 * @author HungDX
 * @time 9:28:14 AM
 * @project tthc-portlet
 */
package com.bkav.portal.portlet.contentsharing.util.tthc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;
import com.portal_egov.portlet.tthc.model.TTHC_Category;
import com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil;


/**
 * @author HungDX
 *
 */
public class TTHCUtil {

	/**
	 * @todo LAY TEN CATEGORY CUA TTHC THEO CATEGORYID
	 * @author HungDX	
	 * @date Aug 22, 2012
	 * @return String
	 * @param categoryId
	 * @return
	 */
	public static String getTTHCCategoryName(long categoryId){
		
		String tthcCategoryName = "others";
		try {
			
			if(categoryId > 0){
				
				TTHC_Category tthcCategory = TTHC_CategoryLocalServiceUtil.getTTHC_Category(categoryId);
				
				if(tthcCategory != null){
					tthcCategoryName = tthcCategory.getCategoryName();
				}
			}
		}
		catch (Exception e) {
			if(e instanceof NoSuchTTHC_CategoryException){
				
			}else{
				_log.error(e);
			}
		}
		return tthcCategoryName;
	}
	
	private static Log _log = LogFactory.getLog(TTHCUtil.class.getName());
}
