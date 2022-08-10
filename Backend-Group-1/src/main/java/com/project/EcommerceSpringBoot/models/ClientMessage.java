package com.project.EcommerceSpringBoot.models;

public class ClientMessage {
    private String Message;

    public ClientMessage(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
///