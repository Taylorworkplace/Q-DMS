<%--
  Created by IntelliJ IDEA.
  User: zero
  Date: 2022/6/1
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <style>
    body {
      background-image: url('img/BG3.jpg');
      background-size: 100% 100% ;
      background-attachment: fixed;
      /* opacity: 0.8; */
    }

    #left,#center,
    #right {
      position: fixed;
      top: 22%;
      width: 20%;
      height: 58%;
      text-align: center;
      border: 1px solid #000;
      /* background-color: #FFF; */
      background-color: rgba(201, 197, 197, 0.451);

      /* opacity: 0.5; */

    }

    #left {
      left: 10%;
    }
    #center {
      margin-left:40%;

    }
    #right {
      left: 70%;
      right: 20%;
    }

    .vertical-text1 {

      -webkit-writing-mode: vertical-rl;
      writing-mode: vertical-rl;
      font-size: 40px;
      color: pink;
      letter-spacing: 100px;
      margin-top: 20px;

    }
    .vertical-text {

      -webkit-writing-mode: vertical-rl;

      writing-mode: vertical-rl;
      font-size: 40px;
      color: pink;
      letter-spacing: 20px;
      margin-top: 20px;

    }

    a {
      text-decoration: none;
    }
    img{
      margin-top: 20px;
    }
    a:hover{ color: coral;}
    .QD{
      font-size: 40PX;
      margin-left: 1%;
      color: white;
    }


  </style>
  <body>
  <div>
    <div>
      <span class="QD" style="right: 80%;">Q-DNS数据挖掘</span>
      <a href="exit" style="float: right;font-size: 30px;">退出</a>
    </div>
    <div id="left">
      <img src="img/shop.png" width="30%"><br>
      <a href="shopping" class="vertical-text1" >购物</a>
      <div style="position:center;color:blanchedalmond;">${message}</div>
    </div>
    <div id="center">
      <img src="img/wuliu.png" width="30%"><br>
      <a href="transport" class="vertical-text">物流查询</a>
    </div>
    <div id="right">
      <img src="img/rizhi.png" width="30%"><br>
      <a href="log" class="vertical-text">日志查询</a>
    </div>
  </div>
  </body>
<%--  <h5>首页</h5>--%>
<%--          <form action="shopping">--%>
<%--              <input type="submit" value="提交">${message}--%>
<%--          </form>--%>
  </body>
</html>
