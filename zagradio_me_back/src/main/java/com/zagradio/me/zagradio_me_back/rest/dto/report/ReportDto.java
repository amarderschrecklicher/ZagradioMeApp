package com.zagradio.me.zagradio_me_back.rest.dto.report;

import java.time.LocalDateTime;

public abstract class ReportDto {

    private long id;
    private String description;
    private String location;
    private String status;
    private String media;
    private LocalDateTime timestamp;

    // Constructors
    public ReportDto() {
    }

    public ReportDto(long id, String description, String location, String status, String media, LocalDateTime timestamp) {
        this.id = id;
        this.description = description;
        this.location = location;
        this.status = status;
        this.media = media;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // toString method
    @Override
    public String toString() {
        return "ReportDto{" +
                "description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", media='" + media + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
