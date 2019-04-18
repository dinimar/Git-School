<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<t:base >
    <c:if test="${message != null}">
        <div class="alert alert-success" role="alert">
                ${message}
        </div>
    </c:if>
    <form:form modelAttribute="hometask" method="post">
        <t:input id="deadline" label="Deadline:" type="date" path="deadline"></t:input>

        <div class="form-group">
            <label for="description">Description:</label>
            <form:textarea cssClass="form-control" id="description" path="description"></form:textarea>
        </div>

        <div>
            <input type="submit" class="btn btn-primary" value="Submit">
        </div>
    </form:form>
</t:base>