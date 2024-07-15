package dev.cb.hospital.persistence;

import dev.cb.hospital.business.model.Patient;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class PatientRepository {

    private SessionFactory sessionFactory;

    public PatientRepository() {
        this.sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    // basic CRUD
    public void save(Patient patient) {
        sessionFactory.inTransaction(session -> session.persist(patient));
    }

    public Optional<Patient> findById(Long id) {
        return sessionFactory.fromTransaction(session -> Optional.ofNullable(session.find(Patient.class, id)));
    }

    public List<Patient> findAll() {
        return sessionFactory.fromTransaction(session ->
                session.createSelectionQuery("from Patient", Patient.class)
                        .getResultList());
    }

    public void update(Patient patient) {
        sessionFactory.inTransaction(session -> session.merge(patient));
    }

    public void delete(Patient patient) {
        sessionFactory.inTransaction(session -> session.remove(patient));
    }
}
