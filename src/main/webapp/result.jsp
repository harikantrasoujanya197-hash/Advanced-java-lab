<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Result</title>
<style>
.result-container {
    width:300px;
    margin:50px auto;
    padding:20px;
    border:1px solid #ccc;
}
.message {
    color:green;
}
.error {
    color:red;
}
</style>
</head>
<body>

<div class="result-container">

<h2>Processing Result</h2>

<div class="<%= ((String)request.getAttribute("message")).contains("Error") ? "error" : "message" %>">
    <%= request.getAttribute("message") %>
</div>

<% if(request.getAttribute("roll") != null) { %>

<h3>Student Data:</h3>

<p>Roll No: <%= request.getAttribute("roll") %></p>
<p>Name: <%= request.getAttribute("name") %></p>

<p>Sub1: <%= request.getAttribute("s1") %></p>
<p>Sub2: <%= request.getAttribute("s2") %></p>
<p>Sub3: <%= request.getAttribute("s3") %></p>
<p>Sub4: <%= request.getAttribute("s4") %></p>
<p>Sub5: <%= request.getAttribute("s5") %></p>

<p>Average: <%= request.getAttribute("avg") %></p>
<p>Result: <%= request.getAttribute("result") %></p>

<% } %>

<a href="index.jsp">Back to Form</a>

</div>

</body>
</html>