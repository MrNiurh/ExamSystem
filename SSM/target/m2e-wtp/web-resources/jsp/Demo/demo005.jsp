<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- bootstrap  -->
<%-- <%-- <link href="<%=path%>/css/bootstrap.min.css?v=3.4.0" rel="stylesheet" type="text/css"> --%>
<!-- <link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet "> -->
<%-- <script src="<%=path%>/js/jquery/jquery-2.1.1.min.js"></script> --%>
<%-- <script src="<%=path%>/js/bootstrap.min.js?v=3.4.0"></script>  --%>

<link href="<%=path%>/css/Demo/demo005.css" rel="stylesheet"
	type="text/css">
<title>样例</title>

</head>

<div style="width: 50%; margin-top: 50px; margin-left: 20%">
	<p>RadioBox</p>
	<!-- radio 的未选中状态 -->
	<label class="radioBox"> <input type="radio" class="radio"
		name="1" id="radio1" value="a"> <span for="radio1 "
		class="radiolable"></span><span class="radio-content">未选中项</span>
	</label>

	<!-- radio 的选中状态 -->
	<label class="radioBox"> <input type="radio" class="radio"
		name="1" id="radio2 " value="b" checked="checked"> <span
		for="radio2 " class="radiolable "></span><span class="radio-content">已选中项</span>
	</label>

	<!-- radio 的未选中悬停状态 -->
	<label class="radioBox"> <input type="radio" class="radio"
		name="" id="radiohover"> <span for="radiohover"
		class="radiolable radio-hover"></span><span class="radio-content">未选悬停项</span>
	</label><br> <label class="radioBox"> <input type="radio"
		class="radio" name="" id="radio3" checked="checked"
		disabled="disabled"> <span for="radio3"
		class="radiolable  check-disable"></span><span class="radio-content">已选失效项</span>
	</label> <label class="radioBox"> <input type="radio" class="radio"
		name="" id="radio3" disabled="disabled"> <span for="radio3"
		class="radiolable  radio-disable"></span><span class="radio-content">未选失效项</span>
	</label> <br /> <br /> <br />
	<p>Button Radiobox</p>
	<br />

	<div class="radio-btn-group">
		<button class="my-btn my-btn-primary btn-large">杭州</button>
		<button class="my-btn my-btn-primary btn-large" value="上海">上海</button>
		<button class="my-btn my-btn-primary btn-large" value="北京">北京</button>
		<button class="my-btn my-btn-primary btn-large" value="成都">成都</button>
	</div>
	<br /> <br />

	<div class="radio-btn-group">
		<button class="my-btn my-btn-light">杭州</button>
		<button class="my-btn my-btn-light ">上海</button>
		<button class="my-btn my-btn-light ">北京</button>
		<button class="my-btn my-btn-light ">成都</button>
	</div>

	<br /> <br />

	<div class="radio-btn-group">
		<button class="my-btn my-btn-primary">杭州</button>
		<button class="my-btn my-btn-primary">上海</button>
		<button class="my-btn my-btn-primary ">北京</button>
		<button class="my-btn my-btn-primary ">成都</button>
	</div>

	<br /> <br />

	<!-- 禁选状态 -->
	<div class="radio-btn-group">
		<button class="my-btn my-btn-primary disabled-active"
			disabled="disabled">杭州</button>
		<button class="my-btn my-btn-primary " disabled="disabled">上海</button>
		<button class="my-btn my-btn-primary " disabled="disabled">北京</button>
		<button class="my-btn my-btn-primary " disabled="disabled">成都
		</button>
	</div>

	<br /> <br />

	<div class="radio-btn-group">
		<button class="my-btn my-btn-info btn-large">热门推荐</button>
		<button class="my-btn my-btn-info btn-large">行业应用</button>
		<button class="my-btn my-btn-info btn-large">GIS类</button>
		<button class="my-btn my-btn-info btn-large">测绘类</button>
		<button class="my-btn my-btn-info btn-large">其他</button>
	</div>

	<br /> <br /> <br />
	<p>CheckBox</p>
	<br />
	<!--CheckBox 样式-->
	<!-- CheckBox默认选中 -->
	<label class="my-checkbox inline checked"> <input
		type="checkbox" class="mycheck" checked="checked" id="check1"><span
		for="check1" class="checklabel"></span><span>选中项</span>
	</label>
	<!-- CheckBox默认未选中 -->
	<label class="my-checkbox"> <input type="checkbox"
		class="mycheck" name="" id="check2"><span for="check2"
		class="checklabel"></span><span>未选中项</span>
	</label>
	<!-- CheckBox默认悬停 -->
	<label class="my-checkbox"> <input type="checkbox"
		class="mycheck check-hover" name="" id="check3"><span
		for="check3" class="checklabel"></span><span>未选悬停</span>
	</label>
	<!-- CheckBox默认已选失效 -->
	<label class="my-checkbox"> <input type="checkbox"
		class="mycheck" name="" disabled="disabled" checked="checked"><span
		class="checklabel"></span><span class="disabled-content">已选失效项</span>
	</label>
	<!-- CheckBox默认未选失效 -->
	<label class="my-checkbox"> <input type="checkbox"
		class="mycheck" name="" disabled="disabled"><span
		class="checklabel"></span><span class="disabled-content">未选失效项</span>
	</label> <br /> <br /> RadioBox <br /> <br />

	<!--无字开关-->

	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="swith00" checked> <label class="onoffswitch-label"
			for="swith00"> <span class="onoffswitch-inner"></span> <span
			class="onoffswitch-switch"></span>
		</label>
	</div>

	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="swith01" checked disabled> <label
			class="onoffswitch-label" for="swith01"> <span
			class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span>
		</label>
	</div>

	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="swith02" disabled> <label class="onoffswitch-label"
			for="swith02"> <span class="onoffswitch-inner"></span> <span
			class="onoffswitch-switch"></span>
		</label>
	</div>

	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="swith03"> <label class="onoffswitch-label" for="swith03">
			<span class="onoffswitch-inner"></span> <span
			class="onoffswitch-switch"></span>
		</label>
	</div>

	<br />
	<!--有字开关-->

	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="swith10" checked> <label class="onoffswitch-label"
			for="swith10"> <span class="onoffswitch-inner simpleMark"></span>
			<span class="onoffswitch-switch"></span>
		</label>
	</div>

	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="swith11" checked disabled> <label
			class="onoffswitch-label" for="swith11"> <span
			class="onoffswitch-inner simpleMark"></span> <span
			class="onoffswitch-switch"></span>
		</label>
	</div>

	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="swith12" disabled> <label class="onoffswitch-label"
			for="swith12"> <span class="onoffswitch-inner simpleMark"></span>
			<span class="onoffswitch-switch"></span>
		</label>
	</div>

	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="swith13"> <label class="onoffswitch-label" for="swith13">
			<span class="onoffswitch-inner simpleMark"></span> <span
			class="onoffswitch-switch"></span>
		</label>
	</div>

	<br />
	<!--符号开关-->

	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="switch30" checked> <label class="onoffswitch-label"
			for="switch30"> <span class="onoffswitch-inner rightMark"></span>
			<span class="onoffswitch-switch"></span>
		</label>
	</div>
	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="switch31" checked disabled> <label
			class="onoffswitch-label" for="switch31"> <span
			class="onoffswitch-inner rightMark"></span> <span
			class="onoffswitch-switch"></span>
		</label>
	</div>
	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="switch32" disabled> <label class="onoffswitch-label"
			for="switch32"> <span class="onoffswitch-inner rightMark"></span>
			<span class="onoffswitch-switch"></span>
		</label>
	</div>
	<div class="onoffswitch inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="switch33"> <label class="onoffswitch-label"
			for="switch33"> <span class="onoffswitch-inner rightMark"></span>
			<span class="onoffswitch-switch"></span>
		</label>
	</div>

	<br />
	<!--小号开关-->

	<div class="onoffswitch onoff-sm inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="small10" checked> <label class="onoffswitch-label"
			for="small10"> <span class="onoffswitch-inner"></span> <span
			class="onoffswitch-switch"></span>
		</label>
	</div>
	<div class="onoffswitch onoff-sm inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="small11" checked disabled> <label
			class="onoffswitch-label" for="small11"> <span
			class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span>
		</label>
	</div>
	<div class="onoffswitch onoff-sm inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="small12" disabled> <label class="onoffswitch-label"
			for="small12"> <span class="onoffswitch-inner"></span> <span
			class="onoffswitch-switch"></span>
		</label>
	</div>
	<div class="onoffswitch onoff-sm inline">
		<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
			id="small13"> <label class="onoffswitch-label" for="small13">
			<span class="onoffswitch-inner"></span> <span
			class="onoffswitch-switch"></span>
		</label>
	</div>

	<br /> <br />
	<!-- 下拉菜单 -->
	<div class="btn-group inline">
		<button type="button"
			class="btn btn-lg btn-primary btn-my dropdown-toggle"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			菜单按钮 <span class="glyphicon glyphicon-menu-down"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">第一项</a></li>
			<li><a href="#">这是第二项</a></li>
			<li><a href="#">第三项才是最长的</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">--分割线--</a></li>
		</ul>
	</div>
	<div class="btn-group inline">
		<button type="button" class="btn  btn-lg btn-default dropdown-toggle"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			菜单按钮 <span class="glyphicon glyphicon-menu-down"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">第一项</a></li>
			<li><a href="#">这是第二项</a></li>
			<li><a href="#">第三项才是最长的</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">--分割线--</a></li>
		</ul>
	</div>
	<br /> <br />

	<div class="btn-group inline">
		<button type="button" class="btn btn-primary btn-my dropdown-toggle"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			菜单按钮 <span class="glyphicon glyphicon-menu-down"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">第一项</a></li>
			<li><a href="#">这是第二项</a></li>
			<li><a href="#">第三项才是最长的</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">--分割线--</a></li>
		</ul>
	</div>
	<div class="btn-group inline">
		<button type="button" class="btn btn-default dropdown-toggle"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			菜单按钮 <span class="glyphicon glyphicon-menu-down"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">第一项</a></li>
			<li><a href="#">这是第二项</a></li>
			<li><a href="#">第三项才是最长的</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">--分割线--</a></li>
		</ul>
	</div>

	<br /> <br />

	<div class="btn-group inline">
		<button type="button"
			class="btn  btn-primary btn-sm btn-my dropdown-toggle"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			菜单按钮 <span class="glyphicon glyphicon-menu-down"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">第一项</a></li>
			<li><a href="#">这是第二项</a></li>
			<li><a href="#">第三项才是最长的</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">--分割线--</a></li>
		</ul>
	</div>
	<div class="btn-group inline">
		<button type="button" class="btn  btn-default btn-sm dropdown-toggle"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			菜单按钮 <span class="glyphicon glyphicon-menu-down"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">第一项</a></li>
			<li><a href="#">这是第二项</a></li>
			<li><a href="#">第三项才是最长的</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">--分割线--</a></li>
		</ul>
	</div>


	<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
	<br /> <br /> <br />

</div>