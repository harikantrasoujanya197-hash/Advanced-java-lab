/* 7b. Construct a Cookie Management program using JSP to get the fields  Name, Domain and Max Expiry Age
 ( in sec) and press the button Add Cookie for displaying the set cookie information. Then it has to go to show the active cookie list when you
 press the link go to the active cookie list */






<%@ page import="javax.servlet.http.Cookie" %>



<html>
<head>
    <title>Cookie Added</title>
</head>
<body>

<%
    String name = request.getParameter("cname");
    String domain = request.getParameter("cdomain");
    int age = Integer.parseInt(request.getParameter("cage"));

    // Create cookie
    Cookie cookie = new Cookie(name, domain);
    cookie.setMaxAge(age);

    // Add cookie to response
    response.addCookie(cookie);
%>

<h2>Cookie Added Successfully!</h2>

<b>Name:</b> <%= name %><br>
<b>Domain:</b> <%= domain %><br>
<b>Max Age:</b> <%= age %> seconds<br><br>

<a href="viewCookies.jsp">Go to Active Cookie List</a>

</body>
</html>
