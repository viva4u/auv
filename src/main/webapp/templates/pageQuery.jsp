<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE>
<html>
	<head>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table-locale-all.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/pageQuery.js"></script>
		<%-- <script src="<%=request.getContextPath()%>/js/testPageQuery.js"></script> --%>
		<style type="text/css">
			div.mainSearch {
				width: 150px;
				height: 50px;
				margin: 10px auto;
				position: relative;
			}
			div.search {
				width: 140px;
				height: 20px;
				margin: 5px 5px 5px 5px;
			}
			div.searchButton {
				position: absolute;
				top: 10px;
				left: 200px;
			}
		</style>
	</head>
	<body>
		<div class="mainSearch">
			<input id="basepath" name="basepath" value="<%=request.getContextPath()%>" style="display: none">
			<div class="search">
				<input class="searchInput" type="text" name="name" placeholder="请输入姓名"/>
			</div>
			<div class="search">
				<input class="searchInput" type="text" name="age" placeholder="请输入年龄"/>
			</div>
			<div class="searchButton">
				<button class="btn btn-default search" type="button">查询</button>
			</div>
		</div>
		<div class="col-xs-12">
			<table id="pageQueryTable" class="table table-striped table-bordered table-hover" ></table>
		</div>
		
	</body>
</html>