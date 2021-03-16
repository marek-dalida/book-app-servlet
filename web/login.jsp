<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 11.03.2021
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona logowania</title>
</head>
<link rel="stylesheet" href="style.css" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<body>
<div class="wrapper">
    <div class="loginPageStyle">
            <h1 class="text-center mb-2">
                Biblioteka
            </h1>
        <form name="loginForm" method="post" action="LoginServlet">
            <div class="form-group">
                <label for="username">Nazwa użytkownika</label>
                <input type="text" class="form-control" name="username" id="username" placeholder="Podaj nazwę użytkownika">
            </div>
            <div class="form-group">
                <label for="password">Hasło</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Hasło">
            </div>
            <button type="submit" class="btn btn-secondary">Zaloguj</button>
        </form>
    </div>
</div>

</body>
</html>
