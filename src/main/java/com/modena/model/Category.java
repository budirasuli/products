package com.modena.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "master_categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "id_product_category_id", nullable = false)
    private Integer id_product_category_id;

    @Column(name = "id_product_segment_id", nullable = false)
    private Integer id_product_segment_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "active", nullable = false)
    private Integer active;

    @Column(name = "country_code", nullable = false)
    private String country_code;

    @Column(name = "language_code", nullable = false)
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

    public Category() {

    }


    public Category(Integer id_product_category_id, Integer id_product_segment_id, String name, Integer active, String country_code, String language_code) {
        this.id_product_category_id = id_product_category_id;
        this.id_product_segment_id = id_product_segment_id;
        this.name = name;
        this.active = active;
        this.country_code = country_code;
        this.language_code = language_code;
    }

    public long getId() {
        return id;
    }

    public Integer getId_product_category_id() {
        return id_product_category_id;
    }

    public void setId_product_category_id(Integer id_product_category_id) {
        this.id_product_category_id = id_product_category_id;
    }

    public Integer getId_product_segment_id() {
        return id_product_segment_id;
    }

    public void setId_product_segment_id(Integer id_product_segment_id) {
        this.id_product_segment_id = id_product_segment_id;
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
        return "Category [id=" + id + ", id_product_category_id="+ id_product_category_id +", id_product_segment_id=" + id_product_segment_id + ", name=" + name + ",  active=" + active + ", language_code="+ language_code +", country_code=" + country_code +"]";
    }
}
