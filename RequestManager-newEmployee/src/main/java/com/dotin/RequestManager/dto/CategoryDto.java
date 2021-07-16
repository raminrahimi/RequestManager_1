package com.dotin.RequestManager.dto;

public class CategoryDto extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "CategoryDto{" +
                ", name='" + name + '\'' +
                '}';
    }
}
