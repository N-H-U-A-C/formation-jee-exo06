<jsp:useBean id="patient" type="dev.cb.hospital.business.model.Patient" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../WEB-INF/imports/bootstrap.html" %>
</head>
<body>
<%@include file="../WEB-INF/html/header.html" %>
<main>
    <div class="container">
        <h2>Détail du patient :</h2>
        <section>
            <div>
                <p>Nom : <%=patient.getLastName()%></p>
            </div>
            <div>
                <p>Prénom : <%=patient.getFirstName()%></p>
            </div>
            <div>
                <p>Date de naissance : <%=patient.getBirthDate()%></p>
            </div>
            <div>
                <p>Téléphone : <%=patient.getPhoneNumber()%></p>
            </div>
        </section>
        <section class="bg-body-secondary">
            <h2>Ajouter une consultation</h2>
            <a href="#" class="btn btn-primary bg-primary">Valider</a>
        </section>
<%--        <section>--%>
<%--            <%if (!patient.getConsultations().isEmpty()) {%>--%>
<%--            <p>Il y a des consultations</p>--%>
<%--            <%} else {%>--%>
<%--            <h2>Aucune consultation pour ce patient</h2>--%>
<%--            <%}%>--%>
<%--        </section>--%>
    </div>
</main>
<%@include file="../WEB-INF/html/footer.html" %>
</body>
</html>
