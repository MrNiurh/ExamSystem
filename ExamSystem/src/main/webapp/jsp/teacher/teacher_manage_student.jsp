<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>学生信息</title>
<script type="text/javascript" src="<%=path%>/js/teacher/teacher_student_manage.js"></script>
</head>
<div class="layui-main">
	<div class="bighat">
		<div class="tecicon">
			<img style="width: 80px; height: 80px;"
				src="<%=path%>/assets/imgs/teacher.jpg" />
		</div>
		<h2>上机考试管理</h2>
	</div>
	<form class="modifyall" method="post" id="insert">
		<span class="bigtext">添加单个学生</span><br> <input type="text"
			name="stuid" placeholder="学号*" class="jointext"> <input
			type="text" name="stuname" placeholder="姓名*" class="jointext">
		<input type="text" name="stuclass" placeholder="班级" class="jointext">
		<button class="layui-btn" type="button" id="addStudent">
			<i class="layui-icon">&#xe608;</i> 添加
		</button>
	</form>
	<form class="modifyall" method="post" id="select">
		<span class="bigtext">查找学生信息</span><br> <input type="text"
			name="stuid" placeholder="学号" class="jointext"> <input
			type="text" name="stuname" placeholder="姓名" class="jointext">
		<input type="text" name="stuclass" placeholder="班级" class="jointext">
		<button class="layui-btn " type="button" id="selectStudent">
			<i class="layui-icon">&#xe615;</i> 查找
		</button>
	</form>

	<div class="modifyall">
		<span class="bigtext">查找结果</span><br>
		<table class="layui-table">
			<colgroup>
				<col width="25%">
				<col width="15%">
				<col width="25%">
				<col width="25%">
			</colgroup>
			<tr class="tablectrl">
				<td>学号</td>
				<td>姓名</td>
				<td>班级</td>
				<td>IP地址</td>
			</tr>
			<tbody id="tbody"></tbody>
		</table>
	</div>
</div>

