<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://java.sun.com/jsp/jstl/paging" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<div class="userList_div">
    <input type="button" value="新增用户" id="btn_add">
    <input type="button" value="批量删除" id="btn_delete">
    <input type="button" value="导出用户" id="btn_export">
    <form action="/user/query" method="post">
        <input type="text" class="userName" placeholder="请输入用户名查询" name="userName">
        <button type="submit">查询</button>
        <button type="reset">重置</button>
        <label style="color: brown">${mess}</label>

    </form>
    <table frame="box" rules="all">
        <thead>
        <td>
            <input type="checkbox" class="checkbox0"> 用户名称
        </td>
        <td>职业</td>
        <td>邮箱</td>
        <td>性别</td>
        <td>生日</td>
        <td>爱好</td>
        <td>创建时间</td>
        <td>操作</td>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="obj">
        <tr>
            <td> <input type="checkbox" name="checkbox">${obj.userName}</td>
            <td>${obj.profession}</td>
            <td>${obj.email}</td>
            <td>${obj.sex}</td>
            <td>${obj.birthdate}</td>
            <td>${obj.hobby}</td>
            <td>${obj.createDate}</td>
            <td><a href="/user/update?id=${obj.id}">【编辑】</a>
                <a href="#">【修改密码】</a>
                <a href="/user/remove?id=${obj.id}">【删除】</a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <page:paging pageNo="${page.pageNo}" totalCount="${page.totalCount}" pageSize="${page.pageSize}" url="/user/list"></page:paging>
</div>
<script type="text/javascript" src="../plugins/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../plugins/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/regit.js"></script>
</body>
</body>
</html>
