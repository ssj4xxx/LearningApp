package com.khoalt.PhoneBook;

public class PhoneEntry {
    private String phoneNumber;
    private String contactName;

    public PhoneEntry() {
    }

    public PhoneEntry(String contactName, String phoneNumber){
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName(){
        return contactName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setContactName(String contactName){
        this.contactName = contactName;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "Ten: " + this.contactName + "\t" + "So dien thoai: " + this.phoneNumber;
    }
}
