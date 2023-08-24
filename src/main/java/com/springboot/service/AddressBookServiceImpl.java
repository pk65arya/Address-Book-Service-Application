package com.springboot.service;

import com.springboot.dto.AddressBookDTO;
import com.springboot.model.PersonDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements IAddressBookService {
    List<PersonDetails> personDetailsList=new ArrayList<>();
    @Override
    public List<PersonDetails> getAddressbookData() {

        return personDetailsList;
    }

    @Override
    public PersonDetails getAddressbookDataById(int personId) {
       PersonDetails personDetails=null;
       personDetails=personDetailsList.get(personId -1);
        return personDetails;
    }

    @Override
    public PersonDetails createAddressbookData(AddressBookDTO addressbookDTO) {
        PersonDetails personDetails = null;
       personDetails=new PersonDetails(personDetailsList.size() +1,addressbookDTO);
       personDetailsList.add(personDetails);
        return personDetails;
    }

    @Override
    public PersonDetails updateAddressbookData(int personId, AddressBookDTO addressbookDTO) {

       PersonDetails personDetails=this.getAddressbookDataById(personId);
       personDetails.setName(addressbookDTO.name);
       personDetails.setPhNumber(addressbookDTO.phNumber);
       personDetailsList.set(personId -1,personDetails);
        return personDetails;
    }

    @Override
    public void deleteAddressbookData(int personId) {
        int i=1;
        personDetailsList.remove(personId -1);
        for (PersonDetails personDetails:personDetailsList){
            personDetails.setPersonId(i++);
        }

    }
}
