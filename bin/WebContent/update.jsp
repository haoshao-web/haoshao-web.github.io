<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
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
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改</h3>
        <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${student.id}">

          <div class="form-group">
            <label for="bookid">图书编号：</label>
            <input type="text" class="form-control" id="bookid" name="bookid"  value="${student.bookid}" readonly="readonly" placeholder="请输入图书编号" />
          </div>


          <div class="form-group">
            <label for="type">图书类型：</label>
            <input type="text" class="form-control" value="${student.type}" id="type"  name="type" placeholder="请输入图书类型" />
          </div>


          <div class="form-group">
            <label for="bookname">图书名称：</label>
            <input type="text" id="bookname" class="form-control" value="${student.bookname}" name="bookname" placeholder="请输入图书名称"/>
          </div>

          <div class="form-group">
            <label for="author">作者名称：</label>
            <input type="text" id="author" class="form-control" value="${student.author}" name="author" placeholder="请输入作者名称"/>
          </div>
          
          <div class="form-group">
            <label for="press">出版社：</label>
            <input type="text" id="press" class="form-control" value="${student.press}" name="press" placeholder="请输入出版社"/>
          </div>
          
          <div class="form-group">
            <label for="number">总数量：</label>
            <input type="text" id="number" class="form-control" value="${student.number}" name="number" placeholder="请输入总数量"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" id="back" type="button" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>