package com.modena.model;

import javax.persistence.*;


@Entity
@Table(name = "master_sub_categories")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Integer active;

    @Column(name = "position")
    private Integer position;

    @Column(name = "master_category_id")
    private Integer categoryid;


    public Subcategory() {

    }

    public Subcategory(String name, Integer active, Integer position, Integer categoryid) {
        this.name = name;
        this.active = active;
        this.position = position;
        this.categoryid = categoryid;
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

    public Integer getCategoryid(){
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid= categoryid;
    }



    @Override
    public String toString() {
        return "Subcategory [id=" + id + ", name=" + name + ",  active=" + active + ", position=" + position + ", categoryid=" + categoryid + "]";
    }
}
