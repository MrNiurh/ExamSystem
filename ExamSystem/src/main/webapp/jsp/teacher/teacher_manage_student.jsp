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
        <form class="modifyall">
            <span class="bigtext">添加单个学生</span><br>
            <input type="text" name="classnumber"  placeholder="学号*" class="jointext">
            <input type="text" name="joinname"  placeholder="姓名*" class="jointext">
            <input type="text" name="joinclass"  placeholder="班级" class="jointext">
            <button class="layui-btn" type="submit">
                <i class="layui-icon">&#xe608;</i> 添加
              </button>
        </form>
        <form class="modifyall">
            <span class="bigtext">查找学生信息</span><br>
            <input type="text" name="classnumber"  placeholder="学号" class="jointext">
            <input type="text" name="joinname"  placeholder="姓名" class="jointext">
            <input type="text" name="joinclass"  placeholder="班级" class="jointext">
            <button class="layui-btn " type="submit">
                <i class="layui-icon">&#xe615;</i> 查找
              </button>
        </form>
    </div>
  