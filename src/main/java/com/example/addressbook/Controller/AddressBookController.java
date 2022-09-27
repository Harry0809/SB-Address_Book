package com.example.addressbook.Controller;

import com.example.addressbook.Model.AddressBookData;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;

public class AddressBookController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello From Bridgelabz";
    }


    @GetMapping(value = "/query")
    public String hello(@RequestParam(value = "name") String name) {
        return "hello" + name;
    }
    @GetMapping(value = "/param/{name}")
    public String helloParam(@PathVariable String name) {
        return "hello" + name;
    }


    @PostMapping("/post")
    public String hello(@RequestBody AddressBookData addressBookData) {
        return "hello" + addressBookData.getName() + " " + addressBookData.getCity();
    }

    //UC5_PutMapping

    @PutMapping("/put/{firstName}")
    public String hello(@PathVariable String Name, @RequestParam(value = "lastName") String City) {
        return "hello" + Name + " " + City + " ";
    }


}
