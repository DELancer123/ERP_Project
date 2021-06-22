<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import ="java.util.Arrays"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<style>
a {
	text-decoration: none;
}

#wrap {
	width: 1400px;
	height: 450px;
	border: 1px solid black;
}

#searchBox {
	width: 100%;
	height: 23%;
	border: 1px solid black;
}

#button {
	margin-top: 3%;
	margin-right: 3%;
	text-align: right;
}

#search {
	margin-left: 30px;
}

#view {	
    overflow: scroll;
    height: 100%;
    width: 100%;
    
}
</style>
</head>
<body>
<form name="select" action="member/mainplan.do" method="get">
	<div id="wrap">
		<div id="searchBox">
			<table id="search">
 				<tr>
					<td>주문기간</td>
						<td><input type="date" id="dateStart"
							style="background-color: yellow;" /></td>
						<td>~</td>
						<td><input type="date" id="dateEnd"
							style="background-color: yellow;" /></td>
						<td></td>
				</tr>
			</table>
			<div id="button">
				<input type="button" id="planSearch" value="조회" onClick="sendData();" />			
				<button onClick="sendToParent();">적용</button>
				<button>취소</button>
			</div>
		</div>
		<div id="view">
			<table style="width: 100%;">
				<thead align="center" style="background-color: gray">
					<td ><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
					<td>순서</td>
					<td>주문번호</td>
					<td>주문일자</td>
					<td>승인일자</td>
					<td>고객</td>
					<td>품번</td>
					<td>품명</td>
					<td>규격</td>
					<td>단위</td>
					<td>주문수량</td>
					<td>적용수량</td>
					<td>주문잔량</td>
					<td>출하예정일</td>
					<td>비고</td>
				</thead>	
				<c:forEach var="MpsOS" items="${mpsosList}">
					<tr align="center">
					<td><input type="checkbox" name="content"/></td>
					<td style="width:13px;"><input type="text" value="${MpsOS.sequence}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.orderno}" /></td>
						<td><input type="text" value="${MpsOS.orderdate}"/></td>
						<td><input type="text" value="${MpsOS.okeydate}"/></td>
						<td><input type="text" id="buyer" value="${MpsOS.buyer}" /></td>
						<td><input type="text" id="item_Code" value="${MpsOS.item_Code}" /></td>
						<td><input type="text" id="item_Name" value="${MpsOS.item_Name}" /></td>
						<td><input type="text" value="${MpsOS.standard}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.inventory_unit}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.order_quantity}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.apply_quantity}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.order_Balance}" style="width:100%"/></td>
						<td><input type="text" id="expected_Date" value="${MpsOS.expected_Date}"/></td>
						<td><input type="text" value="${MpsOS.note}" style="width:100%"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</form>
		</div>
	</div>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
function sendToParent(){	
    var text_buyer = document.getElementById("buyer").value;
    var text_Code = document.getElementById("item_Code").value;
    var text_Name = document.getElementById("item_Name").value;
    var text_expDate = document.getElementById("expected_Date").value;
        
    opener.document.getElementById("buyer").value=text_buyer;
    opener.document.getElementById("item_Code").value=text_Code;
    opener.document.getElementById("item_Name").value=text_Name;
    opener.document.getElementById("expected_date").value=text_expDate;
        
     window.close();
} 

var startDate;
var endDate;


$('#dateStart').change(function (){
    var date = $('#dateStart').val();
    startDate = date;
});
$('#dateEnd').change(function (){
    var date = $('#dateEnd').val();
    endDate = date;
});

function sendData() {
	if(startDate == null && endDate == null){
		alert("시작일과 종료일은 필수 입력 요소입니다!");
	} else if(startDate == null) {
		alert("시작일은 필수 입력 요소입니다!");
	} else if(endDate == null){
		alert("종료일은 필수 입력 요소입니다!");
	} else if(startDate > endDate){
		alert("종료일은 시작일보다 커야합니다!");
	} else {
		location.href='${contextPath }/member/applyorder.do?dateStart='+startDate+'&&dateEnd='+endDate;
	}
}
</script>
</body>
</html>