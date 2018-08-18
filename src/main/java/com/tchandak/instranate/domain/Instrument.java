package com.tchandak.instranate.domain;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "instrument")
public class Instrument {

    public Instrument() {

    }

    public Instrument(Integer id, Integer donorId, String type, String size, String brand,
                      String modelNumber, String age, String condition, String status) {
        this.id = id;
        this.donorId = donorId;
        this.type = type;
        this.size = size;
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.age = age;
        this.condition = condition;
        this.status = "donationRequest";
    }


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "crazy_key")
    private Integer key;

    @Column(name = "donor_id")
    private Integer donorId;

    @Column(name = "school_id")
    private Integer schoolId;

    @Column(name = "type")
    private String type;

    @Column(name = "size")
    private String size;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model_number")
    private String modelNumber;

    @Column(name = "age")
    private String age;

    @Column(name = "cond")
    private String condition;

    @Column(name = "status")
    private String status;

    @Column(name = "renter_id")
    private Integer renterId;

    @Column(name = "amount_paid")
    private Integer amountPaid;

    @Column(name = "potential_school")
    private Integer potentialSchool;

    @Column(name = "owner")
    private String owner;

    @Column(name = "information")
    private String information;

    @Column(name = "partner_id")
    private Integer partner;

    @Column(name = "last_worked")
    private Integer lastWorked;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "access_to_elevator")
    private String accessToElevator;

    @Column(name = "bench")
    private String bench;

    @Column(name = "keytop_condition")
    private String keytopCondition;

    @Column(name = "sticky_keys")
    private String stickyKeys;

    @Column(name = "broken_parts")
    private String brokenParts;

    @Column(name = "sticky_pedals")
    private String stickyPedals;

    public String getStickyPedals() {
        return stickyPedals;
    }

    public void setStickyPedals(String stickyPedals) {
        this.stickyPedals = stickyPedals;
    }

    public String getBrokenParts() {
        return brokenParts;
    }

    public void setBrokenParts(String brokenParts) {
        this.brokenParts = brokenParts;
    }

    public Integer getLastWorked() {
        return lastWorked;
    }

    public void setLastWorked(Integer lastWorked) {
        this.lastWorked = lastWorked;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAccessToElevator() {
        return accessToElevator;
    }

    public void setAccessToElevator(String accessToElevator) {
        this.accessToElevator = accessToElevator;
    }

    public String getBench() {
        return bench;
    }

    public void setBench(String bench) {
        this.bench = bench;
    }

    public String getKeytopCondition() {
        return keytopCondition;
    }

    public void setKeytopCondition(String keytopCondition) {
        this.keytopCondition = keytopCondition;
    }

    public String getStickyKeys() {
        return stickyKeys;
    }

    public void setStickyKeys(String stickyKeys) {
        this.stickyKeys = stickyKeys;
    }

    public Integer getPartner() {
        return partner;
    }

    public void setPartner(Integer partner) {
        this.partner = partner;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getPotentialSchool() {
        return potentialSchool;
    }

    public void setPotentialSchool(Integer potentialSchool) {
        this.potentialSchool = potentialSchool;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    //List<Renter> previousRenters = new ArrayList<Renter>();

    //HASHMAP TO GET THANK YOU NOTES?

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDonorId() {
        return donorId;
    }

    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
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



