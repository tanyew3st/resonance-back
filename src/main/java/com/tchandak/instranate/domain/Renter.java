package com.tchandak.instranate.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@Table(name = "renter")
public class Renter {

    public Renter() {

    }

    public Renter(Integer id, String firstName, String lastName, String email, Long instrumentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
        this.instrumentId = instrumentId;

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "instrument_id")
    private long instrumentId;

    @Column(name = "donor_message")
    private String donorMessage;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "type")
    private String type;

    @Column(name = "income")
    private String income;

    @Column(name = "people_benefiting")
    private String peopleBenefiting;

    @Column(name = "donation")
    private String donation;

    @Column(name = "move_process")
    private String moveProcess;

    @Column(name = "assistance")
    private String assistance;

    @Column(name = "hear_about_us")
    private String hearAboutUs;

    @Column(name = "ethnicity")
    private String ethnicity;

    @Column(name = "sex")
    private String sex;

    @Column(name = "marital_status")
    private String marital_status;

    @Column(name = "partner_id")
    private Integer partnerId;

    @Column(name = "player")
    private String player;

    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getPeopleBenefiting() {
        return peopleBenefiting;
    }

    public void setPeopleBenefiting(String peopleBenefiting) {
        this.peopleBenefiting = peopleBenefiting;
    }

    public String getDonation() {
        return donation;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }

    public String getMoveProcess() {
        return moveProcess;
    }

    public void setMoveProcess(String moveProcess) {
        this.moveProcess = moveProcess;
    }

    public String getAssistance() {
        return assistance;
    }

    public void setAssistance(String assistance) {
        this.assistance = assistance;
    }

    public String getHearAboutUs() {
        return hearAboutUs;
    }

    public void setHearAboutUs(String hearAboutUs) {
        this.hearAboutUs = hearAboutUs;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public String getDonorMessage() {
        return donorMessage;
    }

    public void setDonorMessage(String donorMessage) {
        this.donorMessage = donorMessage;
    }

    public long getInstrumentId() { return instrumentId; }

    public void setInstrumentId(long instrumentId) { this.instrumentId = instrumentId; }

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
