<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<script type="text/javascript">
var root = "<%=path%>/";
if (root == "/") {root="";}
var abroot = "<%=basePath%>";
</script>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <style>
        body,
        html {
            margin: 0;
            padding: 0;
        }

        a:hover {
            text-decoration: none;
        }

        a:visited {
            text-decoration: none;
        }

        a:focus {
            text-decoration: none;
        }

        a {
            text-decoration: none
        }

        #main {
            width: 220px;
            margin: 0 auto;
        }

        .layui-btn {
            display: inline-block;
            height: 38px;
            line-height: 38px;
            padding: 0 18px;
            background-color: #009688;
            color: #fff;
            white-space: nowrap;
            text-align: center;
            font-size: 14px;
            border: none;
            border-radius: 2px;
            cursor: pointer;
        }
        .new-p{
            padding: 10px;
            display: inline-block;
            height: 30px;
            line-height: 30px;
            width: 100%;
            text-align: center;
        }
        .fix{
            padding-left: 50px;
        }
    </style>
</head>

<body>
	<form action="" method="post" id="exitAccount">
    <div id="main">
        <p class="new-p">确定退出?</p>
        <div class="fix">
        <input type="hidden" id="identity" value="${identity}">
        <input type="hidden" id="teaid" value="${teacher_id }">
        <a class="layui-btn" href="javascript:void(0)" target="_self" id="out">退出</a>
        <a class="layui-btn" href="javascript:void(0)" target="_self" id="suiyi">取消</a>
       </div>
    </div>
    </form>
    <script src="../../layui/layui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        layui.use('layer', function () {
            var layer = layui.layer;
        });
        $('#out').click(function(){
        	var data = $("#exitAccount").serialize();
        	var URL=root + "/" + $("#identity").val() +"/exitAccount";
        	$.ajax({
        		url : URL,
        		type : "post",
        		async : false,
        		data : data,
        		dataType : 'json',
        		success : function(data) {
        				var index = parent.layer.getFrameIndex(window.name);
        	            parent.layer.close(index);
        		},
        		error : function(data) {
        			alert("操作失败");
        		}
        	})
        	history.go(-1);
        });
        $('#suiyi').click(function(){
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        })
    </script>
</body>

</html>