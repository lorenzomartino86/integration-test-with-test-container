package com.javanger.testcontainer.mysql;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;

import java.sql.SQLException;

public class MysqlTodoRepository extends BaseDaoImpl<MysqlTodo, Long> {

    public MysqlTodoRepository(JdbcPooledConnectionSource connection) throws SQLException {
        super(connection, MysqlTodo.class);
    }

    public void save(MysqlTodo todo) throws SQLException {
        super.create(todo);
    }

    public MysqlTodo getById(Long id) throws SQLException {
        return super.queryForEq("id", id).get(0);
    }

}
