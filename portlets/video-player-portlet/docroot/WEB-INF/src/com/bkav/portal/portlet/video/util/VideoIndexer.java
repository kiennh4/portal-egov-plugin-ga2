package com.bkav.portal.portlet.video.util;

import java.util.Locale;

import javax.portlet.PortletURL;

import com.bkav.portal.portlet.video.model.VideoEntry;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.util.PortalUtil;

public class VideoIndexer extends BaseIndexer {
	
	public static final String[] CLASS_NAMES = {VideoEntry.class.getName()};

	public static final String PORTLET_ID = "9991";

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		if (searchContext.getAttributes() == null) {
			return;
		}

		addSearchTerm(searchQuery, searchContext, Field.NAME, false);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		VideoEntry videoEntry = (VideoEntry)obj;
		
		Document doc = new DocumentImpl();
		
		doc.addUID(PORTLET_ID, videoEntry.getEntryId());
		
		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		
		SearchEngineUtil.deleteDocument(searchEngineId, videoEntry.getCompanyId(), doc.getUID());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception{
		VideoEntry videoEntry = (VideoEntry)obj;
		
		long groupId = PortalUtil.getParentGroupId(videoEntry.getGroupId());
		
		long scopeGroupId = videoEntry.getGroupId();
		
		String videoName = videoEntry.getName();
		
		Document doc = getBaseModelDocument(PORTLET_ID, videoEntry);
		
		doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		
		doc.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		
		doc.addKeyword(Field.GROUP_ID, groupId);
		
		doc.addKeyword(Field.TITLE, videoName);
		
		doc.addKeyword(Field.COMPANY_ID, videoEntry.getCompanyId());
		
		return doc;
	}
	
//	@Override
//	protected Document 
//	
	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet,
		PortletURL portletURL) {

		return null;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		VideoEntry videoEntry = (VideoEntry)obj;
		
		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		
		SearchEngineUtil.updateDocument(searchEngineId, videoEntry.getCompanyId(), getDocument(videoEntry));
	}

	@Override
	protected void doReindex(String className, long classPK) {
	}

	@Override
	protected void doReindex(String[] ids) {
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}
}
