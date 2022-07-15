package org.iassociation.service.impl;

import org.iassociation.dto.AssociationDTO;
import org.iassociation.model.Association;
import org.iassociation.repository.AssociationRepository;
import org.iassociation.service.itf.AssociationService;
import org.iassociation.util.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Hamza Amentag
 * @since 7/13/2022
 */
@Service
@Transactional
public class AssociationServiceImpl implements AssociationService {


    private AssociationRepository associationRepository;

    private ModelMapper modelMapper;

    private ModelMapperUtil modelMapperUtil;

    @Autowired
    public void setAssociationRepository(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
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
    public AssociationDTO addAssociation(AssociationDTO associationDTO) {
        Association association = modelMapperUtil.mapToEntity(associationDTO);
        return modelMapperUtil.mapToDto(associationRepository.save(association));
    }

    @Override
    public List<AssociationDTO> getAssociations() {
        return modelMapperUtil.mapAssociationsToList(associationRepository.findAll());
    }

    @Override
    public Page<AssociationDTO> getAllAuthorsByPagination(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy) {
        return null;
    }

    @Override
    public AssociationDTO retrieveAssociation(Long id) {
        if (associationRepository.findById(id).isPresent()) {
            return modelMapperUtil.mapToDto(associationRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public AssociationDTO updateAssociation(Long id, AssociationDTO associationDTO) {
        if (associationRepository.findById(id).isPresent()) {
            associationDTO.setId(id);
            Association author = associationRepository.findById(id).get();
            modelMapper.map(associationDTO, author);
            return modelMapperUtil.mapToDto(associationRepository.save(author));
        }
        return null;
    }

    @Override
    public void deleteAssociation(Long id) {
        if (associationRepository.findById(id).isPresent()) {
            associationRepository.deleteById(id);
        }
    }

//    public Page<AssociationDTO> getAllAuthorsbyPagination(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy) {
//        return associationRepository.findAll(PageRequest.of(page.orElse(0), size.orElse(5), Sort.Direction.ASC, sortBy.orElse("id")));
//    }
}
