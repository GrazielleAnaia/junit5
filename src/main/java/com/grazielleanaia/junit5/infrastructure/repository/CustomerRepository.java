package com.grazielleanaia.junit5.infrastructure.repository;

import com.grazielleanaia.junit5.infrastructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
