<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="userForm_div">
    <label>新增&编辑用户信息</label>
    <form action="/user/save" method="post">
        <table>
            <tr>
                <td>用户名称:</td>
                <td>
                    <input type="text" class="userName" placeholder="请输入您的用户名" name="userName">
                </td>
            </tr>
            <tr>
                <td>登录密码:</td>
                <td>
                    <input type="password" class="password" placeholder="请输入您的登录密码" name="password">
                </td>
            </tr>
            <tr>
                <td>重复密码:</td>
                <td>
                    <input type="password" class="verifyPassword" placeholder="请输入您的确认密码" name="verifyPassword">
                </td>
            </tr>
            <tr>
                <td>电子邮箱:</td>
                <td>
                    <input type="email" name="email" class="email" placeholder="请输入您的邮箱" >
                </td>
            </tr>
            <tr>
                <td>出生日期:</td>
                <td>
                    <input type="date" name="birthdate" class="birthdate" placeholder="请选择您的出生日期">
                </td>
            </tr>
            <tr>
                <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
                <td>
                    <input type="radio" name="sex" value="男" class="sex" checked="checked">男
                    <input type="radio" name="sex" value="女" class="sex">女
                </td>
            </tr>
            <tr>
                <td>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</td>
                <td>
                    <select name="profession">
                        <c:forEach items="${profession}" var="profession">
                            <option value="${profession.professionName}">${profession.professionName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>爱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好：</td>
                <!-- 多选框（按住 Shift 键） -->
                <td>
                    <select class="multiple-select" name="hobby" multiple="multiple">
                       <c:forEach items="${hobby}" var="obj">
                           <option value="${obj.hobbyName}">${obj.hobbyName}</option>
                       </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <hr/>
        <div>
            <button type="submit" id="btn">保存</button>
            <button type="reset">重置</button>
            <button onclick="javascript:history.go(-1)">返回</button>
        </div>
    </form>

</div>
<script type="text/javascript" src="../plugins/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../plugins/waitMe.js"></script>
<link rel="stylesheet" href="../css/waitMe.css">
<script type="text/javascript" src="../js/regit.js"></script>
</body>
</html>