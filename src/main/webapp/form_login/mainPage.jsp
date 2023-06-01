<%--
  Created by IntelliJ IDEA.
  User: Timur
  Date: 19.05.2023
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="/form_login/css/style.css"%>
    </style>
    <title>Form login</title>
</head>
<body>
<h1 class="header">Login Form</h1>
<form action="${pageContext.request.contextPath}/check-login" method="post">
    <main>
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>
        <br><br>
        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>
        <br><br>
        <button type="submit">Restore</button>
    </main>
    <br>
    <footer>
        <span class="psw">Forgot <a href="/restore-pass">password?</a></span><br>
        <span class="account">Don't have an account? <a href="/create-account">create account</a></span>
    </footer>
</form>
</body>
</html>
