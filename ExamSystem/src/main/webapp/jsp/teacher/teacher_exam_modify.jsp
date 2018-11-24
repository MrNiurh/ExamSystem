<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>考试编辑</title>
<script type="text/javascript"
	src="<%=path%>/js/teacher/teacher_exam_modify.js"></script>
<c:if test="${editTest.get('test_signal') > 0}">
	<script type="text/javascript">
		history.go(-1);
	</script>
</c:if>
</head>
<div class="layui-main">
	<div class="bighat">
		<div class="tecicon">
			<img style="width: 80px; height: 80px;"
				src="<%=path%>/assets/imgs/teacher.jpg" />
		</div>
		<h2>上机考试管理</h2>
	</div>
	<c:if test="${editTest.get('test_signal') > 0}">
		<script type="text/javascript">
			history.go(-1);
		</script>
	</c:if>
	<form class="modifyall" id="updateForm" style="margin-top: 20px;">
		<span class="newh3">编辑考试信息</span><br> <span class="newtext">考试名称：</span>
		<input type="text" name="testname" id="testname"
			value="${editTest.get('testname')}" class="textline"> <span
			class="newtext">考试时间：</span> <input type="text" id="timset"
			name="starttime" class="textline"
			value="${editTest.get('starttime')}"><br>
		<c:if test="${editTest.get('auto_begin') == 0}">
			<input type="checkbox" id="auto_begin" class="po">
		</c:if>
		<c:if test="${editTest.get('auto_begin') == 1}">
			<input type="checkbox" id="auto_begin" checked class="po">
		</c:if>
		<input type="hidden" name="auto_begin" id="begin"> <input
			type="hidden" name="tea_id" value="${teacher_id}"> <input
			type="hidden" name="testid" value="${editTest.get('testid')}">
		<span class="newtext">自动开始</span><br> <input type="button"
			id="update" class="layui-btn layui-btn-sm " value="修改">
	</form>
	<form action="" enctype="multipart/form-data" class="modifyall"
		method="post" id="uploadForm">
		<span class="newh3">上传试卷</span><br> <input type="file"
			name="file" id="file" style="display: inline-block" class="po">
		<input type="hidden" name="testid" value="${editTest.get('testid')}" />
		<input type="submit" class="layui-btn layui-btn-sm " value="上传"
			id="fileUpload">
		<c:if
			test="${editTest.get('submit') != null || editTest.get('submit') != ''}">
			<br>
			<span style="color: green">已上传文件</span>
		</c:if>

	</form>
	<form class="modifyall" id="excelForm">
		<span class="newh3">导入学生名单</span><br> <span class="newtext">目前设定参加此次考试的学生人数：${allStudent }</span><br>
		<input type="file" name="file" id="file" style="display: inline-block"
			class="po"> <input type="hidden" name="testid"
			value="${editTest.get('testid')}"> <input id="excelButton"
			type="button" class="layui-btn layui-btn-sm  po" value="继续导入">
	</form>
	<c:if test="${testid ==null}">
		<div class="modifyall">
			<button class="btn btn-primary" name="${editTest.get('testid')}"
				style="margin-top: 30px" id="startTest">
				<i class="iconfont icon-xiayiye"></i>开启考试
			</button>
			<br>
		</div>
	</c:if>
	<c:if test="${testid != null }">
		<div class="modifyall">
			<p class="newtext" style="margin-top: 30px">
				考试 <span style="font-weight: bold; font-size: 1.3em">${RunTest.get(0).get('testname')}</span>
				正在进行中，本系统不允许同时进行多场考试。
			</p>
		</div>
	</c:if>
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


