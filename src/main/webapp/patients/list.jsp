<%@ page import="dev.cb.hospital.business.model.Patient" %>
<jsp:useBean id="patients" type="java.util.ArrayList<dev.cb.hospital.business.model.Patient >" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hôpital Princeton-Plainsboro | Liste des patients</title>
    <%@include file="../WEB-INF/imports/bootstrap.html" %>
</head>
<body>
<%@include file="../WEB-INF/html/header.html" %>
<main>
    <div class="container d-flex flex-column justify-content-start border-bottom p-2">
        <%if (session.getAttribute("loggedin") != null && (boolean) session.getAttribute("loggedin")) {%>
            <p>Félicitations vous êtes connectés (lol)</p>
        <%} else {%>
        <h2>Ajouter un patient</h2>
        <a href="${pageContext.request.contextPath}/login/form" class="btn btn-primary bg-primary">Se connecter</a>
        <%}%>
    </div>
    <div class="container">
        <h2>Liste des patients :</h2>
        <br/>
        <%if (!patients.isEmpty()) {%>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nom</th>
                <th scope="col">Prénom</th>
                <th scope="col">Téléphone</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <%for (Patient patient : patients) {%>
            <tr>
                <th scope="row"><%=patient.getId()%>
                </th>
                <td><%=patient.getLastName()%>
                </td>
                <td><%=patient.getFirstName()%>
                </td>
                <td><%=patient.getPhoneNumber()%>
                </td>
                <td><a href="${pageContext.request.contextPath}/patient/detail?id=<%=patient.getId()%>" class="btn btn-primary">Détail</a>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <%} else {%>
        <p>Aucun patient</p>
        <%}%>
    </div>
</main>
<%@include file="../WEB-INF/html/footer.html"%>
</body>
</html>
