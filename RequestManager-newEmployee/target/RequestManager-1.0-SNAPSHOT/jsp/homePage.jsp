<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome Page</title>
    <style>
        * {
            box-sizing: border-box;
        }
        body {
            margin: 0;
        }
        .nav {
            background-color: #dddddd;
            height: 50px;
        }
        .nav ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }
        .nav > ul > li {
            float: left;
        }
        .nav ul li a {
            text-decoration: none;
            background-color: #dddddd;
            color: rgb(0, 0, 0);
            display: block;
            line-height: 50px;
            padding: 0 16px;
        }
        .nav ul li:hover > a{
            background-color: #ababab;
        }
        .nav ul li{
            position: relative;
            z-index: 1000;
        }
        .nav ul li ul{
            position: absolute;
            visibility: hidden;
        }
        .nav ul li:hover > ul{
            visibility: visible;
        }
        .nav ul li ul li a{
            min-width: 150px;
            white-space: nowrap;
            background-color: orangered;
            color: white;
        }
        .nav ul li ul li:hover > a{
            background-color: hsl(16, 100%, 40%);
        }
        .nav ul ul ul{
            top: 0;
            left: 100%;
            padding-left: 10px;
        }
        .nav ul ul li:last-child > a{
            border-bottom: 10px solid rgb(86, 226, 86);
            border-radius: 0 0 10px 10px;
        }
        .banner{
            position: relative;
        }
        .banner img{
            display: block;
            width: 100%;
        }
    </style>
</head>
<body>
<div class="nav" >
    <ul>
        <li><a href="#">Home</a></li>
        <li>
            <a href="#">EmplyeeManagement </a>
            <ul>
                <li><a href="register.jsp">NewEmployee  </a></li>
                <li><a href="list.jsp">EmployeeList  </a></li>
            </ul>
        </li>
        <li>
            <a href="#"> RequestLeave</a>
            <ul>
                <li><a href="#">NewRequest </a></li>
                <li><a href="#">  ListAllRequest</a></li>
            </ul></li>
        <li>
            <a href="#">Email</a>
            <ul>
                <li><a href="#">NewEmail  </a></li>
                <li><a href="#"> EmailSent  </a></li>
            </ul></li>
    </ul>
    <img src="image.jpg" height="100%" width="100%" align="center">
</div>

<div class="banner">
    <img src="image.jpg" alt="">
</div>


</body>