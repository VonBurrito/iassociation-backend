package org.iassociation.service.impl;

import org.iassociation.dto.EventDTO;
import org.iassociation.model.AuthorizationRequest;
import org.iassociation.model.Event;
import org.iassociation.model.Member;
import org.iassociation.repository.EventRepository;
import org.iassociation.service.itf.EventService;
import org.iassociation.util.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private ModelMapper modelMapper;
    private ModelMapperUtil modelMapperUtil;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setModelMapperUtil(ModelMapperUtil modelMapperUtil) {
        this.modelMapperUtil = modelMapperUtil;
    }

    @Override
    public EventDTO addEvent(EventDTO eventDTO) {
        Event event = modelMapperUtil.mapToEntity(eventDTO);
        return modelMapperUtil.mapToDto(eventRepository.save(event));
    }

    @Override
    public List<EventDTO> getEvents() {
        return modelMapperUtil.mapEventsToList(eventRepository.findAll());
    }

    @Override
    public Page<EventDTO> getAllEventsByPagination(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy) {
        return null;
    }

    @Override
    public EventDTO retreiveEvent(Long id) {
        if (eventRepository.findById(id).isPresent()) {
            return modelMapperUtil.mapToDto(eventRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public EventDTO updateEvent(EventDTO eventDTO, Long id) {
        if (eventRepository.findById(id).isPresent()) {
            eventDTO.setId(id);
            Event event = eventRepository.findById(id).get();
            modelMapper.map(eventDTO, event);
            return modelMapperUtil.mapToDto(eventRepository.save(event));
        }
        return null;
    }

    @Override
    public void deleteEvent(Long id) {
        if (eventRepository.findById(id).isPresent()) {
            eventRepository.deleteById(id);
        }
    }
}
