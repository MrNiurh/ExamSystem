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
<script type="text/javascript" src="<%=path%>/js/admin/add_teacher.js"></script>
<title>添加教师</title>
</head>
<body>
	<div class="container" style="width: 90%;">
		<h1>
			<img src="<%=path%>/assets/imgs/admin.jpg" alt="" class="imgstyle">系统管理
		</h1>

		<div class="addteacher">
			<form action="" class="addTeacher" method="post"
				onSubmit="return addTeacher()">
				<h4 style="font-weight: 600">添加教师</h4>
				<input type="text" class="input" id="t_name" name="t_name"
					placeholder="用户名*"> <input type="password" class="input"
					id="t_password" name="t_password" placeholder="初始口令*"> <input
					type="text" class="input" id="t_fullname" name="t_fullname"
					placeholder="真实姓名*"> <input id="admin_signal" value="0"
					type="checkbox">管理员 <input type="hidden" name="admin" id="admin"
					value="0" /><input class="btn btn-default sumbtn" type="submit"
					value="提交">
			</form>
		</div>
		<div class="teacher_dis">
			<table class="table table-bordered">
				<tr style="font-weight: 600">
					<td>用户名</td>
					<td>全名</td>
					<td>是否管理员</td>
					<td>表单操作</td>
				</tr>
				<c:forEach items="${teachers}" var="teacher">
					<tr>
						<td>${teacher.get("tname")}</td>
						<td>${teacher.get("fullname")}</td>
						<c:if test="${teacher.get('admin') eq '1'}">
							<td>√</td>
						</c:if>
						<c:if test="${teacher.get('admin') eq '0'}">
							<td>X</td>
						</c:if>
						<td><a
							href="<%=basePath%>admin/edit_teacher?id=${teacher.get('id')}"><span
								class="iconfont icon-bianji"></span></a> <a id="deleteTeacher"
							onclick="deleteTeacher()"> <span
								class="iconfont icon-shanchu"></span>
						</a><input type="hidden" value="${teacher.get('id')}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>


	</div>