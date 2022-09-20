package org.iassociation.dto;

import org.iassociation.model.Association;
import org.iassociation.model.Status;

/**
 * @author Hamza Amentag
 * @since 7/14/2022
 */
public class SubsidyRequestDTO {

    private Long id;
    private String description;
    private Association association;
    private Status status;

    public SubsidyRequestDTO() {
    }

    public SubsidyRequestDTO(Long id, String description, Association association, Status status) {
        this.id = id;
        this.description = description;
        this.association = association;
        this.status = status;
    }

    public SubsidyRequestDTO(String description, Association association, Status status) {
        this.description = description;
        this.association = association;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
