package com.practise.FirstJobApp.company.service.impl;

import com.practise.FirstJobApp.company.entity.Company;
import com.practise.FirstJobApp.company.repository.CompanyRepository;
import com.practise.FirstJobApp.company.service.CompanyService;
import com.practise.FirstJobApp.job.entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company findCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCompany(Long id,Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()){
            Company com = companyOptional.get();
            com.setName(company.getName());
            com.setDescription(company.getDescription());
            com.setJobs(company.getJobs());

            companyRepository.save(com);
            return true;
        }
        return false;
    }
}
