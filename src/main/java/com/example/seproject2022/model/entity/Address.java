package com.example.seproject2022.model.entity;

import com.example.seproject2022.model.dto.UpdateAddressRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address", catalog = "se_project_2022")
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String county;

    @Column(name = "country")
    private String country;

    @Column(name = "post_code")
    private String postCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.LAZY)
    private List<Account> accounts = new ArrayList<>();

    public Address(UpdateAddressRequestDto updateAddressRequestDto, long id) {
        this.id = id;
        this.street = updateAddressRequestDto.getStreet();
        this.number = updateAddressRequestDto.getNumber();
        this.city = updateAddressRequestDto.getCity();
        this.county = updateAddressRequestDto.getCounty();
        this.country = updateAddressRequestDto.getCountry();
        this.postCode = updateAddressRequestDto.getPostCode();
        this.accounts = null;
    }
}
