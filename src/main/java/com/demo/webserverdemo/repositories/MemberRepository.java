package com.demo.webserverdemo.repositories;

import com.demo.webserverdemo.model.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
    
}
