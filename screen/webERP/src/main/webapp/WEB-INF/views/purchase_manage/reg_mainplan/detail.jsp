<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
request.setCharacterEncoding("UTF-8");
String sequence = (String)request.getAttribute("sequence");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<th>정보</th>
		<th>데이터</th>
		<tr>
			<td>순서</td>
			<td>${mainplan.sequence}</td>
		</tr>
		<tr>
			<td>계획일</td>
			<td>${mainplan.plandate}</td>
		</tr>
		<tr>
			<td>품번</td>
			<td>${mainplan.item_Code}</td>
		</tr>
		<tr>
			<td>규격</td>
			<td>${mainplan.item_Name}</td>
		</tr>
		<tr>
			<td>단위</td>
			<td>${mainplan.standard}</td>
		</tr>
		<tr>
			<td>출하예정일</td>
			<td>${mainplan.unit}</td>
		</tr>
		<tr>
			<td>납기일</td>
			<td>${mainplan.expected_date}</td>
		</tr>
		<tr>
			<td>계획수량</td>
			<td>${mainplan.due_date}</td>
		</tr>
		<tr>
			<td>고객</td>
			<td>${mainplan.plan_quantity}</td>
		</tr>
		<tr>
			<td>비고</td>
			<td>${mainplan.customer_Name}</td>
		</tr>
		<tr>
			<td>비고</td>
			<td>${mainplan.note}</td>
		</tr>

	</table>
	<div class='btnSet'>
		<a class='btn-fill' href="mainplan.do">목록</a>
		<a class='btn-fill' href="modify?Sequence=${vo.Sequence}">수정</a>
	</div>
</body>
</html>
