<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
request.setCharacterEncoding("UTF-8");
%>
<%
String dueDate = (String) request.getAttribute("dueDate");
%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:forEach var="rs" items="${rsInsert }">
	<c:set var="itemCode" value="${Item_Code}" />
	<c:set var="itemName" value="${Item_Name}" />
	<c:set var="standard" value="${standard}" />
	<c:set var="inventoryUnit" value="${Inventory_Unit}" />
	<c:set var="dueDate" value="${dueDate}" />
	<c:set var="orderQuantity" value="${ordersQuantity}" />
	<c:set var="productPrice" value="${productPrice}" />
	<c:set var="expectedDate" value="${expectedDate}" />
	<c:set var="releaseExpectedDate" value="${releaseExpectedDate}" />
	<c:set var="inspection" value="${inspection}" />
	<c:set var="orderOX" value="${orderOX}" />
	<c:set var="customerCode" value="${customerCode}" />
</c:forEach>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#contents1 {
	position: absolute;
	left: 15%;
	top: 15%;
	width: 85%;
	height: 10%;
	border: 1px solid black;
	z-index: 1;
}

#contents2 {
	position: absolute;
	left: 15%;
	top: 25%;
	width: 85%;
	height: 70%;
	border: 1px solid black;
	z-index: 1;
	overflow: scroll;
}

.con1_search {
	padding: 0;
	text-align: center;
	position: absolute;
	top: 25%;
	left: 15%;
}

#rsTable {
	width: 100%;
	text-align: center;
	border: 1px solid black;
}

#rsSum {
	position: absolute;
	right: 0;
	bottom: 0;
}

#reqInput {
	background-color: rgb(255, 255, 149);
	text-align: center;
}
</style>
</head>
<body>
	<container1 id=contents1>
	<form id="searchForm">
		<table class="con1_search">
			<tr>
				<td>사업장</td>
				<td style="width: 50px;"><input type="text"
					style="width: 100%;" /></td>

				<td colspan="3"><input type="text" name="" disabled
					style="width: 100%;" /></td>
				<td><i class="fas fa-search" style="color: blue;"></i></td>
				<td colspan="5" style="width: 100px;">거래구분</td>
				<td style="width: 80px;"><input type="text"
					style="width: 100%;" /></td>
				<td><input type="text" name="" disabled /></td>
				<td><i class="fas fa-search" style="color: blue;"></i></td>

			</tr>
			<tr>
				<td>출고기간</td>
				<td colspan="2" style="width: 80px;"><input type="date"
					id="reqInput" style="width: 100%;" /></td>
				<td>~</td>
				<td><input type="date" id="reqInput" style="width: 100%;" /></td>
				<td><i class="fas fa-search" style="color: blue;"></i></td>
				<td colspan="5">사원</td>
				<td style="width: 80px;"><input type="text"
					style="width: 100%;" /></td>
				<td><input type="text" name="" disabled /></td>
				<td><i class="fas fa-search" style="color: blue;"></i></td>
			</tr>
		</table>
	</form>
	</container1>
	<form id="regRs" method="get" commandName="ListVO">
		<container2 id=contents2>
		<div id="rsInfo">
			<table id="rsTable">
				<thead>
					<td>품번</td>
					<td>품명</td>
					<td>규격</td>
					<td>단위</td>
					<td>납기일</td>
					<td>주문수량</td>
					<td>단가</td>
					<td>출하예정일(수주)</td>
					<td>출고예정일(의뢰)</td>
					<td>출고구분</td>
					<td>고객코드</td>
				</thead>
				<c:forEach var="rs" items="${rsView }" varStatus="status">
				<tr>
					<td><input type="text" id="itemCode" name="ListVO[${fn:length }].itemCode" value='${rs.itemCode }'/></td>
					<td><input type="text" id="itemName" name="ListVO[${fn:length }].itemName" value='${rs.itemName }'/></td>
					<td><input type="text" id="standard" name="ListVO[${fn:length }].standard" value='${rs.standard }'/></td>
					<td><input type="text" id="inventoryUnit" name="ListVO[${fn:length }].inventoryUnit" value='${rs.inventoryUnit }'/></td>
					<td><input type="text" id="dueDate" name="ListVO[${fn:length }].dueDate" value='${rs.dueDate }'/></td>
					<td><input type="text" id="orderQuantity" name="ListVO[${fn:length }].orderQuantity" value='${rs.orderQuantity }'/></td>
					<td><input type="text" id="productPrice" name="ListVO[${fn:length }].productPrice" value='${rs.productPrice }'/></td>
					<td><input type="text" id="expectedDate" name="ListVO[${fn:length }].expectedDate" value='${rs.expectedDate }'/></td>
					<td><input type="text" id="releaseExpectedDate" name="ListVO[${fn:length }].releaseExpectedDate" value='${rs.releaseExpectedDate }'/></td>
					<td><input type="text" id="orderOX" name="ListVO[${fn:length }].orderOX" value='${rs.orderOX }'/></td>
					<td><input type="text" id="customerCode" name="ListVO[${fn:length }].customerCode" value='${rs.customerCode }'/></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div id="rsSum">
			수량합계: <input type="text" disabled /> 공급가 합계: <input type="text"
				disabled /> 부가세 합계: <input type="text" disabled /> 합계액: <input
				type="text" disabled />
		</div>

		</container2>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script>
			var itemCode = document.getElementById("itemCode");
			var itemName = document.getElementById("itemName");
			var standard = document.getElementById("standard");
			var inventoryUnit = document.getElementById("inventoryUnit");
			var dueDate = document.getElementById("dueDate");
			var orderQuantity = document.getElementById("orderQuantity");
			var productPrice = document.getElementById("productPrice");
			var expectedDate = document.getElementById("expectedDate");
			var releaseExpectedDate = document.getElementById("releaseExpectedDate");
			var orderOX = document.getElementById("orderOX");
			var customerCode = document.getElementById("customerCode");
		</script>
	</form>
</body>
</html>