package dev.cb.hospital.controller;

import dev.cb.hospital.business.model.Patient;
import dev.cb.hospital.business.service.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "patientServlet", value = "/patient/*")
public class PatientServlet extends HttpServlet {

    private PatientService patientService;

    @Override
    public void init() {
        patientService = new PatientService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        switch (pathInfo) {
            case "list":
                forwardList(req, resp);
                break;
            case "detail":
//                displayDetail(req, resp);
                break;
//            case "form":
//                forwardForm(req, resp);
//                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String phoneNumber = req.getParameter("phoneNumber");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        Patient patient = new Patient(lastName, firstName, phoneNumber, birthDate);
        patientService.save(patient);
        resp.sendRedirect("list");
    }

    private void forwardList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients = patientService.getAll();
        req.setAttribute("patients", patients);
        getServletContext().getRequestDispatcher("/patients/list.jsp").forward(req, resp);
    }
}
