package org.iassociation.service.impl;

import org.iassociation.dto.AuthorizationRequestDTO;
import org.iassociation.model.AuthorizationRequest;
import org.iassociation.model.SubsidyRequest;
import org.iassociation.repository.AuthorizationRequestRepository;
import org.iassociation.service.itf.AuthorizationRequestService;
import org.iassociation.util.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Hamza Amentag
 * @since 7/24/2022
 */
@Service
public class AuthorizationRequestServiceImpl implements AuthorizationRequestService {

    private AuthorizationRequestRepository authorizationRequestRepository;
    ;
    private ModelMapper modelMapper;
    private ModelMapperUtil modelMapperUtil;

    @Autowired
    public void setAuthorizationRequestRepository(AuthorizationRequestRepository authorizationRequestRepository) {
        this.authorizationRequestRepository = authorizationRequestRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setModelMapperUtil(ModelMapperUtil modelMapperUtil) {
        this.modelMapperUtil = modelMapperUtil;
    }

    @Transactional
    @Override
    public AuthorizationRequestDTO addAuthorizationRequest(AuthorizationRequestDTO authorizationRequestDTO) {
        AuthorizationRequest authorizationRequest = modelMapperUtil.mapToEntity(authorizationRequestDTO);
        return modelMapperUtil.mapToDto(authorizationRequestRepository.save(authorizationRequest));
    }

    @Transactional
    @Override
    public List<AuthorizationRequestDTO> getAuthorizationRequests() {
        return modelMapperUtil.mapAuthorizationRequestsToList(authorizationRequestRepository.findAll());
    }

    @Transactional
    @Override
    public Page<AuthorizationRequestDTO> getAllAuthorizationRequestsByPagination(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy) {
        //return authorizationRequestRepository.findAll(PageRequest.of(page.orElse(0), size.orElse(5), Sort.Direction.ASC, sortBy.orElse("id")));
        return null;
    }

    @Transactional
    @Override
    public AuthorizationRequestDTO retreiveAuthorizationRequest(Long id) {
        if (authorizationRequestRepository.findById(id).isPresent()) {
            return modelMapperUtil.mapToDto(authorizationRequestRepository.findById(id).get());
        }
        return null;
    }

    @Transactional
    @Override
    public AuthorizationRequestDTO updateAuthorizationRequest(AuthorizationRequestDTO authorizationRequestDTO, Long id) {
        if (authorizationRequestRepository.findById(id).isPresent()) {
            authorizationRequestDTO.setId(id);
            AuthorizationRequest authorizationRequest = authorizationRequestRepository.findById(id).get();
            modelMapper.map(authorizationRequestDTO, authorizationRequest);
            return modelMapperUtil.mapToDto(authorizationRequestRepository.save(authorizationRequest));
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteAuthorizationRequest(Long id) {
        if (authorizationRequestRepository.findById(id).isPresent()) {
            authorizationRequestRepository.deleteById(id);
        }
    }
}
