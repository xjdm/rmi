package com.idstaa.pojo;

import java.io.Serializable;

/**
 * @author chenjie
 * @date 2020/12/17 19:36
 */
public class User implements Serializable {
    private static final long serialVersionUID = 6693012525832553855L;
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
