<%@tag description="put the tag description here" pageEncoding="UTF-8" %>

<%-- Taglib directives can be specified here: --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tlds/mytags.tld" prefix="mytags" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="listOrder" required="true" rtexprvalue="true" %>
<%@attribute name="dateColor" required="false" rtexprvalue="true" %>

<jsp:useBean id="userList" class="eu.rzymek.java.lab1b.UserList" scope="application" />

<jsp:doBody/>

<c:set var="login" value="${pageContext.session.getAttribute(\"login\")}"/>
<div>zalogowany jako <b>${login}</b></div>

<c:if test="${empty dateColor}">
  <c:set var="dateColor" value="#000"/>
</c:if>

<div>
  <p>Liczba zalogowanych użytkowników: ${userList.count}</p>
  <c:forEach var="user" items="<%=userList.getList(listOrder)%>">
    <p>
      ${user.login}
      (data zalogowania: <span style="color:${dateColor}">${mytags:formatDate(user.loginDate)}</span>)
    </p>
  </c:forEach>
</div>
