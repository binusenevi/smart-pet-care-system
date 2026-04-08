package com.myproject.petcare.controller;

import com.myproject.petcare.entity.Reminder;
import com.myproject.petcare.service.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reminders")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ReminderController {

    private final ReminderService reminderService;

    @PostMapping("/save")
    public Reminder saveReminder(@RequestBody Reminder reminder) {
        return reminderService.saveReminder(reminder);
    }

    @GetMapping("/all")
    public List<Reminder> getAllReminders() {
        return reminderService.getAllReminders();
    }
}