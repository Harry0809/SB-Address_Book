package com.example.addressbook.Model;

public class AddressBookData {

    String name;
    String city;
    Long phoneNumber;
    Integer zip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    String country;
    String email;
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AddressBookData() {
    }

    public AddressBookData(String name, String city, Long phoneNumber, Integer zip, String country, String email, String message) {
        this.name = name;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.zip = zip;
        this.country = country;
        this.email = email;
    }



    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}