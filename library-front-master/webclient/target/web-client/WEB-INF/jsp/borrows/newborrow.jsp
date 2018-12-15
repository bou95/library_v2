<%--
  Created by IntelliJ IDEA.
  User: juju
  Date: 09/05/18
  Time: 16:35
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
<s:form action="createborrow">
    <s:textfield name="bookInfo.bookId" label="livre"/>
    <s:submit name="ok"/>
</s:form>
</body>
</html>
