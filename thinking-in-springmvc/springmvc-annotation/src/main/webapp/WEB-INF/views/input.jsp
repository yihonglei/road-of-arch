<%@page import="com.jpeony.springmvc.entity.Address"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<!--
    action属性的addUser为表单提交路径,method的post为提交方式 ,
    modelAttribute为实体类，默认为command，如果找不到command会报错，
    这里手动修改为user，表单初始化的方法中设置map.put("user", new User());
-->
<form:form action="addUser" method="POST" modelAttribute="user">
    <!-- path属性对应html表单标签的name属性 -->
    USERNAME:<form:input path="username" maxlength="20"/><br>
    PASSWORD:<form:password path="password"/><br>
    <%
        Map<Integer,String> genders = new HashMap<Integer,String>();
        genders.put(1, "男");
        genders.put(0, "女");

        request.setAttribute("genders", genders);
    %>
    GENDER:<form:radiobuttons path="gender" items="${genders }"/><br>
    <%
        Map<String,String> provinces = new HashMap<String,String>();
        provinces.put("1", "北京");
        provinces.put("2", "天津");

        request.setAttribute("provinces", provinces);
    %>
    <!-- path后面的address.province为级联属性 -->
    PROVINCE:<form:select path="address.province" items="${provinces }" ></form:select><br>
    <%
        Map<String,String> cities = new HashMap<String,String>();
        cities.put("1", "东城");
        cities.put("2", "西城");

        request.setAttribute("cities", cities);
    %>
    CITY:<form:select path="address.city" items="${cities }"></form:select><br>
    <input type="submit" value="提交">
</form:form>
</body>
</html>
