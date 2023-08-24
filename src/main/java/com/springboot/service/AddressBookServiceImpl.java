package com.springboot.service;

import com.springboot.dto.AddressBookDTO;
import com.springboot.model.PersonDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements IAddressBookService {
    @Override
    public List<PersonDetails> getAddressbookData() {
        List<PersonDetails> addressbookDataList = new ArrayList<>();
        addressbookDataList.add(new PersonDetails(1, new AddressBookDTO("Kishlay", "7057082582")));
        return addressbookDataList;
    }

    @Override
    public PersonDetails getAddressbookDataById(int personId) {
        PersonDetails personDetails = null;
        personDetails = new PersonDetails(personId, new AddressBookDTO("Kishan", "1234567890"));
        return personDetails;
    }

    @Override
    public PersonDetails createAddressbookData(AddressBookDTO addressbookDTO) {
        PersonDetails personDetails = null;
        personDetails = new PersonDetails(1,addressbookDTO);
        return personDetails;
    }

    @Override
    public PersonDetails updateAddressbookData(int personId, AddressBookDTO addressbookDTO) {
        PersonDetails personDetails = null;
        personDetails = new PersonDetails(personId, addressbookDTO);
        return personDetails;
    }

    @Override
    public void deleteAddressbookData(int personId) {

    }
}
