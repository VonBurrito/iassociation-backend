package org.iassociation.service.itf;

import org.iassociation.dto.AuthorizationRequestDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AuthorizationRequestService {

    public AuthorizationRequestDTO addAuthorizationRequest(AuthorizationRequestDTO authorizationRequestDTO);

    public List<AuthorizationRequestDTO> getAuthorizationRequests();

    public Page<AuthorizationRequestDTO> getAllAuthorizationRequestsByPagination(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy);

    public AuthorizationRequestDTO retreiveAuthorizationRequest(Long id);

    public AuthorizationRequestDTO updateAuthorizationRequest(AuthorizationRequestDTO authorizationRequest, Long id);

    public void deleteAuthorizationRequest(Long id);
}
