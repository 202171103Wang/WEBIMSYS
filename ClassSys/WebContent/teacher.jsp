<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String no=(String)session.getAttribute("no"); %>
<!DOCTYPE html>
<HTML>
<head>
    <meta charset="UTF-8">
    <title>教师界面</title>
    <style>
      @import url(css/control.css);
    </style>
</head> 
<body>
   <div id="Container">
      <div id="header"><img src="css/h1.jpg" class="img1"/><h1><font face="华文彩云" size="20" >     宿 舍 卫 生 管 理 系 统</font></h1></div>
      <div id="main">
         <div id="first">
          <%@include file="teacher_cho.jsp" %>
          </div>
         <div id="second">
          <%@include file="success.jsp" %>
         </div>
       </div>
       <div id="footer">Copyright 2019-2020 202171103.All rights Reserved</div>
   </div>
</body>
</HTML>
