package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MapMemberRepository implements MemberRepository{
    private final Map<Long, Member> store = new HashMap<>(); // <id, Member> 구조
    private Long sequence = 1L; // 정수에 L 붙여야 Long 타입으로 인지함

    @Override
    public void save(Member member){
        member.setId(sequence++);
        store.put(member.getId(), member); // HashMap에 <id, Member> 저장
    }

    @Override
    public Member findByUsername(String username){
        for(Long key: store.keySet()){ // store에 저장된 모든 회원 중 username과 같은 이름이 있는 member 탐색
            Member member = store.get(key);
            if(member.getUsername().equals(username)){
                return member;
            }
        }

        return null;
    }


}
