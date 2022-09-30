package com.example.addressbook.Controller;

import com.example.addressbook.Dto.AddressBookDto;
import com.example.addressbook.Dto.ResponseDto;
import com.example.addressbook.Model.AddressBookData;
import com.example.addressbook.Service.IAddressBookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressBookController {

    @Autowired
    IAddressBookInterface iAddressBookInterface;

    @GetMapping("/get")
    public String getMessage() {
        return "Welcome to address book";
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> saveData(@Valid @RequestBody AddressBookDto addressBookDto) {
        ResponseDto responseDto = new ResponseDto("Data saved succeessfully", iAddressBookInterface.saveAll(addressBookDto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/data")
    public ResponseEntity<ResponseDto> getall() {
        ResponseDto responseDto = new ResponseDto("Data displayed", iAddressBookInterface.display());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable int id) {
        AddressBookData addressBookData = iAddressBookInterface.findById(id);
        ResponseDto responseDto = new ResponseDto("Data Founded", addressBookData);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateById(@Valid @RequestBody AddressBookDto addressBookDto, @PathVariable int id) {
        AddressBookData addressBookData = iAddressBookInterface.UpdateById(id, addressBookDto);
        ResponseDto responseDto = new ResponseDto("Data updated succesfully", addressBookData);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable int id) {
        Boolean addressBookData = iAddressBookInterface.deleteById(id);
        String message = addressBookData ? "ID deleted succesfully" : "ID not founded";
        ResponseDto responseDto = new ResponseDto(message);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/search/{city}")
    public ResponseEntity<ResponseDto> findByCity(@PathVariable String city) {
        List<AddressBookData> addressBookDataList;
        addressBookDataList = iAddressBookInterface.findByCity(city);
        ResponseDto responseDto = new ResponseDto("Data founded by city name", addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping(value = {"/city"})
    public ResponseEntity<ResponseDto> sortByCity() {
        List<AddressBookData> addressBookDataList = iAddressBookInterface.sortByCity();
        ResponseDto responseDto = new ResponseDto("Address data sorted by city", addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

    }

    @GetMapping(value = {"/name"})
    public ResponseEntity<ResponseDto> sortByName() {
        List<AddressBookData> addressBookDataList = iAddressBookInterface.sortByName();
        ResponseDto responseDto = new ResponseDto("Address data sorted by Name", addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

    }
}

