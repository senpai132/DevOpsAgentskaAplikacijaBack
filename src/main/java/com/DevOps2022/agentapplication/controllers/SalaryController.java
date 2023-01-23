package com.DevOps2022.agentapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DevOps2022.agentapplication.helper.dto.SalaryDTO;
import com.DevOps2022.agentapplication.helper.mappers.SalaryMapper;
import com.DevOps2022.agentapplication.services.SalaryService;

@RestController
@CrossOrigin
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    private SalaryMapper salaryMapper;

    @PostMapping("/add")
    public ResponseEntity<String> addSalary(@RequestBody SalaryDTO dto)
    {
        return new ResponseEntity<String>(salaryService.addSalary(salaryMapper.toEntity(dto)), 
            HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSalary(@PathVariable Integer id)
    {
        try {
                return new ResponseEntity<String>(salaryService.deleteSalary(id), 
                    HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> deleteSalary(@PathVariable Integer id, @RequestBody SalaryDTO dto)
    {
        try {
                return new ResponseEntity<String>(salaryService.editSalary(salaryMapper.toEntity(dto), id), 
                    HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
    }

    @GetMapping("/getbycompany/{company}")
    public ResponseEntity<List<SalaryDTO>> getSalariesByCompany(@PathVariable String company)
    {
        return new ResponseEntity<List<SalaryDTO>>(salaryMapper.toDtoList(salaryService.getSalaryReviewsByCompany(company)), 
            HttpStatus.OK);
    }

    public SalaryController() {
        this.salaryMapper = new SalaryMapper();
    }
}
