<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,car.*,db.*,control.*"%>
<%
       RoomDB roomdb=new RoomDB();
       ArrayList<Room> rooms=roomdb.selectroom();
       roomdb.close();
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
         <div id="but_onl">宿舍信息总表</div>
        <table width=100%>
        <tr>
         <td >宿舍号</td>
         <td >班级代码</td>
         <td >目前居住人数</td>
         <td >操作</td>
         <td id="btn"><a href="room_register.jsp">增加信息</a>
        </tr>
        <%
              for(int i=0;i<rooms.size();i++)
              {
            	 Room r=rooms.get(i);  
              
        %>
        <tr>
        <td ><%=r.getRoomNo() %></td>
        <td ><%=r.getClassNo() %></td>
        <td ><%=r.getNum() %>
        <td id="btn"><a href="open_room?i=<%=i%>">修改</a></td>
        <td id="btn"><a href="rdelete?i=<%=i%>">删除</a></td>
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
