<%--
  Created by IntelliJ IDEA.
  User: KITT
  Date: 2020-09-15
  Time: 오후 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello world!</h1>

<c:forEach var="m" items="${members}">
    <p># 이름: ${m.username}</p>
    <p># 암호: ${m.password}</p>
    ---------------------- <br>
</c:forEach>
</body>
</html>
