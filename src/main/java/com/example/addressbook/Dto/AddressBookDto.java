package com.example.addressbook.Dto;

public class AddressBookDto {
    String Name;
    String City;
    Long phoneNumber;
    Integer zip;
    String country;
    String email;

    public AddressBookDto(String name, String city, Long phoneNumber, Integer zip, String country, String email) {
        Name = name;
        City = city;
        this.phoneNumber = phoneNumber;
        this.zip = zip;
        this.country = country;
        this.email = email;
    }
}
