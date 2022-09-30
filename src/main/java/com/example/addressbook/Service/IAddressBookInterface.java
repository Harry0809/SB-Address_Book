package com.example.addressbook.Service;

import com.example.addressbook.Dto.AddressBookDto;
import com.example.addressbook.Model.AddressBookData;

import java.util.List;
import java.util.Optional;

public interface IAddressBookInterface {
    AddressBookData findById(int id);

    Object saveAll(AddressBookDto addressBookDto);

    Object display();

    AddressBookData UpdateById(int id, AddressBookDto addressBookDto);

    Boolean deleteById(int id);

    List<AddressBookData> findByCity(String city);

    List<AddressBookData> sortByCity();

    List<AddressBookData> sortByName();
}
