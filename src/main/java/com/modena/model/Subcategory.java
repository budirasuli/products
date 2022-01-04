package com.modena.model;


// import java.time.Instant;

import javax.persistence.*;

// import org.springframework.data.annotation.CreatedBy;
// import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
// import org.springframework.security.core.userdetails.User;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "master_subcategories")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tradein")
    private Integer tradein;

    @Column(name = "rental")
    private Integer rental;
    public void setId(long id) {
        this.id = id;
    }

   

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

    @Column(name = "category_id", nullable = false)
    private Integer category_id;


    public SubCategory() {

    }


    public SubCategory(Integer category_id, String name, Integer active, Integer position, String country_code, String language_code, Integer tradein, Integer rental) {
        this.category_id = category_id;
        this.name = name;
        this.active = active;
        this.position = position;
        this.country_code = country_code;
        this.language_code = language_code;
        this.tradein = tradein;
        this.rental = rental;
    }

    public long getId() {
        return id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
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

    public Integer getTradein() {
        return this.tradein;
    }

    public void setTradein(Integer tradein) {
        this.tradein = tradein;
    }

    public Integer getRental() {
        return this.rental;
    }

    public void setRental(Integer rental) {
        this.rental = rental;
    }



    @Override
    public String toString() {
        return "SubCategory [id=" + id + ", category_id=" + category_id + ", name=" + name + ",  active=" + active + ", position=" + position + ", language_code="+ language_code +", country_code=" + country_code +", tradein="+ tradein +", rental="+ rental +"]";
    }
}
