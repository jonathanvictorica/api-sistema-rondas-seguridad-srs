package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.SecurityCompany;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SecurityCompanyRepository extends JpaRepository<SecurityCompany, Long> {
    SecurityCompany findTop1ByDocumentTypeAndDocumentValue(String type, String value);
}