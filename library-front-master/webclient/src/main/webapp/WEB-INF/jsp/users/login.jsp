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
    <title>Connexion</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container" align="center">
    <div class="row">
        <section class="col-lg-12">
            <h2>Connexion</h2>
            <div class="form-horizontal">
                <s:form action="login">
                <div class="row">
                    <div class="form-group">
                        <s:textfield class="form-inline" name="email" label="Email" placeholder="email" requiredLabel="true" />
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <s:textfield class="form-inline" name="password" label="Mot de passe" placeholder="mot de passe" requiredLabel="true" type="password" />
                    </div>
                </div>
                    <div class="form-group">
                        <s:submit value="Valider"/>
                    </div>
                </s:form>
            </div>
                <p>Si vous n'avez encore de compte inscrivez vous <s:a action="createuser"> ici </s:a> !</p>
            </div>
        </section>
        <s:actionerror />
    </div>
</div>
</body>
</html>
