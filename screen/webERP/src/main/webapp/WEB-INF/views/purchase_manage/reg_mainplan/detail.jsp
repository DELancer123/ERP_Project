<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
</head>
<style>
	h2  { text-align: center;}
  table { width: 100%;}
  textarea { width: 100%;}
 	#outter {
		display: block;
		width: 30%;
		margin: auto;
	}
</style>
<body>

<br><br><br>
<div id="outter">
	<table border="1">
		<tr>
			<td>순서: ${mainplan.sequence}</td>
		</tr>
		<tr>
			<td>
				계획일: ${mainplan.plandate }
				<span style="float: right;"><input type="text" value="${mainplan.plandate}" /></span>
			</td>
			<td>
				품번: ${mainplan.item_Code}
				<span style="float: right;"><input type="text" value="${mainplan.item_Code}" /></span>
			</td>
			<td>
				품명: ${mainplan.item_Name}
				<span style="float: right;"><input type="text" value="${mainplan.item_Name}" /></span>
			</td>
			<td>
				규격: ${mainplan.standard}
				<span style="float: right;"><input type="text" value="${mainplan.standard}" /></span>
			</td>
			<td>
				단위: ${mainplan.unit}
				<span style="float: right;"><input type="text" value="${mainplan.unit}" /></span>
			</td>
			<td>
				출하예정일: ${mainplan.expected_date}
				<span style="float: right;"><input type="text" value="${mainplan.expected_date}" /></span>
			</td>
			<td>
				납기일: ${mainplan.due_date}
				<span style="float: right;"><input type="text" value="${mainplan.due_date}" /></span>
			</td>
			<td>
				계획수량: ${mainplan.plan_quantity}
				<span style="float: right;"><input type="text" value="${mainplan.plan_quantity}" /></span>
			</td>
			<td>
				고객: ${mainplan.customer_Name}
				<span style="float: right;"><input type="text" value="${mainplan.customer_Name}" /></span>
			</td>
			<td>
				비고: ${mainplan.note}
				<span style="float: right;"><input type="text" value="${mainplan.note}" /></span>
			</td>
	
		</tr>
<%-- 		<tr>
			<td><div style="height: 300px; margin: 10px; display: inline-block">${board.content }</div></td>
		</tr> --%>
	</table>
	<input type="button" value="글 목록" style="float: right;" onclick="location.href='member/mainplan.do';"> 
</div>
</body>
</html>