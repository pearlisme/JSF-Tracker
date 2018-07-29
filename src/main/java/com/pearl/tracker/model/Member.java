package com.pearl.tracker.model;

import com.pearl.tracker.annotations.Mobile;
import lombok.Data;

import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Named
@Data
@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    @NotNull
    private long id;

    @Column(name = "MEMBER_NAME")
    @NotNull
    private String name;

    @Column(name = "MEMBER_MOBILE")
    @Mobile
    private long mobile;

    @Column(name = "MEMBER_EMAIL")
    @Email
    private long email;

    @Column(name = "MEMBER_DOB")
    @Temporal(TemporalType.DATE)
    @Past
    private Date dob;

    @Column(name = "MEMBER_GENDER")
    private String gender;

    @Column(name = "MEMBER_ADDRESS")
    private String address;

    @Column(name = "DATE_OF_JOINING")
    @Temporal(TemporalType.DATE)
    @Future
    private Date dateOfJoing = new Date();

    @Column(name = "ACTIVE")
    private int active = 1;




}
