package org.iassociation.controller;

import org.iassociation.dto.AssociationDTO;
import org.iassociation.model.Association;
import org.iassociation.service.itf.AssociationService;
import org.iassociation.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hamza Amentag
 * @since 7/13/2022
 */
@RestController
@RequestMapping(value = "/associations", produces = MediaType.APPLICATION_JSON_VALUE)
public class AssociationController {

    private AssociationService associationService;
    private ModelMapperUtil modelMapperUtil;

    @Autowired
    public void setAssociationService(AssociationService associationService) {
        this.associationService = associationService;
    }

    @Autowired
    public void setModelMapperUtil(ModelMapperUtil modelMapperUtil) {
        this.modelMapperUtil = modelMapperUtil;
    }

    @PostMapping
    public ResponseEntity<AssociationDTO> addAssociation(@RequestBody AssociationDTO associationDTO) {
        try {
            return new ResponseEntity<>(associationService.addAssociation(associationDTO), HttpStatus.OK);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping
    public List<AssociationDTO> getAllAssociations() {
        try {
            associationService.getAssociations();
            return associationService.getAssociations();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAssociation(@PathVariable Long id) {
        try {
            associationService.deleteAssociation(id);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssociationDTO> updateAssociation(@PathVariable Long id, @RequestBody AssociationDTO associationDTO) {
        try {
            return new ResponseEntity<>(associationService.updateAssociation(id, associationDTO), HttpStatus.OK);

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociationDTO> getAssociation(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(associationService.retrieveAssociation(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
