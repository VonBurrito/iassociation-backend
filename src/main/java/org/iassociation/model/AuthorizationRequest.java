package org.iassociation.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.tomcat.util.http.parser.Authorization;
import org.iassociation.util.DateProcessor;
import org.iassociation.util.LocalDateTimeDeserializer;
import org.iassociation.util.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * @author Hamza Amentag
 * @since 7/24/2022
 */
@Entity
public class AuthorizationRequest extends BaseEntity {

    private String subject;

    @DateTimeFormat(pattern = DateProcessor.DATE_FORMAT)
    private LocalDate eventDate;

    @ManyToOne
    @JoinColumn(name = "association_id", nullable = true)
    private Association association;

    public AuthorizationRequest() {
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
