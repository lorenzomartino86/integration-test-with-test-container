package com.javanger.testcontainer.redis;

import redis.clients.jedis.Jedis;

public class RedisClient {
    private final Jedis jedis;

    public RedisClient(final String host, final int port) {
        this.jedis = new Jedis(host, port);
    }

    public void cache(String id, String todo) {
        jedis.set(id, todo);
    }

    public String getBy(String id) {
        return jedis.get(id);
    }
}
