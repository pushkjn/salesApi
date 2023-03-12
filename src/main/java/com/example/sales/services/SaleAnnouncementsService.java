package com.example.sales.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sales.domain.SaleAnnouncement;
import com.example.sales.exceptions.AnnouncementNotFoundException;
import com.example.sales.exceptions.IncorrectAnnouncementException;
import com.example.sales.repository.SaleAnnouncementsRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleAnnouncementsService implements ISaleAnnouncementsService {
    private final SaleAnnouncementsRepository repo;

    @Override
    public SaleAnnouncement getAnnouncementById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new AnnouncementNotFoundException("Announcement not found"));
    }

    @Override
    public List<SaleAnnouncement> getAllAnnouncements() {
        return repo.findAll();
    }

    @Override
    public SaleAnnouncement createAnnouncement(@NonNull SaleAnnouncement announcement) {
        if (announcement.getPhotos().size() > 3)
            throw new IncorrectAnnouncementException("Too many photos");

        if (announcement.getDescription().length() > 1000)
            throw new IncorrectAnnouncementException("Description is too long");

        if (announcement.getName().length() > 10)
            throw new IncorrectAnnouncementException("Name is too long");
            
        return repo.save(announcement);
    }

}
