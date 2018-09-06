package com.baizhi.cmfz.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil2 {
	private static JedisPool pool = null;
	static{
		//连接池配置
		JedisPoolConfig config = new JedisPoolConfig();
		//设置最大连接数
		config.setMaxTotal(100);
		
		config.setMaxIdle(20);
		//创建连接池
		pool = new JedisPool(config, "192.168.36.138");
	}
	
	//获取jedis对象，与redis数据库建立连接
	public static Jedis getJedis(){
		//通过连接池获取jedis对象
		Jedis jedis = pool.getResource();
		jedis.select(8);
		return  jedis;
	}
	//关闭连接
	public static void closeJedis(Jedis jedis){
		if(jedis!=null){
			jedis.close();
		}
	}
}
