package com.example.employee;
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empId = request.getParameter("empid");

        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs;

            if (empId != null && !empId.isEmpty()) {
                rs = st.executeQuery("SELECT * FROM employee WHERE EmpID=" + empId);
            } else {
                rs = st.executeQuery("SELECT * FROM employee");
            }

            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Salary</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("EmpID") + "</td>");
                out.println("<td>" + rs.getString("Name") + "</td>");
                out.println("<td>" + rs.getDouble("Salary") + "</td></tr>");
            }
            out.println("</table>");
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
