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
    <title>Dashboard</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<body>
<div>
    <h1 class="h1 text-center"> Panel użytkownika </h1>
    <br/>
    <br/>
    <div class="text-center h4">
        Jestes zalogowany jako: <b>${user.login}</b>
        <a href="LogoutServlet">wyloguj</a>
    </div>
    <form name="searchBooks" method="post" action="DashboardServlet">
        <div class="form-group">
            <label for="search">Wyszukaj</label>
            <input type="text" class="form-control" name="search" id="search" placeholder="Szukaj">
        </div>
        <button type="submit" class="btn btn-secondary">Szukaj</button>
    </form>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tytuł</th>
            <th scope="col">Autor</th>
            <th scope="col">Rok wydania</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${applicationScope.books.stream().filter(p ->  p.title.contains('5')).toArray()}" var="book">
            <tr>
                <th scope="row">1</th>
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
