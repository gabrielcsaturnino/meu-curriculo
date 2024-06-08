package org.example.meucurriculo;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static Jedis getConnection() {
        String redisHost = System.getenv("REDISHOST");
        int redisPort = Integer.parseInt(System.getenv("REDISPORT"));
        System.out.println(redisHost + ":" + redisPort);
        return new Jedis(redisHost, redisPort);
    }
}