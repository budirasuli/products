package com.modena.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;


@Entity
@Table(name = "master_color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "id_product_color_id", nullable = false)
    private Integer id_product_color_id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Integer active;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "country_code")
    private String country_code;

    @Column(name = "language_code")
    private String language_code;

    //auto fill
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    @DeleteTimestamp
    private LocalDateTime deletedAt;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "updated_by")
    @LastModifiedBy
    private String modifiedBy;

    public Color() {

    }

    public Color(Integer id_product_color_id, String name, Integer active, Integer sort, String country_code, String language_code) {
        this.id_product_color_id = id_product_color_id;
        this.name = name;
        this.active = active;
        this.sort = sort;
        this.country_code = country_code;
        this.language_code = language_code;
    }

    public long getId() {
        return id;
    }

    public Integer getId_product_color_id() {
        return id_product_color_id;
    }

    public void setId_product_color_id(Integer id_product_color_id) {
        this.id_product_color_id = id_product_color_id;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    
    public LocalDateTime getCreated_at() {
        return createdAt;
    }

    public LocalDateTime getUpdated_at() {
        return updatedAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "Color [id=" + id + ", id_product_color_id="+ id_product_color_id +", name=" + name + ",  active=" + active + ", sort=" + sort + ", language_code="+ language_code +", country_code=" + country_code +" ]";
    }
}
