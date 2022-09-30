package com.example.addressbook.Model;

import com.example.addressbook.Dto.AddressBookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookData {
    String name;
    String email;
    String country;
    String city;
    String message;

    Integer zip;
    Long phoneNumber;
    String state;

    public AddressBookData(String message) {
        this.message = message;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    public AddressBookData(AddressBookDto addressBookDto) {
        this.id = id;
        this.name = addressBookDto.getName();
        this.city = addressBookDto.getCity();
        this.message = addressBookDto.getMessage();
        this.country = addressBookDto.getCountry();
        this.email = addressBookDto.getEmail();
        this.zip = addressBookDto.getZip();
        this.state = addressBookDto.getState();
        this.phoneNumber = addressBookDto.getPhoneNumber();
    }
}







