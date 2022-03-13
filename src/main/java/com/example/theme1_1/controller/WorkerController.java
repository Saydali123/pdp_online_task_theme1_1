package com.example.theme1_1.controller;

import com.example.theme1_1.domains.Address;
import com.example.theme1_1.domains.Company;
import com.example.theme1_1.domains.Department;
import com.example.theme1_1.domains.Worker;
import com.example.theme1_1.dtos.CompanyCreateDto;
import com.example.theme1_1.dtos.WorkerCreateDto;
import com.example.theme1_1.repository.AddressRepo;
import com.example.theme1_1.repository.CompanyRepo;
import com.example.theme1_1.repository.DepartmentRepo;
import com.example.theme1_1.repository.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Saydali Murodullayev, Sun 6:05 PM. 3/13/2022
 */
@RestController
@RequestMapping(value = "/worker")
public class WorkerController {

    private final AddressRepo addressRepo;
    private final DepartmentRepo departmentRepo;
    private final WorkerRepo workerRepo;

    public WorkerController(AddressRepo addressRepo, DepartmentRepo departmentRepo, WorkerRepo workerRepo) {
        this.addressRepo = addressRepo;
        this.departmentRepo = departmentRepo;
        this.workerRepo = workerRepo;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public HttpEntity<?> create(@RequestBody WorkerCreateDto dto) {

        Integer address_id = dto.getAddress_id();
        Integer department_id = dto.getDepartment_id();
        String phoneNumber = dto.getPhoneNumber();
        String name = dto.getName();

        Worker worker = new Worker();
        worker.setName(name);
        worker.setPhoneNumber(phoneNumber);

        Optional<Address> byId = addressRepo.findById(address_id);
        byId.ifPresent(worker::setAddress);

        Optional<Department> byId1 = departmentRepo.findById(department_id);
        byId1.ifPresent(worker::setDepartment);

        workerRepo.save(worker);

        return ResponseEntity.ok("success");
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public HttpEntity<?> getAll() {
        List<Worker> all = workerRepo.findAll();
        return ResponseEntity.ok(all);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public HttpEntity<?> get(@PathVariable Integer id) {
        Optional<Worker> byId = workerRepo.findById(id);
        return ResponseEntity.ok(byId.orElse(null));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public HttpEntity<?> delete(@PathVariable Integer id) {
        workerRepo.deleteById(id);
        return ResponseEntity.ok("success");
    }


}
