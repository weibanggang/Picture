<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/bbbbb" method="post" enctype="multipart/form-data">
    <div style="color: red">
            ${err}
    </div>
    <input type="file" name="xxx" />
    <input type="submit"/>
</form:form>
</body>
</html>
