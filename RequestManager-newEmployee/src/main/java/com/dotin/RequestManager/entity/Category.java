package com.dotin.RequestManager.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_category")
public class Category extends BaseEntity {
    @Column(name = "c_name")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}