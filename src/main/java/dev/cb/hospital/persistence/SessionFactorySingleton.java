package dev.cb.hospital.persistence;

import dev.cb.hospital.business.model.Consultation;
import dev.cb.hospital.business.model.Patient;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

// TODO check try-with-resources
// TODO check synchronized
// TODO refactor with an enum
public class SessionFactorySingleton {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    private SessionFactorySingleton() {
        standardServiceRegistry = new StandardServiceRegistryBuilder()
                .build();
        sessionFactory = new MetadataSources(standardServiceRegistry)
                .addAnnotatedClasses(Patient.class, Consultation.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            new SessionFactorySingleton();
        }
        return sessionFactory;
    }
}
