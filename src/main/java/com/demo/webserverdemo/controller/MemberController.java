package com.demo.webserverdemo.controller;

import java.util.List;

import com.demo.webserverdemo.model.Member;
import com.demo.webserverdemo.repositories.MemberRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;
    
    @GetMapping
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Member getMember(@PathVariable Long id) {
        return memberRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Member createMember(@RequestBody final Member member) {
        return memberRepository.saveAndFlush(member);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteMember(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        Member existingMember = memberRepository.findById(id).get();
        BeanUtils.copyProperties(member, existingMember, "id");
        return memberRepository.saveAndFlush(existingMember);
    }
}
