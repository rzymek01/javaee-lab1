<%--
  Created by IntelliJ IDEA.
  User: maciek
  Date: 05.10.14
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tlds/mytags.tld" prefix="mytags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lab1</title>
</head>
<body>
    <h1>Lab1</h1>
    <div>
        <mytags:form />
    </div>

    <p><a href="userlist.jsp">Przejdź do listy użytkowników</a></p>
    <p><a href="paragraph.jsp">Przejdź do formatowania akapitów</a></p>
    <p><a href="currencies.jsp">Przejdź do przeliczania walut</a></p>

    <mytags:footer even="false" text="test stopki">
        test drugi
    </mytags:footer>
</body>
</html>
