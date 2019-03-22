<%--
  Created by IntelliJ IDEA.
  User: juju
  Date: 20/04/18
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="html" uri="/struts-tags" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title><s:property value="userInfo.lastName"/></title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container" align="center">
    <div class="row">
        <section class="col-lg-12">
            <div class="row">
                <h2>Les infos de <s:property value="users.lastName"/> </h2>
                <div class="col-lg-6">
                    <ul class="list-unstyled">
                        <li>Prénom : <s:property value="users.firstName" /></li>
                        <li>Nom : <s:property value="users.lastName" /></li>
                        <li>email : <s:property value="users.email" /></li>
                        <li><s:a action="checkbox"> Rappel fin de prêt : </s:a> <s:if test="#users.reminder==true">Activé</s:if>
                            <s:else>Désactivé</s:else>
                        </li>
                    </ul>
                </div>

            </div>
                <h4> Vos prêts en cours</h4>
                <br/>
                    <table class="table table-bordered table-striped table-condensed">
                        <thead>
                        <tr>
                            <th>Livre</th>
                            <th>Date de fin du prêt</th>
                            <th>Prolonger un prêt</th>
                        </tr>
                        </thead>

                        <tbody>
                        <s:set var="currentDate" value="%{new java.util.Date()}"/>
                        <s:iterator value="users.borrows" var="borrows">
                            <tr>
                                <td><s:a action="borrow"><s:property value="book.title"/> </s:a></td>
                                <td><s:property value="term"/> </td>
                                <s:if test="#borrows.extend == true">
                                <td>Le pret n'est pas prolongeable</td>
                                </s:if>
                                <s:else>
                                <td><s:a action="extendborrow">Prolonger un pret</s:a></td>
                                </s:else>
                        </s:iterator>
                        </tbody>
                    </table>

            <h4> Vos reservations</h4>
            <br/>
            <table class="table table-bordered table-striped table-condensed">
                <thead>
                <tr>
                    <th>Livre</th>
                    <th>Position dans la liste d'attente</th>
                    <th>Annuler une reservation</th>
                </tr>
                </thead>

                <tbody>
                <s:iterator value="users.reservations" var="reservations">
                <tr>
                    <td><s:property value="book.title"/></td>
                    <td><s:property value="index"/></td>
                    <td><s:a action="cancel"><s:param name="id" value="res_Id"/>Annuler une reservation</s:a></td>
                    </s:iterator>
                </tbody>
            </table>

        </section>
    </div>
</div>
</body>
</html>
