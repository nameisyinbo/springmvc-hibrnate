<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/profession/update" method="post">
    <input value="${profession.id}" name="id" type="hidden">
    修改爱好:<input type="text" name="professionName" value="${profession.professionName}"><br/>
    <button type="submit">提交</button>
    <button type="reset">重置</button>
</form>
</body>
</html>
