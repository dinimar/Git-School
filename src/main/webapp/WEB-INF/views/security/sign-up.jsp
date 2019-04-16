<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:base>
    <form:form modelAttribute="user" method="post">
        <t:input id="email" label="Email:" type="text" path="email"></t:input>
        <t:input id="password" label="Password:" type="password" path="password"></t:input>
        <input type="submit" class="btn btn-primary" value="Nodss">
    </form:form>
</t:base>