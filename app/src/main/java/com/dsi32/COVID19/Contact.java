package com.dsi32.COVID19;

public class Contact {
    private String conatctId;
    private String contactName;
    private String contactAdress;
    private String contactMail;
    private String numberOfTimes;

    public Contact(String conatctId, String contactName, String contactAdress, String contactMail, String numberOfTimes) {
        this.conatctId = conatctId;
        this.contactName = contactName;
        this.contactAdress = contactAdress;
        this.contactMail = contactMail;
        this.numberOfTimes = numberOfTimes;
    }

    public Contact() {
    }

    public String getConatctId() {
        return conatctId;
    }

    public void setConatctId(String conatctId) {
        this.conatctId = conatctId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactAdress() {
        return contactAdress;
    }

    public void setContactAdress(String contactAdress) {
        this.contactAdress = contactAdress;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public String getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(String numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }
}
