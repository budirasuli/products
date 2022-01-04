package com.modena.model;


// import java.time.Instant;

import javax.persistence.*;

// import org.springframework.data.annotation.CreatedBy;
// import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
// import org.springframework.security.core.userdetails.User;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "master_categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "active", nullable = false)
    private Integer active;

    @Column(name = "position", nullable = false)
    private Integer position;

    @Column(name = "country_code", nullable = false)
    private String country_code;

    @Column(name = "language_code", nullable = false)
    private String language_code;

    @Column(name = "segment_id", nullable = false)
    private Integer segment_id;


    public Category() {

    }


    public Category(Integer segment_id, String name, Integer active, Integer position, String country_code, String language_code) {
        this.segment_id = segment_id;
        this.name = name;
        this.active = active;
        this.position = position;
        this.country_code = country_code;
        this.language_code = language_code;
    }

    public long getId() {
        return id;
    }

    public Integer getSegment_id() {
        return segment_id;
    }

    public void setSegment_id(Integer segment_id) {
        this.segment_id = segment_id;
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
        return "Category [id=" + id + ", segment_id=" + segment_id + ", name=" + name + ",  active=" + active + ", position=" + position + ", language_code="+ language_code +", country_code=" + country_code +"]";
    }

    @PostLoad
    public void postLoad() {

    }
}
