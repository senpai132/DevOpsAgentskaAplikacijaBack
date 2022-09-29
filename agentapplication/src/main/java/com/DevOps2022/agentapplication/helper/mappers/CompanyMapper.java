package com.DevOps2022.agentapplication.helper.mappers;

import java.util.ArrayList;
import java.util.List;

import com.DevOps2022.agentapplication.helper.dto.CompanyDTO;
import com.DevOps2022.agentapplication.model.Company;

public class CompanyMapper implements MapperInterface<Company, CompanyDTO>{

    @Override
    public Company toEntity(CompanyDTO dto) {
        Company company_local = new Company();
        company_local.setAddress(dto.getAddress());
        company_local.setCulture(dto.getCulture());
        company_local.setDescription(dto.getDescription());
        company_local.setName(dto.getName());
        company_local.setOwner(dto.getOwner());
        return company_local;
    }

    @Override
    public List<Company> toEntityList(List<CompanyDTO> dtoList) {
        List<Company> companyList = new ArrayList<Company>();
        for(CompanyDTO dto : dtoList) {
            companyList.add(toEntity(dto));
        }
        return companyList;
    }

    @Override
    public CompanyDTO toDto(Company entity) {
        CompanyDTO company_local = new CompanyDTO();
        company_local.setAddress(entity.getAddress());
        company_local.setCulture(entity.getCulture());
        company_local.setDescription(entity.getDescription());
        company_local.setName(entity.getName());
        company_local.setOwner(entity.getOwner());
        return company_local;
    }

    @Override
    public List<CompanyDTO> toDtoList(List<Company> entityList) {
        List<CompanyDTO> companyList = new ArrayList<>();
        for(Company entity: entityList)
            companyList.add(toDto(entity));
        return companyList;
    }
    
}
