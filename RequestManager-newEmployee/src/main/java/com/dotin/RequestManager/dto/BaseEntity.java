package com.dotin.RequestManager.dto;

public class BaseEntity {


    private Long Id;
    private Boolean disable;
    private Boolean active;
    private Integer version;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }


    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}