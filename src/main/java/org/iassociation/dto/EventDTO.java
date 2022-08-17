package org.iassociation.dto;

import org.iassociation.model.Association;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class EventDTO {

    private Long id;
    private String eventType;
    private String eventDesc;
    private LocalDate eventDate;
    private String address;
    private Set<Association> associations;

    public EventDTO() {
    }

    public EventDTO(Long id, String eventType, String eventDesc, LocalDate eventDate, String address, Set<Association> associations) {
        this.id = id;
        this.eventType = eventType;
        this.eventDesc = eventDesc;
        this.eventDate = eventDate;
        this.address = address;
        this.associations = associations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(Set<Association> associations) {
        this.associations = associations;
    }
}
