<%--
  Created by IntelliJ IDEA.
  User: jnditife
  Date: 07/02/2019
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Creer un pret</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<s:form action="createreservation">
    <s:textfield name="reservationInfo.bookId" label="livre"/>
    <s:submit name="ok"/>
</s:form>
</body>
</html>