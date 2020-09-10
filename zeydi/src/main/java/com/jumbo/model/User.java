package com.jumbo.model;

import javax.persistence.Id;

public class User {
    @Id
    private String id;
    private String name;
    private String email;
}
