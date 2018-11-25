<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<script type="text/javascript">
var root = "<%=path%>/";
if (root == "/") {root="";}
var abroot = "<%=basePath%>";
</script>
<html> 
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>登录</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="../../layui/css/layui.css">
        <style>
              .new-label {
    float: left;
    display: block;
    padding: 9px 15px;
    width: 160px;
    font-weight: 400;
    line-height: 20px;
    text-align: right;
}

.layui-form-item .layui-input-inline {
    float: left;
    width: 240px;
    margin-right: 10px;
}
.au{
  
  margin-left: 150px;
}
a:hover {text-decoration: none;}
a:visited{text-decoration: none;}
a:focus{text-decoration: none; color: #fff}
        </style>
    </head>
    <body>
            <div style="width:500px;margin: 0 auto">
                <form class="layui-form" action="" method="post" id="updatePassword">
                    <div class="layui-form-item">
                      <label class="new-label">请输入旧口令</label>
                      <div class="layui-input-inline">
                        <input type="password" name="oldpassword" required lay-verify="required" placeholder="旧口令" autocomplete="off" class="layui-input">
                      </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="new-label">请输入新口令</label>
                        <div class="layui-input-inline">
                          <input id="password" type="password" name="password" required lay-verify="required" placeholder="新口令" autocomplete="off" class="layui-input">
                        </div>
                      </div>
                      <div class="layui-form-item">
                        <label class="new-label">确认新口令</label>
                        <div class="layui-input-inline">
                          <input id="checkpassword" type="password" required lay-verify="required" placeholder="确认新口令" autocomplete="off" class="layui-input">
                        </div>
                      </div>
                      <input type="hidden" id="identity" value="${identity}">
                      <input type="hidden" name="id" value="${teacher_id }">
                      <div class="layui-form-item au">
                      <a class="layui-btn" href="javascript:void(0)" target="_self" id="go">立即提交</a>
                      <a class="layui-btn" href="javascript:void(0)" target="_self"  id="o">取消</a>
                    </div>
                  </form>
            </div>
              
              
              
           
        <script src="../../layui/layui.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
          
          layui.use('element', function(){
            var element = layui.element;
         
          });
          layui.use('layer', function () {
            var layer = layui.layer;
        });
        $('#go').click(function(){
        	 
        	if($("#password").val()=="" ||$("#oldpassword").val()=="" ){
        		alert("请输入密码");
        		return false;
        	}
        	if($("#password").val()!=$("#checkpassword").val()){
        		alert("密码不一致");
        		return false;
        	}
        	var data = $("#updatePassword").serialize();
        	var URL=root + "/" + $("#identity").val() +"/updatePassword";
        	$.ajax({
        		url : URL,
        		type : "post",
        		async : false,
        		data : data,
        		dataType : 'json',
        		success : function(data) {
        			if (data == true) {
        				location.reload();
        				var index = parent.layer.getFrameIndex(window.name);
        	            parent.layer.close(index);
        	            alert("修改成功");
        			} else {
        			}
        		},
        		error : function(data) {
        			alert("密码输入错误");
        		}
        	})
            
        });
        $('#o').click(function(){
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        })
          </script>
    </body>
</html>