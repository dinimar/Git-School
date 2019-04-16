<%@tag description="Input Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@attribute name="id" required="true" type="java.lang.String"%>
<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="type" required="true" type="java.lang.String"%>
<%@attribute name="label" required="false" type="java.lang.String"%>
<%@attribute name="placeholder" required="false" type="java.lang.String"%>

<div class="form-group">
    <label for="${id}">${label}</label>
    <form:input id="${id}" type="${type}" path="${path}" class="form-control" placeholder="${placeholder}"/>
</div>