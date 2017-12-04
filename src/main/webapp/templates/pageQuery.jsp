<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE>
<html>
	<head>
		
	</head>
	<body>
		<c:forEach items="${allUsers}" var="user">
			<span>姓名：</span><span>${user.name}</span>
		</c:forEach>
	</body>
</html>