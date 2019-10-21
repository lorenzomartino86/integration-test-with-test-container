package com.javanger.testcontainer.mysql;

import com.j256.ormlite.db.MysqlDatabaseType;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;

public class MysqlTodoRepositoryTest {
    @ClassRule
    public static MySQLContainer mysql = new MySQLContainer();
    private MysqlTodoRepository repository;

    @Before
    public void setUp() throws Exception {
        String url = String.format("jdbc:mysql://%s:%s/%s",
                mysql.getContainerIpAddress(),
                mysql.getMappedPort(3306),
                mysql.getDatabaseName());
        JdbcPooledConnectionSource connectionPool = new JdbcPooledConnectionSource(url,
                mysql.getUsername(), mysql.getPassword(), new MysqlDatabaseType());
        TableUtils.createTableIfNotExists(connectionPool, MysqlTodo.class);
        repository = new MysqlTodoRepository(connectionPool);
    }

    @Test
    public void canIntegrateWithMysqlContainer() throws SQLException {
        MysqlTodo todo = new MysqlTodo();
        todo.setId(123L);
        todo.setTodo("Important TODO");
        repository.save(todo);
        MysqlTodo persistedTodo = repository.getById(todo.getId());
        Assert.assertThat(persistedTodo, is(todo));
    }
}