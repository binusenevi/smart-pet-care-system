package com.myproject.petcare.service;

import com.myproject.petcare.entity.GrowthRecord;
import com.myproject.petcare.repository.GrowthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GrowthRecordService {

    @Autowired
    private GrowthRecordRepository growthRecordRepository;

    public GrowthRecord saveGrowthRecord(GrowthRecord record) {
        return growthRecordRepository.save(record);
    }

    public List<GrowthRecord> getAllRecords() {
        return growthRecordRepository.findAll();
    }
}