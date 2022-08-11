package org.iassociation.dto;

import org.iassociation.model.Association;

import java.time.LocalDate;

/**
 * @author Hamza Amentag
 * @since 8/6/2022
 */
public class MemberDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String idNumber;
    private LocalDate dob;
    private String profession;
    private String address;
    private String phone;
    private String email;
    private String photo;
    private Association association;

    public MemberDTO() {
    }

    public MemberDTO(Long id, String firstName, String lastName, String idNumber, LocalDate dob, String profession, String address, String phone, String email, String photo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.dob = dob;
        this.profession = profession;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
