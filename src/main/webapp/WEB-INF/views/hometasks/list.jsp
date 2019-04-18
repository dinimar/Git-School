<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<t:base >
    <div class="list-group">
    <c:forEach var="ht" items="${hometasks}" >
            <a href="#" class="list-group-item list-group-item-action">
                ${ht.deadline}
            </a>
    </c:forEach>
    </div>
</t:base>