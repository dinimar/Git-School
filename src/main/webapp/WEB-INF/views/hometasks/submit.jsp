<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<t:base>
    <c:if test="${message != null}">
        <div class="alert alert-success" role="alert">
                ${message}
        </div>
    </c:if>
    <h3>Submit your hometask. It's easy</h3>
    <form:form modelAttribute="user" method="post">
        <div>
            <form:select path="submittedHomeTasks" multiple="true" items="${options}" itemLabel="deadline" itemValue="id">
            </form:select>
        </div>
        <div>
            <input type="submit" class="btn btn-primary" value="Submit">
        </div>
    </form:form>
</t:base>