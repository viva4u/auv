<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
	<head>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<style type="text/css">
			div.categoryWithCarousel{
			    width: 100%;
			    margin-top:15px;
			    position:relative;
			}
			div.categoryWithCarousel div.headbar{
    			background-color: #DD2727;
			}
			div.categoryWithCarousel div.head{
			    width: 200px;
			    background-color: #C60A0A;
			    height: 36px;
			    line-height: 36px;
			    font-size: 16px;
			    font-weight: bold;
			    color: white;
			    margin-left: 20px;
			    display: inline-block;
			}
			div.categoryWithCarousel div.rightMenu{
    			display: inline-block;
			}
			div.categoryWithCarousel div.rightMenu a{
			    font-size: 16px;
			    color: white;
			    text-decoration:none;
			}
			div.categoryWithCarousel div.rightMenu span{
    			margin: 0px 20px 0px 20px;
			}
			div.carousel-of-product{
			    height: 490px;
			    width:1024px;
			    margin:0px auto;
			}
			img.carouselImage{
    			height: 490px !important;
			}
			div.carouselBackgroundDiv{
			    width:100%;
			    height:510px;
			    background-color:#E8E8E8;
			    position:absolute;
			    top:36px;
			    z-index:-1;
			}
		</style>
	</head>
	<body>
		<div class="categoryWithCarousel">
			<div class="headbar">
				<div class="head">
					<span class="glyphicon glyphicon-th-list" style="margin-left: 10px;"></span>
					<span style="margin-left: 10px;">商品分类</span>
				</div>
				<div class="rightMenu">
					<span><a href="#nowhere">平板电视</a></span>
					<span><a href="#nowhere">电热水器</a></span>
				</div>
			</div>
			<div data-ride="carousel" class="carousel-of-product carousel slide" id="carousel-of-product">
				<ol class="carousel-indicators">
				    <li class="active" data-slide-to="0" data-target="#carousel-of-product"></li>
				    <li data-slide-to="1" data-target="#carousel-of-product" class=""></li>
				    <li data-slide-to="2" data-target="#carousel-of-product" class=""></li>
				    <li data-slide-to="3" data-target="#carousel-of-product" class=""></li>
  				</ol>
  				<div role="listbox" class="carousel-inner">
  					<div class="item active">
      					<img src="http://how2j.cn/tmall/img/lunbo/1.jpg" class="carousel carouselImage">
    				</div>
				    <div class="item">
				      <img src="http://how2j.cn/tmall/img/lunbo/2.jpg" class="carouselImage">
				    </div>
				    <div class="item">
				        <img src="http://how2j.cn/tmall/img/lunbo/3.jpg" class="carouselImage">
				    </div>
				    <div class="item">
				        <img src="http://how2j.cn/tmall/img/lunbo/4.jpg" class="carouselImage">
				    </div>
  				</div>
			</div>
			<div class="carsouselBackgroundDiv"></div>
		</div>
	</body>
</html>