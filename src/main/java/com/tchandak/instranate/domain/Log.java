package com.tchandak.instranate.domain;

import javax.persistence.*;

@Entity
@Table(name = "log")
public class Log {

    public Log() {

    }

    // ID OF THE INSTRUMENT
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "instrument_id")
    Integer instrumentId;

    // ID OF THE DONOR
    @Column(name = "donor_id")
    Integer donorId;

    // ID OF THE RENTER
    @Column(name = "renter_id")
    Integer renterId;

    // some sore of ANGULAR DATE
    @Column(name = "date")
    String date;


    // Either DONATION or RENTAL
    @Column(name = "type")
    String type;

    // ID OF THE SCHOOL
    @Column(name = "school_id")
    Integer schoolId;

    // Select all of the instruments where the type is equal to rental and the instrument
    // matches the instrument id. Find all of those and then find the renter id adn then
    // search for the renter's name and organizationn etc. and then find the school
    // where the instrument was rented out to.


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }

    public Integer getDonorId() {
        return donorId;
    }

    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }
}
