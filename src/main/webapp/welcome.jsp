<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%! String name = ""; %>
<% name = "Austin".toUpperCase(); %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="partials/navbar.jsp" %>
    <h1>Hello, my name is: <%= name%></h1>
</body>
</html>