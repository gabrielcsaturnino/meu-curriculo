package org.example.meucurriculo;

import redis.clients.jedis.Jedis;

public class RedisUtil {
    private static final String REDIS_HOST = "redis";
    private static final int REDIS_PORT = 6379;


    public static Jedis getConnection() {
        return new Jedis(REDIS_HOST, REDIS_PORT);
    }
}