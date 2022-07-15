package org.iassociation.service.itf;

import org.iassociation.dto.AssociationDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AssociationService {

    public AssociationDTO addAssociation(AssociationDTO associationDTO);

    public List<AssociationDTO> getAssociations();

    public Page<AssociationDTO> getAllAuthorsByPagination(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy);


    public AssociationDTO retrieveAssociation(Long id);

    public AssociationDTO updateAssociation(Long id, AssociationDTO associationDTO);

    public void deleteAssociation(Long id);

}
