package com.wikimedia.wikiconsumer.entity;


import javax.persistence.*;
import java.sql.Clob;

@Entity
@Table(name="wikidata")
public class WikiDataEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String message;

    public WikiDataEvent() {
    }

    public WikiDataEvent(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
