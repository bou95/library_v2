<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: juju
  Date: 08/05/18
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylsheet" href="style.css">
    <title>Nouvel utilisateur</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <div class="row" align="center">
        <section class="col-lg-12">
            <h2>Creez votre profil</h2>
            <div class="form-horizontal">
            <s:form action="createuser">
                <div class="row">
                    <div class="form-group">
                        <s:textfield class="form-control" name="firstName" label="Nom" placeholder="Nom" requiredLabel="true" />
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <s:textfield class="form-control" name="lastName" label="Prénom" placeholder="prénom" requiredLabel="true" />
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <s:textfield class="form-control" name="email" label="Email"  placeholder="email" requiredLabel="true" />
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <s:textfield class="form-control" name="password" label="mot de passe" placeholder="Mot de passe" requiredLabel="true" type="password"/>
                    </div>
                </div>
                <div class="form-group">
                    <s:submit class="pull-right btn btn-default" value="Valider"/>
                </div>
            </s:form>
            </div>
        </section>
        <s:actionerror />
    </div>
</div>
</body>
</html>
