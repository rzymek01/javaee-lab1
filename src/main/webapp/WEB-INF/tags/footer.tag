<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- Taglib directives can be specified here: --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="even" required="true" rtexprvalue="true"%>
<%@attribute name="text" required="true" rtexprvalue="true"%>

<jsp:doBody />
<c:choose>
    
    <c:when test="${even}">
        <p align="left">
    </c:when>
    <c:otherwise>
        <p align="right">
    </c:otherwise>
</c:choose>
<i>${text}</i>
</p>
