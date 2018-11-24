<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>考前操作</title>
<script type="text/javascript"
	src="<%=path%>/js/teacher/teacher_exam_before.js"></script>
</head>
<div class="layui-main">
	<div class="bighat">
		<div class="tecicon">
			<img style="width: 80px; height: 80px;"
				src="<%=path%>/assets/imgs/teacher.jpg" />
		</div>
		<h2>上机考试管理</h2>
	</div>
	<div class="hat">
		<div class="hat-1">
			<h3>添加考试</h3>
		</div>
		<form id="TestForm" method="post">
			<div class="hat-2">
				<input type="text" name="testname" size="20" placeholder="考试名称*"
					class="textline" name="testname" id="testname"> <input
					type="text" id="time1" placeholder="考试时间" class="textline"
					name="starttime"> <input type="checkbox" id="auto_begin"><span>自动开始</span>
				<input type="hidden" name="auto_begin" value="0" id="begin">
				<input type="hidden" value="${teacher_id}" name="t_id">
				<button class="layui-btn layui-btn-sm layui-btn-normal" id="addTest">添加</button>
			</div>
		</form>
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
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="8%">
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
				<td>编辑</td>
			</tr>
			<c:forEach items="${tests}" var="test">
				<tr>
					<td>${test.get('testname')}</td>
					<td>${test.get('starttime')}</td>
					<td>${test.get('teacherName')}</td>
					<!-- 上传试卷 -->
					<td></td>
					<!-- 自动开始 -->
					<c:if test="${test.get('auto_begin') == 0 }">
						<td>X</td>
					</c:if>
					<c:if test="${test.get('auto_begin') == 1 }">
						<td>√</td>
					</c:if>
					<!-- 进行中 -->
					<c:if test="${test.get('test_signal') == 0 }">
						<td></td>
					</c:if>
					<c:if test="${test.get('test_signal') == 1 }">
						<td>√</td>
					</c:if>
					<c:if test="${test.get('test_signal') > 1 }">
						<td>X</td>
					</c:if>
					<!-- 已结束 -->
					<c:if test="${test.get('test_signal') < 2 }">
						<td></td>
					</c:if>
					<c:if test="${test.get('test_signal') >= 2 }">
						<td>√</td>
					</c:if>
					<!-- 已归档 -->
					<c:if test="${test.get('test_signal') < 3 }">
						<td></td>
					</c:if>
					<c:if test="${test.get('test_signal') >= 3 }">
						<td>√</td>
					</c:if>
					<!-- 已清理 -->
					<c:if test="${test.get('test_signal') < 4 }">
						<td></td>
					</c:if>
					<c:if test="${test.get('test_signal') >= 4 }">
						<td>√</td>
					</c:if>
					<!-- 编辑 -->
					<td>
					<c:if test="${test.get('test_signal') < 1 }">
						<a
						href="<%=basePath%>teacher/teacher_modify?testid=${test.get('testid')}"><i
							class="iconfont icon-bianji"></i></a>
					
					</c:if>
							</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<script>
	layui.use('laydate', function() {
		var laydate = layui.laydate;
		//执行一个laydate实例
		laydate.render({
			elem : '#time1',
			type : 'datetime'

		});
	});
</script>