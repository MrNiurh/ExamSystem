<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>考试编辑</title>
</head>

<div class="layui-main">
	<div class="bighat">
		<div class="tecicon">
			<img style="width: 80px; height: 80px;"
				src="<%=path%>/assets/imgs/teacher.jpg" />
		</div>
		<h2>上机考试管理</h2>
	</div>
	<form class="modifyall" style="margin-top: 20px;">
		<span class="newh3">编辑考试信息</span><br> <span class="newtext">考试名称：</span>
		<input type="text" value="" class="textline"> <span
			class="newtext">考试时间：</span> <input type="text" id="timset"
			class="textline"><br> <input type="checkbox"
			name="zidong" class="po"><span class="newtext">自动开始</span><br>
		<input type="submit" class="layui-btn layui-btn-sm " value="修改">
	</form>
	<form class="modifyall">
		<span class="newh3">上传试卷</span><br> <input type="file"
			name="paper" style="display: inline-block" class="po"> <input
			type="submit" class="layui-btn layui-btn-sm " value="上传">

	</form>
	<form class="modifyall">
		<span class="newh3">导入学生名单</span><br> <span class="newtext">目前设定参加此次考试的学生人数：</span><br>
		<input type="submit" class="layui-btn layui-btn-sm  po" value="继续导入">
	</form>
	<form class="modifyall">
		<span class="newh3">开启考试</span><br> <span class="newtext">考试（exam）正在进行中，本系统不允许同时进行多场考试。</span>
	</form>
</div>

<script>
	layui.use('laydate', function() {
		var laydate = layui.laydate;
		//执行一个laydate实例
		laydate.render({
			elem : '#timset',
			type : 'datetime'

		});
	});
</script>


