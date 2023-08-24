package com.springboot.model;

import com.springboot.dto.AddressBookDTO;
import lombok.Data;

@Data
public class PersonDetails {
    private int personId;
    private String name;
    private String phNumber;
    public PersonDetails(int personId, AddressBookDTO addressBookDTO){
        this.personId=personId;
        this.name=addressBookDTO.name;
        this.phNumber=addressBookDTO.phNumber;
    }

}
