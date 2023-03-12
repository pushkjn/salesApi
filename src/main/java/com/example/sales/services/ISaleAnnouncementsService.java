package com.example.sales.services;

import java.util.List;

import com.example.sales.domain.SaleAnnouncement;

import lombok.NonNull;

public interface ISaleAnnouncementsService {
    @NonNull
    SaleAnnouncement getAnnouncementById(Long id);
    List<SaleAnnouncement> getAllAnnouncements();
    SaleAnnouncement createAnnouncement(@NonNull SaleAnnouncement announcement);
}