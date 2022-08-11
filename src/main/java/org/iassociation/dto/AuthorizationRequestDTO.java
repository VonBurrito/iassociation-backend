package org.iassociation.dto;

import org.iassociation.model.Association;

import java.time.LocalDate;

/**
 * @author Hamza Amentag
 * @since 7/24/2022
 */
public class AuthorizationRequestDTO {

    private Long id;
    private String subject;
    private LocalDate eventDate;
    private Association association;

    public AuthorizationRequestDTO() {
    }

    public AuthorizationRequestDTO(Long id, String subject, LocalDate eventDate, Association association) {
        this.id = id;
        this.subject = subject;
        this.eventDate = eventDate;
        this.association = association;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
