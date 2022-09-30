package com.example.addressbook.Respository;


import com.example.addressbook.Model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepo extends JpaRepository<AddressBookData, Integer> {
    List<AddressBookData> findDataByCity(String city);

    @Query(value = "SELECT * FROM addressBook.address_book_data order by city;", nativeQuery = true)
    List<AddressBookData> sortByCity();

    @Query(value = "SELECT * FROM addressBook.address_book_data order by name", nativeQuery = true)
    List<AddressBookData> sortByName();
}
