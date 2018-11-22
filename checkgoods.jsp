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
<title>二手交易网后台管理系统</title>
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
<script type="text/javascript" src="js/modernizr.custom.04022.js"></script>
<!--clock init-->
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
	<div class="left-content">
	   <div class="inner-content">
		<!-- header-starts -->
			<div class="header-section">
					<div class="clearfix"></div>
				</div>
					<!-- //header-ends -->
							<!--//outer-wp-->
									<div class="outter-wp">
									<!--/sub-heard-part-->
											 <div class="sub-heard-part">
													   <ol class="breadcrumb m-b-0">
															<li><a href="here.jsp">主页</a></li>
															<li class="active">商品审核管理</li>
														</ol>
											</div>	
											<div class="graph-visual tables-main">
											<h3 class="inner-tittle two">转让商品</h3>
													<div class="graph">
														<div class="tables">
																<table class="table table-bordered"> 
																	<thead> 
																		<tr> 
																			<th>商品编号</th>
																			<th>商品名称</th>
																			<th>商品类型</th>
																			<th>商品原价</th>
																			<th>商品描述</th>
																			<th>转让价格</th>
																			<th>转让者编号</th>
																			<th>审核</th>
																		</tr> 
																	</thead> 
																	<tbody> 
																		<c:forEach items="${requestScope.goodszrCheckInfoAll}" var="gszrc">
																			<tr>
																				<td>${gszrc.goodszrid}</td>
																				<td>${gszrc.goodsname}</td>
																				<td>${gszrc.classname}</td>
																				<td>${gszrc.orig}</td>
																				<td>${gszrc.goodsmsg}</td>
																				<td>${gszrc.price}</td>
																				<td>${gszrc.sellerid}</td>
																				<td>
																					<a href="../CheckGoodsServlet?method=zrPass&id=${gszrc.goodszrid}">通过</a>
																					<a href="../CheckGoodsServlet?method=zrNo&id=${gszrc.goodszrid}">不通过</a>
																				</td>
																			</tr>
																		</c:forEach>
																	</tbody> 
																</table>
														</div>
													</div>
													<h3 class="inner-tittle two">求购请求</h3>
													<div class="graph">
														<div class="tables">
																<table class="table table-bordered"> 
																	<thead> 
																		<tr> 
																			<th>求购信息编号</th>
																			<th>求购商品名称</th>
																			<th>求购商品类型</th>
																			<th>求购商品描述</th>
																			<th>求购商品估价</th>
																			<th>求购信息发布人编号</th>
																			<th>审核</th>
																		</tr> 
																	</thead> 
																	<tbody> 
																		<c:forEach items="${requestScope.goodsqgCheckInfoAll}" var="gsqgc">
																			<tr>
																				<td>${gsqgc.goodsqgid}</td>
																				<td>${gsqgc.goodsname}</td>
																				<td>${gsqgc.classname}</td>
																				<td>${gsqgc.goodsmsg}</td>
																				<td>${gsqgc.price}</td>
																				<td>${gsqgc.buyerid}</td>
																				<td>
																					<a href="../CheckGoodsServlet?method=qgPass&id=${gsqgc.goodsqgid}">通过</a>
																					<a href="../CheckGoodsServlet?method=qgNo&id=${gsqgc.goodsqgid}">不通过</a>
																				</td>
																			</tr>
																		</c:forEach>
																	</tbody> 
																</table>
														</div>
													</div>
											</div>
			<!--/sidebar-menu-->
				<div class="sidebar-menu">
					<header class="logo">
					<a href="#" class="sidebar-icon" onclick="return false;"> <span class="fa fa-bars"></span> </a> <a href="index.html"> <span id="logo"> <h1>后台系统</h1></span> 
					<!--<img id="logo" src="" alt="Logo"/>--> 
				  </a> 
				</header>
			<div style="border-top:1px solid rgba(69, 74, 84, 0.7)"></div>
			<!--/down-->
							<div class="down">	
									  <a href="#" onclick="return false;"><img src="images/admin.jpg"></a>
									  <a href="#" onclick="return false;"><span class=" name-caret">Administrator</span></a>
									 <p>System Administrator in Company</p>
									<ul>
									<!-- <li><a class="tooltips" href="index.html"><span>Profile</span><i class="lnr lnr-user"></i></a></li> -->
										<!-- <li><a class="tooltips" href="index.html"><span>Settings</span><i class="lnr lnr-cog"></i></a></li> -->
										<li><a class="tooltips" href="../logout.jsp"><span>Log out</span><i class="lnr lnr-power-switch"></i></a></li>
										</ul>
									</div>
							   <!--//down-->
								<div class="menu">
									<ul id="menu" >
										<li><a href="../UserListServlet?method=show"><i class="fa fa-tachometer"></i><span>查看所有用户信息</span></a></li>
										 <li id="menu-academico" ><a href="#" onclick="return false;"><i class="fa fa-table"></i><span>商品类型管理</span><span class="fa fa-angle-right" style="float: right"></span></a>
										   <ul id="menu-academico-sub" >
											<li id="menu-academico-avaliacoes" ><a href="../GoodClassServlet?method=show">查看已有商品类型</a></li>
											<li id="menu-academico-boletim" ><a href="insertgoodsclass.jsp">添加新的商品类型</a></li>
										  </ul>
										</li>
										 <li id="menu-academico" ><a href="#" onclick="return false;"><i class="fa fa-file-text-o"></i><span>学校院级管理</span> <span class="fa fa-angle-right" style="float: right"></span></a>
											 <ul id="menu-academico-sub" >
												<li id="menu-academico-avaliacoes" ><a href="../SchoolDepartServlet?method=show">查看已有学校与院级</a></li>
												<li id="menu-academico-boletim" ><a href="insertschool.jsp">添加新的学校</a></li>
												<li id="menu-academico-boletim" ><a href="insertdepart.jsp">添加新的院级</a></li>
											  </ul>
										 </li>
									<li><a href="../CheckGoodsServlet?method=show"><i class="lnr lnr-pencil"></i><span>商品审核管理</span></a></li>
									<li id="menu-academico" ><a href="../SearchServlet?method=show"><i class="lnr lnr-book"></i> <span>商品留言管理</span></a></li>
									 <li><a href="../SearchSuggestionServlet?method=show"><i class="fa fa-smile-o"></i><span>网站建议留言管理</span></a></li>
								  </ul>
								</div>
							  </div>
							  <div class="clearfix"></div>		
							</div>
							<script>
							var toggle = true;
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }
											
											toggle = !toggle;
										});
							</script>
<!--js -->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
</body>
</html>