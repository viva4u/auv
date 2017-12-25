<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE>
<html>
	<head>
	
	</head>
	<body>
		<html>
			<form action="<%=request.getContextPath()%>/uploadfile" method="post" enctype="multipart/form-data">
				上传文件：<input type="file" name="file1"/>
				<button onclick="submit">上传</button>
				${message}
			</form>
		</html>
	</body>
</html>