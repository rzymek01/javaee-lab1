<%@tag description="put the tag description here" pageEncoding="UTF-8" %>

<%-- Taglib directives can be specified here: --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="login" required="true" rtexprvalue="true" %>
<%@attribute name="msg" required="false" rtexprvalue="true" %>

<jsp:doBody/>

<c:if test="${not empty msg}">
  <div style="font-weight: bold">
    <c:out value="${msg}"/>
  </div>
</c:if>

<c:set var="isLogged" value="false"/>
<c:if test="${not empty login}">
  <c:set var="isLogged" value="true"/>
</c:if>

<c:choose>
  <c:when test="${isLogged}">
    <%-- logout link --%>
    <div>
      zalogowany jako <c:out value="${login}"/> (<a href="UserServlet">wyloguj</a>)
    </div>
  </c:when>
  <c:otherwise>
    <%-- login form --%>
    <form action="UserServlet" method="post">
      <div>
        Login: <input name="login" required="required"/>
      </div>
      <div>
        Hasło: <input name="passwd" type="password"/> (abcd)
      </div>
      <div>
        <input type="submit" value="Zaloguj"/>
      </div>
    </form>
  </c:otherwise>
</c:choose>
