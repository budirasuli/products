package com.modena.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "master_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "id_product", nullable = false)
    private Integer id_product;

    @Column(name = "id_product_sub_category_id", nullable = false)
    private Integer id_product_sub_category_id;

    @Column(name = "id_product_category_id", nullable = false)
    private Integer id_product_category_id;

    @Column(name = "id_product_segment_id", nullable = false)
    private Integer id_product_segment_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "sku", nullable = false)
    private String sku;
    
    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "active", nullable = false)
    private Integer active;

    @Column(name = "sort", nullable = false)
    private Integer sort;

    @Column(name = "country_code", nullable = false)
    private String country_code;

    @Column(name = "language_code", nullable = false)
    private String language_code;
 
    @Column(name = "image", nullable = false)
    private String image;

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

    public Product(){

    }

    public Product(
        Integer id_product, 
        Integer id_product_sub_category_id, 
        Integer id_product_category_id, 
        Integer id_product_segment_id, 
        String name, 
        String description,
        String type, 
        String sku, 
        Integer active,
        String country_code, 
        String language_code, 
        Integer sort, 
        String image
    )
    {
        this.id_product = id_product;
        this.id_product_sub_category_id = id_product_sub_category_id;
        this.id_product_category_id = id_product_category_id;
        this.id_product_segment_id = id_product_segment_id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.type = type;
        this.sku = sku;
        this.country_code = country_code;
        this.language_code = language_code;
        this.sort = sort;
        this.image = image;

    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getId_product() {
        return this.id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public Integer getId_product_sub_category_id() {
        return this.id_product_sub_category_id;
    }

    public void setId_product_sub_category_id(Integer id_product_sub_category_id) {
        this.id_product_sub_category_id = id_product_sub_category_id;
    }

    public Integer getId_product_category_id() {
        return this.id_product_category_id;
    }

    public void setId_product_category_id(Integer id_product_category_id) {
        this.id_product_category_id = id_product_category_id;
    }

    public Integer getId_product_segment_id() {
        return this.id_product_segment_id;
    }

    public void setId_product_segment_id(Integer id_product_segment_id) {
        this.id_product_segment_id = id_product_segment_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCountry_code() {
        return this.country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getLanguage_code() {
        return this.language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return this.deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
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
 
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
    }
}
