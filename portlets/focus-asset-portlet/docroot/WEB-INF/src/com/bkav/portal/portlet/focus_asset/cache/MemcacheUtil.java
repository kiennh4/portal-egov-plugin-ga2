
package com.bkav.portal.portlet.focus_asset.cache;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

public class MemcacheUtil {

	private static MemcacheUtil INSTANCE;

	private MemCachedClient memcacheClient = new MemCachedClient();

	static public MemcacheUtil getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new MemcacheUtil();
		}
		return INSTANCE;
	}

	static String[] HOST = StringUtil.split(PropsUtil.get("portal.memcached.host"), StringPool.COMMA);
	static String WEIGHTS = PropsUtil.get("portal.memcached.weight");
	static String MAINT_SLEEP = PropsUtil.get("portal.memcached.MaintThreadSleep");
	static String SOCKET_TIME_OUT = PropsUtil.get("portal.memcached.SocketTimeOut");
	static String SOCKET_CONNECT_TO = PropsUtil.get("portal.memcached.SocketConnectTo");

	private MemcacheUtil() {

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

		return memcacheClient.set(key, value);
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
