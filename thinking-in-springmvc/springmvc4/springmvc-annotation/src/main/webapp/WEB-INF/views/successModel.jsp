<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>spring MVC实例初体验</title>
</head>

<body>
<h1>success Page</h1>

<p>=================1.ModelAndView=================</p>
<p>Time:${requestScope.time }</p><br>

<p>=================2.Map or Model=================</p>
<p>Map:${requestScope.username }</p><br>

<p>=================3.@SessionAttributes=================</p>
<p>SessionAttributes--request(请求域):${requestScope.user }</p><br>
<p>SessionAttributes--session(session中属性名):${sessionScope.user }</p><br>
<p>SessionAttributes--session(session中属性类型):${sessionScope.staff }</p><br>

</body>
</html>