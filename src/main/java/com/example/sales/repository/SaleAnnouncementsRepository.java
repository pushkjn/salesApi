package com.example.sales.repository;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sales.domain.SaleAnnouncement;


public interface SaleAnnouncementsRepository extends JpaRepository<SaleAnnouncement, Long> {
    Optional<SaleAnnouncement> findByExternalId(UUID externalId);
}
