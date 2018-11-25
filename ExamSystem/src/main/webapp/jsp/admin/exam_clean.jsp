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
<script type="text/javascript" src="<%=path%>/js/admin/exam_clean.js"></script>
<title>考试清理</title>
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
			<c:forEach items="${afterTests}" var="test">
				<tr>
					<td>${test.get('testname')}</td>
					<td>${test.get('starttime')}</td>
					<td>${test.get('teacherName')}</td>
					<!-- 上传试卷 -->
					<td><c:if test="${test.get('submit') != null }">
						试卷已上传
					</c:if></td>
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
					<td><c:if test="${test.get('test_signal')==3}">
							<button class="test_after_op  btn btn-default " id="testClean"
								name="${test.get('testid')}">
								<img src="<%=path%>/assets/imgs/clean_tests.png"
									class="test_afterlogos" alt="">清理
							</button>
						</c:if> <c:if test="${test.get('test_signal')==4}">
							<button class="test_del   btn btn-danger" id="testDel"
								name="${test.get('testid')}">
								<img src="<%=path%>/assets/imgs/clean_tests.png"
									class="test_afterlogos" alt="">删除
							</button>
						</c:if> <input type="hidden" name="testid" value="${test.get('testid')}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</div>