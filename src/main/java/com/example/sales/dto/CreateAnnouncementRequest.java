package com.example.sales.dto;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateAnnouncementRequest {
    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotBlank(message = "description cannot be blank")
    private String description;

    private Optional<List<String>> photos;
}
