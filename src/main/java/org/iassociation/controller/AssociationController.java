package org.iassociation.controller;

import org.iassociation.dto.AssociationDTO;
import org.iassociation.service.itf.AssociationService;
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

    @Autowired
    public void setAssociationService(AssociationService associationService) {
        this.associationService = associationService;
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
}
