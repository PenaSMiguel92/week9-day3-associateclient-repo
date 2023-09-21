package com.associateclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.associateclient.entity.Associate;
import com.associateclient.service.AssociateService;

@RestController
@RequestMapping("/associates")
public class AssociateController {
    @Autowired
    private AssociateService associateService;

    @PostMapping
    public String addStudent(@RequestBody Associate associate) {
        return associateService.saveAssociate(associate);
    }

    @GetMapping
    public List<Associate> showStudents() {
        return associateService.getAssociate();
    }
}
