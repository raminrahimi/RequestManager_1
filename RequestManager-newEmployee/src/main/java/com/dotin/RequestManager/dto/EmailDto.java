package com.dotin.RequestManager.dto;

import java.util.Set;

public class EmailDto extends BaseEntity {

    private String subject;
    private String description;
    private Long senderId;
    private Set<Long> receiverId;



    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Set<Long> getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Set<Long> receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public String toString() {
        return "EmailDto{" +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                '}';
    }
}
