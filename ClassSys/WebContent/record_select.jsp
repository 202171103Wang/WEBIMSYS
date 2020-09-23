<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*,car.*,control.*,java.util.*"%>
<%   RecordDB record=new RecordDB();
     ArrayList<Record> records=record.selectrecord();
     record.close();
%>
<!DOCTYPE html>
<HTML>
<head>
    <meta charset="UTF-8">
    <title>卫生管理员界面</title>
    <style>
      @import url(css/control.css);
    </style>
</head> 
<body>
   <div id="Container">
      <div id="header"><img src="css/h1.jpg" class="img1"/><h1><font face="华文彩云" size="20" >     宿 舍 卫 生 管 理 系 统 </font></h1></div>
      <div id="main">
         <div id="first">
          <%@include file="admin_cho.jsp" %>
          </div>
         <div id="second">
         <table width=100%>
           <tr>
              <td >宿舍号</td>
              <td >年</td>
              <td >月</td>
              <td >日</td>
              <td >成绩</td>
              <td >附加信息,</td>
           </tr>
            <%for(int i=0;i<records.size();i++){
            	Record r=records.get(i);
            	%>
            <tr>
             <td class="tex">
                 <%=r.getRoomNo() %>
             </td>
              <td class="tex">
                 <%=r.getYear() %>
             </td>
             <td class="tex">
                 <%=r.getMonth() %>
             </td>
             <td class="tex">
                 <%=r.getDay()%>
             </td>
             <td class="tex">
                 <%=r.getGread()%>
             </td>
             <td class="tex">
                <%=r.getMessage()%>
             </td>
            </tr>
            <%} %>
       </table>
      </div>
       </div>
       <div id="footer">Copyright 2019-2020 202171103.All rights Reserved</div>
   </div>
</body>
</HTML>
