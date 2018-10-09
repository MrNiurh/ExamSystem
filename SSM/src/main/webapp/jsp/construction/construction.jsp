<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="text-align: center;">
	<img style="margin-top: 210px;" alt="建设中"
		src="<%=path%>/assets/imgs/img_build.png">
</div>
<div style="text-align: center; margin: 50px;">
	<label
		style="font-family:PingFangSC-Regular;font-size:42px;color:#222222;text-align:center;">抱歉，您访问的页面正在建设中...</label>
</div>

