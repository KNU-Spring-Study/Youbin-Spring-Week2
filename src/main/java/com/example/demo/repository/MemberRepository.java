package com.example.demo.repository;

import com.example.demo.entity.Member;

public interface MemberRepository {
    void save(Member member);
    void delete(Member member);
    Member findByUsername(String username);

}
