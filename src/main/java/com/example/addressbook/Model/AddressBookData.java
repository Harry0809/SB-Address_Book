package com.example.addressbook.Model;

public class AddressBookData {

    String Name;
    String City;

    public AddressBookData() {
    }

    public AddressBookData(String name, String city) {
        Name = name;
        City = city;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}