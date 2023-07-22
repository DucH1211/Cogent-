package com.microservice.rabbitmq.RabbitMQDemo.classes;

import java.util.Date;

public class CustomMessage {
    private String message_id;
    private String message;
    private Date date;

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "message_id='" + message_id + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
