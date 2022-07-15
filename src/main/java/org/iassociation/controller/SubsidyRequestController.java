package org.iassociation.controller;

import org.iassociation.dto.SubsidyRequestDTO;
import org.iassociation.service.itf.SubsidyRequestService;
import org.iassociation.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hamza Amentag
 * @since 7/16/2022
 */
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
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping
    public List<SubsidyRequestDTO> getAllAssociations() {
        try {
            subsidyRequestService.getSubsidyRequest();
            return subsidyRequestService.getSubsidyRequest();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSubsidyRequest(@PathVariable Long id) {
        try {
            subsidyRequestService.deleteAssociation(id);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubsidyRequestDTO> updateSubsidyRequest(@PathVariable Long id, @RequestBody SubsidyRequestDTO subsidyRequestDTO) {
        try {
            return new ResponseEntity<>(subsidyRequestService.updateAssociation(id, subsidyRequestDTO), HttpStatus.OK);

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubsidyRequestDTO> getSubsidyRequest(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(subsidyRequestService.retrieveSubsidyRequest(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
