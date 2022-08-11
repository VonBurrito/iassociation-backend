package org.iassociation.controller;

import org.iassociation.dto.AuthorizationRequestDTO;
import org.iassociation.exception.ApiRequestException;
import org.iassociation.service.itf.AuthorizationRequestService;
import org.iassociation.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hamza Amentag
 * @since 7/24/2022
 */
@RestController
@RequestMapping(value = "/authorizationRequests", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorizationRequestController {


    private AuthorizationRequestService authorizationRequestService;
    private ModelMapperUtil modelMapperUtil;

    @Autowired
    public void setAuthorizationRequestService(AuthorizationRequestService authorizationRequestService) {
        this.authorizationRequestService = authorizationRequestService;
    }

    @Autowired
    public void setModelMapperUtil(ModelMapperUtil modelMapperUtil) {
        this.modelMapperUtil = modelMapperUtil;
    }

    @PostMapping
    public ResponseEntity<AuthorizationRequestDTO> addSubsidyRequest(@RequestBody AuthorizationRequestDTO authorizationRequestDTO) {
        try {
            return new ResponseEntity<>(authorizationRequestService.addAuthorizationRequest(authorizationRequestDTO), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @GetMapping
    public ResponseEntity<List<AuthorizationRequestDTO>> getAllAuthorizationRequests() {
        try {
            return new ResponseEntity<>(authorizationRequestService.getAuthorizationRequests(), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorizationRequest(@PathVariable Long id) {
        try {
            authorizationRequestService.deleteAuthorizationRequest(id);
            return new ResponseEntity<>("The authorization request with id: " + id + " has been deleted.", HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorizationRequestDTO> updateAuthorizationRequest(@PathVariable Long id, @RequestBody AuthorizationRequestDTO authorizationRequestDTO) {
        try {
            return new ResponseEntity<>(authorizationRequestService.updateAuthorizationRequest(authorizationRequestDTO, id), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorizationRequestDTO> getAuthorizationRequest(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(authorizationRequestService.retreiveAuthorizationRequest(id), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }
}
