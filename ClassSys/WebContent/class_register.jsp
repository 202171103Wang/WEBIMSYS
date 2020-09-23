<%@page language="java" import="java.util.*,db.*" pageEncoding="utf-8"%>
<html>
    <head>
    <title>新建班级</title>
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
       height:200px;
       position:relative;
       box-shadow:0px 1px 5px 0px rgba(0,0,0,0.3);
       border-radius:8px;
       top:120px;
       left:30%;
    }
    .box{
	 position:relative;
	 line-height:160%;
	 margin:10px;
	 top:20px;
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
    </script>
    </head>
<body>
        <div class="center">
        <div class="content">
            <form name="form_class" method="post" action="ClassaddServlet">
              <div class="box">
                  <h1 align="center">新建班级</h1>
              </div>
              <div class="box">
                  <label class="i-label">班级号</label>
                  <input type="text" name="ClassNo" class="i-text" >
              </div>
              <div class="box">
                  <label class="i-label">班级名称</label>
                  <input type="text" name="ClassName" class="i-text">
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