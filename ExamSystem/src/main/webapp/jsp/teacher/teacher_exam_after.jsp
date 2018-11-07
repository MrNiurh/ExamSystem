<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title></title>
</head>
<div class="layui-main">
	<div class="bighat">
		<div class="tecicon">
			<img style="width: 64px; height: 64px;"
				src="<%=path%>/assets/imgs/teacher.jpg" />
		</div>
		<h2>上机考试管理</h2>
	</div>
	<div>
		<table class="layui-table">
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="9%">
				<col width="10%">
				<col width="10%">
				<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="5%">
			</colgroup>
			<tr class="tablectrl">
				<td>考试名称</td>
				<td>考试时间</td>
				<td>创建人</td>
				<td>上传试卷</td>
				<td>自动开始</td>
				<td>进行中</td>
				<td>已结束</td>
				<td>已归档</td>
				<td>已清理</td>
				<td></td>
			</tr>
		</table>
	</div>
</div>
