<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>教师</title>
</head>

<div class="layui-main">
	<div class="partone">
		<div class="logo"><img  style="width:100px;height:100px;margin-left:15px;margin-right:10px;" src="<%=path%>/assets/imgs/teacher.jpg"/></div>
		<div class="logotitle" style="margin-left:3em;">
			<h2 class="logotitle">上机考试管理系统</h2>
		</div>
	</div>
	<div class="layui-row">
		<div class="layui-col-md4">
			<div class="bccolor">
				<span class="stip"><h3>考前操作</h3></span>
				<ol class="bol">
					<li><span class="layui-badge-dot layui-bg-orange"></span>可以新建考试：指定考试名称、开始时间等</li>
					<li><span class="layui-badge-dot layui-bg-orange"></span>可以编辑自己创建的、未开始的考试，除了修改考试信息，还可以：
					</li>

					<li>
						<ol class="sol">
							<li><span class="layui-badge-dot layui-bg-black"></span>上传试卷</li>
							<li><span class="layui-badge-dot layui-bg-black"></span>学生名单导入</li>
							<li><span class="layui-badge-dot layui-bg-black"></span>开启考试</li>
						</ol>
					</li>
				</ol>
			</div>
		</div>
		<div class="layui-col-md4">
			<div class="bccolor">
				<span class="stip"><h3>考中管理</h3></span>
				<ol class="bol">
					<li><span class="layui-badge-dot layui-bg-orange"></span>可以查看考试情况</li>
					<li><span class="layui-badge-dot layui-bg-orange"></span>可以管理学生信息，手工添加个别学生信息</li>
					<li><span class="layui-badge-dot layui-bg-orange"></span>可以解除学生登录锁定</li>
					<li><span class="layui-badge-dot layui-bg-orange"></span>可以添加或删除通知消息</li>
				</ol>
			</div>
		</div>
		<div class="layui-col-md4">
			<div class="bccolor">
				<span class="stip"><h3>考后操作</h3></span>
				<ol class="bol">
					<li><span class="layui-badge-dot layui-bg-orange"></span>主考教师（考试创建者）可以结束考试</li>
					<li><span class="layui-badge-dot layui-bg-orange"></span>主考教师可以打包下载学生提交文件</li>
					<li><span class="layui-badge-dot layui-bg-orange"></span>主考教师可以导出提交信息</li>
					<li><span class="layui-badge-dot layui-bg-orange"></span>如果管理员设置，主考教师可以清理和删除考试</li>
				</ol>
			</div>
		</div>

	</div>
</div>