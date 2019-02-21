package com.portal_egov.portlet.visit_counter.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class OnlineVisitorCounter implements HttpSessionListener{


	public static int getOnlineVisitorCounter(){
		
		if(ONLINE_VISITOR_COUNTER <= 0){
			
			ONLINE_VISITOR_COUNTER = 1;
		}
		
		return ONLINE_VISITOR_COUNTER;
	}
	
	private static int ONLINE_VISITOR_COUNTER = 1;

	
	public void sessionCreated(HttpSessionEvent arg0) {
		ONLINE_VISITOR_COUNTER ++;
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		ONLINE_VISITOR_COUNTER --;
	}

}
