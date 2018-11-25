<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>

<title>学生</title>
<link rel="stylesheet" href="<%=path%>/css/student/student.css">
<script type="text/javascript" src="<%=path%>/js/student/student.js"></script>
</head>

<div class="body">

	<div class="container">
		<div class="user">
			<img src="<%=path%>/assets/imgs/student.jpg" alt="" class="userlogo">
			<div class="info">
				<h1 class="fontweight">上机考试中...</h1>
			</div>
		</div>
		<div>
			<div class="content leftcontent">
				<form action="downTest" name="form3" id="form3" method="post">
					<c:if test="${RunTest.get(0).get('submit') !=null}">
						<div class="test">
							<h3 class="fontweight">试卷下载</h3>
							<input type="submit" class="test_down" value="下载查看" /> <input
								type="hidden" name="testid" value="${testid}" />
						</div>
					</c:if>
					<c:if test="${RunTest.get(0).get('submit') ==null}">
						<div class="test">
							<h3>当前考试没有电子试卷</h3>
						</div>
					</c:if>
				</form>
			</div>


			<div class="content rightcontent">
				<div class="result">
					<h3 class="fontweight">答案上传</h3>
					<div class="upresult">
						<p>请按照考试要求将答案文件打包，再次进行上传。同名文件多次上传将会被覆盖</p>
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
		</div>

	</div>
</div>
