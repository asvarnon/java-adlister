<%--
  Created by IntelliJ IDEA.
  User: austinvarnon
  Date: 11/10/20
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="username" value="Create a username" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Create a User</h1>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="text">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
