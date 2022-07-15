package org.iassociation.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "association_id", nullable = true)
    private Association association;

    private Status status;

    public SubsidyRequest() {
    }

    public SubsidyRequest(Association association) {
        super();
        this.association = association;
    }

    public Association getAssociation() {
        return association;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SubsidyRequest that = (SubsidyRequest) o;
        return Objects.equals(association, that.association);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), association);
    }
}
