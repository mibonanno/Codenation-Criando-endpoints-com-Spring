package com.challenge.controllers;

import com.challenge.entity.Acceleration;
import com.challenge.entity.User;
import com.challenge.service.impl.AccelerationService;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;


    @GetMapping("/{id}")
    public ResponseEntity<Acceleration> findById(@PathVariable Long id) {
        Optional<Acceleration> acceleration = accelerationService.findById(id);
        return ResponseEntity.ok().body(acceleration.get());
    }

    @GetMapping(params = "companyId")
    public List<Acceleration> findByCompanyId(@RequestParam Long companyId) {
        return accelerationService.findByCompanyId(companyId);
    }
}
