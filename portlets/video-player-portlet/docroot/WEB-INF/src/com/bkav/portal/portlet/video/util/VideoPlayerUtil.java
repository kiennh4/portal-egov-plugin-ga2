package com.bkav.portal.portlet.video.util;

import java.util.ArrayList;
import java.util.List;

import com.bkav.portal.portlet.video.model.VideoCategory;
import com.bkav.portal.portlet.video.model.VideoCategoryMap;
import com.bkav.portal.portlet.video.model.VideoEntry;
import com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil;
import com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil;
import com.bkav.portal.portlet.video.service.VideoEntryLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class VideoPlayerUtil {
	
	public static VideoCategory getCategoryByVideoId (long videoId,  long groupId, long companyId)
	{
		try {
			
			List<VideoCategoryMap> listMap = VideoCategoryMapLocalServiceUtil.findByEntry(videoId);
			
			if ((Validator.isNotNull(listMap))&&(listMap.size()>0))
			{
				long categoryId = listMap.get(0).getCategoryId();
				
				return VideoCategoryLocalServiceUtil.fetchVideoCategory(categoryId);
			}
			else
			{
				return null;
			}
			
		}
		catch (Exception e)
		{
			_log.error(e);
			return null;
		}
	}
	
	public static List<VideoEntry> getVideoEntriesByCategoryId (long categoryId, long groupId, long companyId)
	{
		try
		{
			String queryKey = buildCacheQueryKey(categoryId);
			
			List<VideoEntry> listCacheVideo = getCacheData(queryKey);
			
			if ((Validator.isNotNull(listCacheVideo))&&(listCacheVideo.size()>0))
			{
				return listCacheVideo;
			}
			
			else
			{
				List<VideoCategoryMap> listMap = VideoCategoryMapLocalServiceUtil.findByCategory(categoryId);
				
				List<VideoEntry> listVideo = new ArrayList<VideoEntry>();
				
				if ((Validator.isNotNull(listMap))&&(listMap.size()>0))
				{
					for (VideoCategoryMap map : listMap)
					{
						listVideo.add(VideoEntryLocalServiceUtil.fetchVideoEntry(map.getEntryId()));
					}
				}
				
				updateCacheData(queryKey, listVideo);
				
				return listVideo;
			}
			
		}
		catch (Exception e)
		{
			_log.error(e);
			return new ArrayList<VideoEntry>();
		}
		
	}
	
	public static String buildCacheEntityKey (long videoId, long groupId, long companyId)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("entity");
		
		sb.append(StringPool.UNDERLINE);
		
		sb.append(VideoEntry.class.getName());
		
		sb.append(StringPool.UNDERLINE);
		
		sb.append(groupId);
		
		sb.append(StringPool.UNDERLINE);
		
		sb.append(companyId);
		
		sb.append(StringPool.UNDERLINE);
		
		sb.append(videoId);
		
		return sb.toString();
	}
	
	public static boolean updateCacheData(String queryKey, List<VideoEntry> listVideo) {

		return MemcachedUtil.getInstance().set(queryKey, listVideo);
	}
	
	@SuppressWarnings("unchecked")
	private static ArrayList<VideoEntry> getCacheData(String queryKey) {

		Object cacheData = MemcachedUtil.getInstance().get(queryKey);

		if (cacheData != null) {
			return (ArrayList<VideoEntry>) cacheData;
		}
		else {
			return new ArrayList<VideoEntry>();
		}
	}
	
	public static String buildCacheQueryKey (long categoryId)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("query");
		
		sb.append(StringPool.UNDERLINE);
		
		sb.append(VideoEntry.class.getName());
		
		sb.append(StringPool.UNDERLINE);
		
		sb.append(categoryId);
		
		return sb.toString();
	}
	
	private final static Log _log = LogFactoryUtil.getLog(VideoPlayerUtil.class);
}
