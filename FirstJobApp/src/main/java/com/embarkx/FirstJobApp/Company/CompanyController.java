package com.embarkx.FirstJobApp.Company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

  private CompanyService companyService;

  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @PostMapping("/companies")
  public ResponseEntity<String> addCompany(@RequestBody Company company) {
    companyService.addCompany(company);

    return ResponseEntity.ok("Company added successfully");

  }

  @GetMapping("/companies")
  public ResponseEntity<List<Company>> getAllCompanies() {
    List<Company> companies = companyService.getAllCompanies();
    return new ResponseEntity<>(companies, HttpStatus.OK);
  }

  @GetMapping("/companies/{id}")
  public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {

    return ResponseEntity.ok(companyService.getCompanyById(id));
  }

  @PutMapping("companies/{id}")
  public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
    companyService.updateCompany(id, company);
    return ResponseEntity.ok("Company updated successfully");
  }

  @DeleteMapping("companies/{id}")
  public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
    boolean deleteCompany = companyService.deleteCompany(id);
    if (!deleteCompany) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok("Company deleted successfully");
  }

}
