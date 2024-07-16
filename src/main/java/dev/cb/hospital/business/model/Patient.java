package dev.cb.hospital.business.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private LocalDate birthDate;
    private Byte[] picture;
    // TODO picture field

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patient_id")
    private List<Consultation> consultations = new ArrayList<>();

    public Patient() {
    }

    public Patient(String lastName, String firstName, String phoneNumber, LocalDate birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public Patient(String lastName, String firstName, String phoneNumber, LocalDate birthDate, Byte[] picture) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.picture = picture;
    }

    public void update(Patient patient) {
        this.setLastName(patient.getLastName());
        this.setFirstName(patient.getFirstName());
        this.setPhoneNumber(patient.getPhoneNumber());
        this.setBirthDate(patient.getBirthDate());
        this.setPicture(patient.getPicture());
        this.setConsultations(patient.getConsultations());
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
}
