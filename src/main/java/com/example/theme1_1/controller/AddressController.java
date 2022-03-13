package com.example.theme1_1.controller;

import com.example.theme1_1.domains.Address;
import com.example.theme1_1.dtos.AddressCreateDto;
import com.example.theme1_1.repository.AddressRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Saydali Murodullayev, Sun 6:11 PM. 3/13/2022
 */
@RestController
@RequestMapping(value = "/address")
public record AddressController(AddressRepo repository) {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public HttpEntity<?> create(@RequestBody AddressCreateDto dto) {
        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setHomeNumber(dto.getHomeNumber());
        repository.save(address);
        return ResponseEntity.ok("success");
    }

}
