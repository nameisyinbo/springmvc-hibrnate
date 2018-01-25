<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://java.sun.com/jsp/jstl/paging" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="Hobby">
<button id="addHobby">添加爱好</button>
<table>
    <tbody>
    <tr>
        <td>序号</td>
        <td>爱好名称</td>
        <td>创建时间</td>
        <td>操作</td>
    </tr>
    <c:forEach var="obj" items="${list}">
        <tr>
            <td>${obj.id}</td>
            <td>${obj.hobbyName}</td>
            <td>${obj.createDate}</td>
            <td><a href="/hobby/to_update?id=${obj.id}">【编辑】</a>
                <a href="/hobby/delete?id=${obj.id}">【删除】</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<page:paging pageNo="${page.pageNo}" totalCount="${page.totalCount}" pageSize="${page.pageSize}" url="/hobby/list"></page:paging>
</div>
</body>
<script type="text/javascript" src="../plugins/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#addHobby").on("click",function () {
            $("#Hobby").load("/hobby/to_save")
        })
    })
</script>
</html>
