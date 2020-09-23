<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,car.*,db.*,control.*"%>
<%
      ClassDB classdb=new ClassDB();
     ArrayList<Clas> classes=classdb.selectclass();
     classdb.close();
%>
<!DOCTYPE html>
<HTML>
<head>
    <meta charset="UTF-8">
    <title>系统管理界面</title>
    <style>
      @import url(css/control.css);
    </style>
</head> 
<body>
   <div id="Container">
      <div id="header"><img src="css/h1.jpg" class="img1"/><h1><font face="华文彩云" size="20" >     宿 舍 卫 生 管 理 系 统</font></h1></div>
      <div id="main">
         <div id="first">
            <%@include file="control_cho.jsp" %>
         </div>
         <div id="second">
         <div id="but_onl">班级信息总表</div>
      <table width=100%>
        <tr>
         <td >班级代码</td>
         <td >班级名称</td>
         <td >操作</td>
          <td id="btn"><a href="class_register.jsp">增加信息</a>
        </tr>
        <%
              for(int i=0;i<classes.size();i++)
              {
            	Clas c=classes.get(i);  
              
        %>
        <tr>
        <td ><%=c.getClassNo() %></td>
        <td ><%=c.getClassName() %></td>
        <td id="btn"><a href="open_class?i=<%=i%>">修改</a></td>
        <td id="btn"><a href="cdelete?i=<%=i%>">删除</a></td>
        </tr>
        <%
              }
        %>
        </table>
        </div>
  </div>
       <div id="footer">Copyright 2019-2020 202171103.All rights Reserved</div>
   </div>
</body>
</HTML>