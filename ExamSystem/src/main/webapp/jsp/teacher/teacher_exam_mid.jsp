<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>考中管理</title>
</head>
<div class="layui-main">
	<div class="bighat">
		<div class="tecicon">
			<img style="width: 80px; height: 80px;"
				src="<%=path%>/assets/imgs/teacher.jpg" />
		</div>
		<h2>上机考试管理</h2>
	</div>
</div>
<div class="errorbox">
	<h3>发生错误!</h3>
	<div class="boxin">
		<span class="errtitle">错误信息:</span> <span class="errinfo">没有进行中的考试，不能进行考中管理。</span>
	</div>
</div>


