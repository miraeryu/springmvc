<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사원수정</h2>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<form action="empUpdateProc" method="post">
		<div>employeeId<input name="employeeId" value="${emp.employeeId }" readonly="readonly"></div>
		<div>firstName<input name="firstName" value="${emp.firstName }"></div>
		<div>lastName<input name="lastName" value="${emp.lastName }"></div>
		<div>hireDate<input type="date" name="hireDate" value="${emp.hireDate }"></div>
		<!-- <div>hireDate<input type="date" name="hireDate" value='<fmt:formatDate value="${emp.hireDate }" pattern="yyyy-MM-dd"/>'></div> -->
		<div>email<input name="email" value="${emp.email }"></div>
		<div>jobId<input name="jobId" value="${emp.jobId }"></div>
		<button>등록</button>
		<button type="button" id="btnDelete">삭제</button>
	</form>
</body>
<script>
	btnDelete.addEventListener("click", function(){
		location.href="#{path}/empDelete?employeeId=${emp.employeeId}";
	})
</script>
</html>