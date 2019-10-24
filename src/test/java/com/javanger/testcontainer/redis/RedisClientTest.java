package com.javanger.testcontainer.redis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;

public class RedisClientTest {

    @ClassRule
    public static GenericContainer redis = new GenericContainer("redis:alpine3.10")
            .withExposedPorts(6379);

    private RedisClient redisClient;

    @Before
    public void setUp() throws Exception {
        redisClient = new RedisClient(redis.getContainerIpAddress(), redis.getMappedPort(6379));
    }

    @Test
    public void canCacheNewTodo() {
        redisClient.cache(UUID.randomUUID().toString(), "TODO description");
    }

    @Test
    public void canGetCachedTodoById() {
        String id = UUID.randomUUID().toString();
        String todo = "TODO description";
        redisClient.cache(id, todo);
        Assert.assertThat(redisClient.getBy(id), is(todo));
    }
}