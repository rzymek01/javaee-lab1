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
  <title>Lab1</title>
</head>
<body>
  <h1>Lab1</h1>

  <%--&lt;%&ndash; przez dyrektywę session="false" obiekt sesji nie jest dostępny przez pageContext &ndash;%&gt;--%>
  <%--<%--%>
    <%--HttpSession session = request.getSession(false);--%>
    <%--String isLogged = "false";--%>
    <%--if (session != null) {--%>
      <%--isLogged = "true";--%>
    <%--}--%>
  <%--%>--%>

  <c:set var="login" value="${pageContext.session.getAttribute(\"login\")}"/>

  <div>
    <c:set var="msg" value="${pageContext.request.getParameter(\"msg\")}"/>
    <mytags:form login="${login}" msg="${msg}"/>
  </div>

  <p><a href="userlist.jsp">Przejdź do listy użytkowników</a></p>
  <p><a href="paragraph.jsp">Przejdź do formatowania akapitów</a></p>
  <p><a href="currencies.jsp">Przejdź do przeliczania walut</a></p>

</body>
</html>
