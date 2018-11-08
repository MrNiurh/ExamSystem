<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="<%=path%>/css/admin/admin.css">
	<title>上机考试系统</title>
</head>
<div class="container" style="width: 90%;">
	<h1>
		<img src="<%=path%>/assets/imgs/admin.jpg" alt="" class="imgstyle">系统管理
	</h1>
	<div class="admin-alert">
		没有设置管理员账号，默认管理员账号有风险
	</div>
	<div class="content">
  		<div class="item">
  			<div class="itemcontent">
  				<strong>教师管理</strong>
  				<br><br>
  				<ul>
  					<li>可以对教师用户进行增删改查操作，并可以指定特定教师作为系统管理员</li>
  					<li>系统可以有多个管理员</li>
  					<li>如果没有任何一个教师具有管理员身份，则默认管理员登录信息有效</li>
  				</ul>
  			</div>
  			
  		</div>
  		<div class="item">
  			<div class="itemcontent">
  				<strong>考试清理</strong>
  				<br><br>
  				<ul>
  					<li>清除考试的相关数据，包括数据库中的信息、文件系统中的提交文件</li>
  					<li>只有在主考教师已经打包下载学生提交文件后才可以进行</li>
  					<li>清理后的考试可以删除</li>
  				</ul>
  			</div>
  		</div>
  		<div class="item">
  			<div class="itemcontent">
  				<strong>系统配置</strong>
  				<br><br>
  				<ul>
  					<li>设置一些全局性的系统选项，包括后台任务的时间周期、分页查询时的每页记录数、手动开启考试的时间阈值、学生上传文件字节数的有效范围等</li>
  					<li>可以指定是否允许主考教师清理和删除考试。</li>
  				</ul>
  			</div>
  		</div>

	</div>

</div>	
