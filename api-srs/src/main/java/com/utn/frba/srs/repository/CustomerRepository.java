package com.utn.frba.srs.repository;

import com.utn.frba.srs.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findTop1ByDocumentTypeAndDocumentValue(String type, String value);
}