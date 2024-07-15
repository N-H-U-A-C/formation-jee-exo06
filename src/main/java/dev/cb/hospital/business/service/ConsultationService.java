package dev.cb.hospital.business.service;


import dev.cb.hospital.business.model.Consultation;
import dev.cb.hospital.persistence.ConsultationRepository;

import java.util.List;
import java.util.Optional;

public class ConsultationService {

    private ConsultationRepository consultationRepository;

    public ConsultationService() {
        this.consultationRepository = new ConsultationRepository();
    }

    // basic CRUD
    public void save(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    public Optional<Consultation> getById(Long id) {
        return consultationRepository.findById(id);
    }

    public List<Consultation> getAll() {
        return consultationRepository.findAll();
    }

    public void update(Consultation consultation) {
        Optional<Consultation> optionalConsultation = consultationRepository.findById(consultation.getId());
        optionalConsultation.ifPresent(fetchedConsultation -> {
            fetchedConsultation.update(consultation);
            consultationRepository.update(fetchedConsultation);
        });
    }

    public void delete(Consultation consultation) {
        consultationRepository.delete(consultation);
    }
}
