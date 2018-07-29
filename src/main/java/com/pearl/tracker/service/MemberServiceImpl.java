package com.pearl.tracker.service;

import com.pearl.tracker.model.Member;
import com.pearl.tracker.repository.MemberRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "memberService")
@SessionScoped
public class MemberServiceImpl implements MemberService ,Serializable {

    @Inject
    MemberRepository memberRepository;

    @Override
    public Member addMember(Member member) {

        memberRepository.addMember(member);
        return null;
    }
}
