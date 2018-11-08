<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="<%=path %>/css/admin/admin.css">
	<title>添加教师</title>
</head>
<body>
<div class="container" style="width: 90%;">
	<h1>
		<img src="<%=path%>/assets/imgs/admin.jpg" alt="" class="imgstyle">系统管理
	</h1>
	
    <div class="addteacher">
        <form action="" class="add">
          <h4 style="font-weight: 600">添加教师</h4>
          <input type="text" class="input" placeholder="用户名*">
          <input type="text" class="input" placeholder="初始口令*">
          <input type="text" class="input" placeholder="真实姓名*">
          <input type="checkbox">管理员
          <input class="btn btn-default sumbtn" type="submit" value="提交" >
        </form>
    </div>
    <div class="teacher_dis">
      <table class="table table-bordered">
            <tr style="font-weight: 600">
               <td>用户名</td>
               <td>全名</td>
               <td>是否管理员</td>
               <td>表单操作</td>
            </tr>
             <tr >
               <td>www</td>
               <td>www</td>
               <td>√</td>
               <td><a href="">edit</a>  <a href="">delete</a></td>
            </tr>
      </table>
    </div>
  

	</div>


