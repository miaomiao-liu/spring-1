package com.atguigu.spring5.hibernate.entities;

/**
 * Created by miaomiao on 18-1-23.
 */
public class Account {

    private Integer id;
    private String username;
    private int balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
