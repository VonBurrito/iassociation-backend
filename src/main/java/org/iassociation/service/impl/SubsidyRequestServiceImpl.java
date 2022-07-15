package org.iassociation.service.impl;

import org.iassociation.dto.SubsidyRequestDTO;
import org.iassociation.model.Association;
import org.iassociation.model.SubsidyRequest;
import org.iassociation.repository.SubsidyRequestRepository;
import org.iassociation.service.itf.SubsidyRequestService;
import org.iassociation.util.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Hamza Amentag
 * @since 7/14/2022
 */
@Service
@Transactional
public class SubsidyRequestServiceImpl implements SubsidyRequestService {

    private SubsidyRequestRepository subsidyRequestRepository;

    private ModelMapper modelMapper;

    private ModelMapperUtil modelMapperUtil;

    @Autowired
    public void setSubsidyRequestRepository(SubsidyRequestRepository subsidyRequestRepository) {
        this.subsidyRequestRepository = subsidyRequestRepository;
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
    public SubsidyRequestDTO addSubsidyRequest(SubsidyRequestDTO subsidyRequestDTO) {
        SubsidyRequest subsidyRequest = modelMapperUtil.mapToEntity(subsidyRequestDTO);
        return modelMapperUtil.mapToDto(subsidyRequestRepository.save(subsidyRequest));
    }

    @Override
    public List<SubsidyRequestDTO> getSubsidyRequest() {
        return modelMapperUtil.mapSubsidyRequestsToList(subsidyRequestRepository.findAll());
    }

    @Override
    public Page<SubsidyRequestDTO> getAllSubsidyRequestsByPagination(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy) {
        return null;
    }

    @Override
    public SubsidyRequestDTO retrieveSubsidyRequest(Long id) {
        if (subsidyRequestRepository.findById(id).isPresent()) {
            return modelMapperUtil.mapToDto(subsidyRequestRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public SubsidyRequestDTO updateAssociation(Long id, SubsidyRequestDTO subsidyRequestDTO) {
        if (subsidyRequestRepository.findById(id).isPresent()) {
            subsidyRequestDTO.setId(id);
            SubsidyRequest subsidyRequest = subsidyRequestRepository.findById(id).get();
            modelMapper.map(subsidyRequestDTO, subsidyRequest);
            return modelMapperUtil.mapToDto(subsidyRequestRepository.save(subsidyRequest));
        }
        return null;
    }

    @Override
    public void deleteAssociation(Long id) {
        if (subsidyRequestRepository.findById(id).isPresent()) {
            subsidyRequestRepository.deleteById(id);
        }
    }
}
