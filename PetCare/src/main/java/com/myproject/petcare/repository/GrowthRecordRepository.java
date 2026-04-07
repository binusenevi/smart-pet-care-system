package com.myproject.petcare.repository;

import com.myproject.petcare.entity.GrowthRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrowthRecordRepository extends JpaRepository<GrowthRecord, Long> {
}