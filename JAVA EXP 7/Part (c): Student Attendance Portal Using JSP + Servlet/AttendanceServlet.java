package com.example.attendance;
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("studentId");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO attendance(StudentID, Date, Status) VALUES (?, ?, ?)");
            ps.setString(1, id);
            ps.setString(2, date);
            ps.setString(3, status);
            ps.executeUpdate();

            RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
