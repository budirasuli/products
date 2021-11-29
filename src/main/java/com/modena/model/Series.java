package com.modena.model;

import javax.persistence.*;

@Entity
@Table(name = "master_series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Integer active;

    @Column(name = "position")
    private Integer position;

    public Series() {

    }

    public Series(String name, Integer active, Integer position) {
        this.name = name;
        this.active = active;
        this.position = position;
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



    @Override
    public String toString() {
        return "Series [id=" + id + ", name=" + name + ",  active=" + active + ", position=" + position +"]";
    }
}
