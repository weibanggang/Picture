<%@ taglib prefix="script" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 小邦哥
  Date: 2018/10/31
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="title"/> </title>
</head>
<body style="color: <spring:theme code="main.color"/>;background: <spring:theme code="main.bgcolor"/> ">
<div>
    <p><spring:message code="message" arguments="${sessionScope.user}::```" argumentSeparator="::" /></p>
    <spring:message code="page.cl" />
    <br>
    <a href="/emp2/cl/zh">中文</a>
    <a href="/emp2/cl/en">English.</a>
    <a href="/emp2/cl/jp">小日本</a>
    <br><br>
</div>

<br>
<a href="/test01/theme/male">male</a>
<a href="/test01/theme/girl">girl</a>
<a href="/test01/theme/pink">pink</a>
<br>
<br>
<br/>

<form:form action="/bbbbb" method="post" enctype="multipart/form-data">
    <div style="color: red">
            ${err}
    </div>
    <input type="file" name="xxx" />
    <input type="submit"/>
</form:form>
</body>
</html>
