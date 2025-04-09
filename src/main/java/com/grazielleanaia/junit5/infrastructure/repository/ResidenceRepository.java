package com.grazielleanaia.junit5.infrastructure.repository;

import com.grazielleanaia.junit5.infrastructure.entity.ResidenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenceRepository extends JpaRepository<ResidenceEntity, Long> {
}
