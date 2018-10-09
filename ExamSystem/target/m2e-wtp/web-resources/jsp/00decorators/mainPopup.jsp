<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="sitemesh"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("path:" + path);
	System.out.println("basePath:" + basePath);
	//设置缓存为空
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>

<!DOCTYPE HTML>
<html>
<head>
<title>SSM-<sitemesh:title /></title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<meta name="keywords" content="SSM,sample">
<meta name="description" content="sample">

<!-- 项目CSS -->
<link href="<%=path%>/css/bootstrap.min.css?v=3.4.0" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/layout.css?uuid=${uuid}" rel="stylesheet" />
<link href="<%=path%>/css/hbvat.css?uuid=${uuid}" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/hbvat-columns.css?uuid=${uuid}" rel="stylesheet" />
<!-- fonts 字体 -->
<link href="<%=path%>/fonts/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet" type="text/css">
<link href="<%=path%>/fonts/font-huaban/iconfont.css" rel="stylesheet" type="text/css">

<!-- Gritter -->
<link href="<%=path%>/js/plugins/gritter/jquery.gritter.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/animate.css" rel="stylesheet" type="text/css">
<%-- <link href="<%=path%>/js/plugins/laydate/skins/danlan/laydate.css" rel="stylesheet" type="text/css" id="LayDateSkin"> --%>
<link href="<%=path%>/js/plugins/iCheck/skins/flat/blue.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet" type="text/css">

<!-- Mainly scripts -->
<script src="<%=path%>/js/jquery/jquery-2.1.1.min.js"></script>
<script src="<%=path%>/js/bootstrap.min.js?v=3.4.0"></script>
<script src="<%=path%>/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=path%>/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="<%=path%>/js/hplus.js?v=2.2.0"></script>
<script src="<%=path%>/js/plugins/pace/pace.min.js"></script>
<script src="<%=path%>/js/plugins/laydate/laydate.js"></script>
<script src="<%=path%>/js/plugins/iCheck/icheck.min.js"></script>

<!-- jquery validate js -->
<script src="<%=path%>/js/plugins/validate/jquery.validate.min.js"></script>
<script src="<%=path%>/js/plugins/validate/messages_zh.min.js"></script>
<script src="<%=path%>/js/common/valid-addi-methods.js"></script>

<link href="<%=path%>/js/layer/skin/layer.css?uuid=${uuid}" rel="stylesheet" type="text/css">
<script src="<%=path%>/js/layer/layer.js?uuid=${uuid}"></script>

<script src="<%=path%>/js/common/common.util.js?uuid=${uuid}"></script>
<sitemesh:head />
<script>
	var root = "<%=path%>/";
	if (root == "/") {root="";}
	var abroot = "<%=basePath%>";
</script>
</head>
<body>
	<sitemesh:body />
</body>
</html>
