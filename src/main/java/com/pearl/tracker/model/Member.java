package com.pearl.tracker.model;

import lombok.Data;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Named
@Data
@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private long id;

    @Column(name = "MEMBER_NAME")
    private String name;

    @Column(name = "MEMBER_MOBILE")
    private long mobile;

    @Column(name = "MEMBER_DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "MEMBER_GENDER")
    private String gender;

    @Column(name = "MEMBER_ADDRESS")
    private String address;

    @Column(name = "DATE_OF_JOINING")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoing = new Date();

    @Column(name = "ACTIVE")
    private int active = 1;




}
