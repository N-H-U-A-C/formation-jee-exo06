package dev.cb.hospital.persistence;

import dev.cb.hospital.business.model.Consultation;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ConsultationRepository {

    private SessionFactory sessionFactory;

    public ConsultationRepository() {
        this.sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    // basic CRUD
    public void save(Consultation consultation) {
        sessionFactory.inTransaction(session -> session.persist(consultation));
    }

    public Optional<Consultation> findById(Long id) {
        return sessionFactory.fromTransaction(session -> Optional.ofNullable(session.find(Consultation.class, id)));
    }

    public List<Consultation> findAll() {
        return sessionFactory.fromTransaction(session ->
                session.createSelectionQuery("from Consultation", Consultation.class)
                        .getResultList());
    }

    public void update(Consultation consultation) {
        sessionFactory.inTransaction(session -> session.merge(consultation));
    }

    public void delete(Consultation consultation) {
        sessionFactory.inTransaction(session -> session.remove(consultation));
    }
}
