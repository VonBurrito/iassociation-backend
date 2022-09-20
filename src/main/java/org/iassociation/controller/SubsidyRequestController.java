package org.iassociation.controller;

import org.iassociation.dto.SubsidyRequestDTO;
import org.iassociation.exception.ApiRequestException;
import org.iassociation.service.itf.SubsidyRequestService;
import org.iassociation.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hamza Amentag
 * @since 7/16/2022
 */
@RestController
@RequestMapping(value = "/subsidyrequests", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubsidyRequestController {

    private SubsidyRequestService subsidyRequestService;
    private ModelMapperUtil modelMapperUtil;

    @Autowired
    public void setSubsidyRequestService(SubsidyRequestService subsidyRequestService) {
        this.subsidyRequestService = subsidyRequestService;
    }

    @Autowired
    public void setModelMapperUtil(ModelMapperUtil modelMapperUtil) {
        this.modelMapperUtil = modelMapperUtil;
    }

    @PostMapping
    public ResponseEntity<SubsidyRequestDTO> addSubsidyRequest(@RequestBody SubsidyRequestDTO subsidyRequestDTO) {
        try {
            return new ResponseEntity<>(subsidyRequestService.addSubsidyRequest(subsidyRequestDTO), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @GetMapping
    public ResponseEntity<List<SubsidyRequestDTO>> getAllAssociations() {
        try {

            return new ResponseEntity<>(subsidyRequestService.getSubsidyRequest(), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubsidyRequest(@PathVariable Long id) {
        try {
            subsidyRequestService.deleteSubsidyRequest(id);
            return new ResponseEntity<>("The subsidy request with id: " + id + " has been deleted.", HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubsidyRequestDTO> updateSubsidyRequest(@PathVariable Long id, @RequestBody SubsidyRequestDTO subsidyRequestDTO) {
        try {
            return new ResponseEntity<>(subsidyRequestService.updateAssociation(id, subsidyRequestDTO), HttpStatus.OK);

        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubsidyRequestDTO> getSubsidyRequest(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(subsidyRequestService.retrieveSubsidyRequest(id), HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException();
        }
    }
}
