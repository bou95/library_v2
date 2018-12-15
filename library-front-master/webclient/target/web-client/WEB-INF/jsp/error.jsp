<%--
  Created by IntelliJ IDEA.
  User: juju
  Date: 20/04/18
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <title>erreur s'est produite</title>
</head>

<body>
<%@ include file="./header.jsp" %>
<h3 align="center">Une erreur s'est produite</h3>

<s:actionerror />
</body>
</html>
