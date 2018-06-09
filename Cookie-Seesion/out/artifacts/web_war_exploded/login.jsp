<%--
  Created by IntelliJ IDEA.
  User: 育  Danger
  Date: 2018/5/27
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--图片文件要放在web目录下面，不能放在WEB-INF--%>
    <link href="111.jpg" rel="icon" />
    <title>【官方】登录界面</title>
    <script type="text/javascript">
        window.onload = function (ev) {
        }
        function changeImg(obj) {
            // 利用参数，实现点击更换验证码功能参数不能一样，所以利用取当前时间的方式。
            obj.src = "/checksession?time=" + new Date().getTime();
        }
    </script>
</head>
<body>
        <form action="/login" method="post">
            <div><%=request.getAttribute("loginInfo")==null?"":request.getAttribute("loginInfo")%></div>
            <%--<div><%=request.getAttribute("check1")%></div>--%>
            用户名：<input type="text" name="username"><br>
            密码：<input type="password" name="password"><br>
            验证码：<input type="text"  name="check_image"><img id="image" src="/checksession" >
            <a href="#" onclick="changeImg(image)">看不清,换一张</a>
            <br>
            <input type="submit" value="提交">

        </form>
</body>
</html>
