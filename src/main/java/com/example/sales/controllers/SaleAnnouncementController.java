package com.example.sales.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sales.domain.SaleAnnouncement;
import com.example.sales.services.ISaleAnnouncementsService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class SaleAnnouncementController {
    private final ISaleAnnouncementsService service;

    @GetMapping(value="/sales")
    public List<SaleAnnouncement> getAllAnnouncements() {
        return service.getAllAnnouncements();
    }

    @PostMapping(value="/sales")
    public SaleAnnouncement createAnnouncement(@RequestBody SaleAnnouncement newAnnouncement) {
        return service.createAnnouncement(newAnnouncement);
    }

    @GetMapping(value="/sales/{id}")
    public SaleAnnouncement getAnnouncementById(@PathVariable Long id) {
        return service.getAnnouncementById(id);
    }
    
}
