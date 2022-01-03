package com.modena.model;

import javax.persistence.*;


@Entity
@Table(name = "master_color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Integer active;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "country_code")
    private String country_code;

    @Column(name = "language_code")
    private String language_code;

    public Color() {

    }

    public Color(String name, Integer active, Integer sequence, String country_code, String language_code) {
        this.name = name;
        this.active = active;
        this.sequence = sequence;
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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
        return "Color [id=" + id + ", name=" + name + ",  active=" + active + ", sequence=" + sequence + ", language_code="+ language_code +", country_code=" + country_code +" ]";
    }
}
