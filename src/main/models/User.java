package main.models;

import main.annotations.Column;
import main.annotations.Table;

@Table("users")
public class User {
    private Integer id;

    @Column("userName")
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
