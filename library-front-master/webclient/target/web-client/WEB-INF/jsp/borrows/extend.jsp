<%--
  Created by IntelliJ IDEA.
  User: jnditife
  Date: 08/06/2018
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Prolonger un prêt</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container" align="center">
    <div class="row">
        <section class="col-lg-12" >
            <s:actionmessage />
            <div class="form-control">
                <s:form  action="extendborrow">
                    <div class="row">
                        <div class="form-gorup">
                            <s:select class="form-inline" name="borrows.borrow_Id" label="Nom livre"
                                      list="borrowList" listKey="borrow_Id" listValue="book.title"
                                      emptyOption="true"
                                      requiredLabel="true"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <s:submit  class="pull-right btn btn-default" name="ok"/>
                    </div>
                </s:form>
            </div>
        </section>
        <s:actionerror />
    </div>
</div>
</body>
</html>
