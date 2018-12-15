<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: juju
  Date: 20/04/18
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Tous les livres</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container" align="center">
    <div class="row">
        <section class="col-lg-12">
            <h2>Tous les livres</h2>
            <table class="table table-bordered table-striped table-condensed">
                <thead>
                <tr>
                    <th>Titre</th>
                    <th>Auteur</th>
                    <th>Catégory</th>
                    <th>Disponiilité</th>
                </tr>
                </thead>

                <tbody>
                <s:iterator value="bookInfoList">
                    <tr>

                        <td><s:a action="book"> <s:param name="id" value="book_id"/><s:property value="title"/></s:a></td>
                        <td><s:property value="author"/> </td>
                        <td><s:property value="category"/> </td>
                        <td><s:property value="available"/> </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </section>
        <s:actionerror />
    </div>

</body>
</html>
