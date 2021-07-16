<%@ page import="com.dotin.RequestManager.controller.EmployeeController" %><%--
  Created by IntelliJ IDEA.
  User: Ramin
  Date: 7/15/2021
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <%
        String id = request.getParameter("id");
      String fname = request.getParameter("firstname");
      String lname = request.getParameter("lastname");
      String nCode = request.getParameter("NationalCode");
      String eAddress = request.getParameter("EmailAddress");
        String address = request.getParameter("address");
      String pNumber = request.getParameter("PhoneNumber");
        String manager = request.getParameter("manager");
        String role = request.getParameter("role");

      EmployeeController employeeController = new EmployeeController();
      employeeController.save(id ,fname ,lname ,nCode , eAddress ,pNumber , address ,manager , role );
      %>
</body>
</html>
