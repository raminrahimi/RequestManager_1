package com.dotin.RequestManager.entity;
import javax.persistence.*;
@Entity
@Table(name = "t_categoryElement")
public class CategoryElement extends BaseEntity {
    @Column(name = "c_code")
    private Long code;
    @Column(name = "c_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "c_category")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
