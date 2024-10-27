package com.example.wjug.controller;

import com.example.wjug.entity.Claim;
import com.example.wjug.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClaimController {
    @Autowired
    private ClaimRepository claimRepository;

    @GetMapping("/claims")
    public List<Claim> getUsers() {
        return claimRepository.findAll();
    }
}
