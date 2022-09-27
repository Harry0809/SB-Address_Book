package com.example.addressbook.Controller;

import com.example.addressbook.Model.AddressBookData;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;

@RestController
public class AddressBookController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello From Bridgelabz";
    }

    //UC2_UsingQuery

    @GetMapping(value = "/query")
    public String Get(@RequestParam(value = "name") String name) {
        return "hello" + name;
    }


    @GetMapping(value = "/param/{name}")
    public String helloParam(@PathVariable String name) {
        return "hello" + name;
    }

    @PostMapping("/post")
    public String hello(@RequestBody AddressBookData addressBookData) {
        return "hello" + addressBookData.getName() + addressBookData.getCity() + addressBookData.getCountry() + addressBookData.getEmail() + addressBookData.getZip() + addressBookData.getMessage();
    }


    @PutMapping("/put/{firstName}")
    public String hello(@PathVariable String country, @RequestParam(value = "lastName") String city) {
        return "hello" + country + " " + city + " ";
    }
}