package main.models;

import main.annotations.Column;
import main.annotations.Table;

@Table("profiles")
public class Profile {

    private Integer id;

    @Column("profileName")
    private String name;
    private String bio;
    private Integer age;

    public Profile(Integer id, String name, String bio, Integer age) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public Integer getAge() {
        return age;
    }
}
