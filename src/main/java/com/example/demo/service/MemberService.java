package com.example.demo.service;

import com.example.demo.entity.Member;


/**
 * MerverService 인터페이스
 */

public interface MemberService {

    String join(Member member);
    String login(String username, String password);
}
