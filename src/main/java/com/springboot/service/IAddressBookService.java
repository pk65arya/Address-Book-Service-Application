package com.springboot.service;

import com.springboot.dto.AddressBookDTO;
import com.springboot.model.PersonDetails;

import java.util.List;

public interface IAddressBookService {
    List<PersonDetails> getAddressbookData();

    PersonDetails getAddressbookDataById(int personId);

    PersonDetails createAddressbookData(AddressBookDTO addressbookDTO);

    PersonDetails updateAddressbookData(int personId, AddressBookDTO addressbookDTO);

    void deleteAddressbookData(int personId);
}
