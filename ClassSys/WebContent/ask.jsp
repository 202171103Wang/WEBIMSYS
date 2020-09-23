<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="car.*,db.*,control.*,java.util.*"%>
<%
      String no=(String)session.getAttribute("no");
      ArrayList<Ask> pasks=new ArrayList<Ask>();
      AskDB askdb=new AskDB();
      pasks=askdb.selectpask(no);
      askdb.close();
%>
<!DOCTYPE html>
<HTML>
<head>
    <meta charset="UTF-8">
    <title>学生界面</title>
    <style>
      @import url(css/control.css);
    </style>
</head> 
<body>
   <div id="Container">
      <div id="header"><img src="css/h1.jpg" class="img1"/><h1><font face="华文彩云" size="20" >     宿 舍 卫 生 管 理 系 统</font></h1></div>
      <div id="main">
         <div id="first">
          <%@include file="student_cho.jsp" %>
          </div>
         <div id="second">
         <div id="but_onl">申请信息</div>
        <table width=100%>
        <tr >
         <td class="te">年</td>
         <td class="te">月</td>
         <td class="te">日</td>
         <td class="te">状态</td>
         <td class="te"><a href="addask?no=<%=no%>">提出申请</a>
        </tr>
        <%
              for(int i=0;i<pasks.size();i++)
              {
            	 Ask a=pasks.get(i);  
              
        %>
        <tr>
        <td class="tex"><%=a.getYear() %></td>
        <td class="tex"><%=a.getMonth() %></td>
        <td class="tex"><%=a.getDay() %></td>
        <td class="tex"><%=a.getMessage() %></td>
        <td class="tex"><a href="adelete?no=<%=no%>&c=<%=a.getClassno()%>&y=<%=a.getYear()%>&m=<%=a.getMonth()%>&d=<%=a.getDay()%>">撤销申请</a></td>
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