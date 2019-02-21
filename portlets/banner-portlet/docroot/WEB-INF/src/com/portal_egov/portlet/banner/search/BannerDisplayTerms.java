/**
 * @author HUNGDX
 * @time 10:36:41 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.banner.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class BannerDisplayTerms extends DisplayTerms{

	public static final String BANNER_TITLE = "bannerTitle";
	/**
	 * @param portletRequest
	 */
	public BannerDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		bannerTitle = ParamUtil.getString(portletRequest, BANNER_TITLE);
	}

	public String getName() {

		return bannerTitle;
	}
	
	protected String bannerTitle;
}
