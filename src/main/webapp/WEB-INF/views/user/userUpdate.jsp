<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/do_update" method="post">
    <input type="hidden" value="${user.id}" name="id">
    <input type="hidden" value="${user.hobby}" name="hobby">
    <input type="hidden" value="${user.profession}" name="profession">
    <input type="text" value="${user.userName}" name="userName">
    <input type="date" value="${user.birthdate}" name="birthdate">
    <input type="email" value="${user.email}" name="email">
    <input type="radio" value="男" name="sex" checked="checked">男
    <input type="radio" value="女" name="sex">女
    <button type="submit">确定</button>
    <button type="reset">取消</button>
</form>
</body>
</html>
