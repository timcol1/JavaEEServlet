<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 22.05.2023
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body style="background-color:#f1f1f1">
<h1>Registration Form</h1>
<form action="${pageContext.request.contextPath}/registration-account" method="post">
    <div class="container">
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>
        <br><br>
        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>
        <br><br>
        <label for="email"><b>Email</b></label>
        <input type="email" placeholder="Enter your email" name="email" required>
        <br><br>
        <button type="submit">Registrate account</button>
    </div>
    <br>
    <div class="container" style="background-color:#f1f1f1">
        <span class="psw">Have account? <a href="/login">Click here to go to log in form</a></span>
    </div>
</form>
</body>
</html>
