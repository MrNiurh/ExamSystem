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
<title>教师编辑</title>
<script type="text/javascript" src="<%=path%>/js/admin/edit_teacher.js"></script>
</head>
<body>
	<div class="container" style="width: 90%;">
		<h1>
			<img src="<%=path%>/assets/imgs/admin.jpg" alt="" class="imgstyle">系统管理
		</h1>

		<div class="editteacher">
			<form action="" class="edit" method="post" id="updateForm">
				<h4 style="font-weight: 600">修改教师账号</h4>
				<table class="table edit_table">
					<tr>
						<td class="td1">用户名</td>
						<td><input type="text" class="input" name="tname" id="tname"
							value="${editTeacher.get('tname') }"></td>
					</tr>
					<tr>
						<td class="td1">密码</td>
						<td><input type="password" class="input" name="password">
							如不需要重新设定密码请留空</td>
					</tr>
					<tr>
						<td class="td1">全名</td>
						<td><input type="text" class="input" name="fullname"
							id="fullname" value="${editTeacher.get('fullname')}"></td>
					</tr>
					<tr>
						<td class="td1"></td>
						<td><c:if test="${editTeacher.get('admin') ==0 }">
								<input type="checkbox" id="admin_signal">
							</c:if> <c:if test="${editTeacher.get('admin') ==1 }">
								<input type="checkbox" checked id="admin_signal">
							</c:if> 管理员<input type="hidden" name="admin" id="admin"> <input
							type="hidden" name="id" value="${editTeacher.get('id') }"></td>
					</tr>
					<tr>
						<td class="td1"></td>
						<td><input class="btn btn-default sumbtn" type="button"
							value="修改" id="updateTeacher"></td>
					</tr>
				</table>

			</form>
		</div>


	</div>