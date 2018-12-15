<%--
  Created by IntelliJ IDEA.
  User: jnditife
  Date: 18/05/2018
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container" align="center">
    <div class="row">
        <section class="col-lg-12" >
            <h2>Tous les prets</h2>
            <ul class="list-unstyled">
                <s:iterator value="borrowInfoList">
                    <li>
                        <s:a action="borrow">
                            <s:param name="id" value="borrowId"/>
                            <s:property value="term"/>
                        </s:a>
                    </li>
                </s:iterator>
            </ul>
        </section>
    </div>
</div>
</body>
</html>
