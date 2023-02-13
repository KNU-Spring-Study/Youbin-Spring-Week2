package com.example.demo.dto;

public class MyPageResponseDto {
    private String username;
    private String name;
    private String phoneNumber;

    public String getUsername(){
        return username;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }


}
