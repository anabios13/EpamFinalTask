<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.05.2022
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> TestData</h1>
    <p>
        <%
            java.util.Date now = new java.util.Date();
            String date = "Текущая дата: "+now;
        %>
        <%= date%>>
    </p>
</body>
</html>
