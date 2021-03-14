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
    <title>Strona główna</title>
  </head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <body>
  <div>
    <h1 class="h1 text-center mt-5">
      Biblioteka
    </h1>
    <form name="loginForm" method="post" action="login">
      Username: <input type="text" name="username"/> <br/>
      Password: <input type="password" name="password"/> <br/>
      <input type="submit" value="Login" />
    </form>
  </div>
  </body>
</html>
