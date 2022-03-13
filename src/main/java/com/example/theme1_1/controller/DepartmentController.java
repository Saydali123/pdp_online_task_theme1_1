package com.example.theme1_1.controller;

import com.example.theme1_1.domains.Address;
import com.example.theme1_1.domains.Company;
import com.example.theme1_1.domains.Department;
import com.example.theme1_1.dtos.CompanyCreateDto;
import com.example.theme1_1.dtos.DepartmentCreateDto;
import com.example.theme1_1.repository.CompanyRepo;
import com.example.theme1_1.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Saydali Murodullayev, Sun 6:06 PM. 3/13/2022
 */
@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    private final CompanyRepo companyRepo;
    private final DepartmentRepo departmentRepo;

    public DepartmentController(CompanyRepo companyRepo, DepartmentRepo departmentRepo) {
        this.companyRepo = companyRepo;
        this.departmentRepo = departmentRepo;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public HttpEntity<?> create(@RequestBody DepartmentCreateDto dto) {
        String name = dto.getName();
        Integer company_id = dto.getCompany_id();

        Department department = new Department();
        department.setName(name);

        Optional<Company> byId = companyRepo.findById(company_id);
        byId.ifPresent(department::setCompany);

        departmentRepo.save(department);

        return ResponseEntity.ok("success");
    }

}
