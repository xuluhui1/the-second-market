<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
    String path = request.getRequestURI();
    String basePath = request.getScheme()+"://"
            +request.getServerName()+":"
            +request.getServerPort()+path;
%>
<base href="<%=basePath%>">
<title>欢迎登陆二手交易网后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<link href='https://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<script src="js/jquery-1.10.2.min.js"></script>
<!--clock init-->
<script type="text/javascript">
													function check1(){ //登录判断
														var name=document.getElementById("name").value;
														var password=document.getElementById("password").value;
														if(name==null||name==""||name.length==0||name=="用户名"){
															alert("用户名不能为空！");
															return false;
														}else if(password==null||password==""||password.length==0||password=="******"){
															alert("密码不能为空！");
															return false;
														}else
															return true;
													}
													
													function loadMess(){ //用户不存在，登录失败
														var message=parseInt(document.getElementById("message").value);
														if(message==0){
															alert("登录失败");
															return false;
														}else
															return true;
													}
												</script>
</head> 
<body style="height:700px" onload="return loadMess();">
								<!--/login-->
								
									   <div class="error_page">
												<!--/login-top-->
													<div class="error-top">
													<h2 class="inner-tittle page">管理员登录</h2>
													    <div class="login">
														<h3 class="inner-tittle t-inner">Login</h3>
																<form action="../AdminLoginServlet" method="post"> 
																<%--"../AdminLoginServlet"表示转到该java程序，判断该用户是否存在 --%>
																		<input type="text" class="text" value="用户名" name="name" id="name" >
																		<input type="password" value="******" id="password" name="password">
																		<div class="submit"><input type="submit" onclick="return check1();return loadMess();" value="Login" ></div>
																		<div class="clearfix"></div>
																	</form>
														</div>

														
													</div>
													
													
												<!--//login-top-->
										   </div>
						
										  	<!--//login-->
										   
									<!--/404-->
<!--js -->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
</body>
</html>