<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*,car.*"%>
<% 
    String no=(String)session.getAttribute("no");
    UserDB userdb=new UserDB();
    person2 p=new person2();
    p=userdb.select(no);
    userdb.close();
%>
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
      <div id="header"><img src="css/h1.jpg" class="img1"/><h1><font face="华文彩云" size="20" >     宿 舍 卫 生 管 理 系 统 </font></h1></div>
      <div id="main">
         <div id="first">
            <%@include file="teacher_cho.jsp" %>
         </div>
         <div id="second">
             <div id="but_onl">个人信息</div>
             <form name="form1" method="post" action="PersonUpServlet" class="content" >
              <div class="box">
                  <label class="i-label">学工号</label>
                  <input type="text" name="No" class="i-text" value="<%=p.getNo()%>" readonly="readonly">
              </div>
              <div class="box">
                  <label class="i-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                  <input type="text" name="Pwd" class="i-text" value=<%=p.getPwd()%>>
              </div>
              <div class="box">
                  <label class="i-label">姓&nbsp;&nbsp;&nbsp;&nbsp;名</label>
                  <input type="text" name="Name" class="i-text"value="<%=p.getName() %>"disabled="disabled">
              </div>
              <div class="box">
                  <label class="i-label">性&nbsp;&nbsp;&nbsp;&nbsp;别</label>
                  <input type="text" name="Sex" class="i-text"value="<%=p.getSex() %>"disabled="disabled">
              </div>
              <div class="box">
                   <label class="i-label">出生年月</label>
                   <input type="date" name="Birthday" class="i-text"value="<%=p.getBirthday() %>"disabled="disabled">
              </div>
              <div class="box">
                  <label class="i-label">联系方式</label>
                  <input type="text" name="call" class="i-text"value=<%=p.getCall() %>>
              </div>
             <div class="box">
                   <label class="i-label">班&nbsp;&nbsp;&nbsp;&nbsp;级</label>
                   <input type="text" name="ClassName" class="i-text"value="<%=p.getClassname() %>"disabled="disabled">
              </div>
              <div class="box">
                   <input type="submit" name="Sub" value="修    改">
              </div>
            </form>
     </div>
       </div>
       <div id="footer">Copyright 2019-2020 202171103.All rights Reserved</div>
   </div>
</body>
</HTML>
