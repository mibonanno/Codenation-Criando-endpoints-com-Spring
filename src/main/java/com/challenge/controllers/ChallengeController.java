package com.challenge.controllers;

import com.challenge.entity.Challenge;
import com.challenge.entity.User;
import com.challenge.service.impl.ChallengeService;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;


    @GetMapping(params = {"accelerationId", "userId"})
    public ResponseEntity<List<Challenge>> findByAccelerationIdAndUserId(@RequestParam Long accelerationId,
                                                                         @RequestParam Long userId) {
        List<Challenge> challenges = challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
        return ResponseEntity.ok().body(challenges);
    }
}
