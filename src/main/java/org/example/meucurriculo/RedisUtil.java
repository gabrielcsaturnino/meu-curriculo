package org.example.meucurriculo;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static Jedis getConnection() {
        String redisHost = System.getenv("REDIS_HOST");
        String redisPortString = System.getenv("REDIS_PORT");
        String redisPassword = System.getenv("REDIS_PASSWORD");

        if (redisHost == null || redisHost.isEmpty()) {
            throw new IllegalArgumentException("REDIS_HOST environment variable is not set.");
        }

        if (redisPortString == null || redisPortString.isEmpty()) {
            throw new IllegalArgumentException("REDIS_PORT environment variable is not set.");
        }

        int redisPort;
        try {
            redisPort = Integer.parseInt(redisPortString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("REDIS_PORT environment variable is not a valid integer.", e);
        }

        Jedis jedis = new Jedis(redisHost, redisPort);

        if (redisPassword != null && !redisPassword.isEmpty()) {
            jedis.auth(redisPassword);
        }

        return jedis;
    }
}
