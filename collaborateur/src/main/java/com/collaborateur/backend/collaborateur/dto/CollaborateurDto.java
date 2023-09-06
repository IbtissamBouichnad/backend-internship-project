package com.collaborateur.backend.collaborateur.dto;

import lombok.Getter;

public class CollaborateurDto {

    @Getter
    private Long id;
    private String name;
    private String job;
    private String imageUrl;

    public CollaborateurDto() {
    }

    public CollaborateurDto(Long id, String name, String job, String imageUrl) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

