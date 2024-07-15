package dev.cb.hospital.business.service;


import dev.cb.hospital.business.model.Patient;
import dev.cb.hospital.persistence.PatientRepository;

import java.util.List;
import java.util.Optional;

public class PatientService {

    private PatientRepository patientRepository;

    public PatientService() {
        this.patientRepository = new PatientRepository();
    }

    // basic CRUD
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    public Optional<Patient> getById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public void update(Patient patient) {
        Optional<Patient> optionalPatient = patientRepository.findById(patient.getId());
        optionalPatient.ifPresent(fetchedPatient -> {
            fetchedPatient.update(patient);
            patientRepository.update(fetchedPatient);
        });
    }

    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }
}
