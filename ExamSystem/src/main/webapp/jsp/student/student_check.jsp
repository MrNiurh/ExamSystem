<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>

<link rel="stylesheet" href="<%=path%>/css/student/student.css">
<title>提交答案</title>
<script type="text/javascript" src="<%=path%>/js/student/student.js"></script>
</head>
<body>
	<div class="body">

		<div class="container">
			<div class="user">
				<img src="<%=path%>/assets/imgs/student.jpg" alt="" class="userlogo">
				<div class="info">
					<h1 class="fontweight">上机考试中...</h1>
				</div>
			</div>
			<div class="filelist">
				<h4 class="fontweight">已上传的文件列表</h4>
				<table class="table table-bordered">
					<tr>
						<th>文件名</th>
						<th>文件大小</th>
						<th>上传时间</th>
					</tr>
					<c:forEach items="${files}" var="file">
						<tr>
							<td>${file.get('filename')}</td>
							<td>${file.get('filesize')}</td>
							<td>${file.get('fileuptime')}</td>
						</tr>
					</c:forEach>

				</table>
			</div>
			<div class="result2">
				<h4 class="fontweight">答案上传</h4>
				<form action="" enctype="multipart/form-data" method="post"
					id="uploadForm" class="resultform">
					<input type="file" name="file" value="浏览..." class="resultfile">
					<input type="hidden" name="stuid" value="${stuid }"> <input
						type="button" id="fileUpload" value="上传"
						class="btn btn-primary btn-sm sumbtn">
				</form>
			</div>

		</div>
	</div>