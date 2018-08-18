package com.tchandak.instranate.domain;

import javax.persistence.*;

@Entity
@Table(name = "partner")
public class Partner {

    public Partner() {

    }

    public Partner(Integer id, String username, String password, String name, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
