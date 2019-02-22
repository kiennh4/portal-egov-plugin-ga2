package com.bkav.portal.portlet.site_display_setting.util;

import java.io.Serializable;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portlet.expando.NoSuchColumnException;
import com.liferay.portlet.expando.NoSuchTableException;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;

public class ExpandoUtil {
	
	public static ExpandoColumn getColumn (ExpandoBridge expandoBridge, String columnName, String tableName)
	{
		ExpandoColumn expandoColumn = null;
		try {
			
			ExpandoTable expandoTable = null;
			
			if(checkExistTable(expandoBridge,tableName)){
				
				expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(expandoBridge.getCompanyId(),
						expandoBridge.getClassName());
			}else{
				
				expandoTable = ExpandoTableLocalServiceUtil.addDefaultTable(expandoBridge.getCompanyId(),
						expandoBridge.getClassName());
			}
			
			if(expandoTable != null){
				
				if(checkExistTableColumn(expandoTable,columnName)){
					
					expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), columnName);
				}
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return expandoColumn;
	}
	
	public static void updateColumnValue(long companyId, ExpandoBridge expandoBridge, String columnName,
			int columnType,Serializable columnValue){
		
		try {
			
			ExpandoColumn expandoColumn = addColumn(companyId, expandoBridge, ExpandoTableConstants.DEFAULT_TABLE_NAME,
					columnName, columnType);
			
			if(expandoColumn != null){
				
				expandoBridge.setAttribute(columnName, columnValue);
			}
			
		} catch (Exception e){
			_log.error(e);
		}
	}
	
	private static ExpandoColumn addColumn(long companyId, ExpandoBridge expandoBridge,String tableName,
			String columnName, int columnType){
		
		ExpandoColumn expandoColumn = null;
		
		try {
			
			ExpandoTable expandoTable = null;
			
			if(checkExistTable(expandoBridge,tableName)){
				
				expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(expandoBridge.getCompanyId(),
						expandoBridge.getClassName());
			}else{
				
				expandoTable = ExpandoTableLocalServiceUtil.addDefaultTable(expandoBridge.getCompanyId(),
						expandoBridge.getClassName());
			}
			
			if(expandoTable != null){
				
				if(checkExistTableColumn(expandoTable,columnName)){
					
					expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), columnName);
				}else{
					
					expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), columnName, columnType);
				}
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return expandoColumn;
	}
	
	private static boolean checkExistTable(ExpandoBridge expandoBridge,String tableName){
		
		try {
			
			ExpandoTable expandoTable = ExpandoTableLocalServiceUtil.getTable(expandoBridge.getCompanyId(),
					expandoBridge.getClassName(), tableName);
			
			if(expandoTable != null){
				
				return true;
			}else{
				
				return false;
			}

		} catch (Exception e) {
			
			if(e instanceof NoSuchTableException){
				_log.info(e.getMessage());
			}else{
				_log.error(e);
			}
			return false;
		}
	}
	
	private static boolean checkExistTableColumn(ExpandoTable expandoTable,String columnName){
		
		try {
			
			ExpandoColumn expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getCompanyId(),
					expandoTable.getClassName(), expandoTable.getName(), columnName);
			
			if(expandoColumn != null){
				
				return true;
				
			}else{
				
				return false;
			}
		
		} catch (Exception e) {
			
			if(e instanceof NoSuchColumnException){
				_log.info(e.getMessage());
			}else{
				_log.error(e);
			}
			return false;
		}
	}
	
	private final static Log _log = LogFactoryUtil.getLog(ExpandoUtil.class);
}
