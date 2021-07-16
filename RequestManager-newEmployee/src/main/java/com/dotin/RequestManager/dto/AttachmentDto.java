package com.dotin.RequestManager.dto;

public class AttachmentDto extends BaseEntity {
    private String fileName;
    private Long emailId;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "AttachmentDto{" +
                ", fileName='" + fileName + '\'' +
                ", emailId=" + emailId +
                '}';
    }
}
