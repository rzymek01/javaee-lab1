<%@tag description="put the tag description here" pageEncoding="UTF-8" %>

<%-- Taglib directives can be specified here: --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="msg" required="false" rtexprvalue="true" %>

<jsp:doBody/>
<c:choose>
  <c:when test="${pageContext.getSession()}">
    <%-- logout link --%>
    <a href="UserServlet">Wyloguj</a>
  </c:when>
  <c:otherwise>
    <%-- feedback msg --%>
    <c:when test="${msg}">
      <div style="font-weight: bold">
        ${msg}
      </div>
    </c:when>

    <%-- login form --%>
    <form action="UserServlet" method="post">
      <div>
        Login: <input name="login"/>
      </div>
      <div>
        Hasło: <input name="passwd" type="password"/>
      </div>
      <div>
        <input type="submit" value="Zaloguj"/>
      </div>
    </form>
  </c:otherwise>
</c:choose>

