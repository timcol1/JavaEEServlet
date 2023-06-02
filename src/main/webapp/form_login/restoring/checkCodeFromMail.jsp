<%--
  Created by IntelliJ IDEA.
  User: Timur
  Date: 02.06.2023
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check Code</title>
</head>
<body>
<h1>An email has been sent to your email to reset your password</h1>
<form action="${pageContext.request.contextPath}/restore-pass" method="post">
    <main>
        <label for="uname"><b>Enter your code</b></label>
        <input type="text" placeholder="Enter code" name="uname" required>
        <br><br>
        <button type="submit">Check password</button>
    </main>
</form>
</body>
</html>
