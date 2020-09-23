<%@page language="java" import="java.util.*,db.*" pageEncoding="utf-8"%>
<%
  ClassDB Class=new ClassDB();
  ArrayList<String> classns=Class.lookforClassname();
  Class.close();
%>
<html>
    <head>
    <title>新建宿舍信息</title>
    <style>
    .center{
       position:relative;
	    background:url(pic_theme.jpg) no-repeat 0 0px;
	    width:1000px;
	    height:600px;
    }
    .content{
       background-color:rgb(252,252,252);
       width:400px;
       height:300px;
       position:relative;
       box-shadow:0px 1px 5px 0px rgba(0,1,1,1.3);
       border-radius:8px;
       left:30%;
       top:50px;
    }
    .box{
	 position:relative;
	 line-height:160%;
	 margin:10px;
	 top:30px;
	 }
	 .i-label{
	 position:absolute;
	 left:0px;
	 width:80px;
	 line-height:160%;
	 text-align:right;
	 }
	 .i-text{
	 position:relative;
	 left:95px;
	 width:200px;
	 line-height:160%;
	 }
	 .i-texta{
	 position:relative;
	 left:95px;
	 width:100px;
	 line-height:160%;
	 }
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
    for(var i in roomList) {
        Power.add(new Option(i,i),null);
    }
  }
   window.onload=allRoom;
    </script>
    </head>
    <body >
        <div class="center">
        <div class="content">
            <form name="form1" method="post" action="RoomaddServlet" >
              <div class="box">
                  <h1 align="center">宿舍信息</h1>
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
                   <label class="i-label">选择班级</label>
                   <select name="ClassName"  class="i-text" style="padding:5px" >
                           <option value="">-选择班级-</option>
                   <%for(int i=1;i<classns.size();i++) { 
                           String no=classns.get(i);
                   %>
                   　　　　　　　　　　　<option value="<%=no%>"> <%=no%> </option>
                  <%} %>
                   </select>
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
    </body>
</html>