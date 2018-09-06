package com.baizhi.cmfz.util;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.ibatis.cache.Cache;

import redis.clients.jedis.Jedis;


public class RedisCache implements Cache {
	//代表namespace，即一个dao对应一个缓存
	private String id;
	
	
	public RedisCache(String id) {
		super();
		this.id = id;
	}
	
	@Override
	public void clear() {
		Jedis jedis = JedisUtil2.getJedis();
		byte[] k1 = SerializationUtils.serialize(id);
		
		jedis.del(k1);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Object getObject(Object arg0) {
		Jedis jedis = JedisUtil2.getJedis();
		byte[] k1 = SerializationUtils.serialize(id);
		byte[] k2 = SerializationUtils.serialize((Serializable) arg0);
		
		byte[] v = jedis.hget(k1, k2);
		if(v==null){
			return null;
		}
		Object obj = SerializationUtils.deserialize(v);
		return obj;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		Jedis jedis = JedisUtil2.getJedis();
		byte[] k1 = SerializationUtils.serialize(id);
		Set<byte[]> hkeys = jedis.hkeys(k1);
		
		return hkeys.size();
	}

	@Override
	public void putObject(Object arg0, Object arg1) {
		Jedis jedis = JedisUtil2.getJedis();
		byte[] k1 = SerializationUtils.serialize(id);
		byte[] k2 = SerializationUtils.serialize((Serializable) arg0);
		byte[] v = SerializationUtils.serialize((Serializable) arg1);
		jedis.hset(k1, k2, v);
	}

	@Override
	public Object removeObject(Object arg0) {
		Jedis jedis = JedisUtil2.getJedis();
		byte[] k1 = SerializationUtils.serialize(id);
		byte[] k2 = SerializationUtils.serialize((Serializable) arg0);
		Object obj = getObject(arg0);
		
		jedis.hdel(k1, k2);
		return obj;
	}
	
}
