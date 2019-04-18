<%@tag description="Header Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-light bg-dark">
    <a class="navbar-brand text-light mr-auto" href="<c:url value="/about" />">
        <img src="<c:url value="/img/index.png"/>" width="30" height="30" class="d-inline-block align-top" alt="GitSchool">
        Git School
    </a>

    <security:authorize access="!isAuthenticated()">
        <a href="<c:url value="/sign-up"/>" class="btn btn-outline-success mr-2">
            Sign Up
        </a>

        <a href="<c:url value="/sign-in"/>" class="btn btn-outline-primary">
            Sign In
        </a>
    </security:authorize>

    <security:authorize access="isAuthenticated()">
        <a class="btn btn-info mr-2" href="<c:url value="/hometask/list"/>">HT List</a>
    </security:authorize>

    <security:authentication property="authorities" var="roles"/>
    <c:forEach var="role" items="${roles}" varStatus="authoritiesLoop">
        <c:if test="${role == 'ROLE_TEACHER'}">
            <a href="<c:url value="/hometask/assign"/>" class="btn btn-success mr-2">
                Assign home task
            </a>
        </c:if>
    </c:forEach>

    <security:authentication property="authorities" var="roles"/>
    <c:forEach var="role" items="${roles}" varStatus="authoritiesLoop">
        <c:if test="${role == 'ROLE_STUDENT'}">
            <a href="<c:url value="/hometask/submit"/>" class="btn btn-success mr-2">
                Submit home task
            </a>
        </c:if>
    </c:forEach>

    <security:authorize access="isAuthenticated()">
        <a href="<c:url value="/sign-out"/>" class="btn btn-light">
            Sign Out
        </a>
    </security:authorize>

</nav>