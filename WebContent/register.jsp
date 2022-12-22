<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html  class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title>注册</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/login.css">
	  <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <%Object msg = request.getAttribute("msg"); %>
	<%Object name = request.getAttribute("username"); %>
	<%Object pas = request.getAttribute("password"); %>
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">图书管理员注册</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" action="add_user"  οnSubmit="return check()">
            <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" value="<%=name==null?"":name%>">
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input" value="<%=pas==null?"":pas%>">
            <hr class="hr15">
             <input id="kou" lay-verify="required" placeholder="口令"  type="password" class="layui-input">
            <hr class="hr15">
            <div class="checkbox" style="padding-top: 10px;">
				<span style="color:red"> <%= msg==null?"":msg %> </span>
			</div>
            <input value="注册" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
           
        </form>
    </div>
</body>
<script type="text/javascript">
    function check() {
    	//var n1 = document.getElementById("kou"); 
      //  if(){
      //      return true;    //return true; 时,表单将提交
      //  }
      //  else {
            return false;   //return false; 时,表单不提交
      //  }
    }
</script>

</html>