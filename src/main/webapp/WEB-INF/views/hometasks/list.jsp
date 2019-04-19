<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<t:base >
    <div class="list-group">
    <c:forEach var="ht" items="${hometasks}" >
        <a href="<c:url value="/hometask/${ht.id}" />" class="list-group-item list-group-item-action">
            ${ht.deadline}
                <%--<a href="#" class="btn btn-danger">Delelte</a>--%>
        </a>
        <form class="form-inline" method="GET" action="<c:url value="/hometask/${ht.id}/update"/>">
            <input type="submit" class="btn btn-warning" value="Update">
        </form>
        <form class="form-inline" method="GET" action="<c:url value="/hometask/${ht.id}/delete"/>">
            <input type="submit" class="btn btn-danger" value="Delete">
        </form>
    </c:forEach>
    </div>
</t:base>