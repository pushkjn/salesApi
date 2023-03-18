package com.example.sales.services;

import java.util.List;
import java.util.UUID;

import com.example.sales.dto.CreateAnnouncementRequest;
import com.example.sales.dto.CreateAnnouncementResponce;
import com.example.sales.dto.GetAnnouncementsResponce;

import lombok.NonNull;

public interface SaleAnnouncementsService {
    @NonNull
    GetAnnouncementsResponce getAnnouncementById(UUID id);
    List<GetAnnouncementsResponce> getAllAnnouncements();
    CreateAnnouncementResponce createAnnouncement(@NonNull CreateAnnouncementRequest announcement);
}