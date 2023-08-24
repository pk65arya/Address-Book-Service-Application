package com.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "FirstName name is Invalid")
    @NotEmpty(message = "FirstName  cannot be null")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "LastName name is Invalid")
    @NotEmpty(message = "LastName name cannot be null")
    public String lastName;

    @NotEmpty(message = "Address should not be empty")
    public String address;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "City name is Invalid")
    @NotEmpty(message = "City name  cannot be null")
    public String city;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "state name is Invalid")
    @NotEmpty(message = "State name  cannot be null")
    public String state;

    @Pattern(regexp = "^[0-9]{3}[\\\\s]*[0-9]{2,}$", message = "Zip name is invalid")
    @NotEmpty(message = "Zip code must not be null")
    public String zip;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", message = "phonenumber is invalid")
    @NotEmpty(message = "phone number is not empty")
    public String phone;

    @Pattern(regexp = "^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}$", message = "email is invalid")
    @NotEmpty(message = "email should not be empty")
    public String email;
}
