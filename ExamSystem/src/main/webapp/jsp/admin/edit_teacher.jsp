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
	<title>教师编辑</title>
</head>
<body>
<div class="container" style="width: 90%;">
	<h1>
		<img src="<%=path%>/assets/imgs/admin.jpg" alt="" class="imgstyle">系统管理
	</h1>
	
    <div class="editteacher">
        <form action="" class="edit">
          <h4 style="font-weight: 600">修改教师账号</h4>
          <table class="table edit_table">
            <tr>
              <td class="td1" >用户名</td>
              <td><input type="text" class="input" ></td>
            </tr>
            <tr>
              <td class="td1">密码</td>
              <td><input type="text" class="input" >  如不需要重新设定密码请留空</td>
            </tr>
            <tr>
              <td class="td1">全名</td>
              <td><input type="text" class="input" ></td>
            </tr>
            <tr>
              <td class="td1"></td>
              <td><input type="checkbox">管理员</td>
            </tr>
            <tr>
              <td class="td1"></td>
              <td><input class="btn btn-default sumbtn" type="submit" value="修改" ></td>
            </tr>
          </table>
          
        </form>
    </div>
   

	</div>

