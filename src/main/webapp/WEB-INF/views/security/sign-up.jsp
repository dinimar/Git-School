<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:base>
    <c:if test="${message != null}">
        <div class="alert alert-success" role="alert">
            ${message}
        </div>
    </c:if>
    <form:form modelAttribute="user" method="post">
        <t:input id="firstName" label="First name:" type="text" path="firstName"></t:input>
        <t:input id="lastName" label="Last name:" type="text" path="lastName"></t:input>
        <t:input id="email" label="Email:" type="text" path="email"></t:input>
        <t:input id="password" label="Password:" type="password" path="password"></t:input>

        <label>As:</label>

        <div class="form-group">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="role" id="role-student" value="ROLE_STUDENT">
                <label class="form-check-label" for="role-student">Student</label>
            </div>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="role" id="role-teacher" value="ROLE_TEACHER">
                <label class="form-check-label" for="role-teacher">Teacher</label>
            </div>
        </div>

        <div>
            <input type="submit" class="btn btn-primary" value="Submit">
        </div>
    </form:form>
</t:base>