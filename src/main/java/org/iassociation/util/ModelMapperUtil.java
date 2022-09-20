package org.iassociation.util;

import org.iassociation.dto.*;
import org.iassociation.model.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Hamza Amentag
 * @since 7/11/2022
 */
@Component
public class ModelMapperUtil {

    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //no-args constructor for IoC
    public ModelMapperUtil() {
    }

    public AssociationDTO mapToDto(Association association) {
        AssociationDTO associationDTO = modelMapper.map(association, AssociationDTO.class);
        return associationDTO;
    }

    public Association mapToEntity(AssociationDTO associationDTO) {
        Association association = modelMapper.map(associationDTO, Association.class);
        return association;
    }

    public List<AssociationDTO> mapAssociationsToList(List<Association> associations) {
        List<AssociationDTO> entityToDtoList = modelMapper.map(associations, new TypeToken<List<AssociationDTO>>() {
        }.getType());
        return entityToDtoList;
    }

    public SubsidyRequestDTO mapToDto(SubsidyRequest subsidyRequest) {
        SubsidyRequestDTO subsidyRequestDTO = modelMapper.map(subsidyRequest, SubsidyRequestDTO.class);
        return subsidyRequestDTO;
    }

    public SubsidyRequest mapToEntity(SubsidyRequestDTO subsidyRequestDTO) {
        SubsidyRequest subsidyRequest = modelMapper.map(subsidyRequestDTO, SubsidyRequest.class);
        return subsidyRequest;
    }

    public List<SubsidyRequestDTO> mapSubsidyRequestsToList(List<SubsidyRequest> subsidyRequests) {
        List<SubsidyRequestDTO> entityToDtoList = modelMapper.map(subsidyRequests, new TypeToken<List<SubsidyRequestDTO>>() {
        }.getType());
        return entityToDtoList;
    }

    public AuthorizationRequestDTO mapToDto(AuthorizationRequest authorizationRequest) {
        AuthorizationRequestDTO authorizationRequestDTO = modelMapper.map(authorizationRequest, AuthorizationRequestDTO.class);
        return authorizationRequestDTO;
    }

    public AuthorizationRequest mapToEntity(AuthorizationRequestDTO authorizationRequestDTO) {
        AuthorizationRequest authorizationRequest = modelMapper.map(authorizationRequestDTO, AuthorizationRequest.class);
        return authorizationRequest;
    }

    public List<AuthorizationRequestDTO> mapAuthorizationRequestsToList(List<AuthorizationRequest> authorizationRequests) {
        List<AuthorizationRequestDTO> entityToDtoList = modelMapper.map(authorizationRequests, new TypeToken<List<AuthorizationRequest>>() {
        }.getType());
        return entityToDtoList;
    }

    ///////////////////////////

    public MemberDTO mapToDto(Member member) {
        MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);
        return memberDTO;
    }

    public Member mapToEntity(MemberDTO memberDTO) {
        Member member = modelMapper.map(memberDTO, Member.class);
        return member;
    }

    public List<MemberDTO> mapMembersToList(List<Member> members) {
        List<MemberDTO> entityToDtoList = modelMapper.map(members, new TypeToken<List<Member>>() {
        }.getType());
        return entityToDtoList;
    }

    /////////////////////////////////////////

    public EventDTO mapToDto(Event event) {
        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);
        return eventDTO;
    }

    public Event mapToEntity(EventDTO eventDTO) {
        Event event = modelMapper.map(eventDTO, Event.class);
        return event;
    }

    public List<EventDTO> mapEventsToList(List<Event> events) {
        List<EventDTO> entityToDtoList = modelMapper.map(events, new TypeToken<List<Event>>() {
        }.getType());
        return entityToDtoList;
    }
}
