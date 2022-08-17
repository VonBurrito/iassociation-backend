package org.iassociation.controller;

import org.iassociation.dto.EventDTO;
import org.iassociation.dto.MemberDTO;
import org.iassociation.exception.ApiRequestException;
import org.iassociation.service.itf.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventController {

    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventDTO> addEvent(@RequestBody EventDTO eventDTO) {
        try {
            return new ResponseEntity<>(eventService.addEvent(eventDTO), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @GetMapping
    public List<EventDTO> getEvents() {
        try {
            return eventService.getEvents();
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        try {
            eventService.deleteEvent(id);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateAssociation(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        try {
            return new ResponseEntity<>(eventService.updateEvent(eventDTO, id), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(eventService.retreiveEvent(id), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }
}
