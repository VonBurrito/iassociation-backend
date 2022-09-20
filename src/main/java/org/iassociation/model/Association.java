package org.iassociation.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Association extends BaseEntity {

    @NotNull
    @Size(min = 5, max = 30)
    @Column(nullable = false)
    private String name;

    @NotNull
    @Size(min = 5, max = 120)
    @Column(nullable = false)
    private String address;

    @NotNull
    @Size(min = 5, max = 120)
    @Column(nullable = false)
    @Email
    private String email;

    @NotNull
    @Size(min = 5, max = 10)
    @Column(nullable = false)
    private String phone;

    @NotNull
    @Size(min = 5, max = 240)
    @Column(nullable = false)
    private String objectifs;

    @NotNull
    @Size(min = 5, max = 240)
    @Column(nullable = false)
    private String admissionRequirements;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Size(min = 5, max = 240)
    @Column(nullable = false)
    private String documents;

    @OneToMany(mappedBy = "association", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<SubsidyRequest> subsidyRequests;

    @OneToMany(mappedBy = "association", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<AuthorizationRequest> authorizationRequests;

    @OneToMany(mappedBy = "association")
    private Set<Member> members;

    @ManyToMany
    @JoinTable(
            name = "association_event",
            joinColumns = @JoinColumn(name = "association_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Event> events;
    public Association() {
    }

    public Association(String name, String address, String email, String phone, String objectifs, String admissionRequirements, Status status, String documents, Set<SubsidyRequest> subsidyRequests, Set<AuthorizationRequest> authorizationRequests, Set<Member> members) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.objectifs = objectifs;
        this.admissionRequirements = admissionRequirements;
        this.status = status;
        this.documents = documents;
//        this.subsidyRequests = subsidyRequests;
        this.authorizationRequests = authorizationRequests;
        this.members = members;
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

//    public Set<SubsidyRequest> getSubsidyRequests() {
//        return subsidyRequests;
//    }
//
//    public void setSubsidyRequests(Set<SubsidyRequest> subsidyRequests) {
//        this.subsidyRequests = subsidyRequests;
//    }

    public Set<AuthorizationRequest> getAuthorizationRequests() {
        return authorizationRequests;
    }

    public void setAuthorizationRequests(Set<AuthorizationRequest> authorizationRequests) {
        this.authorizationRequests = authorizationRequests;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
