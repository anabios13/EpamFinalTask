<%@ page import="dao.BusStopTable" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Расписание" %>
</h1>
<br/>
<a href="My-Servlet-JSP">Логин</a>
<p>
    <%
        java.util.Date now = new java.util.Date();
        String date = "Текущая дата: "+now;
    %>
    <%= date%>>
</p>
<p>
    <%
        BusStopTable busStopTable = new BusStopTable();
        busStopTable.init(request,response);
    %>
    <%= busStopTable.getNameOfBusStop()%>>
</p>
</body>
</html>