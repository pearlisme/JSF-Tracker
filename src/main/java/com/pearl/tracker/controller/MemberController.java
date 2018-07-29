package com.pearl.tracker.controller;

import com.pearl.tracker.model.Member;
import com.pearl.tracker.service.MemberService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class MemberController implements Serializable {

    @Inject
    MemberService memberService;

    private Member member;

    @PostConstruct
    public void init(){
        member = new Member();
    }

    public String addMember(){

        Member addMember = memberService.addMember(member);

        if(addMember != null){
            return "success";
        }
        return "index";
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void addMessage(){
        String summary = "updated"/* gender ? "Checked" : "Unchecked"*/;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

}
