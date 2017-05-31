package com.redis.cluster;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterPool {

	private static JedisCluster jedisCluster;
	//集群节点列表
	private static Set<HostAndPort> nodes;
	
	private static String host = "127.0.0.1";
//	private static int port = 7001;
	private static int ports[] = {7001, 7002, 7003, 7004, 7005, 7006};
	
	static {
		if(nodes == null) {
			nodes = new HashSet<HostAndPort>();
		}
		for (int p : ports) {
			HostAndPort hap = new HostAndPort(host, p);
			nodes.add(hap);
		}
		
		jedisCluster = new JedisCluster(nodes);
	}
	JedisClusterPool(){
		
	}
	
	
	public static void main(String[] args) {
		String key = "keys:sms";
		String value = "value:123456";
		String appendValue = ":abc";
		String setResult = jedisCluster.set(key, value);
		System.out.println("setResult : " + setResult);
		
		String getResult = jedisCluster.get(key);
		System.out.println("getResult : " + getResult);
		
		
		Long append = jedisCluster.append(key, appendValue);
		System.out.println("append : " + append);
		
	}
}
