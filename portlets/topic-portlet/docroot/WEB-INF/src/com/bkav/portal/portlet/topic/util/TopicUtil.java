package com.bkav.portal.portlet.topic.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.topic.service.TopicLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;

public class TopicUtil {

	public static String topicCategoryValidate(long topicId, String categoryIds) {
		try {

			StringBuilder sb = new StringBuilder();

			String[] topicCategoryArr = categoryIds.split(",");

			for (String categoryIdStr : topicCategoryArr) {

				AssetCategory category = AssetCategoryLocalServiceUtil
						.fetchAssetCategory(GetterUtil.getLong(categoryIdStr));

				if (category != null) {
					sb.append(String.valueOf(GetterUtil.getLong(categoryIdStr)));
					sb.append(StringPool.COMMA);
				}
			}

			categoryIds = sb.toString();
			
			if(categoryIds.endsWith(StringPool.COMMA)){
				categoryIds = categoryIds.substring(0, categoryIds.length()-1);
			}
			
			TopicLocalServiceUtil
					.updateTopicCategoryIds(topicId, categoryIds);

			return categoryIds;

		} catch (Exception e) {
			_log.error(e);
			return StringPool.BLANK;
		}
	}
	private static Log _log = LogFactory.getLog(TopicUtil.class);
}
