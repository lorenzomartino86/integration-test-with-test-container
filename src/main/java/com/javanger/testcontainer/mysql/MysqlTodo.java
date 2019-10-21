package com.javanger.testcontainer.mysql;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@DatabaseTable(tableName = "todo")
public class MysqlTodo {
    @DatabaseField(canBeNull = false, id = true)
    private long id;
    @DatabaseField(canBeNull = false)
    private String todo;
}
