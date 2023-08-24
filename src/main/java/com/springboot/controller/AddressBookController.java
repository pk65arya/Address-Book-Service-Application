package com.springboot.controller;

import com.springboot.dto.AddressBookDTO;
import com.springboot.dto.ResponseDTO;
import com.springboot.model.PersonDetails;
import com.springboot.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    IAddressBookService addressBookService;
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressbookData() {
        List<PersonDetails> personDetailsList=null;
        personDetailsList=addressBookService.getAddressbookData();
        ResponseDTO responseDTO=new ResponseDTO("Get Call Success",personDetailsList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable(value = "personId") int personId) {
       PersonDetails personDetails=null;
       personDetails=addressBookService.getAddressbookDataById(personId);
       ResponseDTO responseDTO=new ResponseDTO("Get call success for Id",personDetails);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@RequestBody AddressBookDTO addressbookDTO) {

  PersonDetails personDetails=null;
  personDetails=addressBookService.createAddressbookData(addressbookDTO);
  ResponseDTO responseDTO=new ResponseDTO("created AddressBokk details successfully",addressbookDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@PathVariable int personId, @RequestBody AddressBookDTO addressbookDTO) {
        PersonDetails personDetails=null;
        personDetails=addressBookService.updateAddressbookData(personId,addressbookDTO);
        ResponseDTO responseDTO=new ResponseDTO("updated AddressBook",personDetails);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("personId") int personId) {
       addressBookService.deleteAddressbookData(personId);
       ResponseDTO responseDTO=new ResponseDTO("delete data successfully","person id: "+personId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
