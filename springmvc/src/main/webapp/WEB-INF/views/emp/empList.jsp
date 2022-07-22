<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사원정보</h2>
	<form>
		사번 <input name="employeeId">
		부서 <input type="checkbox" name="depts" value="10">
			<input type="checkbox" name="depts" value="20">
			<input type="checkbox" name="depts" value="30">
		직무 <select name="jobId">
				<option value="IT-PROG">IT-PROG
				<option value="ST_CLERK">ST_CLERK
				<option value="ST-MAN">ST-MAN
			</select>
		입사일자 <input type="date" name="sdt">~<input type="date" name="edt">
		<button>검색</button>
	</form>
	<table>
		<tr>
			<th>사원번호</th>
			<th>성</th>
			<th>이름</th>
			<th>이메일</th>
			<th>입사일</th>
			<th>업무</th>
			<th>급여</th>
		</tr>
	<c:forEach items="${empList}" var="emp">
		<tr>
			<td><a href="empUpdate?employeeId=${emp.employeeId}">${emp.employeeId }</a></td>
			<td>${emp.firstName }</td>
			<td>${emp.lastName }</td>
			<td>${emp.email }</td>
			<td>${emp.hireDate }</td>
			<td>${emp.jobId }</td>
			<td>${emp.salary }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>