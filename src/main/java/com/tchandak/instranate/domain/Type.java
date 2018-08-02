package com.tchandak.instranate.domain;

import javax.persistence.*;

@Entity
@Table(name = "type")
public class Type {

    public Type() {

    }

    public Type(Integer schoolId, String instrument ) {
        this.instrument = instrument;
        this.schoolId = schoolId;
    }
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "school_id")
    private Integer schoolId;

    @Column(name = "instrument_name")
    private String instrument;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
}
