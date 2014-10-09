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
  <title>Akapity - Lab1</title>
</head>
<body>
  <c:set var="login" value="${pageContext.session.getAttribute(\"login\")}"/>
  <div>zalogowany jako <b>${login}</b></div>

  <h1>Formatowanie akapitów</h1>
  <mytags:paragraph header="nagłówek1">
    treść1
  </mytags:paragraph>

  <mytags:paragraph header="nagłówek2" headerAlign="right">
    treść2
  </mytags:paragraph>

  <mytags:paragraph header="nagłówek3" headerAlign="left" textColor="#d2a900">
    treść3
  </mytags:paragraph>

  <div>
    <a href="index.jsp">Powrót</a>
  </div>
</body>
</html>
