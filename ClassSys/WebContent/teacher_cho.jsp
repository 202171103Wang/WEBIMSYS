<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String username=(String)session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
     <div id="but_on">用户操作</div>
     <div id="but"><a href="tperson_message.jsp">个人信息</a> </div>
     <div id="but"><a  href="dorm_message.jsp">宿舍信息</a></div>
     <div id="but"><a href="ask_re.jsp">检察员</a></div>
     <div id="but"><a href="login.jsp">退出系统</a></div>
</body>
</html>