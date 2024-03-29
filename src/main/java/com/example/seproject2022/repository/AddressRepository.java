package com.example.seproject2022.repository;

import com.example.seproject2022.model.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findAllByStreetAndNumberAndCityAndCountyAndCountryAndPostCode(String street,
                                                                          String number,
                                                                          String city,
                                                                          String county,
                                                                          String country,
                                                                          String postCode);
}
