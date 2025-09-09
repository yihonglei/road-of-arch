<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>spring MVC POJO TEST</title>

<body>
<form action="testpj/testPojo" method="post">
    username:<input name="username"/><br>
    password:<input type="password" name="password"/><br>
    province:<input name="address.province"/><br>
    city:<input name="address.city"/><br>
    <input type="submit" value="testPojoSubmit">
</form>

</body>
</html>