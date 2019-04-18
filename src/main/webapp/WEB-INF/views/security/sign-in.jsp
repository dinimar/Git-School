<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<t:base>
    <c:if test="${error != null}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>
    <form:form cssClass="form-signin" modelAttribute="signInForm" method="post">
        <t:input id="email" label="Email:" type="text" path="email"></t:input>
        <t:input id="password" label="Password:" type="password" path="password"></t:input>

        <div>
            <input type="submit" class="btn btn-primary" value="Sign In">
        </div>
    </form:form>
</t:base>