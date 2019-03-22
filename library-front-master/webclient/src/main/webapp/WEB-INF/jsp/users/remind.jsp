<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: jnditife
  Date: 11/02/2019
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remind</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<s:actionmessage />
<s:form action="checkbox">
    <div>
    <s:radio label="Rappel expiration pret" list="#{true:'Activé',false:'Désactivé'}" name="reminder" ></s:radio>
    <s:submit/>
    </div>
</s:form>

</body>
</html>
