package com.challenge.controllers;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.entity.User;
import com.challenge.service.impl.CandidateService;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<Candidate> findById(@PathVariable Long userId, @PathVariable Long accelerationId, @PathVariable Long companyId) {
        Optional<Candidate> candidate = candidateService.findById(userId, companyId, accelerationId);
        return ResponseEntity.ok().body(candidate.get());
    }

    @GetMapping(params = "companyId")
    public List<Candidate> findByCompanyId(@RequestParam Long companyId){
        return candidateService.findByCompanyId(companyId);
    }

    @GetMapping("accelerationId")
    public List<Candidate> findByAccelerationId(@RequestParam Long accelerationId){
        return candidateService.findByAccelerationId(accelerationId);
    }
}
