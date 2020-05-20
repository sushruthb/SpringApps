package com.backend.services.controllers;

public class HelloWorldBean {
    String message;
    public HelloWorldBean(String message) {
        this.message=message;
    }

    public String getStr() {
        return message;
    }

    public void setStr(String str) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
