<%@tag description="Header Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-light bg-dark">
    <a class="navbar-brand text-light mr-auto" href="<c:url value="/about" />">
        <img src="<c:url value="/img/index.png"/>" width="30" height="30" class="d-inline-block align-top" alt="GitSchool">
        Git School
    </a>

    <a href="<c:url value="/sign-up"/>" class="btn btn-outline-success mr-2">
        Sign Up
    </a>
    <a href="<c:url value="/sign-in"/>" class="btn btn-outline-primary">
        Sign In
    </a>
</nav>