package com.myproject.petcare.controller;

import com.myproject.petcare.entity.GrowthRecord;
import com.myproject.petcare.service.GrowthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/growth-records")
public class GrowthRecordController {

    @Autowired
    private GrowthRecordService growthRecordService;

    @PostMapping("/save")
    public GrowthRecord saveRecord(@RequestBody GrowthRecord record) {
        return growthRecordService.saveGrowthRecord(record);
    }

    @GetMapping("/all")
    public List<GrowthRecord> getAllRecords() {
        return growthRecordService.getAllRecords();
    }
}