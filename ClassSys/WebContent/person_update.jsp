<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*,car.*,java.util.*"%>
<% 
    String i=(String)session.getAttribute("i");
    person p=new person();
    int x=0;
    try
    {
    	x=Integer.parseInt(i);
    	UserDB users=new UserDB();
        ArrayList<person> persons=users.selectperson();
        p=persons.get(x);
        users.close();
    }
    catch(Exception e)
    {
    	System.out.println(e.getMessage());
    }
    
%>
<!DOCTYPE html>
<HTML>
<head>
   <meta charset="UTF-8">
   <title>员工信息界面</title>
   <style>
    .content{
       background-color:rgb(252,252,252);
       width:400px;
       height:500px;
       position:relative;
       box-shadow:0px 1px 5px 0px rgba(0,1,1,1.3);
       border-radius:8px;
       left:30%;
       top:10;
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
   <script type="text/javascript">
   function goback(){
	   history.go(-1);
	   }
   </script>
</head>
<body>
        <form name="form1" method="post" action="pupdate"  class="content">
              <div class="box">
                  <h1 align="center">个人信息</h1>
              </div>
              <div class="box">
                  <label class="i-label">学工号：</label>
                  <input type="text" name="No" class="i-text" value="<%=p.getNo()%>" readonly="readonly">
              </div>
              <div class="box">
                  <label class="i-label">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
                  <input type="text" name="Pwd" class="i-text" value=<%=p.getPwd()%>>
              </div>
              <div class="box">
                  <label class="i-label">姓名</label>
                  <input type="text" name="Name" class="i-text"value="<%=p.getName() %>">
              </div>
              <div class="box">
                  <label class="i-label">性&nbsp;&nbsp;&nbsp;&nbsp;别</label>
                  <input type="text" name="Sex" class="i-text" value="<%=p.getSex() %>">
              </div>
              <div class="box">
                   <label class="i-label">出生年月：</label>
                   <input type="date" name="Birthday" class="i-text"value="<%=p.getBirthday() %>">
              </div>
             <div class="box">
                   <label class="i-label">班&nbsp;&nbsp;&nbsp;&nbsp;级：</label>
                   <input type="text" name="ClassNo" class="i-text"value="<%=p.getClassno() %>">
              </div>
              <div class="box">
                   <label class="i-label">宿&nbsp;&nbsp;&nbsp;&nbsp;舍</label>
                   <input type="text" name="RoomNo" class="i-text"value="<%=p.getRoomno() %>">
              </div>
              <div class="box">
                   <label class="i-label">职&nbsp;&nbsp;&nbsp;&nbsp;称</label>
                   <input type="text" name="professor" class="i-text"value="<%=p.getProfessor() %>">
              </div>
               <div class="box">
                  <label class="i-label">联系方式：</label>
                  <input type="text" name="call" class="i-text"value=<%=p.getCall() %>>
              </div>
              <div class="box">
                  <span class="i-text">
                   <input type="submit" name="Sub" value="修    改">&nbsp;&nbsp;&nbsp;&nbsp;
                   <input type="button" name="Sub2"  value="返   回" onclick="histroy.go(-1)" />
                  </span>
              </div>
            </form>
</body>
</HTML>