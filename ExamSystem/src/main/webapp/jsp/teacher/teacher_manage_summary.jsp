<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
<title>考试概况</title>
</head>

<div class="layui-main">
	<div class="bighat">
		<div class="tecicon">
			<img style="width: 64px; height: 64px;"
				src="<%=path%>/assets/imgs/teacher.jpg" />
		</div>
		<h2>上机考试管理</h2>
	</div>
	<div class="summary">
		<span class="bigtext colowh">exam进行情况：</span><br> <span
			class="newtext colowh">参加考试学生总数： </span><br> <span
			class="newtext colowh">已登录学生数量： ， 未登录学生数量： </span><br> <span
			class="newtext colowh">已登录学生中，提交文件学生数量：， 未提交文件学生数量： </span>
	</div>
</div>


