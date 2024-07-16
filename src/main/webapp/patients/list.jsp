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
        <h2>Ajouter un patient</h2>
        <%if (session.getAttribute("loggedin") != null && (boolean) session.getAttribute("loggedin")) {%>
        <form action="${pageContext.request.contextPath}/patient/add" method="post" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="lastName" class="form-label">Nom :</label>
                <input type="text" class="form-control" id="lastName" name="lastName">
            </div>
            <div class="mb-3">
                <label for="firstName" class="form-label">Prénom :</label>
                <input type="text" class="form-control" id="firstName" name="firstName">
            </div>
            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Téléphone :</label>
                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
            </div>
            <div class="mb-3">
                <label for="birthDate" class="form-label">Téléphone :</label>
                <input type="date" class="form-control" id="birthDate" name="birthDate">
            </div>
<%--            <div class="mb-3">--%>
<%--                <label for="picture" class="form-label">Photo :</label>--%>
<%--                <input type="file" class="form-control" id="picture" accept="image/*" name="picture">--%>
<%--            </div>--%>
            <button type="submit" class="btn btn-primary">Valider</button>
            <button type="reset" class="btn btn-primary">Réinitialiser</button>
        </form>
        <%} else {%>
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
