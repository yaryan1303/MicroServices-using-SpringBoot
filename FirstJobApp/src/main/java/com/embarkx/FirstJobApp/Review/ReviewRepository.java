package com.embarkx.FirstJobApp.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {

  List<Reviews> findByCompanyId(Long companyId);

}
