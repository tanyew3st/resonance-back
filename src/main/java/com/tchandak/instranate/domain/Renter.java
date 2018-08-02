package com.tchandak.instranate.domain;

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
