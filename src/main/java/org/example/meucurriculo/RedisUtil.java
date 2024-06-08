package org.example.meucurriculo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;
import redis.clients.jedis.JedisPoolConfig;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static Jedis getConnection() {
        String redisHost = System.getenv("REDIS_HOST");
        int redisPort = Integer.parseInt(System.getenv("REDIS_PORT"));
        String redisPassword = System.getenv("REDIS_PASSWORD");

        Jedis jedis = new Jedis(redisHost, redisPort);

        if (redisPassword != null && !redisPassword.isEmpty()) {
            jedis.auth(redisPassword);
        }

        return jedis;
    }
}
