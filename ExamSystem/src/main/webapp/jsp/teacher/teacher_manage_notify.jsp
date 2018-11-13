<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
	<title>通知管理</title>
</head>

    <div class="layui-main">
        <div class="bighat">
            <div class="tecicon"><img  style="width:80px;height:80px;" src="<%=path%>/assets/imgs/teacher.jpg"/></div>
            <h2>上机考试管理</h2>
        </div>
        <form class="modifyall">
            <span class="bigtext">新增通知信息</span><br>
            <input type="text" name="joinclass" placeholder="通知消息内容" class="jointext">
            <button class="layui-btn" type="submit">
                    <i class="layui-icon">&#xe608;</i> 添加
                  </button>
        </form>
        <div class="modifyall">
            <span class="bigtext">已有通知消息</span><br> 
            <table class="layui-table">
                    <colgroup>
                        <col width="90%">
                        <col width="10%">
                      </colgroup>
                <tr class="tablectrl">
                    <td>通知内容</td>
                    <td></td>
                </tr>
            </table>
        </div>
    </div>



  