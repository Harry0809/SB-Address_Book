package com.example.addressbook.Service;


import com.example.addressbook.Dto.AddressBookDto;
import com.example.addressbook.ExceptionHandling.AddressBookException;
import com.example.addressbook.Model.AddressBookData;
import com.example.addressbook.Respository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookInterface {
    @Autowired
    AddressBookRepo addressBookRepo;

    public Object saveAll(AddressBookDto addressBookDto) {
        AddressBookData addressBookData = new AddressBookData(addressBookDto);
        return addressBookRepo.save(addressBookData);
    }

    @Override
    public List<AddressBookData> display() {
        return addressBookRepo.findAll();
    }

    public AddressBookData findById(int id) {
        return addressBookRepo.findById(id).
                orElseThrow(() -> new AddressBookException("Address book data wit id =" + id + " " + "is not founded"));
    }

    @Override
    public AddressBookData UpdateById(int id, AddressBookDto addressBookDto) {
        Optional<AddressBookData> addressBookData = addressBookRepo.findById(id);
        if (addressBookData.isPresent()) {
            addressBookData.get().setCity(addressBookDto.getCity());
            addressBookData.get().setCountry(addressBookDto.getCountry());
            addressBookData.get().setMessage(addressBookDto.getMessage());
            addressBookData.get().setPhoneNumber(addressBookDto.getPhoneNumber());
            addressBookData.get().setState(addressBookDto.getState());
            addressBookData.get().setName(addressBookDto.getName());
            addressBookData.get().setZip(addressBookDto.getZip());
            addressBookData.get().setEmail(addressBookDto.getEmail());
            addressBookRepo.save(addressBookData.get());
            return addressBookData.get();
        } else {
            throw new AddressBookException("Address book data with id = " + id + " " + " is not founded.");
        }
    }

    public Boolean deleteById(int id) {
        Optional<AddressBookData> addressBookData = addressBookRepo.findById(id);
        if (addressBookData.isPresent()) {
            addressBookRepo.deleteById(id);
            return true;
        } else {
            throw new AddressBookException("Data with id = " + id + " " + "is not founded");
        }
    }

    @Override
    public List<AddressBookData> findByCity(String city) {
        List<AddressBookData> addressBookData = addressBookRepo.findDataByCity(city);
        if (addressBookData.isEmpty()) {
            throw new AddressBookException("City not founded");
        } else {
            return addressBookData;
        }
    }

    public List<AddressBookData> sortByCity() {
        List<AddressBookData> addressBookData = addressBookRepo.sortByCity();
        return addressBookData;
    }

    public List<AddressBookData>sortByName(){
        List<AddressBookData> addressBookData = addressBookRepo.sortByName();
        return addressBookData;
    }
}

