package dev.cb.hospital.controller;

import dev.cb.hospital.business.model.Patient;
import dev.cb.hospital.business.service.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "patientServlet", value = "/patient/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class PatientServlet extends HttpServlet {

    public static final String IMAGES_DIRECTORY = "/images";

    private PatientService patientService;
    private String uploadPath;

    @Override
    public void init() {
        patientService = new PatientService();
        uploadPath = getServletContext().getRealPath("") + File.separator + IMAGES_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        switch (pathInfo) {
            case "list":
                forwardList(req, resp);
                break;
            case "detail":
                forwardDetail(req, resp);
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
        //TODO finish upload picture
        String picture = writePicture(req, resp);
        Patient patient = new Patient(lastName, firstName, phoneNumber, birthDate);
        patientService.save(patient);
        resp.sendRedirect("list");
    }

    //TODO finish upload picture
    private String writePicture(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part picture = req.getPart("image");
        String fileName = picture.getSubmittedFileName();
        String fullPath = uploadPath + File.separator + fileName;
        picture.write(fullPath);
        return fullPath;
    }

    private void forwardList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients = patientService.getAll();
        req.setAttribute("patients", patients);
        req.getRequestDispatcher("/patients/list.jsp").forward(req, resp);
    }

    private void forwardDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Optional<Patient> optionalPatient = patientService.getById(id);
        // TODO handle null optionalPatient
        req.setAttribute("patient", optionalPatient.orElse(new Patient("Error", "Error", "Error", LocalDate.now())));
        req.getRequestDispatcher("/patients/detail.jsp").forward(req, resp);
    }
}
