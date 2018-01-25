<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<body>
<div id="div0">
    <img src="../images/logo.png" height="40" width="40">
    <label class="label0">用户管理系统</label>
    <br/>
    <label class="label1">帮助&nbsp;&nbsp;退出</label>
</div>
<div id="div1">
    <a href="/user/list" target="iframe">用户管理</a>
    <br/>
    <a href="/profession/list" target="iframe">职业管理</a>
    <br/>
    <a href="/hobby/list" target="iframe">爱好管理</a>
    <div id="div2">
        <label>当前登录用户:${user.userName}</label>
    </div>
    <div id="div3">
        Copyright &copy;2017轻实训版权所有
    </div>
</div>
<iframe src="/user/list" name="iframe"></iframe>
</body>

</html>
