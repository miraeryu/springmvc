<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사원등록</h2>
	<form action="empInsertProc" method="post">
		<div>firstName<input name="firstName"></div>
		<div>lastName<input name="lastName"></div>
		<div>hireDate<input type="date" name="hireDate"></div>
		<div>email<input name="email"></div>
		<div>jobId<input name="jobId"></div>
		<button>등록</button>
	</form>
</body>
</html>