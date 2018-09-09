package com.tchandak.instranate.domain;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    public Image() {

    }

    // ID OF THE INSTRUMENT
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "instrument_id")
    private Integer instrumentId;

    @Column(name = "renter_id")
    private Integer renterId;

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public Integer getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
