package com.example.sales.services;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.sales.domain.SaleAnnouncement;
import com.example.sales.dto.CreateAnnouncementRequest;
import com.example.sales.dto.CreateAnnouncementResponce;
import com.example.sales.dto.GetAnnouncementsResponce;
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
    public GetAnnouncementsResponce getAnnouncementById(UUID id) {
        final SaleAnnouncement announcement = repo.findByExternalId(id)
                .orElseThrow(() -> new AnnouncementNotFoundException("Announcement not found"));

        return GetAnnouncementsResponce.from(announcement);
    }

    @Override
    public List<GetAnnouncementsResponce> getAllAnnouncements() {
        return repo.findAll().stream()
                .peek(System.out::println)
                .map(GetAnnouncementsResponce::from)
                .collect(Collectors.toList());
    }

    @Override
    public CreateAnnouncementResponce createAnnouncement(@NonNull CreateAnnouncementRequest reqBody) {

        reqBody.getPhotos().ifPresent((photos) -> {
            if (photos.size() > 3)
                throw new IncorrectAnnouncementException("Too many photos");
        });

        if (reqBody.getDescription().length() > 1000)
            throw new IncorrectAnnouncementException("Description is too long");

        if (reqBody.getName().length() > 10)
            throw new IncorrectAnnouncementException("Name is too long");

        final var announcement = new SaleAnnouncement();

        announcement.setDescription(reqBody.getDescription());
        announcement.setName(reqBody.getName());
        announcement.setPhotos(reqBody.getPhotos().orElse(Collections.emptyList()));

        repo.save(announcement);

        return CreateAnnouncementResponce.from(announcement);
    }

}
