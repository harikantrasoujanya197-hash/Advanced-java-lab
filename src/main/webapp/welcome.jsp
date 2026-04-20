<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<%
String name = request.getParameter("uname");
String timeStr = request.getParameter("time");

int time = Integer.parseInt(timeStr);

out.print("Welcome! " + name);
out.print("<br>Session has started ... " + name);

session.setAttribute("user", name);

out.print("<br>Your name has been stored in session object");

// ✅ Set user-defined session expiry
session.setMaxInactiveInterval(time);

out.print("<br>Session expiry time is set to " + time + " seconds");

out.print("<br>Kindly press the following link to check it within the set time or wait to see session expiry<br>");
%>

<br>
<a href="second.jsp">Display the value</a>

</body>
</html>