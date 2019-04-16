<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:base>
    <form:form modelAttribute="user" method="post">
        <form:label path="email">Email:</form:label>
        <form:input path="email"></form:input>
        <form:label path="password">Password:</form:label>
        <form:input path="password"></form:input>
        <input type="submit">
    </form:form>
</t:base>