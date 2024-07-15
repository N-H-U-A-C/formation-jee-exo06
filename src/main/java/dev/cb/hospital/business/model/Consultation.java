package dev.cb.hospital.business.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultation_id")
    private long id;
    private LocalDate date;
    private String doctorName;
    private String checkup;
    private String advice;

    public Consultation() {
    }

    public Consultation(LocalDate date, String doctorName, String checkup, String advice) {
        this.date = date;
        this.doctorName = doctorName;
        this.checkup = checkup;
        this.advice = advice;
    }

    public void update(Consultation consultation) {
        this.date = consultation.getDate();
        this.doctorName = consultation.getDoctorName();
        this.checkup = consultation.getCheckup();
        this.advice = consultation.getAdvice();
    }

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getCheckup() {
        return checkup;
    }

    public void setCheckup(String checkup) {
        this.checkup = checkup;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
