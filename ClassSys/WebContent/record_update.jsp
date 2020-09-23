<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<head>
<meta charset="UTF-8">
<title>卫生检察员界面</title>
<style>
      @import url(css/control.css);
</style>
 <script type="text/javascript">
    var roomList = new Array();
    roomList['东1'] = ['E01A111','E01A112','E01A211','E01A212','E01B111','E01B112','E01B211','E01B212'];
    roomList['东2'] = ['E02A111','E02A112','E02A211','E02A212','E02B111','E02B112','E02B211','E02B212'];
    roomList['东3'] = ['E03A111','E03A112','E03A211','E03A212','E03B111','E03B112','E03B211','E03B212'];
    function changeRoom() {
    var Power = document.form1.Power.value;
    var roomno = document.form1.RoomNo;
    roomno.options.length = 0;
    for(var i in roomList) {
        if(i == Power) {
            for(var j in roomList[i]) {
                 roomno.add(new Option(roomList[i][j],roomList[i][j]),null);
             }
         }
     }
   }
   function allRoom() {
    var Power = document.form1.Power;
    var Year=document.form1.Year;
    var Month=document.form1.Month;
    var Day=document.form1.Day;
    for(var i in roomList) {
        Power.add(new Option(i,i),null);
    }
  }
   window.onload=allRoom;
   
    </script>
</head>
<head>
    <meta charset="UTF-8">
    <title>卫生管理员界面</title>
    <style>
      @import url(css/control.css);
    </style>
</head> 
<body>
   <div id="Container">
      <div id="header"><img src="css/h1.jpg" class="img1"/><h1><font face="华文彩云" size="20" >     宿 舍 卫 生 管 理 系 统</font></h1></div>
      <div id="main">
         <div id="first">
          <%@include file="admin_cho.jsp" %>
          </div>
         <div id="second">
           <form name="form1" method="post" action="RecordupServlet" class="content" >
              <div class="box">
                  <h1 >信息修改</h1>
              </div>
              <div class="box">
              <label class="i-label">选择年份</label>
                   <select name="Year"  class="i-text" style="padding:5px">
                      <% for(int i=2019;i<2026;i++){ %>
                         <option value="<%=i%>"><%=i %></option>
                         <%} %>
                   </select>
              </div>
              <div class="box">
              <label class="i-label">选择月份</label>
                   <select name="Month"  class="i-text" style="padding:5px">
                        <% for(int i=1;i<12;i++){ %>
                         <option value="<%=i%>"><%=i %></option>
                         <%} %>
                   </select>
              </div>
              <div class="box">
              <label class="i-label">选择日</label>
                   <select name="Day"  class="i-text" style="padding:5px">
                        <% for(int i=1;i<31;i++){ %>
                         <option value="<%=i%>"><%=i %></option>
                         <%} %>
                   </select>
              </div>
              <div class="box">
                    <label class="i-label">选择楼栋</label>
                   <select name="Power"  class="i-text" style="padding:5px" onchange="changeRoom()">
                   　　　　　　　　　　　<option value="">-选择楼栋-</option>
                   </select>
              </div>
              <div class="box">
                   <label class="i-label">选择房间号</label>
                   <select name="RoomNo"  class="i-text" style="padding:5px">
                         <option value="">-选择房间号-</option>
                   </select>
              </div>
              <div class="box">
                  <label class="i-label">成绩</label>
                  <input type="text" class="i-text" name="grade">
              </div>
              <div class="box">
                 <label class="i-label">附加信息</label>
                 <textarea rows="8" cols="30" name="message" class="i-text"></textarea>
              </div>
              <div class="box">
                  <span class="i-text">
                   <input type="submit" name="Sub" value="提     交">&nbsp;&nbsp;&nbsp;&nbsp;
                   <input type="button" name="Sub2"  value="取    消" onclick="history.go(-1)"/>
                  </span>
              </div>
            </form>
          </div>
       </div>
       <div id="footer">Copyright 2019-2020 202171103.All rights Reserved</div>
   </div>
</body>
</HTML>
