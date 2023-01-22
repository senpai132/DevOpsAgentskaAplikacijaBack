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

import com.DevOps2022.agentapplication.helper.dto.CompanyDTO;
import com.DevOps2022.agentapplication.helper.mappers.CompanyMapper;
import com.DevOps2022.agentapplication.services.CompanyService;

@RestController
@CrossOrigin
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    CompanyService companyService;

    private CompanyMapper companyMapper;

    @PostMapping("/register")
    public ResponseEntity<String> sendCompanyRegistrationRequest(@RequestBody CompanyDTO dto)
    {
        try {
            return new ResponseEntity<String>(companyService.addCompany(companyMapper.toEntity(dto)), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getbyname/{name}")
    public ResponseEntity<CompanyDTO> getCompanyByName(@PathVariable String name)
    {
        try {
            return new ResponseEntity<CompanyDTO>(companyMapper.toDto(companyService.getCompanyByName(name)), 
                HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<CompanyDTO>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies()
    {
        return new ResponseEntity<List<CompanyDTO>>(companyMapper.toDtoList(companyService.getAllCompanies()), 
            HttpStatus.OK);
    }

    @GetMapping("/getpending")
    public ResponseEntity<List<CompanyDTO>> getAllPendingCompanies()
    {
        return new ResponseEntity<List<CompanyDTO>>(companyMapper.toDtoList(companyService.getAllPending()), 
            HttpStatus.OK);
    }

    @GetMapping("/getowned/{owner}")
    public ResponseEntity<List<CompanyDTO>> getAllOwnedCompanies(@PathVariable String owner)
    {
        return new ResponseEntity<List<CompanyDTO>>(companyMapper.toDtoList(companyService.getAllOwned(owner)),
                HttpStatus.OK);
    }

    @GetMapping("/getnotowned/{owner}")
    public ResponseEntity<List<CompanyDTO>> getAllNotOwnedCompanies(@PathVariable String owner)
    {
        return new ResponseEntity<List<CompanyDTO>>(companyMapper.toDtoList(companyService.getAllNotOwned(owner)),
                HttpStatus.OK);
    }

    @PutMapping("/edit/{name}")
    public ResponseEntity<String> editCompany(@PathVariable String name, @RequestBody CompanyDTO dto)
    {
        try {
            return new ResponseEntity<String>(companyService.editCompany(companyMapper.toEntity(dto), name), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/requestresponse/{name}/{response}")
    public ResponseEntity<Boolean> respondToCompanyRegistrationRequest(@PathVariable String name, 
        @PathVariable int response)
    {
        try {
            return new ResponseEntity<Boolean>(companyService.approveCompanyRegistrationRequest(name, response), 
                HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteCompany(@PathVariable String name)
    {
        try {
            return new ResponseEntity<String>(companyService.deleteCompany(name), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public CompanyController() {
        this.companyMapper = new CompanyMapper();
    }
}
