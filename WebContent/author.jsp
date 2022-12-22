<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="imau.edu.author" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
    	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                         <%author student =(author) request.getAttribute("author"); %>
                           <form action="add" style="margin-left: 180px;"method="post">
                               <input type="hidden" name="id" value="<%=student!=null? student.getId() :""%>">
								<div class="form-group" style="display: flex;width: 80%;">
							   <input   type="text" class="form-control" id="exampleInputName2"  name="Username" style="width: 180px;margin-right: 20px;"placeholder="用户名" value="<%=student!=null? student.getUsername() :""%>">
							   <input   type="text" class="form-control" id="exampleInputName2"  name="Gender" style="width: 100px;margin-right: 20px;"placeholder="性别" value="<%=student!=null? student.getGender() :""%>">
							   <input   type="text" class="form-control" id="exampleInputName2"  name="Phoen" style="width: 55px;margin-right: 20px;"placeholder="联系方式" value="<%=student!=null?student.getPhone() :""%>">
							   <input   type="text" class="form-control" id="exampleInputName2"  name="Bookname" style="width: 100px;margin-right: 20px;" placeholder="书名" value="<%=student!=null?student.getBookname() :""%>">
							   <input   type="text" class="form-control" id="exampleInputName2"  name="Sales_volume" style="width: 100px;margin-right: 20px;"placeholder="销量" value="<%=student!=null?student.getSales_volume() :""%>">
							   <input   type="text" class="form-control" id="exampleInputName2"  name="Booknum" style="width: 100px;margin-right: 20px;"placeholder="书总数" value="<%=student!=null?student.getBooknum() :""%>">
                                <button type="submit" class="btn btn-default，btn btn-info">添加 / 修改</button>
                            </form>
                        </div>
                       <!-- <div class="layui-card-header" style="margin-right: 10px;">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加用户','./member-add.html',600,400)"><i class="layui-icon"></i>添加</button>
                        </div> -->
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>ID</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>联系方式</th>
                                    <th>书名</th>
                                    <th>销量</th>
                                    <th>书总数</th>
									<th>操作</th>
									</tr>
                                </thead>
                                <tbody>
                                <%
                                	Object list = request.getAttribute("data");
                                %>
								<%
									for(author c :(ArrayList<author>) list) {
								%>
                                  <tr>
                                   
                                    <td><%=c.getId()%></td>
                                    <td><%=c.getUsername()%></td>
                                    <td><%=c.getGender()%></td>
                                    <td><%=c.getPhone()%></td>
                                    <td><%=c.getBookname()%></td>
									<td><%=c.getSales_volume()%></td>
									<td><%=c.getBooknum()%></td>
						            <td style="text-align:center">
										<a class="btn btn-default，btn btn-warning" href="updata?id=<%=c.getId() %>" role="button">修改</a>
										<a class="btn btn-default，btn btn-danger" href="del?id=<%=c.getId() %>" role="button">删除</a>
									</td>
                                  </tr>
                                   <%}%>
                                </tbody>
                            </table>
                        </div>
                     
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script>
     
    </script>
</html>