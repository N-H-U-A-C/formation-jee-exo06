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
    private long id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    // TODO picture field

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patient_id")
    private List<Consultation> consultations = new ArrayList<>();

    public Patient() {
    }

    public Patient(String lastName, String firstName, LocalDate birthDate, List<Consultation> consultations) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.consultations = consultations;
    }

    public void update(Patient patient) {
        this.setLastName(patient.getLastName());
        this.setFirstName(patient.getFirstName());
        this.setBirthDate(patient.getBirthDate());
        this.setConsultations(patient.getConsultations());
    }

    public long getId() {
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
}
