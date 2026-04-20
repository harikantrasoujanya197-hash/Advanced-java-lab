package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/URLServlet")

public class URLServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String countStr = request.getParameter("count");

        int count = 0;

        if (countStr != null) {
            count = Integer.parseInt(countStr);
        }

        out.println("<html><body>");

        if (userName != null && !userName.isEmpty()) {

            count++;

            out.println("<h2 style='color:blue;'>Welcome back, " + userName + "!</h2>");
            out.println("<h3 style='color:green;'>You have visited this page " + count + " times</h3>");

            out.println("<a href='URLServlet?userName=" + userName + "&count=" + count + "'>Visit Again</a>");

            out.println("<br><br>");
            out.println("<a href='URLServlet'>Logout</a>");

        } else {

            out.println("<h2 style='color:red;'>Welcome Guest! Enter your name</h2>");
            out.println("<form action='URLServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='hidden' name='count' value='0'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }
}