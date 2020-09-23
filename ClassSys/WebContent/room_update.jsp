<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*,car.*,java.util.*"%>
<% 
    String i=(String)session.getAttribute("i");
     Room r=new Room();
    int x=0;
    try
    {
    	x=Integer.parseInt(i);
    	RoomDB roomdb=new RoomDB();
        ArrayList<Room> rs=roomdb.selectroom();
        r=rs.get(x);
        roomdb.close();
    }
    catch(Exception e)
    {
    	System.out.println(e.getMessage());
    }
    
%>
<html>
    <head>
    <title>宿舍信息</title>
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
    </style>
    </head>
    <body>
    <div class="center">
        <div class="content">
          <form name="form1" action="rupdate" method="post">
            <div class="box">
              <label class="i-label">宿舍号</label>
              <input type="text" name="RoomNo" class="i-text" value="<%=r.getRoomNo() %>">
            </div>
            <div class="box">
               <label class="i-label">班级号</label>
               <input type="text" name="ClassNo"class="i-text" value="<%=r.getClassNo() %>">
            </div>
            <div class="box">
              <label class="i-label">目前已有人数</label>
              <input type="text" name="p_num" class="i-text" value="<%=r.getNum() %>">
            </div>
            <div class="box">
                  <span class="i-text">
                   <input type="submit" name="Sub" value="修    改">&nbsp;&nbsp;&nbsp;&nbsp;
                   <input type="button" name="Sub2"  value="取    消" onclick="history.go(-1)"/>
                  </span>
            </div>
    </form>
    </div></div>
    </body>
    </html>