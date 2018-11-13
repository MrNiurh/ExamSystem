<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>考前操作</title>
</head>
<div class="layui-main">
    <div class="bighat">
      <div class="tecicon"><img style="width:80px;height:80px;" src="<%=path%>/assets/imgs/teacher.jpg"/></div>
      <h2>上机考试管理</h2>
    </div>
    <div class="hat">
      <div class="hat-1">
        <h3>添加考试</h3>
      </div>
      <div class="hat-2">
        <input type="text" name="testname" size="20" placeholder="考试名称*" class="textline">
        <input type="text"  id="time1" placeholder="考试时间" class="textline">
        <input type="checkbox" name="自动开始"><span>自动开始</span>
        <button class="layui-btn layui-btn-sm layui-btn-normal">添加</button>
      </div>
    </div>
    <div>
      <table class="layui-table">
          <colgroup>
            <col width="15%">
            <col width="15%">
            <col width="9%">
            <col width="10%">
            <col width="10%">
            <col width="9%">
            <col width="9%">
            <col width="9%">
            <col width="9%">
            <col width="5%">
          </colgroup>
        <tr class="tablectrl">
          <td>考试名称</td>
          <td>考试时间</td>
          <td>创建人</td>
          <td>上传试卷</td>
          <td>自动开始</td>
          <td>进行中</td>
          <td>已结束</td>
          <td>已归档</td>
          <td>已清理</td>
          <td></td>
        </tr>
      </table>
    </div>
  </div>
  <script>
    layui.use('laydate', function () {
      var laydate = layui.laydate;
      //执行一个laydate实例
      laydate.render({
        elem: '#time1'
        , type: 'datetime'

      });
    });
  </script>