package com.pearl.tracker;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import lombok.Data;

@ManagedBean(value="member")
public class Member {
	
	List<Member> members= new ArrayList<Member>();
	long memberId;
	String memberName;
	String memberAddress;
	long memberMobile;
	
	
	
	public List<Member> getMembers() {
		return members;
	}



	public void setMembers(List<Member> members) {
		this.members = members;
	}



	public long getMemberId() {
		return memberId;
	}



	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public String getMemberAddress() {
		return memberAddress;
	}



	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}



	public long getMemberMobile() {
		return memberMobile;
	}



	public void setMemberMobile(long memberMobile) {
		this.memberMobile = memberMobile;
	}



	public void addMember(ActionEvent event){
		FacesMessage message = null;
		Member newMember = new Member();
		newMember.setMemberAddress(memberAddress);
		newMember.setMemberId(memberId);
		newMember.setMemberName(memberName);
		newMember.setMemberMobile(memberMobile);
		message = new FacesMessage(FacesMessage.FACES_MESSAGES, "User Added Successfully");
		FacesContext.getCurrentInstance().addMessage(null, message);
		members.add(newMember);
		
	}
}
