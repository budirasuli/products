package com.modena.model;

import javax.persistence.*;


@Entity
@Table(name = "master_segments")
public class Segmen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Integer active;

    @Column(name = "position")
    private Integer position;

    @Column(name = "country_code")
    private String country_code;

    @Column(name = "language_code")
    private String language_code;

    public Segmen() {

    }

    public Segmen(String name, Integer active, Integer position, String country_code, String language_code) {
        this.name = name;
        this.active = active;
        this.position = position;
        this.country_code = country_code;
        this.language_code = language_code;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }




    @Override
    public String toString() {
        return "Segments [id=" + id + ", name=" + name + ",  active=" + active + ", position=" + position + ", language_code="+ language_code +", country_code=" + country_code +" ]";
    }
}
