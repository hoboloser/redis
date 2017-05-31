package com.redis.sync;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class JedisSentinlePool {
	
	private static final String MASTER_NAME = "mymaster";
	
	private static final String PASSWORD = "123456";
	
	private static Set<String> sentinels;
	
	private static JedisSentinelPool jedisPool;
	//sentinel 监控
	private static String sentinel = "127.0.0.1:26379";
	static {
		if(sentinels == null) {
			sentinels = new HashSet<String>();
		}
		sentinels.add(sentinel);
		jedisPool =  new JedisSentinelPool(MASTER_NAME, sentinels, PASSWORD);
	}

	public static void main(String[] args) {
		String key1 = "key";
		String key = "win1234";
		String value = "1235456";
		System.out.println(get(key1));
		System.out.println(set(key, value));
		System.out.println(get(key));
		
		//线程会一直阻塞，主从复制的主机检测会一直存在
//		jedisPool.close();
		//会关闭主从复制的主机检测，即彻底关闭JedisSentinelPool
//		jedisPool.destroy();
	}
	
	public static String set(String key, String value) {
		Jedis jedis = null;
		String setValue = null;
		try{
			jedis = jedisPool.getResource();
			setValue = jedis.set(key, value);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(jedis);
		}
		
		return setValue;
	}
	
	public static String get(String key) {
		Jedis jedis = null;
		String value = null;
		try{
			jedis = jedisPool.getResource();
			value = jedis.get(key);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(jedis);
		}
		
		return value;
	}
	
	private static void close(Jedis jedis) {
		try {
			jedisPool.returnResourceObject(jedis);
		} catch(Exception e) {
			e.printStackTrace();
			if (jedis.isConnected()) {
				jedis.quit();
				jedis.disconnect();
			}
		}
	} 
}
