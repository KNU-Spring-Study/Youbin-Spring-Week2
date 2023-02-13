package com.example.demo.dto;
import lombok.Setter;

@Setter
public class SignUpDto {
    private String username;
    private String password;
    private String name;
    private String phoneNumber;

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return  name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}
