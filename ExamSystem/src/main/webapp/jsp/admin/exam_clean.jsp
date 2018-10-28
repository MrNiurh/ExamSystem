<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=path%>/css/admin/admin.css">
<title>system</title>
</head>
<div class="container" style="width: 90%;">
	<h1>
		<img src="<%=path%>/assets/imgs/admin.jpg" alt="" class="imgstyle">系统管理
	</h1>
	<div class="test_dis">
		<table class="table table-striped table-bordered">
			<tr>
				<th class="span3">考试名称</th>
				<th class="span3">考试时间</th>
				<th>创建人</th>
				<th>上传试卷</th>
				<th>自动开始</th>
				<th>进行中</th>
				<th>已结束</th>
				<th>已归档</th>
				<th>已清理</th>
				<th></th>
			</tr>
		</table>
	</div>

</div>