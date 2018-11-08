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

  <div class="body">
      
      <div class="container">
            <div class="user">
                    <img src="<%=path %>/assets/imgs/student.jpg" alt="" class="userlogo">
                    <div class="info">
                        <h1 class="fontweight">
                            上机考试中...
                        </h1>
                    </div>
                </div>
        <div>
             <div class="content leftcontent">
                <div class="test">
                     <h3 class="fontweight">试卷下载</h3>
                           
                     <a href="" class="test_down">下载查看</a>
                     </div>
                </div>
                 
            <div class="content rightcontent">
                    <div class="result">
                        <h3 class="fontweight">答案上传</h3>
                        <div class="upresult"> 
                            <p>请按照考试要求将答案文件打包，再次进行上传。同名文件多次上传将会被覆盖</p>
                            <form action=""  class="resultform">
                                <input type="file" value="浏览..." class="resultfile">
                                <input type="submit" value="上传" class="btn btn-primary btn-sm sumbtn">
                            </form>
                            
                        </div>
                    </div>
                </div>
         </div>
          
      </div>
  </div>
