<%--
  Created by IntelliJ IDEA.
  User: jnditife
  Date: 16/02/2019
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Cancel</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container" align="center">
    <div class="row">
        <section class="col-lg-12" >
            <s:actionmessage />
            <div class="form-control">
                <s:form action="cancel">
                    <div class="row">
                        <div class="form-group">
                            <s:select class="form-inline" name="reservations.res_Id"
                                      list="reservationList" listKey="res_Id" listValue="book.title"
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
