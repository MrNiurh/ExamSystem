<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>解除锁定</title>
<script type="text/javascript"
	src="<%=path%>/js/teacher/teacher_manage_unlock.js"></script>
</head>

<div class="layui-main">
	<div class="bighat">
		<div class="tecicon">
			<img style="width: 80px; height: 80px;"
				src="<%=path%>/assets/imgs/teacher.jpg" />
		</div>
		<h2>上机考试管理</h2>
	</div>
	<form class="modifyall" method="post" id="selectInfoStudent">
		<span class="bigtext">按学生查找已登录信息</span><br> <input type="text"
			placeholder="学号" class="jointext" name="stuid"> <input
			type="text" placeholder="姓名" class="jointext" name="stuname">
		<input type="text" placeholder="班级" class="jointext" name="stuclass">
		<button class="layui-btn " type="button" id="infoBtn">
			<i class="layui-icon">&#xe615;</i> 查找
		</button>
	</form>
	<form class="modifyall" method="post" id="selectStudentByIp">
		<span class="bigtext">按ip地址查找已登录信息</span><br> <input type="text"
			 placeholder="ip地址" class="jointext" name="ip">

		<button class="layui-btn " type="button" id="ipBtn">
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
				<col width="10%">
			</colgroup>
			<tr class="tablectrl">
				<td>学号</td>
				<td>姓名</td>
				<td>班级</td>
				<td>IP地址</td>
				<td>操作</td>
			</tr>
			<tbody id="tbody"></tbody>
		</table>
	</div>
</div>


