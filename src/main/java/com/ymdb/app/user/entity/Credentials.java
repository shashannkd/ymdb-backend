package com.ymdb.app.user.entity;


import lombok.Data;

@Data
public class Credentials {

    public String userName;
    public String password;
    public boolean isEmail;
}
