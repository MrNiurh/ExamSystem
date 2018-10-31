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
<link href="<%=path%>/fonts/font-common/iconfont.css?uuid=${uuid}"
	rel="stylesheet" type="text/css">

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
						<li class="layui-nav-item"><a href="<%=basePath%>admin/"><span class="iconfont icon-zhuye" style="color:white"></span>首页</a></li>
						<li class="layui-nav-item"><a href="<%=basePath%>admin/teacher_manager"><span class="iconfont icon-yonghu" style="color:white"></span>教师管理</a></li>
						<li class="layui-nav-item"><a href="<%=basePath%>admin/admin_clean"><span class="iconfont icon-qingchu" style="color:white"></span>考试清理</a>	</li>
						<li class="layui-nav-item"><a href="<%=basePath%>admin/system"><span class="iconfont icon-banshou" style="color:white"></span>系统配置</a></li>
					</ul>
				</div>
				<div id="toprig">
					<ul class="layui-nav">
						<li class="layui-nav-item"><a href="">欢迎，${sessionScope.fullname}</a></li>
						<li class="layui-nav-item"><a href=""><span class="iconfont icon-bianji1" style="color:white"></span> 修改口令 </a></li>
						<li class="layui-nav-item"><a href=""><span class="iconfont icon-tuichu1" style="color:white"></span>退出</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div style="clear: both; min-width: 1320px; overflow-x: auto;">
		<sitemesh:body />
	</div>

</body>
</html>