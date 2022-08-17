package org.iassociation.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Hamza Amentag
 * @since 8/6/2022
 */
@Entity
@Table(name = "MEMBER")
public class Member extends BaseEntity {

    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name = "ID_NUMBER")
    private String idNumber;

    @NotNull
    @Column(name = "DOB")
    private LocalDate dob;

    @NotNull
    @Column(name = "PROFESSION")
    private String profession;

    @NotNull
    @Column(name = "ADDRESS")
    private String address;

    @NotNull
    @Column(name = "PHONE")
    private String phone;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHOTO")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "association_id", nullable = true)
    private Association association;

    @ManyToOne
    @JoinColumn(name = "executive_committee_id", nullable = true)
    private ExecutiveCommittee executiveCommittee;

    //no-args constructor for jpa
    public Member() {
    }

    public Member(String firstName, String lastName, String idNumber, LocalDate dob, String profession, String address, String phone, String email, String photo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Member member = (Member) o;
        return firstName.equals(member.firstName) && lastName.equals(member.lastName) && idNumber.equals(member.idNumber) && dob.equals(member.dob) && profession.equals(member.profession) && address.equals(member.address) && phone.equals(member.phone) && Objects.equals(email, member.email) && Objects.equals(photo, member.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, idNumber, dob, profession, address, phone, email, photo);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", dob=" + dob +
                ", profession='" + profession + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
