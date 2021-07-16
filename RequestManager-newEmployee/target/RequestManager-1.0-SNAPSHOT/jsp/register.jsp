<%@ page import="com.dotin.RequestManager.service.CategoryElementService" %>
<%@ page import="com.dotin.RequestManager.dto.CategoryElementDto" %>
<%@ page import="com.dotin.RequestManager.service.EmployeeService" %>
<%@ page import="com.dotin.RequestManager.dto.EmployeeDto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>


    <title>Document</title>
    <script src="jquery.min.js"></script>
    <style>
        * {
            box-sizing: border-box;
        }
        body {
            margin: 0;
            background: rgba( 71, 147, 227, 1);
        }
        .row::after {
            content: '';
            display: block;
            clear: both;
        }
        .form-container{
            width: 700px;
            padding: 1em;
            border: 1px solid #eee;
            margin: 100px auto;
            box-shadow: 0 2px 4px #ccc;
            border-radius: 5px;
        }
        .form-container .label-wrapper{
            float: left;
            width: 25%;
        }
        .form-container .input-wrapper{
            float: left;
            width: 75%;
        }
        .form-container .label-wrapper,
        .form-container .input-wrapper{
            padding: 8px;
        }
        .form-container .input-wrapper input{
            display: block;
            width: 100%;
            padding: 8px;
            border-radius: 6px;
            outline: none;
            border: 1px solid green;
        }
        .form-container .input-wrapper input:focus{
            background-color: rgb(215, 240, 215);
        }
        .form-container .label-wrapper label{
            display: block;
            width: 100%;
            padding: 8px;
            cursor: pointer;
        }
        .save-btn{
            margin-top: 40px;
            margin-left: auto;
            display: block;
            cursor: pointer;
            border: none;
            padding: 1em 1.5em;
            outline: none;
            transition: all 200ms;
        }
        .save-btn:hover{
            box-shadow: 0 0 4px 2px #555;
        }

    </style>
</head>
<body>
<%
    CategoryElementService categoryElementService = new CategoryElementService();
    List<CategoryElementDto> categoryElementList = categoryElementService.findAllByCode("category.id" , 1l);
    EmployeeService employeeService = new EmployeeService();
    List<EmployeeDto> employees = employeeService.findAll();
%>

