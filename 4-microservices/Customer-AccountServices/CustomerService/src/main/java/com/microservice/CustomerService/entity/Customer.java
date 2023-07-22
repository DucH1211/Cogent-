package com.microservice.CustomerService.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    ) private int id;
    private String firstname;
    private String lastname;

    private String gender;
    @Column(unique = true)
    private Integer account_id;
    public Integer getAccount_id() {
        return account_id;
    }
    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
    public Customer() {
    }
    public Customer(int id, String firstname, String lastname, String gender) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
