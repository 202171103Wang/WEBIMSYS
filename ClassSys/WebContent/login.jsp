<%@page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
     <head>
       <title>登录</title>
       <style type="text/css">
       @import url(css/login.css);
       </style>
       <script type="text/javascript">
          function change(){
        	  document.getElementById("validate").src="ValidateServlet?random="+Math.random();
          }
       </script>
     </head>
     <body>
         <div class="login">
             <div class="content">
                  <form name="form1" action="LoginServlet" method="post" >
                  <div class="frm">
                      <h1 align="center">欢迎登录卫生管理系统</h1>
                  </div>
                  <div class="frm">
                      <label class="i-label">用户名：</label>
                      <input type="text" name="No" class="txtuser"/>
                  </div>
                  <div class="frm">
                       <label class="i-label">密码：</label>
                       <input type="password" name="Pwd" class="txtpwd"/>
                  </div>
                  <div class="frm">
                       <label class="i-label">验证码：</label>
                       <input type="text" name="userVCode" class="txtVcode"/>
                       <span class="Vcode">
                            <img src="ValidateServlet" id="validate" onclick="change()"/>
                            <a href="javascript:change()">看不清，换一张</a>
                       </span>
                  </div>
                  <div class ="frm">
                       <span class="txtuser">
                       <input type="radio" name="professor" value="student">学生
                       <input type="radio" name="professor" value="teacher">教师
                       <input type="radio" name="professor" value="admin">管理员
                       <input type="radio" name="professor" value="control">系统管理员
                       </span>   
                  </div>
                  <div class="frm">
                      <span class="txtuser">
                       <input type="submit" name="login"  value="登     录"/>&nbsp;&nbsp;&nbsp;&nbsp;
                       <input type="reset" name="sub2" value="取     消"/>
                      </span>
                  </div>
                  </form>
             </div>
         </div>
     </body>
</html>