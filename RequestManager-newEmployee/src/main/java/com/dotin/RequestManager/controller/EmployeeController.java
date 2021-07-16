package com.dotin.RequestManager.controller;

import com.dotin.RequestManager.dto.EmployeeDto;
import com.dotin.RequestManager.exception.BadRequestException;
import com.dotin.RequestManager.service.EmployeeService;
import org.apache.catalina.connector.Response;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/employee-controller")
public class EmployeeController extends HttpServlet {
    private final static Logger log = Logger.getLogger(EmployeeController.class.getName());
    private final EmployeeService employeeService = new EmployeeService();

    public EmployeeController() {
        super();
    }
    public void save(String id ,String fname , String lname ,String NationalCode ,String EmailAddress , String PhoneNumber ,String address , String manager , String role ) throws IOException {
        log.info("request with below info has received : " + fname );
        //setCharacterEncoding("UTF-8");
        //response.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html");
       // PrintWriter out = response.getWriter();
        EmployeeDto employeeDto = new EmployeeDto();
        if (id != null)
            employeeDto.setId(Long.valueOf(id));
        employeeDto.setFirstName(fname);
        employeeDto.setLastName(lname);
        employeeDto.setNationalCode(NationalCode);
        employeeDto.setPhoneNumber(PhoneNumber);
        employeeDto.setAddress(address);
        employeeDto.setEmailAddress(EmailAddress);
        if (manager != null && !manager.isEmpty()) {
            employeeDto.setManagerId(Long.valueOf(manager));
        }
        if (role != null) {
            employeeDto.setRoleId(Long.valueOf(role));
        }

        if (employeeDto.getId() == null) {
            employeeService.add(employeeDto);
           // response.sendRedirect("/jsp/list.jsp");
//            Response response = new Response();
//            response.sendRedirect("jsp/homePage.jsp");


        } else {
            employeeDto.setTimeOffBalance(employeeService.findById(employeeDto.getId()).getTimeOffBalance());
            employeeService.update(employeeDto);
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        log.info("request with below info has received : " + request.getParameter("firstName"));
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        EmployeeDto employeeDto = new EmployeeDto();
//        if (request.getParameter("id") != null)
//            employeeDto.setId(Long.valueOf(request.getParameter("id")));
//        employeeDto.setFirstName(request.getParameter("firstName"));
//        employeeDto.setLastName(request.getParameter("lastName"));
//        employeeDto.setNationalCode(request.getParameter("nationalCode"));
//        employeeDto.setPhoneNumber(request.getParameter("phoneNumber"));
//        employeeDto.setAddress(request.getParameter("address"));
//        employeeDto.setEmailAddress(request.getParameter("emailAddress"));
//        if (request.getParameter("manager") != null && !request.getParameter("manager").isEmpty()) {
//            employeeDto.setManagerId(Long.valueOf(request.getParameter("manager")));
//        }
//        if (request.getParameter("role") != null) {
//            employeeDto.setRoleId(Long.valueOf(request.getParameter("role")));
//        }
//
//        if (employeeDto.getId() == null) {
//            employeeService.add(employeeDto);
//            response.sendRedirect("/jsp/list.jsp");
//
//        } else {
//            employeeDto.setTimeOffBalance(employeeService.findById(employeeDto.getId()).getTimeOffBalance());
//            employeeService.update(employeeDto);
//        }
//
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("request with below id has received : " + request.getParameter("id"));
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if (action.equals("del")) {
            try {
                employeeService.delete(Long.valueOf(request.getParameter("id")));
            } catch (BadRequestException e) {
                response.setStatus(400);
                e.printStackTrace();
                out.write("<p><span>" + e.getErrorMessage() + "</span><br/><a style=\"color: #0a943a\" href='/jsp/managerSubset.jsp?id=" + Long.valueOf(request.getParameter("id")) + "'>" +
                        "ویرایش" +
                        "</a></p>");
                out.close();
            }

        }
        if (action.equals("disable")) {
            EmployeeDto employeeDto = employeeService.findById(Long.valueOf(request.getParameter("id")));
            employeeDto.setDisable(true);
            employeeService.update(employeeDto);
            response.sendRedirect("/jsp/list.jsp");
        }
        if (action.equals("active")) {
            EmployeeDto employeeDto = employeeService.findById(Long.valueOf(request.getParameter("id")));
            employeeDto.setDisable(false);
            employeeService.update(employeeDto);
            response.sendRedirect("/jsp/list.jsp");
        }
    }
}
