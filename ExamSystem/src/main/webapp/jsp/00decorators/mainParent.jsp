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
	<!-- <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css " rel="stylesheet "> -->
<link href="<%=path%>/css/layout.css?uuid=${uuid}" rel="stylesheet" />
<link href="<%=path%>/css/nsicat.css?uuid=${uuid}" rel="stylesheet" />
<link href="<%=path%>/css/nsicat-nsicat-columns.css?uuid=${uuid}" rel="stylesheet" />
<!-- fonts 字体 -->
<link href="<%=path%>/fonts/font-awesome/css/font-awesome.css?v=4.3.0"
	rel="stylesheet" type="text/css">
<link href="<%=path%>/fonts/font-pingfang/font.css" rel="stylesheet"
	type="text/css">
<!-- Gritter -->
<link href="<%=path%>/js/plugins/gritter/jquery.gritter.css"
	rel="stylesheet" type="text/css">
<link href="<%=path%>/css/animate.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/js/plugins/iCheck/skins/flat/blue.css"
	rel="stylesheet" type="text/css">
<link
	href="<%=path%>/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css"
	rel="stylesheet" type="text/css">
<!-- Mainly scripts -->
<script src="<%=path%>/js/jquery/jquery-2.1.1.min.js"></script>
<script src="<%=path%>/js/bootstrap.min.js"></script>
<script src="<%=path%>/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=path%>/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>


<!-- Custom and plugin javascript -->
<script src="<%=path%>/js/hplus.js?v=2.2.0"></script>
<script src="<%=path%>/js/plugins/pace/pace.min.js"></script>
<script src="<%=path%>/js/plugins/iCheck/icheck.min.js"></script>
<script src="<%=path%>/js/plugins/laydate/laydate.js"
	type="text/javascript"></script>

<!-- jquery validate js -->
<script src="<%=path%>/js/plugins/validate/jquery.validate.min.js"></script>
<script src="<%=path%>/js/plugins/validate/messages_zh.min.js"></script>

<link href="<%=path%>/js/layer/skin/layer.css?uuid=${uuid}"
	rel="stylesheet" type="text/css">
<script src="<%=path%>/js/layer/layer.js"></script>

<script src="<%=path%>/js/common/common.util.js?uuid=${uuid}"></script>

<script type="text/javascript" src="<%=path%>/js/home.js?uuid=${uuid}"></script>
<link href="<%=path%>/fonts/font_nsicat/iconfont.css?uuid=${uuid}"
	rel="stylesheet" type="text/css">
	<link href="<%=path%>/fonts/font-common/iconfont.css?uuid=${uuid}"
	rel="stylesheet" type="text/css">
<link href="<%=path%>/css/home.css?uuid=${uuid}" rel="stylesheet"
	type="text/css" />
<script src="<%=path%>/fonts/font_nsicat/iconfont.js?uuid=${uuid}"></script>
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
		<h1>HEADaaaaaaaaaaaa</h1>
	</div>
	<div style="clear: both; padding-top: 105px;min-width:1320px;overflow-x:auto; ">
		<sitemesh:body />
	</div>


	<div class="foot">
		<h1>FOOT</h1>
		<!-- 尾部 -->
	</div>
</body>
</html>