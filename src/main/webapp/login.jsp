
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hôpital Princeton-Plainsboro | Se connecter</title>
    <%@include file="/WEB-INF/imports/bootstrap.html" %>
</head>
<body>
<main>
    <div class="container">
        <h2>Se connecter</h2>
        <form action="${pageContext.request.contextPath}/login/submit" method="get">
            <div class="mb-3">
                <label for="username" class="form-label">Login</label>
                <input type="text" class="form-control" id="username" name="username">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <button type="submit" class="btn btn-primary">Valider</button>
            <button type="reset" class="btn btn-primary">Réinitialiser</button>
        </form>
    </div>
</main>
</body>
</html>
