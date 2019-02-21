package com.liferay.portal.memcached;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.liferay.portal.util.PropsValues;

public class MemcachedUtil {

	private static MemcachedUtil INSTANCE;

	private MemCachedClient memcacheClient = new MemCachedClient();

	static public MemcachedUtil getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new MemcachedUtil();
		}
		return INSTANCE;
	}

	// String filePatch = Constant.MEMCACHED_CONFIG_FILE;

	static String[] HOST = PropsValues.PORTAL_MEMCAHCED_HOST;
	static String WEIGHTS = PropsValues.PORTAL_MEMCAHCED_WEIGHT;
	static String MAINT_SLEEP = PropsValues.PORTAL_MEMCAHCED_MAINTTHREADSLEEP;
	static String SOCKET_TIME_OUT = PropsValues.PORTAL_MEMCAHCED_SOCKETTIMEOUT;
	static String SOCKET_CONNECT_TO = PropsValues.PORTAL_MEMCAHCED_SOCKETCONNECTTO;
	static long MEMCACHE_LIFETIME = PropsValues.PORTAL_MEMCAHCED_LIFETIME;
	
	private MemcachedUtil() {

		SockIOPool pool = SockIOPool.getInstance();

		pool.setServers(HOST);
		pool.setWeights(getWeightsProperty(WEIGHTS));
		pool.setMaintSleep(Integer.parseInt(MAINT_SLEEP));
		pool.setSocketTO(Integer.parseInt(SOCKET_TIME_OUT)); 
		pool.setSocketConnectTO(Integer.parseInt(SOCKET_CONNECT_TO)); 

		pool.initialize();
	}

	private Integer[] getWeightsProperty(String weights) {

		String[] strWeights = WEIGHTS.split(",");
		Integer[] IntWeights = new Integer[strWeights.length];

		int i = 0;
		for (String strWeight : strWeights) {
			IntWeights[i] = Integer.valueOf(strWeight);
			i++;
		}
		return IntWeights;
	}

	public Object get(String key) {

		return memcacheClient.get(key);
	}

	public boolean set(String key, Object value) {
		
		Date now = new Date();
		
		long expireTime = now.getTime() + MEMCACHE_LIFETIME*1000;
		
		Date expireDate = new Date(expireTime);
		
		return memcacheClient.set(key, value, expireDate);
	}

	public boolean delete(String key) {

		return memcacheClient.delete(key);
	}

	public boolean clearAllCache() {
		try {

			if (memcacheClient.flushAll())
				return true;
			else
				return false;
		}
		catch (Exception e) {
			return false;
		}
	}
}
