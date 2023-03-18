package com.example.sales.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sales.dto.CreateAnnouncementRequest;
import com.example.sales.dto.CreateAnnouncementResponce;
import com.example.sales.dto.GetAnnouncementsResponce;
import com.example.sales.services.SaleAnnouncementsService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class SaleAnnouncementController {
    private final SaleAnnouncementsService service;

    @GetMapping(value = "/sales")
    public List<GetAnnouncementsResponce> getAllAnnouncements() {
        return service.getAllAnnouncements()
                .stream()
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/sales")
    public CreateAnnouncementResponce createAnnouncement(@RequestBody CreateAnnouncementRequest reqBody) {
        return service.createAnnouncement(reqBody);
    }

    @GetMapping(value = "/sales/{id}")
    public GetAnnouncementsResponce getAnnouncementById(@PathVariable UUID id) {
        return service.getAnnouncementById(id);
    }

}
