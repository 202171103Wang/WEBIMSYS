<%@page language="java" import="java.util.*,db.*" pageEncoding="utf-8"%>
<%
 ClassDB Class=new ClassDB();
 ArrayList<String> classns=Class.lookforClassname();
 Class.close();
%>
<html>
    <head>
    <title>注册页面</title>
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
	 .i-texta{
	 position:relative;
	 left:95px;
	 width:100px;
	 line-height:160%;
	 }
    </style>
    <script type="text/javascript">
    function check(theform){
   	 if(theform.No.value ==""){
   		 alert("用户名不能为空！");
   		 theform.username.focus();
   		 return false;
   	 }
   	 if(theform.Pwd.value!=theform.Pwd2.value){
   		 alert("两次密码不一致，请重新输入！");
   		 theform.userpwd2.value="";
   		 theform.userpwd2.focus();
   		 return false;
   	 }
   	 var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
   	 if(!reg.test(theform.mail.value)){
   		 alert("邮箱格式输入有错，请检查！");
   		 theform.mail.value="";
   		 theform.mail.focus();
   		 return false;
   	 }
   	 if(theform.call.value ==""){
   		 alert("联系方式不能为空！");
   		 theform.username.focus();
   		 return false;
   	 }
   }
    </script>
    </head>
    <body >
        <div class="center">
        <div class="content">
            <form name="form1" method="post" action="PersonaddServlet" onSubmit="return check(this)">
              <div class="box">
                  <h1 align="center">登录注册</h1>
              </div>
              <div class="box">
                  <label class="i-label">*学工号</label>
                  <input type="text" name="No" class="i-text">
              </div>
              <div class="box">
                  <label class="i-label">*密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                  <input type="password" name="Pwd" class="i-text">
              </div>
              <div class="box">
                  <label class="i-label">*密码确认</label>
                  <input type="password" name="Pwd2" class="i-text">
              </div>
              <div class="box">
                  <label class="i-label">姓名</label>
                  <input type="text" name="Name" class="i-text">
              </div>
              <div class="box">
                  <label class="i-label">性&nbsp;&nbsp;&nbsp;&nbsp;别</label>
                  <span class="i-text">
                     <input type="radio"  name="sex" value="male" checked>男
                     <input type="radio"  name="sex" value="female">女
                  </span>
              </div>
              <div class="box">
                   <label class="i-label">出生年月</label>
                   <input type="date" name="Birthday" class="i-text">
              </div>
              <div class="box">
                  <label class="i-label">*联系方式</label>
                  <input type="text" name="call" class="i-text">
              </div>
              <div class="box">
                   <label class="i-label">职&nbsp;&nbsp;&nbsp;&nbsp;业</label>
                   <select name="professor" size="1" style="padding:5px" class="i-text">
                   <option value="teacher">教师</option>
                   <option value="student" selected="selected">学生</option>
                   <option value="control">管理员</option>
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
                   <input type="button" name="register"  value="取    消" onclick="history.go(-1)"/>
                  </span>
              </div>
            </form>
            </div>
        </div>
    </body>
</html>