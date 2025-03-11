package com.embarkx.FirstJobApp.Company.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embarkx.FirstJobApp.Company.Company;
import com.embarkx.FirstJobApp.Company.CompanyRespository;
import com.embarkx.FirstJobApp.Company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

  private CompanyRespository companyRespository;

  public CompanyServiceImpl(CompanyRespository companyRespository) {
    this.companyRespository = companyRespository;
  }

  @Override
  public List<Company> getAllCompanies() {
    return companyRespository.findAll();
  }

  @Override
  public Company getCompanyById(Long id) {
    return companyRespository.findById(id).orElse(null);
  }

  @Override
  public void addCompany(Company company) {
    companyRespository.save(company);
  }

  @Override
  public Company updateCompany(Long id, Company company) {
    Company existingCompany = companyRespository.findById(id).orElse(null);
    if (existingCompany != null) {
      existingCompany.setName(company.getName());
      existingCompany.setDescription(company.getDescription());
      existingCompany.setJobs(company.getJobs());
      return companyRespository.save(existingCompany);
    }
    return null;
  }

  @Override
  public boolean deleteCompany(Long id) {
    if (!companyRespository.existsById(id)) {
      return false;
    }
    companyRespository.deleteById(id);
    return true;
  }

}
