package com.challenge.controllers;

import com.challenge.dto.CandidateDTO;
import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.entity.User;
import com.challenge.service.impl.SubmissionService;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;


    @RequestMapping(method= RequestMethod.GET)
    public List<Submission> findByChallengeIdAndAccelerationId(SubmissionDTO objDTO, CandidateDTO candidateDTO){
        return submissionService.findByChallengeIdAndAccelerationId(objDTO.getChallengeId(), candidateDTO.getAccelerationId());
    }
}
