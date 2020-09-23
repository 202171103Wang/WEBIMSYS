<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*,car.*,java.util.*"%>
<% 
    String no=(String)session.getAttribute("no");
    UserDB userdb=new UserDB();
    person p=new person();
    p=userdb.selectp(no);
    RecordDB record=new RecordDB();
    ArrayList<Record> records=record.select_crecord(p.getClassno());
    record.close();
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
      <div id="header"><img src="css/h1.jpg" class="img1"/><h1><font face="华文彩云" size="20" >     宿 舍 卫 生 管 理 系 统</font></h1></div>
      <div id="main">
         <div id="first">
          <%@include file="teacher_cho.jsp" %>
          </div>
         <div id="second">
         <div id="but_onl">班级宿舍信息</div>
         <form name="form1" method="post" action="">
          <table width=100%>
            <tr>
             <td class="te">宿舍号</td>
             <td class="te">年</td>
             <td class="te">月</td>
             <td class="te">日</td>
             <td class="te">成绩</td>
             <td class="te">附加信息</td>
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
     </form>
    </div>
       </div>
       <div id="footer">Copyright 2019-2020 202171103.All rights Reserved</div>
   </div>
</body>
</HTML>