<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>

<title>学生</title>
    <link rel="stylesheet" href="<%=path %>/css/student/student.css">
    
</head>
<body>
  <div class="body">
      <div class="head"></div>
      <div class="container">
            <div class="user">
                    <img src="" alt="" class="userlogo">
                    <div class="info">
                        <h1 class="fontweight">
                            上机考试中...
                        </h1>
                    </div>
                </div>
         <div class="filelist">
             <h4 class="fontweight">已上传的文件列表</h4>
             <table class="table table-bordered">
                <tr >
                        <th>文件名</th>
                        <th>文件大小</th>
                        <th>上传时间</th>
                </tr>
                <tr >
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                </tr>
            </table>
        </div> 
        <div class="result2">
          <h4 class="fontweight">答案上传</h4>
          <form action=""  class="resultform">
                <input type="file" value="浏览..." class="resultfile">
                <input type="submit" value="上传" class="btn btn-primary btn-sm sumbtn">
            </form>    
        </div>              
          
      </div>
  </div>
