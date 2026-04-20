<%@ page import="javax.servlet.http.Cookie" %>

<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
%>
            <b>Name:</b> <%= c.getName() %> <br>
            <b>Value (Domain):</b> <%= c.getValue() %> <br>
            <b>Max Age:</b> <%= c.getMaxAge() %> <br>
            <hr>
<%
        }
    } else {
%>
        No cookies found!
<%
    }
%>

</body>
</html>