<%--
  Created by IntelliJ IDEA.
  User: maciek
  Date: 05.10.14
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tlds/mytags.tld" prefix="mytags" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Waluty - Lab1</title>
</head>
<body>
  <c:set var="login" value="${pageContext.session.getAttribute(\"login\")}"/>
  <div>zalogowany jako <b>${login}</b></div>

  <h1>Waluty</h1>
  <c:forEach var="item" items="${pageContext.session.getAttribute(\"currConvList\")}">
    <p><b>${item.amount}</b> <b>${item.from}</b> na <b>${item.to}</b> to <b>${mytags:convert(item.from, item.to, item.amount)}</b> ${item.to}</p>
  </c:forEach>

  <div>
    <a href="index.jsp">Powrót</a>
  </div>
</body>
</html>



