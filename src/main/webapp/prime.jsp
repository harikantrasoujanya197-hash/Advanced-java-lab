
/* 6c. Build a servlet program to check the given number is prime number or not using HTML 
with step by step procedure. */



html>
<body>

<%
String numStr = request.getParameter("number");

if (numStr == null || numStr.trim().isEmpty()) {
    response.setStatus(400);
%>
    <h3 style="color:red;">Error: Please enter a value!</h3>
<%
} else {
    try {
        int num = Integer.parseInt(numStr);

        if (num <= 1) {
%>
            <h3 style="color:red;">Error: Enter number greater than 1</h3>
<%
        } else {
            boolean isPrime = true;

            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
%>
                <h2><%= num %> is a PRIME number</h2>
<%
            } else {
%>
                <h2><%= num %> is NOT a prime number</h2>
<%
            }
        }
    } catch (Exception e) {
        response.setStatus(400);
%>
        <h3 style="color:red;">Error: Invalid input!</h3>
<%
    }
}
%>

<br><a href="index.html">Go Back</a>

</body>
</html>
