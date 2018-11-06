<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div id="topcontain">
        <div class="layui-main">
            <a href="" id="mainlogo">上机考试管理系统</a>
            <div id="topsec">
                <ul class="layui-nav">
                    <li class="layui-nav-item"><a href="">首页</a></li>
                    <li class="layui-nav-item"><a href="">考前操作</a></li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">考中管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="">考试概况</a></dd>
                            <dd><a href="">学生信息</a></dd>
                            <dd><a href="">接触锁定</a></dd>
                            <dd><a href="">通知管理</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item"><a href="">考后操作</a></li>
                </ul>
            </div>
            <div id="toprig">
                <ul class="layui-nav">
                    <li class="layui-nav-item"><a href="">欢迎，aa</a></li>
                    <li class="layui-nav-item">
                        <a href="">
                            修改口令
                        </a>
                    </li>
                    <li class="layui-nav-item"><a href="">退出</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="layui-main">
        <div class="bighat">
            <div class="tecicon">头像</div>
            <h2>上机考试管理</h2>
        </div>
        <div class="summary">
            <span class="bigtext colowh">exam进行情况：</span><br>
            <span class="newtext colowh">参加考试学生总数： </span><br>
            <span class="newtext colowh">已登录学生数量： ， 未登录学生数量： </span><br>
            <span class="newtext colowh">已登录学生中，提交文件学生数量：， 未提交文件学生数量： </span>
        </div>
    </div>


  