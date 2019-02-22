/**
 * @author HUNGDX
 * @time 10:36:41 AM
 * @project weblinks-portlet
 */
package com.bkav.portal.portlet.video.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class VideoDisplayTerms extends DisplayTerms{

	public static final String VIDEO_NAME = "name";
	/**
	 * @param portletRequest
	 */
	public VideoDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		videoName = ParamUtil.getString(portletRequest, VIDEO_NAME);
	}

	public String getName() {

		return videoName;
	}
	
	protected String videoName;
}
