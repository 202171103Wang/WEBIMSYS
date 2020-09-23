<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,car.*,db.*,control.*"%>
<%
       UserDB users=new UserDB();
       ArrayList<person> persons=users.selectperson();
     users.close();
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
      <div id="header"><img src="css/h1.jpg" class="img1"/><h1><font face="华文彩云" size="20" >     宿 舍 卫 生 管 理 系 统 </font></h1></div>
      <div id="main">
         <div id="first">
            <%@include file="control_cho.jsp" %>
         </div>
         <div id="second">
         <div id="but_onl">个人信息总表</div>
        <table width="1000px">
        <tr>
         <td >学工号</td>
         <td >姓名</td>
         <td >性别</td>
         <td >出生日期</td>
         <td >密码</td>
         <td >班级代码</td>
         <td >宿舍号</td>
         <td >职称</td>
         <td >联系方式</td>
         <td >操作</td>
         <td id="btn"><a href="register.jsp">增加信息</a>
        </tr>
       <%for(int i=0;i<persons.size();i++){
            	person p=persons.get(i);
            	%>
        	 <tr>
        	 <td ><%=p.getNo()%></td>
        	 <td ><%=p.getName() %></td>
        	 <td ><%=p.getSex() %></td>
        	 <td ><%=p.getBirthday() %></td>
        	 <td ><%=p.getPwd() %></td>
        	 <td ><%=p.getClassno() %></td>
        	 <td ><%=p.getRoomno() %></td>
        	 <td ><%=p.getProfessor() %></td>
        	 <td ><%=p.getCall() %></td>
        	 <td id="btn"><a href="open_person?i=<%=i%>">修改</a></td>
        	 <td id="btn"><a href="pdelete?i=<%=i%>">删除</a></td>
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
