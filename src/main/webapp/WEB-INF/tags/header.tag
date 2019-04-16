<%@tag description="Header Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-light bg-dark">
    <a class="navbar-brand text-light" href="<c:url value="/about" />">
        <img src="<c:url value="/img/index.png"/>" width="30" height="30" class="d-inline-block align-top" alt="GitSchool">
        Git School
    </a>
    <form class="form-inline">
        <button class="btn btn-outline-success" type="button">Sign In</button>
    </form>
</nav>