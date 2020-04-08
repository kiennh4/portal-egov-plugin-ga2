/**
 * @author HUNGDX
 * @time 10:37:22 AM
 * @project weblinks-portlet
 */
package com.bkav.portal.portlet.video.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class VideoSearchTerms extends VideoDisplayTerms{

	/**
	 * @param portletRequest
	 */
	public VideoSearchTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		videoName = DAOParamUtil.getLike(portletRequest, VIDEO_NAME);
	}
}
