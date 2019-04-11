<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="student">
    <label>Name:</label>
    <form:input path="name" value="${student.name}"/>
    <br>
    <label>Home tasks:</label>
    <form:select path="homeTasks" multiple="true" items="${options}" itemLabel="name" itemValue="id">
    <%--<c:forEach items="${options}" var="ht">--%>
        <%--<form:option value="${ht.name}" >${ht.name}</form:option>--%>
    <%--</c:forEach>--%>
    </form:select>
    <br>
    <input type="submit" value="Assign home task"/>
</form:form>
</body>
</html>
