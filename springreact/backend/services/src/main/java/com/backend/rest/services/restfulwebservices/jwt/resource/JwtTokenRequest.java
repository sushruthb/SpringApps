package com.backend.rest.services.restfulwebservices.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;
    /*{
        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU5MzM1NTA5OCwiaWF0IjoxNTkyNzUwMjk4fQ.bC93b26iloe3Gw3pmwtQHugEbfTU0YJ2Tl79TrAnLZLlScWr1y43yYxEzGPdR-TNLzc_MZ55ybVoZIhwvPh5RQ";
    }*/

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

