package com.bkav.portal.portlet.topic.memcached;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.bkav.portal.portlet.topic.memcached.util.*;

public class MemcachedConnection {
	
	private MemCachedClient mcc = new MemCachedClient();
	
	static String filePatch			 = MemcachedConstant.MEMCACHED_CONFIG_FILE;
	
	static String HOST 				=  MemcachedUtil.getPropertyValue(filePatch, MemcachedConstant.HOST);
	static String WEIGHTS 				=  MemcachedUtil.getPropertyValue(filePatch, MemcachedConstant.WEIGHTS);
	static String INIT_CONN 			=  MemcachedUtil.getPropertyValue(filePatch, MemcachedConstant.INIT_CONN);
	static String MIN_CONN 			=  MemcachedUtil.getPropertyValue(filePatch, MemcachedConstant.MIN_CONN);
	static String MAX_CONN 			=  MemcachedUtil.getPropertyValue(filePatch, MemcachedConstant.MAX_CONN);
	static String MAINT_SLEEP 			=  MemcachedUtil.getPropertyValue(filePatch, MemcachedConstant.MAINT_SLEEP);
	static String NAGLE 				=  MemcachedUtil.getPropertyValue(filePatch, MemcachedConstant.NAGLE);
	static String MAX_IDLE				=  MemcachedUtil.getPropertyValue(filePatch, MemcachedConstant.MAX_IDLE);
	static String SOCKET_TO 			=  MemcachedUtil.getPropertyValue(filePatch, MemcachedConstant.SOCKET_TO);
	static String SOCKET_CONNECT_TO 	=  MemcachedUtil.getPropertyValue(filePatch, MemcachedConstant.SOCKET_CONNECT_TO);
	
	public static boolean connectMemcachedServer() {
		
		try {
		
			System.out.println("Connecting to Topic Memcache..." + HOST.split(","));
			
			SockIOPool pool = SockIOPool.getInstance();
			
			pool.setServers( HOST.split(",")); 
			pool.setWeights(getWeightsProperty(WEIGHTS) ); 					// 3,3
			pool.setInitConn(Integer.parseInt(INIT_CONN)  );  				// 5
			pool.setMinConn(Integer.parseInt(MIN_CONN) ); 					// 5
			pool.setMaxConn(Integer.parseInt(MAX_CONN)); 					// 250
			pool.setMaintSleep(Integer.parseInt(MAINT_SLEEP)); 				// 30
			pool.setNagle(Boolean.parseBoolean(NAGLE)); 					// FALSE
			pool.setMaxIdle(Long.parseLong(MAX_IDLE)  ); 					// 21600000
			pool.setSocketTO(Integer.parseInt(SOCKET_TO)); 					// 3000
			pool.setSocketConnectTO(Integer.parseInt(SOCKET_CONNECT_TO) );	// 0
			
			pool.initialize();
			
			System.out.println("Connect to Topic Memcache Success at " + HOST.split(","));
			
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Connect to Topic Memcache Failed at " + HOST.split(","));
			
			return false;
		}
	}
	
	private static Integer[] getWeightsProperty(String weights) {
		String[] strWeights = WEIGHTS.split(",");
		Integer[] IntWeights = new Integer[strWeights.length];

		int i = 0;
		for(String strWeight : strWeights){
			IntWeights[i] = Integer.valueOf(strWeight);
			i++;
		}
		return IntWeights;
	}
	
	public Object get(String key) {
		System.out.println(this.getClass().getName() + " get(key) : " + key);
		Object obj = mcc.get(key);
		if (obj == null) {
			System.out.println(this.getClass().getName() + " get : Object NULL");
		} else {
			System.out.println(this.getClass().getName() + " get : " + obj.toString());
		}
		return obj;
	}
	
	public void set(String key, Object value) {
		System.out.println(this.getClass().getName() + " set(key) : " + key);
		if (mcc.set(key, value)) {
			System.out.println(this.getClass().getName() + " set key success");
		} else {
			System.out.println(this.getClass().getName() + " set key error");
		}
	}
	
	public void delete(String key) {
		System.out.println(this.getClass().getName() + " delete(key) : " + key);
		if (mcc.delete(key)) {
			System.out.println(this.getClass().getName() + " delete key success");
		} else {
			System.out.println(this.getClass().getName() + " delete key error");
		}
	}
	
}
