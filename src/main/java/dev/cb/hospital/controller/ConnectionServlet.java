package dev.cb.hospital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "connectionServlet", value = "/login/*")
public class ConnectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo().substring(1);
        switch (pathInfo) {
            case "form":
                forwardForm(req, resp);
                break;
            case "submit":
                checkLoggedIn(req, resp);
                break;
        }
    }

    private void forwardForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    private void checkLoggedIn(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // TODO replace with DB connection
        if (username.equals("admin") && password.equals("admin")) {
            req.getSession().setAttribute("loggedin", true);
        }
        // TODO handle else

        resp.sendRedirect("../patient/list");
    }
}
