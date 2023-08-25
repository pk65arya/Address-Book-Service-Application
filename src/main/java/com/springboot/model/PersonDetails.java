package com.springboot.model;

import com.springboot.dto.AddressBookDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contact-table")
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public PersonDetails(int personId, AddressBookDTO addressBookDTO) {
        this.personId = personId;
        this.updateAddressBookdata(addressBookDTO);
    }
public PersonDetails(){

}
    public void updateAddressBookdata(AddressBookDTO addressbookDTO) {
        this.firstName = addressbookDTO.firstName;
        this.lastName = addressbookDTO.lastName;
        this.address = addressbookDTO.address;
        this.city = addressbookDTO.city;
        this.state = addressbookDTO.state;
        this.zip = addressbookDTO.zip;
        this.phone = addressbookDTO.phone;
        this.email = addressbookDTO.email;

    }
}