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

import com.DevOps2022.agentapplication.helper.dto.JobOpeningDTO;
import com.DevOps2022.agentapplication.helper.mappers.JobOpeningMapper;
import com.DevOps2022.agentapplication.services.JobOpeningService;

@RestController
@CrossOrigin
@RequestMapping("/jobopening")
public class JobOpeningController {
    @Autowired
    JobOpeningService jobOpeningService;

    private JobOpeningMapper jobOpeningMapper;

    @PostMapping("/add")
    public ResponseEntity<String> addJobOpening(@RequestBody JobOpeningDTO dto)
    {
        return new ResponseEntity<String>(jobOpeningService.addJobOpening(jobOpeningMapper.toEntity(dto)), 
            HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editJobOpening(@RequestBody JobOpeningDTO dto, @PathVariable Integer id)
    {
        try {
            return new ResponseEntity<String>(jobOpeningService.editJobOpening(jobOpeningMapper.toEntity(dto), id), 
                HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJobOpening(@PathVariable Integer id)
    {
        try {
            return new ResponseEntity<String>(jobOpeningService.deleteJobOpening(id), 
                HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/finbycompany/{company}")
    public ResponseEntity<List<JobOpeningDTO>> getAllByCompany(@PathVariable String company)
    {
        return new ResponseEntity<List<JobOpeningDTO>>(jobOpeningMapper.toDtoList(jobOpeningService.getJobOpeningByCompany(company)), 
            HttpStatus.OK);
    }


    public JobOpeningController() {
        this.jobOpeningMapper = new JobOpeningMapper();
    }
}
