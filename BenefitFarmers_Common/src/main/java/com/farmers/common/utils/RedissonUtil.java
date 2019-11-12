package com.farmers.common.utils;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RedissonUtil {
    private static RedissonClient client;
    static {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://47.96.135.159:6379").setConnectionPoolSize(64);
        client = Redisson.create(config);
    }
    public static void set(String key,String value) {
        client.getBucket(key).set(value);
    }
    public static String get(String key) {
        return (String) client.getBucket(key).get();
    }

    public static void hset(String name,String key,String value) {
        client.getMap(name).put(key,value);
    }
    //获取hash的全部
    public static Collection<Object> hgetAll(String key) {
        return client.getMap(key).values();
    }
    public static Object hgetAll(String name,String key) {
        return client.getMap(name).get(key);
    }
    //存入hash一个map
    public static  void putAllHash(String key, Map<Object,String> map,long seconds){
        RMap rm= client.getMap(key);
        if(seconds>0) {
            rm.expire(seconds, TimeUnit.SECONDS);
        }
        rm.putAll(map);
    }

    public static  void putAllHash(String key, Map<String,Object> map){
        client.getMap(key).putAll(map);
    }
    public static boolean checkKey(String key){
        return client.getKeys().countExists(key)>0;
    }
    public static void setExpire(String key,long seconds){
        client.getKeys().expire(key,seconds, TimeUnit.SECONDS);
    }

    public static void lock(String key){
        client.getLock(key).lock();
    }
    //释放分布式锁
    public static void unlock(String key){
        client.getLock(key).unlock();
    }
}