<form action="getRegister.jsp" method="get">
<div class="form-container">
        <div class="row">
            <div class="label-wrapper">

                <label for="firstname"><span style="color: red">*</span> First Name </label>
            </div>
            <div class="input-wrapper">
                <input type="text" name="firstname" id="firstname" placeholder="Your First Name" required/>
            </div>
        </div>


        <div class="row">
            <div class="label-wrapper">

                <label for="lastname"><span style="color: red">*</span> Last Name </label>
            </div>
            <div class="input-wrapper">
                <input type="text" name="lastname" id="lastname" placeholder="Your Last Name" required/>
            </div>
        </div>


        <div class="row">
            <div class="label-wrapper">
                <label for="NationalCode"><span style="color: red">*</span> NationalCode </label>
            </div>
            <div class="input-wrapper">
                <input type="text" name="NationalCode" id="NationalCode" placeholder="Your National Code" required/>
            </div>
        </div>


        <div class="row">
            <div class="label-wrapper">
                <label for="EmailAddress">EmailAddress</label>
            </div>
            <div class="input-wrapper">
                <input type="text" name="EmailAddress" id="EmailAddress" placeholder="Your Email Adress"/>
            </div>
        </div>

         <div class="row">
        <div class="label-wrapper">
            <label for="EmailAddress">address</label>
        </div>
        <div class="input-wrapper">
            <input type="text" name="address" id="address" placeholder="Your Email Adress"/>
        </div>
       </div>

        <div class="row">
            <div class="label-wrapper">
                <label for="PhoneNumber">PhoneNumber</label>
            </div>
            <div class="input-wrapper">
                <input type="text" name="PhoneNumber" id="PhoneNumber" placeholder="Your Phone Number"/>
            </div>
        </div>


        <div class="row">
            <div class="label-wrapper">
                <label for="role"><span style="color: red">*</span> role </label>
            </div>
            <div class="label-wrapper">
                <select id="role" name="role" required>
                    <%
                        for (CategoryElementDto categoryElement : categoryElementList) {
                    %>
                    <option value="<%=categoryElement.getId()%>"><%=categoryElement.getName()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </div>
        </div>


        <div class="row">
            <div class="label-wrapper">
                <label for="Manager">Manager</label>
            </div>
            <div class="input-wrapper">
                <select id="manager" name="manager">
                    <%
                        for (EmployeeDto employee : employees) {
                    %>
                    <option value="<%=employee.getId()%>"><%=employee.getFirstName()%>&nbsp;<%=employee.getLastName()%> </option>
                    <%
                        }
                    %>
                </select>
            </div>
            </div>

    <div class="save-btn" style="float: left">
        <input id="save" type="submit" value="save">
    </div>


</div>
</form>
</body>
</html>

<%--<script>--%>
<%--    $('#alert-info').hide();--%>
<%--    function validate(){--%>
<%--        var result = true;--%>
<%--        if($("#firstname").val() == null || $("#firstname").val()=="") {--%>
<%--            alert("first name must be present, please enter first name");--%>
<%--            result = false;--%>
<%--        }--%>
<%--        if($("#lastname").val() == null || $("#lastname").val()=="") {--%>
<%--            alert("last name must be present, please enter last name");--%>
<%--            result = false;--%>
<%--        }--%>
<%--        if($("#NationalCode").val() == null || $("#NationalCode").val()=="") {--%>
<%--            alert("national code must be present, please enter national code");--%>
<%--            result = false;--%>
<%--        }--%>
<%--        if($("#role").val() == null || $("#role").val()=="") {--%>
<%--            alert("role must be present, please enter role");--%>
<%--            result = false;--%>
<%--        }--%>
<%--        return result;--%>
<%--    }--%>

<%--    $('#save').click(function () {--%>
<%--        if(!validate())--%>
<%--            return;--%>
<%--        $.ajax({--%>
<%--            url: '/employee-controller',--%>
<%--            type: 'POST',--%>
<%--            data: {--%>
<%--                firstName: $("#firstname").val(),--%>
<%--                lastName: $("#lastname").val(),--%>
<%--                nationalCode: $("#NationalCode").val(),--%>
<%--                role: $("#role").val(),--%>
<%--                phoneNumber: $("#PhoneNumber").val(),--%>
<%--                emailAddress: $("#EmailAddress").val(),--%>
<%--                manager: $("#manager").val()--%>
<%--            },--%>
<%--            success: function (data) {--%>
<%--                window.location = "employeeTable.jsp";--%>
<%--            },--%>
<%--            error: function (error) {--%>
<%--                $('#alert-info p').remove();--%>
<%--                $('#alert-info').append(error.responseText);--%>
<%--                $('#alert-info').show();--%>
<%--            }--%>
<%--        })--%>
<%--    });--%>
<%--</script>--%>


<%--<script>--%>
<%--    document.querySelector('#alert-info').hide();--%>

<%--    function validate(){--%>
<%--        var result = true;--%>
<%--        if(document.querySelector(firstname).value == null || document.querySelector(firstname).value=="") {--%>
<%--            alert("first name must be present, please enter first name");--%>
<%--            result = false;--%>
<%--        }--%>
<%--        if(document.querySelector(lastname).value == null || document.querySelector(lastname).value=="") {--%>
<%--            alert("last name must be present, please enter last name");--%>
<%--            result = false;--%>
<%--        }--%>
<%--        if(document.querySelector(NationalCode).value == null || document.querySelector(nationalCode).value=="") {--%>
<%--            alert("national code must be present, please enter national code");--%>
<%--            result = false;--%>
<%--        }--%>
<%--        if(document.querySelector(role).value == null || document.querySelector(role).value=="") {--%>
<%--            alert("role must be present, please enter role");--%>
<%--            result = false;--%>
<%--        }--%>
<%--        return result;--%>
<%--    }--%>

<%--    document.querySelector('#save').click(function () {--%>
<%--        if(!validate())--%>
<%--            return;--%>
<%--        $.ajax({--%>
<%--            url: '/employee-controller',--%>
<%--            type: 'POST',--%>
<%--            data: {--%>
<%--                firstName: document.querySelector("fname").value,--%>
<%--                lastName: document.querySelector("lname").value,--%>
<%--                nationalCode: document.querySelector("nationalCode").value,--%>
<%--                role: document.querySelector("role").value,--%>
<%--                phoneNumber: document.querySelector("phoneNumber").value,--%>
<%--                emailAddress: document.querySelector("emailAddress").value,--%>
<%--                manager: document.querySelector("manager").value--%>
<%--            },--%>
<%--            success: function (data) {--%>
<%--                window.location = "list.jsp.jsp";--%>
<%--            },--%>
<%--            error: function (error) {--%>
<%--                document.querySelector('#alert-info p').remove();--%>
<%--                document.querySelector('#alert-info').insertAdjacentHTML("beforeend",error.responseText);--%>
<%--                document.querySelector('#alert-info').show();--%>
<%--            }--%>
<%--        })--%>
<%--    });--%>
<%--</script>--%>












