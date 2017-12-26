<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE>
<html>
	<head>
	</head>
	<body>
		<c:forEach var="file" items="${filesmap }">
			<c:url value="/download" var="downurl">
				<c:param name="filename" value="${file.key}"></c:param>
			</c:url>
			${file.value}<a href="${downurl}">下载</a>
			<br>
		</c:forEach>
	</body>
</html>