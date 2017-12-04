<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<style type="text/css">
			#category {
				width: 100px;
				height: 200px;
				position: absolute;
				top: 0px;
				left: 0px;
				background-color: #e2e2e2;
				z-index: 1;
			}
			#product div.productitem {
				width:200px;
				height:200px;
				margin-left:100px;
				padding-left:20px;
				background-color: white;
				display: none;
				position: absolute;
				top: 0px;
				left: 0px;
				z-index: 1;
			}
			div.cateitem a:hover {
				text-decoration: none;
			}
		</style>
		<script type="text/javascript">
			function showcateitem(cid) {
				$("div.productitem[data-cid="+cid+"]").show();
			}
			function hidecateitem(cid) {
				$("div.productitem[data-cid="+cid+"]").hide();
			}
			$(function(){
				$("div.cateitem").mouseenter(function name() {
					var cid=$(this).attr("data-cid");
					showcateitem(cid);
					$(this).css("background-color","white");
				});
				$("div.cateitem").mouseleave(function name() {
					var cid=$(this).attr("data-cid");
					hidecateitem(cid);
					$(this).css("background-color","#e2e2e2");
				});
				$("div.productitem").mouseenter(function name() {
					var cid=$(this).attr("data-cid");
					showcateitem(cid);
					$("div.cateitem[data-cid="+cid+"]").css("background-color","white");
				});
				$("div.productitem").mouseleave(function name() {
					var cid=$(this).attr("data-cid");
					hidecateitem(cid);
					$("div.cateitem[data-cid="+cid+"]").css("background-color","#e2e2e2");
				});
			});
			
		</script>
	</head>
	<body>
		<div class="content" style="position: relative;width:100%;height:500px; top:0px;left:0px;background-color: #f4f4f4;">
			<div id="category">
				<div class="cateitem" data-cid="1">
					<span class="glyphicon glyphicon-link"></span>
					<a href="#nowhere">平板电视</a>
				</div>
				<div class="cateitem" data-cid="2">
					<span class="glyphicon glyphicon-link"></span>
					<a href="#nowhere">家居</a>
				</div>
			</div>
			<div id="product">
				<div class="productitem" data-cid="1">
					<span>三星</span>
					<span>苹果</span>
					<span>小米</span>
				</div>
				<div class="productitem" data-cid="2">
					<span>沙发</span>
					<span>茶几</span>
					<span>书桌</span>
				</div>
			</div>
		</div>
	</body>
</html>