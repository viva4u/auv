<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
	<head>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<style type="text/css">
			.simpleSearchDiv {
				background-color:#c40000;
				width:400px;
				height:40px;
				margin: 10px auto;
				padding: 1px;
				display: block;
			}
			.simpleSearchDiv input {
				width: 275px;
				height:36px;
				margin:1px;
				border: 1px solid transparent;
				outline: none;
			}
			.simpleSearchDiv button {
				width: 110px;
				background-color: #c40000;
				border: 1px solid transparent;
				font-size: 18px;
				font-weight:bold;
				color: white;
			}
			.searchBelow {
				margin-top: 3px;
				margin-left: -20px;
			}
			.searchBelow span {
				color: #999;				
			}
			.searchBelow a {
				color: #999;
				padding: 0 20px 0 20px;
			}
			a {
				color: #999;
			}
			a:hover {
				color: #C40000;
			    text-decoration: none;
			}
			body {
				font-size: 12px;
				font-family: Arial;
			}
		</style>
	</head>
	<body>
		<div>
			<a href="#nowhere"><img id="logo" class="logo" src="<!-- http://how2j.cn/tmall/img/site/logo.gif -->">logo</a>
			<div class="simpleSearchDiv pull-right">
				<input type="text" name="keyword" placeholder="太阳镜    男鞋">
				<button class="searchButton" type="submit">搜索</button>
				<div class="searchBelow">
					<span><a href="#nowhere">平衡车</a><span>|</span></span>
					<span><a href="#nowhere">扫地机器人</a><span>|</span></span>
					<span><a href="#nowhere">原汁机</a><span>|</span></span>
					<span><a href="#nowhere">冰箱</a></span>
				</div>
			</div>
			<div style="clear: both;"></div>
		</div>
	</body>
</html>