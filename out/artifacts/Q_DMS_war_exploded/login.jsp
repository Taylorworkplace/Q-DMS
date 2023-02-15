<%--
  Created by IntelliJ IDEA.
  User: zero
  Date: 2022/6/1
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <title>Track Your Order</title>
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link href="https://fonts.googleapis.com/css?family=Montserrat%7CRoboto:100,300,400,500,700,900%7CRoboto+Condensed:100,300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/icon-font-linea.css">
    <link rel="stylesheet" type="text/css" href="css/multirange.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="css/themify-icons.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/effect.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/cartpage.css">
    <link rel="stylesheet" type="text/css" href="css/contact.css">
    <link rel="stylesheet" type="text/css" href="css/owl.theme.default.css">
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
    <link rel="stylesheet" type="text/css" href="css/responsive.css">
    <style>
        body{
            background-image: url('img/background.jpg');
            overflow-y: hidden;
        }
        .mine{
            text-align: center;
            margin: 1% auto;
            padding-top: 9%;
            padding-bottom: 11%;
        }
        .card{
            width: 50%;
            margin: auto;
            border: 0px solid gray;
            background-color: rgba(226,225,228,0.2);
            border-radius: 10px;
        }
        .userstyle{
            width: 50%;
            height: 47px;
            padding: 6px 12px;
            font-size: 14px;
            line-height: 1.428571429;
            color: #555555;
            vertical-align: middle;
            background-color: #ffffff;
            border: 1px solid #cccccc;
            border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
            -webkit-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
            margin-top: 5%;
        }
        .userstyle:focus {
            border-color: #66afe9;
            outline: 0;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgba(102, 175, 233, 0.6);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgba(102, 175, 233, 0.6);
        }

        .buttonstyle{
            outline-style: none;
            border: none;
            width: 25%;
            height: 5%;
            padding: 10px;
            border-radius: 7px;
            margin-top:5% ;
            margin-left: 5%;
            margin-bottom: 2%;
            text-align: center;
            background-color: #e87a66;
            color:white;

        }
    </style>

</head>
<body>
<!-- push menu-->
<div>
    <div class="mine">
        <div class="container">
            <p style="margin-top:0%;font-family: 'Microsoft soft';font-size: 23px;font-weight: 700;color:white">Welcome to Q-dms data mining</p>
            <p style="color:white">    ————————  </p>
            <div class="card">
                <div class="card-body">
                    &emsp13;<p></p>
                    <form action="userLogin">
                        <div style="padding-left:1%">
                            <div>
                                <img src="img/name.png" style="width:9%;margin-bottom:-4%;" >
                                <input type="text" placeholder="请输入id号" class="userstyle" name="id"><br>
                            </div>
                            <div>
                                <img src="img/name.png" style="width:9%;margin-bottom:-4%;" >
                                <input type="text" placeholder="请输入用户名" class="userstyle" name="name"><br>
                            </div>
                            <div style="margin-top: 2px">
                                <img src="img/password.png" style="width:9%;margin-top:-2%;margin-bottom:-7%;">
                                <input type="text" placeholder="请输入密码" class="userstyle" name="password"><br>
                            </div>
                           <span style="color: red"> ${message}</span><br>
                        </div>
                        <span style="margin-left: -2.5%;">
									<input type="submit" value="登录" class="buttonstyle" name="login">
								</span>
                        <span>
									<input type="submit" value="注册" class="buttonstyle" name="register">
								</span>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>



<script src="js/jquery-3.3.1.min.js" defer=""></script>
<script src="js/bootstrap.min.js" defer=""></script>
<script src="js/multirange.js" defer=""></script>
<script src="js/owl.carousel.min.js" defer=""></script>
<script src="js/sync_owl_carousel.js" defer=""></script>
<script src="js/scripts.js" defer=""></script>



<%--<form action="userLogin">--%>
<%--    id：<input type="text" name="id"/><br>--%>
<%--    用户名：<input type="text" name="name"/><br>--%>
<%--    密码：<input type="text" name="password"/><br>--%>
<%--    <input type="submit" value="登录"/><br>--%>
<%--</form>--%>
</body>
</html>
