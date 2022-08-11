package org.iassociation.service.itf;

import org.iassociation.dto.AssociationDTO;
import org.iassociation.dto.SubsidyRequestDTO;
import org.iassociation.model.SubsidyRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * @author Hamza Amentag
 * @since 7/14/2022
 */
public interface SubsidyRequestService {

    public SubsidyRequestDTO addSubsidyRequest(SubsidyRequestDTO subsidyRequestDTO);

    public List<SubsidyRequestDTO> getSubsidyRequest();

    public Page<SubsidyRequestDTO> getAllSubsidyRequestsByPagination(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy);

    public SubsidyRequestDTO retrieveSubsidyRequest(Long id);

    public SubsidyRequestDTO updateAssociation(Long id, SubsidyRequestDTO subsidyRequestDTO);

    public void deleteSubsidyRequest(Long id);
}
