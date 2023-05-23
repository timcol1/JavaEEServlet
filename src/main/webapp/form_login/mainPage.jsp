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
    <style type="text/css">
        main {
            color: white;
            text-align: center;
        }

        .header {
            color: white;
            text-align: center;
        }

        .main-footer {
            color: white;
            text-align: center;
        }
    </style>
    <title>Form login</title>
</head>
<body style="background-color:#9a6565">
<h1 class="header">Login Form</h1>
<form action="${pageContext.request.contextPath}/check-login" method="post">
    <main>
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>
        <br><br>
        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>
        <br><br>
        <button type="submit">Login</button>
    </main>
    <br>
    <div class="main-footer">
        <span class="psw">Forgot <a href="#">password?</a></span><br>
        <span class="account">Don't have an account? <a href="/create-account">create account</a></span>
    </div>
</form>
</body>
</html>
