<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: juju
  Date: 11/05/18
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Info du prêt</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container" align="center">
    <div class="row">
        <section class="col-lg-12">
            <table class="table table-bordered table-condensed">
                <thead>
                <tr>
                    <th>Emprunteur</th>
                    <th>Livre</th>
                    <th>Date de fin du pret</th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td><s:property value="borrows.borrower.lastName "/> <s:property value=" borrows.borrower.firstName"/></td>
                    <td><s:property value="borrows.book.title"/> - <s:property value="borrows.book.author"/></td>
                    <td><s:property value="borrows.term"/></td>
                </tr>
                </tbody>
            </table>
        </section>
    </div>
</div>
</body>
</html>
