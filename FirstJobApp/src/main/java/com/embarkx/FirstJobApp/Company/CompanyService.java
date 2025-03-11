package com.embarkx.FirstJobApp.Company;

import java.util.List;

public interface CompanyService {

  public List<Company> getAllCompanies();

  public Company getCompanyById(Long id);

  public void addCompany(Company company);

  public Company updateCompany(Long id, Company company);

  public boolean deleteCompany(Long id);

}
