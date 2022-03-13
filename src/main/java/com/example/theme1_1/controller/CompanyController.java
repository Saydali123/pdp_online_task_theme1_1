package com.example.theme1_1.controller;

import com.example.theme1_1.domains.Address;
import com.example.theme1_1.domains.Company;
import com.example.theme1_1.dtos.AddressCreateDto;
import com.example.theme1_1.dtos.CompanyCreateDto;
import com.example.theme1_1.repository.AddressRepo;
import com.example.theme1_1.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Saydali Murodullayev, Sun 5:47 PM. 3/13/2022
 */
@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    private final AddressRepo addressRepo;
    private final CompanyRepo companyRepo;

    public CompanyController(AddressRepo addressRepo, CompanyRepo companyRepo) {
        this.addressRepo = addressRepo;
        this.companyRepo = companyRepo;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public HttpEntity<?> create(@RequestBody CompanyCreateDto dto) {

        Company company = new Company();
        company.setCorpName(dto.getCorpName());
        company.setDirectorName(dto.getDirectorName());

        Integer address_id = dto.getAddress_id();
        Optional<Address> byId = addressRepo.findById(address_id);
        byId.ifPresent(company::setAddress);

        companyRepo.save(company);
        return ResponseEntity.ok("success");
    }

}
