<%--
  Created by IntelliJ IDEA.
  User: juju
  Date: 09/05/18
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<header>
    <nav class="navbar navbar-default">
        <div >
            <ul class="nav navbar-nav">
                <li><s:a cssClass="nav navbar-nav" action="home">Acceuil</s:a></li>
                <li><s:a action="allbooks"> Tous les livres </s:a></li>
            </ul>
            <div class="nav navbar-right">
                <button class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-user"></span>
                    <s:if test="#session.user">
                        <s:a action="user"> <s:param name="id" value="#session.user.user_Id"/>
                            <s:property value="#session.user.firstName" />
                            <s:property value="#session.user.lastName" />
                        </s:a>
                        <s:a action="logout">Déconnexion</s:a>
                    </s:if>
                    <s:else>
                        <s:a action="login">Connexion</s:a>
                    </s:else>
                </button>
            </div>
        </div>
    </nav>

</header>
</html>
