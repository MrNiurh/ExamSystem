<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>名单上传</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=path%>/css/teacher/import.css">
<script type="text/javascript"
	src="<%=path%>/js/teacher/teacher_exam_import.js"></script>
</head>
<body>
	<div class="layui-main">
		<div class="bighat">
			<div class="tecicon">
				<img style="width: 80px; height: 80px;"
					src="<%=path%>/assets/imgs/teacher.jpg" />
			</div>
			<h2>上机考试管理</h2>
		</div>
		<div class="notify">
			<span>完成学生名单的导入和修改后</span> <a
				href="<%=basePath%>teacher/teacher_modify?testid=${temp}"
				class="layui-btn layui-btn-primary layui-btn-sm"> <i
				class="layui-icon">&#xe642;</i> 返回编辑
			</a>
		</div>
		<div class="wh">
			<div class="l">
				<span>分页大小</span> <input id="record" style="text-align: center;"
					type="text" name="pagesize" class="minput" value="${page_record}">
				<button class="layui-btn layui-btn-primary layui-btn-sm"
					id="setPage">设置</button>
			</div>
			<div class="r">
				<a href="<%=basePath%>teacher/import_student?pn=1">
					<button type="button" class="btn btn-default">
						<span class="glyphicon glyphicon-fast-backward" aria-hidden="true"></span>
					</button>
				</a>
				<c:if test="${students.hasPreviousPage}">
					<a
						href="<%=basePath%>teacher/import_student?pn=${students.pageNum-1}">
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-step-backward"
								aria-hidden="true"></span>
						</button>
					</a>
				</c:if>
				<input style="text-align: center;" type="text" class="minput"
					name="showpage" readonly value="${students.pageNum}">
				<c:if test="${students.hasNextPage}">
					<a
						href="<%=basePath%>teacher/import_student?pn=${students.pageNum+1}">
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-step-forward" aria-hidden="true"></span>
						</button>
					</a>
				</c:if>
				<a
					href="<%=basePath%>teacher/import_student?pn=${students.pages}">
					<button type="button" class="btn btn-default">
						<span class="glyphicon glyphicon-fast-forward" aria-hidden="true"></span>
					</button>
				</a>
			</div>
		</div>
		<form class="modifyall" method="post" id="insertStudent">
			<input type="hidden" name="testid" value="${editTest.get('testid')}"
				id="testid" /> <span class="bigtext">添加单个学生</span><br> <input
				type="text" id="stuid" name="stuid" placeholder="学号*"
				class="jointext"> <input type="text" id="stuname"
				name="stuname" placeholder="姓名*" class="jointext"> <input
				type="text" id="stuclass" name="stuclass" placeholder="班级"
				class="jointext">
			<button id="addStudent" class="layui-btn" type="button">
				<i class="layui-icon">&#xe608;</i> 添加
			</button>
		</form>
		<div class="wh">
			<table class="table table-bordered">
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>班级</th>
					<th></th>
				</tr>
				<c:forEach items="${students.list}" var="student">
					<tr>
						<td>${student.stuid }</td>
						<td>${student.stuname }</td>
						<td>${student.stuclass }</td>
						<td><a class="deleteOnrStuent" name="${student.stuid }"
							title="删除"> <span class="glyphicon glyphicon-trash"></span>
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<form class="modifyall" id="excelForm">
			<span class="bigtext">批量导入学生名单</span><br> <input type="file"
				name="file" id="file" style="display: inline-block" class="po">
			<input type="hidden" name="testid" value="${editTest.get('testid')}"
				id="testid" /> <input type="hidden" name="testname"
				value="${editTest.get('testname')}"> <input type="hidden"
				name="submit" value="${editTest.get('submit')}"> <input
				id="excelButton" type="button" class="layui-btn layui-btn-sm  po"
				value="导入">
		</form>
	</div>
</body>