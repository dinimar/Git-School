<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<t:base >
    <ul class="list-group">
        <li class="list-group-item active">Deadline:</li>
        <li class="list-group-item">${hometask.deadline}</li>
        <li class="list-group-item active">Description</li>
        <li class="list-group-item">${hometask.description}</li>
    </ul>
</t:base>