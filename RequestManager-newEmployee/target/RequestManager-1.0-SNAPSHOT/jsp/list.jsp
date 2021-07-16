<%@ page import="com.dotin.RequestManager.service.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dotin.RequestManager.service.EmployeeService" %>
<%@ page import="com.dotin.RequestManager.dto.EmployeeDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ListEmployee</title>
</head>
<style>
    *{
        box-sizing: border-box;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
    }
    body{
        font-family: Helvetica;
        -webkit-font-smoothing: antialiased;
        background: rgba( 71, 147, 227, 1);
    }
    h2{
        text-align: center;
        font-size: 18px;
        text-transform: uppercase;
        letter-spacing: 1px;
        color: white;
        padding: 30px 0;
    }
    /* Table Styles */
    .table-wrapper{
        margin: 10px 70px 70px;
        box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );
    }
    .fl-table {
        border-radius: 5px;
        font-size: 12px;
        font-weight: normal;
        border: none;
        border-collapse: collapse;
        width: 100%;
        max-width: 100%;
        white-space: nowrap;
        background-color: white;
    }
    .fl-table td, .fl-table th {
        text-align: center;
        padding: 8px;
    }
    .fl-table td {
        border-right: 1px solid #f8f8f8;
        font-size: 12px;
    }
    .fl-table thead th {
        color: #ffffff;
        background: #4FC3A1;
    }
    .fl-table thead th:nth-child(odd) {
        color: #ffffff;
        background: #324960;
    }
    .fl-table tr:nth-child(even) {
        background: #F8F8F8;
    }
    .save-btn{
        margin-top: 0px;
        margin-left: auto;
        margin-right: auto;
        display: block;
        cursor: pointer;
        border: none;
        padding: 1em 1.5em;
        outline: none;
        transition: all 200ms;
    }
    @media (max-width: 767px) {
        .fl-table {
            display: block;
            width: 100%;
        }
        .table-wrapper:before{
            content: "Scroll horizontally >";
            display: block;
            text-align: right;
            font-size: 11px;
            color: white;
            padding: 0 0 10px;
        }
        .fl-table thead, .fl-table tbody, .fl-table thead th {
            display: block;
        }
        .fl-table thead th:last-child{
            border-bottom: none;
        }
        .fl-table thead {
            float: left;
        }
        .fl-table tbody {
            width: auto;
            position: relative;
            overflow-x: auto;
        }
        .fl-table td, .fl-table th {
            padding: 20px .625em .625em .625em;
            height: 60px;
            vertical-align: middle;
            box-sizing: border-box;
            overflow-x: hidden;
            overflow-y: auto;
            width: 120px;
            font-size: 13px;
            text-overflow: ellipsis;
        }
        .fl-table thead th {
            text-align: left;
            border-bottom: 1px solid #f7f7f9;
        }
        .fl-table tbody tr {
            display: table-cell;
        }
        .fl-table tbody tr:nth-child(odd) {
            background: none;
        }
        .fl-table tr:nth-child(even) {
            background: transparent;
        }
        .fl-table tr td:nth-child(odd) {
            background: #F8F8F8;
            border-right: 1px solid #E6E4E4;
        }
        .fl-table tr td:nth-child(even) {
            border-right: 1px solid #E6E4E4;
        }
        .fl-table tbody td {
            display: block;
            text-align: center;
        }
    }
</style>
<body>
<%
    EmployeeService employeeServiceT = new EmployeeService();
    List<EmployeeDto> employees = employeeServiceT.findAll();
%>
<h2>Responsive Table</h2>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>Row</th>
            <th>FirstName</th>
            <th>LasteName</th>
            <th>NationalCode</th>
            <th>State</th>
<%--            <th>Delete</th>--%>
<%--            <th>Update</th>--%>
<%--            <th>Info</th>--%>

        </tr>
        </thead>
        <tbody>
        <%
            int rowIndex = 0;
            for (EmployeeDto employee : employees) {
                rowIndex++;
        %>
        <tr>
            <td><%=rowIndex%>
            <td><%=employee.getFirstName()%>
            <td><%=employee.getLastName()%>
            <td><%=employee.getNationalCode()%>
                    <%
            if (employee.getDisable().equals(false)){
        %>
            <td>فعال
                    <%
            }else {
        %>
            <td>غیر فعال
                    <%
            }
        %>
            <td><a href="/jsp/employeeView.jsp?id=<%=employee.getId()%>" target="._top">مشاهده</a>
            <td><a href="#" onclick="del(<%=employee.getId()%>)" >حذف</a>
            <td><a href="/jsp/employeeUpdate.jsp?id=<%=employee.getId()%>">ویرایش</a>
                    <%
            if (employee.getDisable().equals(false)){
        %>
            <td><a href="/employee-controller?action=disable&id=<%=employee.getId()%>">غیر فعالسازی</a>
                    <%
            }else {
        %>
            <td><a href="/employee-controller?action=active&id=<%=employee.getId()%>">فعالسازی</a>

                    <%
                }
            }
    %>
        </tbody>

    </table>

</div>
<button class="save-btn">Search</button>
</body>
</html>