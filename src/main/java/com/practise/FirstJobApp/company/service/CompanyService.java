package com.practise.FirstJobApp.company.service;

import com.practise.FirstJobApp.company.entity.Company;
import com.practise.FirstJobApp.job.entity.Job;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void createCompany(Company company);

    Company findCompanyById(Long id);

    boolean deleteCompanyById(Long id);

    boolean updateCompany(Long id,Company company);

}
