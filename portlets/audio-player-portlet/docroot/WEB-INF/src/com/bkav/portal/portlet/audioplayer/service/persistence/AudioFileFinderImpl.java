package com.bkav.portal.portlet.audioplayer.service.persistence;

import java.util.Collections;
import java.util.List;

import com.bkav.portal.portlet.audioplayer.model.AudioFile;
import com.bkav.portal.portlet.audioplayer.model.impl.AudioFileImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;



public class AudioFileFinderImpl extends BasePersistenceImpl<AudioFile> implements AudioFileFinder{
	
	@SuppressWarnings("unchecked")
	public List<AudioFile> findByAudioName (long groupId, String audioName ,int start,int end,OrderByComparator obc)
	{
			if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
				
				sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("AudioFile", AudioFileImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add("%" + audioName + "%");
			    queryPost.add(groupId);
			    
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<AudioFile>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<AudioFile>) query.list();
			    }
			}catch (Exception e){
				e.printStackTrace();
			    return Collections.emptyList();
			}finally{
			    closeSession(session);
			}
		}else{
			
			return Collections.emptyList();
		}
	}
	
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = "com.bkav.portal.portlet.audioplayer.service.persistence.AudioFileFinder.findByKeyword";

}
