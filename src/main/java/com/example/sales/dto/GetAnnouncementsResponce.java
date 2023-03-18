package com.example.sales.dto;

import java.util.List;
import java.util.UUID;

import com.example.sales.domain.SaleAnnouncement;

import lombok.Data;

@Data
public class GetAnnouncementsResponce {
    private UUID id;
    private String description;
    private List<String> photos;

    public static GetAnnouncementsResponce from(SaleAnnouncement announcement) {
        final var responce = new GetAnnouncementsResponce();

        responce.setId(announcement.getExternalId());
        responce.setDescription(announcement.getDescription());
        responce.setPhotos(announcement.getPhotos());

        return responce;
    }
}
