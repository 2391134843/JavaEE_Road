<%--
  Created by IntelliJ IDEA.
  User: 育  Danger
  Date: 2018/5/29
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<!-- enctype 默认是 application/x-www-form-urlencoded -->
<form action="/upload" enctype="multipart/form-data" method="post" >

    用户名：<input type="text" name="usename"> <br/>
    上传文件：<input type="file" name="file1"><br/>
    上传文件： <input type="file" name="file2"><br/>
    <input type="submit" value="提交"/>

</form>
</body>
</html>
