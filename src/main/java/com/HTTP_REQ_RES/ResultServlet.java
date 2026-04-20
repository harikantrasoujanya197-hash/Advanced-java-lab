package com.HTTP_REQ_RES;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// imports (same style kept)
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/processResult")
public class ResultServlet extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
     
     // Get parameters
     String roll = request.getParameter("roll");
     String name = request.getParameter("name");

     int s1 = Integer.parseInt(request.getParameter("sub1"));
     int s2 = Integer.parseInt(request.getParameter("sub2"));
     int s3 = Integer.parseInt(request.getParameter("sub3"));
     int s4 = Integer.parseInt(request.getParameter("sub4"));
     int s5 = Integer.parseInt(request.getParameter("sub5"));

     String message;

     // Server-side validation
     if (roll == null || roll.trim().isEmpty() || name == null || name.trim().isEmpty()) {
         message = "Error: Roll No and Name are required";
     } else {
         int[] marks = {s1, s2, s3, s4, s5};

         for (int m : marks) {
             if (m < 0 || m > 100) {
                 message = "Error: Marks must be between 0 and 100";
                 request.setAttribute("message", message);
                 RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
                 rd.forward(request, response);
                 return;
             }
         }

         // Calculate average
         double avg = (s1 + s2 + s3 + s4 + s5) / 5.0;

         // Result (Pass/Fail)
         String result = "Pass";
         for (int m : marks) {
             if (m < 40) {
                 result = "Fail";
                 break;
             }
         }

         message = "Result Processed Successfully";

         // Set attributes
         request.setAttribute("roll", roll);
         request.setAttribute("name", name);
         request.setAttribute("s1", s1);
         request.setAttribute("s2", s2);
         request.setAttribute("s3", s3);
         request.setAttribute("s4", s4);
         request.setAttribute("s5", s5);
         request.setAttribute("avg", avg);
         request.setAttribute("result", result);
     }

     request.setAttribute("message", message);

     // Forward to JSP
     RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
     dispatcher.forward(request, response);
 }

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
     response.sendRedirect("index.jsp");
 }
}