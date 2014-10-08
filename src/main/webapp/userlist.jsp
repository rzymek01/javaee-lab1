<%--
  Created by IntelliJ IDEA.
  User: maciek
  Date: 05.10.14
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>

<%@taglib uri="/WEB-INF/tlds/mytags.tld" prefix="mytags" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Lista użytkowników - Lab1</title>
</head>
<body>


  <h1>Lista użytkowników</h1>
  <h3>posortowana rosnąco, domyślny kolor daty</h3>
  <mytags:userlist listOrder="asc"/>

  <h1>Lista użytkowników</h1>
  <h3>posortowana malejąco, ustalony kolor daty</h3>
  <mytags:userlist listOrder="desc" dateColor="#a000e0"/>

  <div>
    <a href="index.jsp">Powrót</a>
  </div>
</body>
</html>



