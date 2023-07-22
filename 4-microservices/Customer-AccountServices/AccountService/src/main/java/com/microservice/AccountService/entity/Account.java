package com.microservice.AccountService.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;
    private String username;
    private String password;
    @NotNull
    private String email;
    @Column(unique = true)
    private Integer customer_id;

    public Account() {
    }

    public Account(String username, String password, String email, int customer_id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", customer_id=" + customer_id +
                '}';
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }
}
