package org.iassociation.dto;

import org.iassociation.model.Status;


public class AssociationDTO {

    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String objectifs;
    private String admissionRequirements;
    private Status status;
    private String documents;

    public AssociationDTO() {
    }

    public AssociationDTO(Long id, String name, String address, String email, String phone, String objectifs, String admissionRequirements, Status status, String documents) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.objectifs = objectifs;
        this.admissionRequirements = admissionRequirements;
        this.status = status;
        this.documents = documents;
    }

    public AssociationDTO(String name, String address, String email, String phone, String objectifs, String admissionRequirements, Status status, String documents) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.objectifs = objectifs;
        this.admissionRequirements = admissionRequirements;
        this.status = status;
        this.documents = documents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(String objectifs) {
        this.objectifs = objectifs;
    }

    public String getAdmissionRequirements() {
        return admissionRequirements;
    }

    public void setAdmissionRequirements(String admissionRequirements) {
        this.admissionRequirements = admissionRequirements;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }
}
