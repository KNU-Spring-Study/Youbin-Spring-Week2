package com.example.demo.entity;

public class Member {

    private Long id; // 회원 구분용 식별자 (서버에서 지정해줌)
    private String username; // 회원의 로그인 ID
    private String password; // 회원의 로그인 Password
    private String name; // 회원의 이름
    private String phoneNumber; // 회원의 전화번호
    public Member(String username, String password, String name, String phoneNumber){
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setId(Long id){ // id 지정
        this.id = id;
    }
}
