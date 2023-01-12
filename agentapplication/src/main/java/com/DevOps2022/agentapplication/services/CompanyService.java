package com.DevOps2022.agentapplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevOps2022.agentapplication.model.Company;
import com.DevOps2022.agentapplication.repositories.CompanyRespository;


@Service
public class CompanyService {
    
    @Autowired
    CompanyRespository companyRespository;

    public String addCompany(Company company) throws Exception{
        Company temp = companyRespository.findByName(company.getName());
        if(temp != null)
            throw new Exception("Company " + company.getName() + " already exists");

        company.setStatus(false);
        companyRespository.save(company);

        return "Request for company " + company.getName() + " sent successfully";
    }    

    public Company getCompanyByName(String name) throws Exception{
        Company company_local = companyRespository.findByName(name);
        if(company_local == null || company_local.getStatus() == false)
            throw new Exception("Could not find company by name " + name);
        
        return company_local;
    }

    public List<Company> getAllCompanies() { 
        return companyRespository.findByStatus(true);
    }

    public List<Company> getAllPending() {
        return companyRespository.findByStatus(false);
    }

    public List<Company> getAllOwned(String name) {
        return companyRespository.findByOwnerAndStatus(name, true);
    }

    public List<Company> getAllNotOwned(String name) {
        return companyRespository.findByOwnerNotAndStatus(name, true);
    }

    public String editCompany(Company company, String name) throws Exception {
        Company company_local = companyRespository.findByName(name);
        if(company_local == null || company_local.getStatus() == false)
            throw new Exception("Could not find company by name " + name);

        Company temp = companyRespository.findByName(company.getName());

        if(temp != null && !temp.getName().equals(name))
            throw new Exception("Company with given name already exists.");

        company_local.setName(company.getName());
        company_local.setAddress(company.getAddress());
        company_local.setCulture(company.getCulture());
        company_local.setDescription(company.getDescription());
        company_local.setName(company.getName());
        company_local.setEmailAddress(company.getEmailAddress());
        company_local.setPhoneNumber(company.getPhoneNumber());

        companyRespository.save(company_local);

        return "Company edited successfully.";
    }

    public Boolean approveCompanyRegistrationRequest(String name, int response) throws Exception{
        Company company = companyRespository.findByName(name);
        if(company == null)
            throw new Exception("Could not find company by name " + name);

        if(response == 1)
        {
            company.setStatus(true);   
            companyRespository.save(company);
            return true;
        }
        
        companyRespository.delete(company);
        
        return false;
    }

    public String deleteCompany(String name) throws Exception{
        Company company = companyRespository.findByName(name);
        if(company == null) 
            throw new Exception("Could not find company by name " + name);

        companyRespository.delete(company);
        
        return "Company " + name + " successfully deleted.";
    }
}
