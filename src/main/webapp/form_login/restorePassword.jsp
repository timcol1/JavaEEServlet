<%--
  Created by IntelliJ IDEA.
  User: Timur
  Date: 01.06.2023
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    <%@include file="/form_login/css/style.css"%>
  </style>
    <title>Restoring</title>
</head>
<body>
<h1 class="header">Restore Password</h1>
<form action="${pageContext.request.contextPath}/restoring-pass" method="post">
  <main>
    <label for="email"><b>Email</b></label>
    <input type="email" placeholder="Enter your email" name="email" required>
    <button type="submit">Restore</button>
  </main>
  <br>
  <footer>
    <span class="psw">Want to return to main page? <a href="/login">Click here to go to the log in form</a></span>
  </footer>
</form>
</body>
</html>
