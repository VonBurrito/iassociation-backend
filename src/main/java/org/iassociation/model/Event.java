package org.iassociation.model;

import org.iassociation.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

/**
 * @author Hamza Amentag
 * @since 7/15/2022
 */
@Entity
public class Event extends BaseEntity {

    private String eventType;
    private String eventDesc;

    private LocalDate eventDate;

    private String address;

    @ManyToMany(mappedBy = "events")
    private Set<Association> associations;


    public Event() {
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
}
