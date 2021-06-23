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
				<td>납기일</td>
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
					<td>출고번호</td>
					<td>출고일자</td>
					<td>고객</td>
					<td>품번</td>
					<td>풍명</td>
					<td>납기일</td>
					<td>주문수량</td>
					<td>단가</td>
					<td>공급가</td>
					<td>부가세</td>
					<td>공급대가</td>
					<td>출고구분</td>
				</thead>
				<c:forEach var="rs" items="${rsView }" varStatus="status">
				<tr>
					<td><input type="text" id="releaseNum" name="ListVO[${fn:length(rsView) }].releaseNum" value='${rs.releaseNum }' readonly/></td>
					<td><input type="text" id="releaseDate" name="ListVO[${fn:length(rsView) }].releaseDate" value='${rs.ireleaseDate }' readonly/></td>
					<td><input type="text" id="customerCode" name="ListVO[${fn:length(rsView) }].customerCode" value='${rs.customerCode }' readonly/></td>
					<td><input type="text" id="itemCode" name="ListVO[${fn:length(rsView) }].itemCode" value='${rs.itemCode }' readonly/></td>
					<td><input type="text" id="itemName" name="ListVO[${fn:length(rsView) }].itemName" value='${rs.itemName }' readonly/></td>
					<td><input type="text" id="dueDate" name="ListVO[${fn:length(rsView) }].dueDate" value='${rs.dueDate }' readonly/></td>
					<td><input type="text" id="ordersQuantity" name="ListVO[${fn:length(rsView) }].ordersQuantity" value='${rs.ordersQuantity }' readonly/></td>
					<td><input type="text" id="productPrice" name="ListVO[${fn:length(rsView) }].productPrice" value='${rs.productPrice }' readonly/></td>
					<td><input type="text" id="totPrice" readonly/></td>
					<td><input type="text" id="vat" readonly/></td>
					<td><input type="text" id="totVatPrice" readonly/></td>
					<td><input type="text" id="orderOX" name="ListVO[${fn:length(rsView) }].orderOX" value='${rs.orderOX }' readonly/></td>
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
			var startDate = new Date().toISOString().substring(0,10);;
			var endDate = new Date().toISOString().substring(0,10);;
			var totPrice = document.getElementById("totPrice");
			var vat = document.getElementById("vat");
			var totVatPrice = document.getElementById("totVatPrice");
			
			totPrice.onfocus = function(){
				var ordersQuantity = parsefloat(ordersQuantity.value);
				var productPrice = parsefloat(productPrice.value);
				totPrice.value = ordersQuantity*productPrice;
			}
			
			vat.onfocus = function(){
				var totPrice = parsefloat(totPrice.value);
				vat.value = totPrice * (1/10);
			}
			
			totVatPrice = function(){
				var totPrice = parsefloat(totPrice.value); 
				var vat = parsefloat(vat.value);
				totVatPrice.value = totPrice + vat;
			}
			
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
					alert("지시기간 종료일은 시작일보다 작을 수 없습니다.");
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