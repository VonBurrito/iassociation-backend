package org.iassociation.model;

import org.iassociation.model.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @author Hamza Amentag
 * @since 7/15/2022
 */
@Entity
public class Event extends BaseEntity {

    private String eventType;
    private String eventDesc;

    private Date eventDate;

    private String address;


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

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
