package com.dotin.RequestManager.dto;

public class CategoryElementDto extends BaseEntity {

    private Long code;
    private String name;
    private Long categoryId;


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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


    @Override
    public String toString() {
        return "CategoryElementDto{" +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
