package org.iassociation.util;

import org.iassociation.dto.AssociationDTO;
import org.iassociation.dto.SubsidyRequestDTO;
import org.iassociation.model.Association;
import org.iassociation.model.SubsidyRequest;
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
        List<SubsidyRequestDTO> entityToDtoList = modelMapper.map(subsidyRequests, new TypeToken<List<SubsidyRequest>>() {
        }.getType());
        return entityToDtoList;
    }
}
