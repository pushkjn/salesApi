package com.example.sales.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="sales")
@Entity
public class SaleAnnouncement {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private List<String> photos;

    @Column
    private String name;

    @Column
    private String description;
    
}
