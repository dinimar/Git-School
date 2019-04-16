<%@tag description="Default Layout Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@attribute name="title" %>

<%--
  Creating own tags and simple templating system : http://stackoverflow.com/questions/1296235/jsp-tricks-to-make-templating-easier
--%>

<%--<c:if test="${not empty messageType}" >--%>
    <%--<c:choose>--%>
        <%--<c:when test="${messageType == 'success'}">--%>
            <%--<c:set var="messageClass" value="text-success"/>--%>
        <%--</c:when>--%>
        <%--<c:when test="${messageType == 'fail'}">--%>
            <%--<c:set var="messageClass" value="text-danger"/>--%>
        <%--</c:when>--%>
    <%--</c:choose>--%>
<%--</c:if>--%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        Git School
    </title>

    <script type="text/javascript" src="<c:url value="/js/jquery-2.1.3.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js" />"></script>

    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <%--<link href="<c:url value="/semantic-ui-css/semantic.min.css" />" rel="stylesheet">--%>
    <%--<script--%>
            <%--src="https://code.jquery.com/jquery-3.1.1.min.js"--%>
            <%--integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="--%>
            <%--crossorigin="anonymous"></script>--%>
    <%--<script type="text/javascript" src="<c:url value="/semantic-ui-css/semantic.min.js" />"></script>--%>
</head>
<body>
<t:header></t:header>
<div class="container">
    <jsp:doBody/>
</div>
</body>
</html>