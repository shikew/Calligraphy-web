<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户注册</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <div class="wrapper">
            <div class="header">
                <h1 class="title">用户注册</h1>
                <div class="trigger">
                    <a href="user-login.jsp">登录</a>
                    <span>&nbsp;|&nbsp;</span>
                    <a href="user-register.jsp"  style="color: #333;">注册</a>
                </div>
            </div>
            <form class="form-login" method="POST" action="user-register-make.jsp">
                <input type="text" name="username" value="" placeholder="用户名">
                <input type="password" name="password" value="" placeholder="密码">
                <input type="text" name="useremail" value="" placeholder="邮箱">
                <input type="tel" name="usertelno" value="" placeholder="电话号码">
                <input type="submit" name="register" value="注册">
            </form>
        </div>
    </body>
</html>
