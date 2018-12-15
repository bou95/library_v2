<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: juju
  Date: 07/05/18
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylsheet" href="style.css">
    <title>Nouveau livre</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <div class="row" align="center">
        <section class="col-lg-12">
            <h2>Création un nouveau livre</h2>
            <div class="form-horizontal">
                <s:form action="createbook">
                    <div class="row">
                        <div class="form-group">
                            <s:textfield name="title" placeholder="Titre" requiredLabel="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <s:textfield name="author" placeholder="Auteur" requiredLabel="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <s:textfield name="category" placeholder="Catégorie" requiredLabel="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <s:textfield name="available" placeholder="Disponibilité" requiredLabel="true" />
                        </div>
                    </div>
                    <div class="form-group">
                        <s:submit class="pull-right btn btn-default" value="Valider"/>
                    </div>
                    </s:form>
            </div>
        </section>
    </div>
    <s:actionerror />
</div>
</body>
</html>
