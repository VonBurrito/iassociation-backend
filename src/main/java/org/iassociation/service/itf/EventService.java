package org.iassociation.service.itf;

import org.iassociation.dto.AuthorizationRequestDTO;
import org.iassociation.dto.EventDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface EventService {

    public EventDTO addEvent(EventDTO eventDTO);

    public List<EventDTO> getEvents();

    public Page<EventDTO> getAllEventsByPagination(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy);

    public EventDTO retreiveEvent(Long id);

    public EventDTO updateEvent(EventDTO eventDTO, Long id);

    public void deleteEvent(Long id);
}
