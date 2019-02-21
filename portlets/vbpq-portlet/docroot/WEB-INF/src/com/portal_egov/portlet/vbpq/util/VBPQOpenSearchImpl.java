/**
 * @author HungDX
 * @time 8:12:21 AM
 * @project vbpq-portlet
 */
package com.portal_egov.portlet.vbpq.util;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;


public class VBPQOpenSearchImpl extends HitsOpenSearchImpl{

	
	public static final String SEARCH_PATH = "/c/vbpq/open_search";

	public static final String TITLE = "VBPQ Search: ";

	public static final String PORTLET_ID = "vbpq_WAR_vbpqportlet";
	
	@Override
	public String getPortletId() {

		return PORTLET_ID;
	}
	

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.HitsOpenSearchImpl#getSearchPath()
	 */
	@Override
	public String getSearchPath() {

		return SEARCH_PATH;
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.HitsOpenSearchImpl#getTitle(java.lang.String)
	 */
	@Override
	public String getTitle(String keywords) {

		return TITLE;
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.search.HitsOpenSearchImpl#getIndexer()
	 */
	@Override
	public Indexer getIndexer() {
	
		return IndexerRegistryUtil.getIndexer(VBPQ_Entry.class);
	}

}
