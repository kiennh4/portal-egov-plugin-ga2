package com.bkav.portal.portlet.dynamic_menu;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu;
import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem;
import com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuItemLocalServiceUtil;
import com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DynamicMenu
 */
public class DynamicMenuPortlet extends MVCPortlet {

	public void updateMenu(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			long menuId = ParamUtil.getLong(actionRequest, "menuId");
			
			String name = ParamUtil.getString(actionRequest, "name");
			
			String description = ParamUtil.getString(actionRequest, "description");
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			if(menuId > 0){
				
				DynamicMenuLocalServiceUtil.updateMenu(companyId, groupId, userId, 
					userName, menuId, name, description, serviceContext);
			}else{
				
				DynamicMenuLocalServiceUtil.addMenu(companyId, groupId, userId, 
					userName, name, description, serviceContext);
			}
			
		}catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteMenu(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			
			long menuId = ParamUtil.getLong(actionRequest, "menuId");
			
			if(menuId > 0){
				
				List<DynamicMenuItem> menuItemList = DynamicMenuItemLocalServiceUtil.findByMenu(groupId, menuId);
				
				for(DynamicMenuItem menuItem : menuItemList){
					
					DynamicMenuItemLocalServiceUtil.deleteDynamicMenuItem(menuItem);
				}
				
				DynamicMenuLocalServiceUtil.deleteDynamicMenu(menuId);
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				
				actionResponse.sendRedirect(redirectURL);
			}
			
		}catch (Exception e) {
			_log.error(e);
		}
	}

	public void updateMenuItem(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			long itemId = ParamUtil.getLong(actionRequest, "itemId");
			long menuId = ParamUtil.getLong(actionRequest, "menuId");
			long parentId = ParamUtil.getLong(actionRequest, "parentId");
			
			String name = ParamUtil.getString(actionRequest, "name");
			String url = ParamUtil.getString(actionRequest, "url");
			String urlType = ParamUtil.getString(actionRequest, "urlType");
			
			if(Validator.equals(urlType, "internal")){
				
				long pageLayoutId = ParamUtil.getLong(actionRequest, "pageLayoutId");
				
				if(pageLayoutId > 0){
					
					Layout selectedLayout = LayoutLocalServiceUtil.getLayout(pageLayoutId);
					
					if(selectedLayout != null){
						
						url = selectedLayout.getFriendlyURL();
					}
				}
			}
			
			int position = ParamUtil.getInteger(actionRequest, "position");
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			if(itemId > 0){
				
				DynamicMenuItemLocalServiceUtil.updateItem(companyId, groupId, userId, userName, 
					itemId, menuId, parentId, name, url,urlType, position, serviceContext);
			}else{
				//add item
				DynamicMenuItemLocalServiceUtil.addItem(companyId, groupId, userId, userName,
					menuId, parentId, name, url,urlType, position, serviceContext);
				
				//update menu item counter
				if(menuId > 0){
					DynamicMenu menu = DynamicMenuLocalServiceUtil.getDynamicMenu(menuId);
					
					if(menu != null){
						
						int itemCounter = menu.getItemCount();
						
						menu.setItemCount(itemCounter + 1);
						
						DynamicMenuLocalServiceUtil.updateDynamicMenu(menu);
					}
				}
			}
			
		}catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteMenuItem(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long itemId = ParamUtil.getLong(actionRequest, "itemId");
			
			if(itemId > 0){
				
				DynamicMenuItem item = DynamicMenuItemLocalServiceUtil.getDynamicMenuItem(itemId);
				
				if(item != null){
					
					List<DynamicMenuItem> childItemList = DynamicMenuItemLocalServiceUtil.findByG_M_P(groupId,
						item.getMenuId(), itemId);
					
					for(DynamicMenuItem childItem : childItemList){
						
						DynamicMenuItemLocalServiceUtil.deleteDynamicMenuItem(childItem);
					}
					
					DynamicMenu menu = DynamicMenuLocalServiceUtil.getDynamicMenu(item.getMenuId());
					
					if(menu != null){
						
						int itemCounter = menu.getItemCount();
						
						if(itemCounter >= (childItemList.size() + 1)){
							
							menu.setItemCount(itemCounter - (childItemList.size() + 1));
							
						}else{
							
							menu.setItemCount(0);
						}
						
						DynamicMenuLocalServiceUtil.updateDynamicMenu(menu);
					}
					
					DynamicMenuItemLocalServiceUtil.deleteDynamicMenuItem(itemId);
				}
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				
				actionResponse.sendRedirect(redirectURL);
			}
			
		}catch (Exception e) {
			_log.error(e);
		}
	}
	
	private  Log _log = LogFactory.getLog(DynamicMenu.class);
}
