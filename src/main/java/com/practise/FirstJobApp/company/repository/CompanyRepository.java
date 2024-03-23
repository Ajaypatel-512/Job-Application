package com.practise.FirstJobApp.company.repository;

import com.practise.FirstJobApp.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {

}
