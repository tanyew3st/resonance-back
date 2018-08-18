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
