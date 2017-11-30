<%@page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
		<script src="<%=request.getContextPath() %>/js/jquery.min.js" charset="UTF-8"></script>
		<script src="<%=request.getContextPath() %>/js/bootstrap.min.js" charset="UTF-8"></script> --%>
		<style type="text/css">
			body {
				font-size: 12px;
				font-family: Arial;
			}
			a{
    			color:#999;
			}
			.redColor{
    			color: #C40000 !important;
			}
			nav.top{
			    background-color: #f2f2f2;
			    padding-top: 5px;
			    padding-bottom: 5px;
			    border-bottom:1px solid  #e7e7e7;
			}
			nav.top span, nav.top a{
			    color: #999;
			    margin: 0px 10px 0px 10px;
			}
			nav.top a:hover{
			    color: #C40000;
			    text-decoration: none;
			}
		</style>
	</head>
	<body>
		<nav class="top">
			<a href="#nowhere">
				<span class="glyphicon glyphicon-home redColor"></span>主页
			</a>
			<span>欢迎</span>
			<a href="#nowhere">登陆</a>
			<a href="#nowhere">注册</a>
			<span class="pull-right">
				<a href="#nowhere">我的订单</a>
				<a href="#nowhere"><span class=" glyphicon glyphicon-shopping-cart redColor"></span>购物车<strong>0</strong>件</a>
			</span>
		</nav>
	</body>
</html>
