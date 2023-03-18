package com.example.sales.dto;

import java.util.List;
import java.util.UUID;

import com.example.sales.domain.SaleAnnouncement;

import lombok.Data;

@Data
public class CreateAnnouncementResponce {
    private UUID id;
    private List<String> photos;
    private String name;
    private String description;

    public static CreateAnnouncementResponce from(SaleAnnouncement announcement) {
        final var responce = new CreateAnnouncementResponce();

        responce.setDescription(announcement.getDescription());
        responce.setPhotos(announcement.getPhotos());
        responce.setName(announcement.getName());
        responce.setId(announcement.getExternalId());

        return responce;
    }
}
