package com.bkav.portal.portlet.contentsharing.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.contentsharing.model.ContentSharing;
import com.bkav.portal.portlet.contentsharing.service.ContentSharingLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Image;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;
import com.liferay.portlet.journal.model.JournalArticle;

public class ContentSharingAdminUtil {
	
	@SuppressWarnings("unchecked")
	public static List<AssetEntry> getListAssetEntry (long companyId, long groupId)
	{
		List<AssetEntry> results = new ArrayList<AssetEntry>();
		
		try {
		
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			
			assetEntryQuery.setClassName(JournalArticle.class.getName());
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetEntry.class);
			
			dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(
					PortalUtil.getClassNameId(JournalArticle.class.getName())
					));
			
			dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
			
			results = AssetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			return results;
		
		}
		catch (Exception e)
		{
			_log.error(e);
			return results;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Object> getListItemContentSharing (long companyId,
			String servletContextName,
			String classContentSharing, String classContentSharingUtil)
	{
		
		List<Object> results = new ArrayList<Object>();
		
		try {
			
			ClassLoader classLoader = new ClassLoader() {};
			
			if (servletContextName.equals(StringPool.BLANK))
			{
				classLoader = PortalClassLoaderUtil.getClassLoader();
			}
			
			classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(
					servletContextName, "portletClassLoader");
			
			Class<?> contentClass = Class.forName(classContentSharing);
			
			Class<?> contentClassUtil = Class.forName(classContentSharingUtil);
			
			Object contentObjectUtil = contentClassUtil.newInstance();
			
			@SuppressWarnings("rawtypes")
			Class[] paramDynamicQuery = new Class[1];	
			
			paramDynamicQuery[0] = DynamicQuery.class;
			
			Method methodDynamicQuery = contentClassUtil.getDeclaredMethod("dynamicQuery", paramDynamicQuery);
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(contentClass, classLoader);
			
			dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
			
			results =  (List<Object>)methodDynamicQuery.invoke(contentObjectUtil, dynamicQuery); 
			
			return results;
			
		}
		catch (Exception e)
		{
			_log.error(e);
			return results;
		}
		
	}
	
	public static String getColumnName (String contentKey)
	{
		String[] listContentDefault = PropsUtil.get("portal.key.content.allowed.sharing").split(StringPool.COMMA);
		
		String[] listColumnContent = PropsUtil.get("portal.columnname.content.allowed.sharing").split(StringPool.COMMA);
		
		String result = StringPool.BLANK;
		
		for (int i = 0; i < listContentDefault.length;i++)
		{
			if (contentKey.equals(listContentDefault[i]))
			{
				if (listColumnContent[i]!=null)
				{
					result =  listColumnContent[i];
				}
				break;
			}
		}
		
		return result;
		
	}
	
	public static String getMethod (String contentKey)
	{
		String[] listContentDefault = PropsUtil.get("portal.key.content.allowed.sharing").split(StringPool.COMMA);
		
		String[] listMethod = PropsUtil.get("portal.method.content.allowed.sharing").split(StringPool.COMMA);
		
		String result = StringPool.BLANK;
		
		for (int i = 0; i < listContentDefault.length;i++)
		{
			if (contentKey.equals(listContentDefault[i]))
			{
				if (listMethod[i]!=null)
				{
					result =  listMethod[i];
				}
				break;
			}
		}
		
		return result;
		
	}
	
	public static String getServletContext (String contentKey)
	{
		String results = StringPool.BLANK;
		
		String[] listContentDefault = PropsUtil.get("portal.key.content.allowed.sharing").split(StringPool.COMMA);
		
		String[] listContentPortletDefault = PropsUtil.get("portal.portletname.content.allowed.sharing").split(StringPool.COMMA);
		
		for (int i = 0; i < listContentDefault.length;i++)
		{
			if (contentKey.equals(listContentDefault[i]))
			{
				if (listContentPortletDefault[i]!=null)
				{
					results =  listContentPortletDefault[i];
				}
				break;
			}
		}
		
		return results;
	}
	
	public static String getContentClassModel (String contentKey)
	{
		String results = StringPool.BLANK;
		
		String[] listContentDefault = PropsUtil.get("portal.key.content.allowed.sharing").split(StringPool.COMMA);
		
		String[] listContentClassDefault = PropsUtil.get("portal.classmodel.content.allowed.sharing").split(StringPool.COMMA);
		
		for (int i = 0; i < listContentDefault.length;i++)
		{
			if (contentKey.equals(listContentDefault[i]))
			{
				if (listContentClassDefault[i]!=null)
				{
					results =  listContentClassDefault[i];
				}
				break;
			}
		}
		
		return results;
	}
	
	public static String getContentClassUtil (String contentKey)
	{
		String results = StringPool.BLANK;
		
		String[] listContentDefault = PropsUtil.get("portal.key.content.allowed.sharing").split(StringPool.COMMA);
		
		String[] listContentClassUtilDefault = PropsUtil.get("portal.classutil.content.allowed.sharing").split(StringPool.COMMA);
		
		for (int i = 0; i < listContentDefault.length;i++)
		{
			if (contentKey.equals(listContentDefault[i]))
			{
				if (listContentClassUtilDefault[i]!=null)
				{
					results =  listContentClassUtilDefault[i];
				}
				break;
			}
		}
		
		return results;
	}
	
	public static String listContentName (String[] listContentSharing)
	{
		StringBuilder sb = new StringBuilder();
		
		String[] listContentDefault = PropsUtil.get("portal.key.content.allowed.sharing").split(StringPool.COMMA);
		
		String[] listContentNameDefault = PropsUtil.get("portal.name.content.allowed.sharing").split(StringPool.COMMA);
		
		if (listContentSharing.length>0)
		{
			for (int i = 0 ; i < listContentSharing.length; i++)
			{
				for (int j = 0; j < listContentDefault.length; j++)
				{
					if (listContentSharing[i].equals(listContentDefault[j]))
					{
						if ((listContentNameDefault[j]!=null)&&(!listContentNameDefault[j].equals(StringPool.QUOTE)))
						{
							sb.append(listContentNameDefault[j]);
							break;
						}
						else
						{
							sb.append(listContentSharing[i]);
							break;
						}
					}
				}
				sb.append(StringPool.COMMA);
			}
		}
		
		String result = sb.toString();
		
		if (sb.toString().endsWith(StringPool.COMMA))
		{
			result = result.substring(0, result.length()-1);
		}
		
		return result;
	}
	
	public static long checkExistedCompany (long companyId, long groupId)
	{
		try {
			ContentSharing contentSharingChecker = ContentSharingLocalServiceUtil.findByCompanyAndGroup (companyId, groupId);
			
			if (contentSharingChecker!=null)
			{
				return contentSharingChecker.getContentId();
			}
			else
			{
				return 0;
			}
			
		}
		catch (Exception e)
		{
			return 0;
		}
	}
	
	public static String buildContentSharingString (String[] listContentSharing)
	{
		StringBuilder sb = new StringBuilder();
		
		if (listContentSharing.length>0)
		{
			for (int i = 0 ; i < listContentSharing.length; i ++)
			{
				sb.append(listContentSharing[i]);
				
				if (i<listContentSharing.length-1)
					sb.append(StringPool.COMMA);
				
			}
		}
		
		return sb.toString();
	}
	
	public static File copySmallImageArticle (Image image)
	{
		try {
			
			File imageFile = new File(DLStoreUtil.getFile(0, 0, image.getImageId() + 
				StringPool.PERIOD + image.getType()).getAbsolutePath());
			
			Date now = new Date();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_kkmmss"); 
			
			File copyFile = new File (PropsUtil.get("liferay.home")
					+"/data/temp/"
					,"copy_"+image.getImageId()
					+dateFormat.format(now)+"."+image.getType());

			InputStream in = new FileInputStream(imageFile);
	        OutputStream outF = new FileOutputStream(copyFile);
			
	        //fileDest.mkdir();
	       
			copyFile.createNewFile();
			byte[] buf = new byte[10*1024];
	        int len;

	        while ((len = in.read(buf)) > 0) {
	            outF.write(buf, 0, len);
	        }

	        in.close();
	        outF.close();

			return copyFile;
		
		}
		catch (Exception e)
		{
			_log.error(e);
			return null;
		}
	}
	
	public static String buildCategoriesStr (long[] categoryIds)
	{
		StringBuilder sb = new StringBuilder();
		
		if (categoryIds!=null)
			
			for (int i = 0; i<categoryIds.length;i++)
			{
				sb.append(categoryIds[i]);
				
				if (i<categoryIds.length-1)
					sb.append(StringPool.COMMA);
					
			}
		
		return sb.toString();
		
	}
	
	public static String buildTagsStr (List<AssetTag> tags)
	{
		StringBuilder sb = new StringBuilder();
		
		if (tags!=null)
			
			for (int i = 0; i<tags.size();i++)
			{
				sb.append(tags.get(i).getTagId());
				
				if (i<tags.size()-1)
					sb.append(StringPool.COMMA);
					
			}
		
		return sb.toString();
		
	}
	
	private static Log _log = LogFactory.getLog(ContentSharingAdminUtil.class);
}
