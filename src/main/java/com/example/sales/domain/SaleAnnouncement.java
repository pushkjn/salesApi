package com.example.sales.domain;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "sales")
@Entity
public class SaleAnnouncement {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private List<String> photos;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name="external_id")
    @Generated(GenerationTime.ALWAYS)
    private UUID externalId;

}
