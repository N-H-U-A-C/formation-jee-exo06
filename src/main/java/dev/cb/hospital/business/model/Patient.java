package dev.cb.hospital.business.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Patient {

    @Id
    @GeneratedValue()
    @Column(name = "patient_id")
    private long id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    // TODO picture field

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations = new ArrayList<>();

    public Patient() {
    }

    public Patient(String lastName, String firstName, LocalDate birthDate, List<Consultation> consultations) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.consultations = consultations;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }
}
