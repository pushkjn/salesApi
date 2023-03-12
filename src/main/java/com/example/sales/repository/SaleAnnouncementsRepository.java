package com.example.sales.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sales.domain.SaleAnnouncement;


public interface SaleAnnouncementsRepository extends JpaRepository<SaleAnnouncement, Long> {
    
}
