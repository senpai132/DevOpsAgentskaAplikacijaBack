package com.DevOps2022.agentapplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevOps2022.agentapplication.model.JobOpening;
import com.DevOps2022.agentapplication.repositories.JobOpeningRepository;

@Service
public class JobOpeningService {
    
    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    public String addJobOpening(JobOpening job) {
        jobOpeningRepository.save(job);
        return "Job opening added successfully.";
    }

    public String editJobOpening(JobOpening new_job, int id) throws Exception{
        Optional<JobOpening> job = jobOpeningRepository.findById(id);
        if(job.get() == null)
            throw new Exception("Job opening not found");

        job.get().setDescription(new_job.getDescription());
        job.get().setTitle(new_job.getTitle());
        job.get().setSeniority(new_job.getSeniority());

        jobOpeningRepository.save(job.get());

        return "Job opening edited successfully.";
    }

    public String deleteJobOpening(int id) throws Exception {
        Optional<JobOpening> job = jobOpeningRepository.findById(id);
        if(job.get() == null)
            throw new Exception("Job opening not found");

        jobOpeningRepository.delete(job.get());

        return "Job opening deleted successfully.";
    }

    public List<JobOpening> getJobOpeningByCompany(String company) {
        return  jobOpeningRepository.findByCompany(company);
    }
}