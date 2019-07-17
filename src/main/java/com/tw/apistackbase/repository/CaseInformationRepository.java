package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseInformationRepository extends JpaRepository<CaseInformation, Integer> {
}
