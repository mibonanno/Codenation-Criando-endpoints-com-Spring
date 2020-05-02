package com.challenge.controllers;

import com.challenge.entity.Company;
import com.challenge.entity.User;
import com.challenge.service.impl.CompanyService;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        Optional<Company> company = companyService.findById(id);
        return ResponseEntity.ok().body(company.get());
    }

    @GetMapping(params = "accelerationId")
    public List<Company> findByAccelerationName(@RequestParam Long accelerationId) {
        return companyService.findByAccelerationId(accelerationId);
    }

    @GetMapping(params = "userId")
    public List<Company> findByUserId(@RequestParam Long userId) {
        return companyService.findByUserId(userId);
    }
}
