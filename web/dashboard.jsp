<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 15.03.2021
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="models.User" scope="session"/>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<div>
    <h1> Dashboard </h1>
    <br/>
    <br/>
    Jestes zalogowany jako: ${user.login}

    <c:forEach var = "i" begin = "1" end = "5">
    Item <c:out value = "${i}"/><p>
    </c:forEach>

    <table>
        <c:forEach items="${applicationScope.books}" var="book">
            <tr>
                <td>Title : <c:out value="${book.title}"/></td>
                <td>Author : <c:out value="${book.author}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
