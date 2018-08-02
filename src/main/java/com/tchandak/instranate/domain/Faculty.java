package com.tchandak.instranate.domain;

import javax.persistence.*;

@Entity
@Table(name = "faculty")
public class Faculty {


    public Faculty() {

    }

    public Faculty(String firstName, String lastName, String email, Integer schoolId) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.schoolId = schoolId;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "school_id")
    private Integer schoolId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "position")
    private String position;

    //private String status;


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getInstrumentId() { return schoolId; }

    public void setInstrumentId(Integer instrumentId) { this.schoolId = instrumentId; }

    public Integer getId() {
            return id;
    }

    public void setId(Integer id) {
            this.id = id;

    }


    public String getFirstName() {
            return firstName;
    }

    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }

    public String getLastName() {
            return lastName;
    }

    public void setLastName(String lastName) {
            this.lastName = lastName;
    }

    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

}


