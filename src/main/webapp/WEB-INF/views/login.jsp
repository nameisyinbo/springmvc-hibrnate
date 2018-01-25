<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<body>
    <div id="div">
        <img src="../images/3.jpg">
        <form action="/user/do_login" method="post" id="form">
            <h2>用户登录</h2>
            <input type="text" name="userName" placeholder="请输入用户名" id="input" class="username">
            <input type="password" name="password" placeholder="请输入密码" id="input" class="password">
            <br/>
            <input type="checkbox" name="" value="">记住密码
            <br/>
            <button type="submit" class="btn">登录</button>
            <button type="reset">重置</button><br/>
            <label style="color: red">${mess}</label>
        </form>
    </div>
    <script type="text/javascript" src="../plugins/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
    $(function() {
        $(document).keyup(function(event) {
            if (event.keyCode == 13) {
                $(".btn").trigger("click");
            }
        });
    })
    </script>
</body>

</html>