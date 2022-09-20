package org.iassociation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Hamza Amentag
 * @since 7/14/2022
 */
@Entity
public class SubsidyRequest extends BaseEntity {

    @NotNull
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "association_id", nullable = false)
    private Association association;

    private Status status;

    public SubsidyRequest() {
        // TODO document why this constructor is empty
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
