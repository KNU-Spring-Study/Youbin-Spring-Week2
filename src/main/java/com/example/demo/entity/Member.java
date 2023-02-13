package com.example.demo.entity;

public class Member {

    private Long id; // 회원 구분용 식별자 (서버에서 지정해줌)
    private String username; // 회원의 로그인 ID
    private String password; // 회원의 로그인 Password
    private String name; // 회원의 이름

    public Member(String username, String password, String name){
        this.username = username;
        this.password = password;
        this.name = name;
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

    public void setId(Long id){ // id 지정
        this.id = id;
    }
}
