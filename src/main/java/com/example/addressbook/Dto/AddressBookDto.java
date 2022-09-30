package com.example.addressbook.Dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDto {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Name must be valid")
    String name;
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter valid Email")
    String email;
    String country;
    @NotEmpty(message = "city name must be there")
    String city;
    String message;
    @NotNull(message = "zip can not be empty")
    Integer zip;
    //@Pattern(regexp = "(91-)?[0-9]{10}", message="Enter a valid phone number")
    Long phoneNumber;
    @NotEmpty(message = "State name must be there")
    String state;

}