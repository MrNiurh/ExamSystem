<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="sitemesh"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<!-- <meta name="keywords" content="SSM,sample">
<meta name="description" content="sample"> -->

<!-- 项目CSS -->
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<!-- fonts 字体 -->
<link href="<%=path%>/fonts/font-awesome/css/font-awesome.css?v=4.3.0"
	rel="stylesheet" type="text/css">
<link href="<%=path%>/fonts/font-pingfang/font.css" rel="stylesheet"
	type="text/css">

<!-- Mainly scripts -->
<script src="<%=path%>/js/jquery/jquery-2.1.1.min.js"></script>
<script src="<%=path%>/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
<link rel="stylesheet" href="<%=path%>/css/teacher/main.css">
<script src="<%=path%>/layui/layui.js"></script>
<script>
          
          layui.use('element', function(){
            var element = layui.element;
         
          });
          </script>
<!-- <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script> -->
<!-- 
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script> -->
<!-- <script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<sitemesh:head></sitemesh:head>
<title><sitemesh:title></sitemesh:title></title>
</head>
<script type="text/javascript">
var root = "<%=path%>/";
if (root == "/") {root="";}
var abroot = "<%=basePath%>";
</script>
<body>
		<div style="min-width: 1100px;">
		<div id="topcontain">
			<div class="layui-main">
				<a href="" id="mainlogo">上机考试管理系统</a>
				<div id="topsec">
					<ul class="layui-nav">
						<li class="layui-nav-item"><a href="">首页</a></li>
						<li class="layui-nav-item"><a href="">下载试卷</a></li>
						<li class="layui-nav-item"><a href="javascript:;">上传答案</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="">考试概况</a>
								</dd>
								<dd>
									<a href="">学生信息</a>
								</dd>
								<dd>
									<a href="">接触锁定</a>
								</dd>
								<dd>
									<a href="">通知管理</a>
								</dd>
							</dl></li>
						<li class="layui-nav-item"><a href="">查看提交</a></li>
					</ul>
				</div>
				<div id="toprig">
					<ul class="layui-nav">
						<li class="layui-nav-item"><a href="">欢迎，aa</a></li>
						<li class="layui-nav-item"><a href=""> 修改口令 </a></li>
						<li class="layui-nav-item"><a href="">退出</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div style="clear: both;min-width:1320px;overflow-x:auto; ">
		<sitemesh:body />
	</div>


	<div class="foot">
		<h1>FOOT</h1>
		<!-- 尾部 -->
	</div>
</body>
</html>