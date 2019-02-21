/**
 * @author HUNGDX
 * @time 10:37:22 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.banner.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class BannerSearchTerms extends BannerDisplayTerms{

	/**
	 * @param portletRequest
	 */
	public BannerSearchTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		bannerTitle = DAOParamUtil.getLike(portletRequest, BANNER_TITLE);
	}
}
