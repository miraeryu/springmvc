<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<img src="resources\dog.jpg"> <!-- servlet-context에 설정된 경로만 읽어옴 -->
<img src="images\dog.jpg">
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
