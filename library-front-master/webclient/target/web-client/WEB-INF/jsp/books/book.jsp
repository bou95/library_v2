<%--
  Created by IntelliJ IDEA.
  User: juju
  Date: 20/04/18
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylsheet" href="style.css">
    <title><s:property value="bookInfo.title" /></title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container" align="center">
    <div class="row">
        <section class="col-lg-12">
            <table class="table table-bordered table-condensed">
                <thead>
                <tr>
                    <th>Titre</th>
                    <th>Auteur</th>
                    <th>Disponibilité</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><s:property value="books.title" /></td>
                    <td><s:property value="books.author" /></td>
                    <td><s:property value="books.available"/></td>
                </tr>
                </tbody>
            </table>

        </section>
    </div>
</div>
</body>
</html>
