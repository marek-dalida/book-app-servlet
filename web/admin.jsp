<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 15.03.2021
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="models.User" scope="application"/>
<html>
<head>
    <title>Panel Admina</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<body>
<div>
    <h1 class="h1 text-center"> Panel Administratora </h1>
    <br/>
    <br/>
    <div class="text-center h4 mb-3">
        Jestes zalogowany jako: <b>${user.login}</b>
        <form name="logout" method="post" action="LogoutServlet">
            <button type="submit" class=" mt-2 btn btn-secondary">Wyloguj</button>
        </form>
    </div>

    <form name="addBook" method="post" action="AdminServlet">
        <div class="form-group">
            <label for="title">Tytuł</label>
            <input type="text" class="form-control" name="title" id="title" placeholder="Podaj tytuł">
        </div>

        <div class="form-group">
            <label for="author">Autor</label>
            <input type="text" class="form-control" id="author" name="author" placeholder="Podaj autora">
        </div>

        <div class="form-group">
            <label for="year">Rok wydania</label>
            <input type="number" class="form-control" id="year" name="year" placeholder="Podaj rok wydania">
        </div>
        <button type="submit" class="btn btn-secondary">Dodaj</button>
    </form>

    <table class=" col-10 table table-striped">
        <thead>
        <tr>
            <th scope="col">Tytuł</th>
            <th scope="col">Autor</th>
            <th scope="col">Rok wydania</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${applicationScope.books}" var="book">
            <tr>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.year}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
