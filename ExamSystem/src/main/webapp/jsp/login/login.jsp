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
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="<%=path%>/css/exclude/login.css">

<script type="text/javascript">
var root = "<%=path%>/";
if (root == "/") {root="";}
<%-- var abroot = "<%=basePath%>"; --%>
</script>

<script src="<%=path%>/js/jquery/jquery-2.1.1.min.js"></script>
<script src="<%=path%>/js/bootstrap.min.js"></script>
<script src="<%=path%>/js/exclude/login.js"></script>
<title>login</title>
</head>
<div class="container">
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a
			href="javascript:void(0)" user="1" class="userlogin">学生登录</a></li>
		<li role="presentation"><a href="javascript:void(0)" user="2"
			class="userlogin">教师登录</a></li>
		<li role="presentation"><a href="javascript:void(0)" user="3"
			class="userlogin">管理员登录</a></li>
	</ul>
	<c:if test="${testid == null }">
		<div class="userinfo ">
			<div user="1" class="userstu ">
				<h4>当前没有进行的考试</h4>
			</div>
		</div>
	</c:if>
	<div>
		<c:if test="${testid != null }">
			<div class="logincontent stucontent">

				<div class="logintop">
					<img src="<%=path%>/assets/imgs/student.jpg" alt=""
						class="loginimg" />
					<div class="logintext">
						<h3>学生登录</h3>
					</div>
				</div>

				<div class="formbox">
					<div class="form">
						<form action="" method="post" class="login">
							<p>
								<input type="text" name="s_id" placeholder="  学号"
									style="margin-bottom: 10px;"></br> <input name="s_name"
									type="text" placeholder="  姓名">
							</p>
							<input class="btn btn-primary" id="s_submit" value="登录">

						</form>
					</div>

				</div>

			</div>
		</c:if>
		<div class="logincontent teacontent hide">
			<div class="logintop">
				<img src="<%=path%>/assets/imgs/teacher.jpg" alt="" class="loginimg" />
				<div class="logintext">
					<h3>教师登录</h3>
				</div>
			</div>

			<div class="formbox">
				<div class="form">
					<form action="" method="post" class="login" id="t_form">
						<p>
							<input type="text" name="t_name" placeholder="  用户名"
								style="margin-bottom: 10px;"></br> <input name="t_password"
								type="password" placeholder="  口令">
						</p>
						<input class="btn btn-primary" id="t_submit" value="登录">

					</form>
				</div>

			</div>

		</div>
		<div class="logincontent admincontent hide">
			<div class="logintop">
				<img src="<%=path%>/assets/imgs/admin.jpg" alt="" class="loginimg" />
				<div class="logintext">
					<h3>管理员登录</h3>
				</div>
			</div>

			<div class="formbox">
				<div class="form">
					<form action="" method="post" class="login">
						<p>
							<input type="text" name="a_name" placeholder="  用户名"
								style="margin-bottom: 10px;"></br> <input name="a_password"
								type="password" placeholder="  口令">
						</p>
						<input class="btn btn-primary" id="a_submit" value="登录">

					</form>
				</div>

			</div>

		</div>
	</div>


</div>
