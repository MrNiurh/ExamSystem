<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>学生信息</title>
</head>
<div class="layui-main">
	<div class="bighat">
		<div class="tecicon"><img  style="width:64px;height:64px;" src="<%=path%>/assets/imgs/teacher.jpg"/></div>
		<h2>上机考试管理</h2>
	</div>
	<form class="modifyall">
		<span class="bigtext">添加单个学生</span><br> <input type="text"
			name="classnumber" placeholder="学号*" class="jointext"> <input
			type="text" name="joinname" placeholder="姓名*" class="jointext">
		<input type="text" name="joinclass" placeholder="班级" class="jointext">
		<button class="layui-btn" type="submit">
			<i class="layui-icon">&#xe608;</i> 添加
		</button>
	</form>
	<form class="modifyall">
		<span class="bigtext">查找学生信息</span><br> <input type="text"
			name="classnumber" placeholder="学号" class="jointext"> <input
			type="text" name="joinname" placeholder="姓名" class="jointext">
		<input type="text" name="joinclass" placeholder="班级" class="jointext">
		<button class="layui-btn " type="submit">
			<i class="layui-icon">&#xe615;</i> 查找
		</button>
	</form>
</div>

