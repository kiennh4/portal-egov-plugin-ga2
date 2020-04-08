package com.bkav.portal.portlet.contentsharing.service.persistence;

import java.util.Collections;
import java.util.List;

import com.bkav.portal.portlet.contentsharing.model.ContentSharing;
import com.bkav.portal.portlet.contentsharing.model.impl.ContentSharingImpl;
import com.bkav.portal.portlet.contentsharing.service.messaging.ClpMessageListener;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ContentSharingFinderImpl extends BasePersistenceImpl<ContentSharing> implements ContentSharingFinder  {
	
	@SuppressWarnings("unchecked")
	public List<ContentSharing> getListAudioFileByCompanyId (long companyId ,int start,int end,OrderByComparator obc)
	{
		if(companyId > 0){
			
			SessionFactory sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
			
			ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpMessageListener.getServletContextName(), "portletClassLoader");
			
			Session session = null;
			
			try{
			    session = sessionFactory.openSession();
			
			    String sqlStr = CustomSQLUtil.get(LIST_OBJECT_FROM_TABLE);
				
			    sqlStr = sqlStr.replace("$table_name", "Audioplayer_Audiofile");
			    
				//sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("AudioFile", classLoader.loadClass("com.bkav.portal.portlet.audioplayer.model.impl.AudioFileImpl"));
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    //queryPost.add("ContentSharing");
			    queryPost.add(companyId);
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<ContentSharing>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<ContentSharing>) query.list();
			    }
			}catch (Exception e){
				e.printStackTrace();
			    return Collections.emptyList();
			}finally{
				sessionFactory.closeSession(session);
			}
		}else{
			
			return Collections.emptyList();
		}
	}
	
	private static final String LIST_OBJECT_FROM_TABLE = "com.bkav.portal.portlet.contentsharing.service.persistence.ContentSharingFinder.listFromTable";

}
