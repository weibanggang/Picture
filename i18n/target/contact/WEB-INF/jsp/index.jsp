<%@ taglib prefix="script" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 小邦哥
  Date: 2018/10/31
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="title"/></title>

</head>
<body >

<form:form action="/bbbbb" method="post" enctype="multipart/form-data">
    <div style="color: red">
            ${err}
    </div>
    <input type="file" name="xxx" />
    <input type="submit"/>
</form:form>
</body>
</html>
