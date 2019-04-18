<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<t:base >
    <dl>
        <dt>Name</dt>
            <%-- For additional (our entity) details use principal.*** --%>
        <dd>
            <security:authentication property="principal.firstName"/>
            <security:authentication property="principal.lastName"/>
        </dd>
        <dt>Email</dt>
            <%-- Name or principal.username - see documentation --%>
        <dd><security:authentication property="principal.email" /></dd>
        <dt>Roles:</dt>
        <dd>
                <%-- Authorities or principal.authorities - see documentation --%>
            <security:authentication property="authorities" var="roles"/>
            <c:forEach var="authority" items="${roles}" varStatus="authoritiesLoop">
                ${authority}<c:if test="${!authoritiesLoop.last}">, </c:if>
            </c:forEach>
        </dd>
    </dl>
</t:base>