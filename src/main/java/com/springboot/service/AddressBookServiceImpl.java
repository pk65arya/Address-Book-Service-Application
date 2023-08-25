package com.springboot.service;

import com.springboot.dto.AddressBookDTO;
import com.springboot.exception.AddressBookException;
import com.springboot.model.PersonDetails;
import com.springboot.repository.AddressBookRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookServiceImpl implements IAddressBookService {
    @Autowired
    AddressBookRepo addressBookRepo;
    List<PersonDetails> personDetailsList=new ArrayList<>();
    @Override
    public List<PersonDetails> getAddressbookData() {

        return addressBookRepo.findAll();
    }

    @Override
    public PersonDetails getAddressbookDataById(int personId) {
      return personDetailsList.stream().filter(personDetails -> personDetails.getPersonId()==personId).findFirst().orElseThrow(()->new AddressBookException("Person not found"));
    }

    @Override
    public PersonDetails createAddressbookData(AddressBookDTO addressbookDTO) {
        PersonDetails personDetails = null;
       personDetails=new PersonDetails(personDetailsList.size() +1,addressbookDTO);
        log.debug("AddressbookData: "+personDetails.toString());
       personDetailsList.add(personDetails);
        return addressBookRepo.save(personDetails);
    }

    @Override
    public PersonDetails updateAddressbookData(int personId, AddressBookDTO addressbookDTO) {

       PersonDetails personDetails=this.getAddressbookDataById(personId);
      personDetails.updateAddressBookdata(addressbookDTO);
       personDetailsList.set(personId -1,personDetails);
        return addressBookRepo.save(personDetails);
    }

    @Override
    public void deleteAddressbookData(int personId) {

        addressBookRepo.deleteById(personId);


    }
}
