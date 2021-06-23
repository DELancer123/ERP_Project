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
				<td>������</td>
				<td colspan="2" style="width: 80px;">
				<input type="date" id="searchStartDate" value="${param.startDate }" style="width: 100%;" />
				</td>
				<td>~</td>
				<td>
				<input type="date" id="searchEndDate" value="${param.endDate }"style="width: 100%;" />
				</td>
			</tr>
		</table>
	</form>
	</container1>
	<form id="regRs" method="get" commandName="ListVO">
		<container2 id=contents2>
		<div id="rsInfo">
			<table id="rsTable">
				<thead>
					<td>ǰ��</td>
					<td>ǰ��</td>
					<td>�԰�</td>
					<td>����</td>
					<td>������</td>
					<td>�ֹ�����</td>
					<td>�ܰ�</td>
					<td>���Ͽ�����(����)</td>
					<td>�������(�Ƿ�)</td>
					<td>�˻�(�Ƿ�,����)</td>
					<td>�����</td>
					<td>���ڵ�</td>
				</thead>
				<c:forEach var="rs" items="${rsView }" varStatus="status">
				<tr>
					<td><input type="text" id="itemCode" name="ListVO[${fn:length(rsView) }].itemCode" value='${rs.itemCode }' readonly/></td>
					<td><input type="text" id="itemName" name="ListVO[${fn:length(rsView) }].itemName" value='${rs.itemName }' readonly/></td>
					<td><input type="text" id="standard" name="ListVO[${fn:length(rsView) }].standard" value='${rs.standard }' readonly/></td>
					<td><input type="text" id="inventoryUnit" name="ListVO[${fn:length(rsView) }].inventoryUnit" value='${rs.inventoryUnit }' readonly/></td>
					<td><input type="text" id="dueDate" name="ListVO[${fn:length(rsView) }].dueDate" value='${rs.dueDate }' readonly/></td>
					<td><input type="text" id="orderQuantity" name="ListVO[${fn:length(rsView) }].orderQuantity" value='${rs.orderQuantity }' readonly/></td>
					<td><input type="text" id="productPrice" name="ListVO[${fn:length(rsView) }].productPrice" value='${rs.productPrice }' readonly/></td>
					<td><input type="text" id="expectedDate" name="ListVO[${fn:length(rsView) }].expectedDate" value='${rs.expectedDate }' readonly/></td>
					<td><input type="text" id="releaseExpectedDate" name="ListVO[${fn:length(rsView) }].releaseExpectedDate" value='${rs.releaseExpectedDate }' readonly/></td>
					<td><input type="text" id="inspection" name="ListVO[${fn:length(rsView) }].inspection" value='${rs.inspection }' readonly/></td>
					<td><input type="text" id="orderOX" name="ListVO[${fn:length(rsView) }].orderOX" value='${rs.orderOX }' readonly/></td>
					<td><input type="text" id="customerCode" name="ListVO[${fn:length(rsView) }].customerCode" value='${rs.customerCode }' readonly/></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div id="rsSum">
			�����հ�: <input type="text" disabled /> ���ް� �հ�: <input type="text"
				disabled /> �ΰ��� �հ�: <input type="text" disabled /> �հ��: <input
				type="text" disabled />
		</div>

		</container2>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script>
			var startDate = new Date().toISOString().substring(0,10);;
			var endDate = new Date().toISOString().substring(0,10);;
			
			$('#searchStartDate').change(function(){
				var date = $('#searchStartDate').val();
				startDate = date;
			});
			$('#searchEndDate').change(function(){
				var date = $('#searchEndDate').val();
				endDate = date;
			});
			
			view_button.onclick = function(){
				if(startDate>endDate){
					alert("���ñⰣ �������� �����Ϻ��� ���� �� �����ϴ�.");
				} else{
					const URLSearch = new URLSearchParams(location.search);
					URLSearch.set('submit',"1")
					URLSearch.set('startDate',startDate);
					URLSearch.set('endDate',endDate);
					const newParam = URLSearch.toString();
					
					window.open(location.pathname + '?' + newParam, '_self');
				}
			}
		</script>
	</form>
</body>
</html>