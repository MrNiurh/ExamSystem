<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=path%>/css/admin/admin.css">
<title>系统配置</title>
<script type="text/javascript" src="<%=path%>/js/admin/system.js"></script>
</head>
<body>
	<div class="container" style="width: 90%;">
		<h1>
			<img src="<%=path%>/assets/imgs/admin.jpg" " alt="" class="imgstyle">系统管理
		</h1>
		<div class="system_settings">
			<form action="" class="settings" method="post">
				<h4 style="font-weight: 600">修改系统配置</h4>
				<div class="setting">
					<label for="interval" class="systemoptions">后台任务间隔时间</label> <input
						type="text" id="interal" class="systeminput" name="time_interval"
						value="${system.get(0).get('time_interval')}">
					<p class="helpinfo">指定扫描考试信息的间隔时间，单位为 分钟。</p>
				</div>
				<div class="setting">
					<label for="record" class="systemoptions">分页查询记录条数</label> <input
						type="text" id="record" class="systeminput" name="page_record"
						value="${system.get(0).get('page_record')}">
					<p class="helpinfo">指定分页查询时每页显示记录数的默认值（查询页面中可以更改）</p>
				</div>
				<div class="setting">
					<label for="time" class="systemoptions">手动开启考试时间阈值</label> <input
						type="text" id="time" class="systeminput" name="test_maxtime"
						value="${system.get(0).get('test_maxtime')}">
					<p class="helpinfo">指定手工开启考试时允许的最大提前量，单位为分钟</p>
				</div>
				<div class="setting">
					<label for="minsize" class="systemoptions">上传文件字节数下限</label> <input
						type="text" id="minsize" class="systeminput" name="file_minsize"
						value="${system.get(0).get('file_minsize')}">
					<p class="helpinfo">指定上传文件的长度下限（字节），低于此值发出警告</p>
				</div>
				<div class="setting">
					<label for="maxsize" class="systemoptions">上传文件字节数上限</label> <input
						type="text" id="maxsize" class="systeminput" name="file_maxsize"
						value="${system.get(0).get('file_maxsize')}">
					<p class="helpinfo">指定上传文件的长度上限（字节），高于此值发出警告</p>
				</div>
				<div class="submitbtn">
					<c:if test="${system.get(0).get('teacher_right')  == '1'}">
						<input type="checkbox" style="margin-left: 183px" id="teacher_r"
							checked="checked">教师可以清理和删除考试<br>
					</c:if>
					<c:if test="${system.get(0).get('teacher_right')  == '0'}">
						<input type="checkbox" style="margin-left: 183px" id="teacher_r">教师可以清理和删除考试<br>
					</c:if>
					<input type="hidden" name="teacher_right" value="1" id="teacher_right">
					<input type="submit" style="margin: 20px 0px 0px 183px" id="submit"
						class="sumbtn" value="修改">
				</div>
			</form>
		</div>

	</div>