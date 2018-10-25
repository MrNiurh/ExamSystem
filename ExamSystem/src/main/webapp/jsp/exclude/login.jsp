<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="../../css/exclude/login.css">
    <script src="../../js/jquery/jquery-2.1.1.min.js"></script>
    <script src="../../js/exclude/login.js"></script>
    <title>login</title>
</head>
  <div class="container">
        <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a  href="javascript:void(0)" user="1" class="userlogin">学生登录</a></li>
                <li role="presentation"  ><a href="javascript:void(0)" user="2" class="userlogin">教师登录</a></li>
                <li role="presentation"><a href="javascript:void(0)" user="3" class="userlogin">管理员登录</a></li>
        </ul>
        <div class="userinfo ">
             <div user="1" class="userstu ">
                 <h4 >当前没有进行的考试</h4>
             </div>
        </div>
      <div>
          <div class="logincontent stucontent">
            <div class="logintop">
                <img src="../../assets/imgs/logo.jpg" alt="" class="loginimg"/>
                <div class="logintext">
                    <h3>学生登录</h3>
                </div>
            </div>

                <div class="formbox">
                    <div class="form">
                            <form action="" class ="login">
                                <p>
                                    <input type="text" placeholder="  学号" style="margin-bottom:10px;"></br>
                                    <input type="text" placeholder="  姓名">
                                </p>
                               <input type="submit" value="登录" style="color:#747474;">

                            </form>
                    </div>

                </div>

        </div>

       <div class="logincontent teacontent hide">
            <div class="logintop">
                <img src="../../assets/imgs/logo.jpg" alt="" class="loginimg"/>
                <div class="logintext">
                    <h3>教师登录</h3>
                </div>
            </div>

                <div class="formbox">
                    <div class="form">
                            <form action="" class ="login">
                                <p>
                                    <input type="text" placeholder="  用户名" style="margin-bottom:10px;"></br>
                                    <input type="text" placeholder="  口令">
                                </p>
                               <input type="submit" value="登录" style="background:#0059cc;color: white">

                            </form>
                    </div>

                </div>

        </div>
      <div class="logincontent admincontent hide">
            <div class="logintop">
                <img src="../../assets/imgs/logo.jpg" alt="" class="loginimg"/>
                <div class="logintext">
                    <h3>管理员登录</h3>
                </div>
            </div>

                <div class="formbox">
                    <div class="form">
                            <form action="" class ="login">
                                <p>
                                    <input type="text" placeholder="  用户名" style="margin-bottom:10px;"></br>
                                    <input type="text" placeholder="  口令">
                                </p>
                               <input type="submit" value="登录" style="background:#0059cc;color: white">

                            </form>
                    </div>

                </div>

        </div>
      </div>


  </div>
