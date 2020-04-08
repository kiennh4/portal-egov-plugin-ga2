package com.bkav.portal.portlet.rss.util;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.webcache.WebCacheItem;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;
import com.sun.syndication.feed.synd.SyndFeed;

public class RssFeedUtil {

	public static ObjectValuePair<String, SyndFeed> getFeed(String url) {
		
		WebCacheItem wci = new RSSWebCacheItem(url);
		
		return new ObjectValuePair<String, SyndFeed>(
			url,
			(SyndFeed)WebCachePoolUtil.get(
				RssFeedUtil.class.getName() + StringPool.PERIOD + url, wci));
	}
}
