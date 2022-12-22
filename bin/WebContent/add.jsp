<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/common.js"></script>
    
    <!-- Bootstrap core CSS -->
    <link href="static/bootstrap-3.4.1/css/bootstrap.min.css" rel="stylesheet">

   
    <!-- Custom styles for this template -->
    <link href="static/css/navbar-fixed-top.css" rel="stylesheet">
    
    <!-- datatable js -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.13.1/datatables.min.css"/>
    <style type="text/css">
	
		 body {
		   background:url("1.jpg")  no-repeat center center;   
		   background-size:cover;  
		   background-attachment:fixed;       
		   background-color:#CCCCCC;  
		  
		 }
	</style>
    
</head>
<body>
<div class="container">
    <center><h3>添加页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">图书编号：</label>
            <input type="text" class="form-control" id="bookid" name="bookid" placeholder="请输入图书编号">
        </div>


        <div class="form-group">
            <label for="type">图书类型：</label>
            <input type="text" class="form-control" id="type" name="type" placeholder="请输入图书类型">
        </div>


        <div class="form-group">
            <label for="bookname">图书名称：</label>
            <input type="text" class="form-control" id="bookname" name="bookname" placeholder="请输入图书名称"/>
        </div>

        <div class="form-group">
            <label for="author">作者名称：</label>
            <input type="text" class="form-control" id="author" name="author" placeholder="请输入作者名称"/>
        </div>
        
        <div class="form-group">
            <label for="press">出版社：</label>
            <input type="text" class="form-control" id="press" name="press" placeholder="请输入出版社"/>
        </div>
        
        <div class="form-group">
            <label for="number">总数量：</label>
            <input type="text" class="form-control" id="number" name="number" placeholder="请输入总数量"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default"  id="back" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>