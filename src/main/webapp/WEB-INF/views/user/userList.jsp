<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${obj}" var="obj" >
${obj.userName}<br/>
${obj.profession}<br/>
${obj.email}<br/>
${obj.sex}<br/>
${obj.birthdate}<br/>
${obj.hobby}<br/>
${obj.createDate}
</c:forEach>
</body>
</html>
