<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import ="java.util.Arrays"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
	String sequence = (String)request.getAttribute("sequence");
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
<!-- 				<tr>
					<td>주문기간</td>
					<td colspan="2" style="width: 80px;"><input type="date"
						id="reqInput" style="width: 100%;" /></td>
					<td>~</td>
					<td><input type="date" id="reqInput" style="width: 100%;" /></td>
					<td></td>
				</tr> -->
				<tr>
                    <td>검색1</td>
                    <td><input type="text" id="cusName" /></td>
                </tr>
                <tr>
                    <td>검색2</td>
                    <td><input type="text" id="Code"/></td>
                </tr>
                <tr>
                    <td>검색3</td>
                    <td><input type="text" id="Name" /></td>
                </tr>
                <tr>
                    <td>검색4</td>
                    <td><input type="text" id="expDate"/></td>
                </tr>
			</table>
			<div id="button">
				<button>조회</button>				
				<button id="clickme">적용</button>				
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
					<td><input type="checkbox" name="chk"/></td>
					<td style="width:13px;"><input type="text" value="${MpsOS.sequence}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.ordersno}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.orderdate}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.okeydate}" style="width:100%"/></td>
					<td id="customer_Name"><input type="text" value="${MpsOS.customer_Name}" style="width:100%"/></td>
					<td id="item_Code"><input type="text" value="${MpsOS.item_Code}" style="width:100%"/></td>
					<td id="item_Name"><input type="text" value="${MpsOS.item_Name}" style="width:100%"/></td>
					<td style="width:13px;"><input type="text" value="${MpsOS.standard}" style="width:100%"/></td>
					<td style="width:13px;"><input type="text" value="${MpsOS.unit}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.order_quantity}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.apply_quantity}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.order_Balance}" style="width:100%"/></td>
					<td id="expected_Date"><input type="text" value="${MpsOS.expected_Date}" style="width:100%"/></td>
						<td><input type="text" value="${MpsOS.note}" style="width:100%"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</form>
		</div>
	</div>
<script type="text/javascript">
var submit_button = document.getElementById("submit");
        var text_cusName = document.getElementById("cusName").value;
        var text_Code = document.getElementById("Code").value;
        var text_Name = document.getElementById("Name").value;
        var text_expDate = document.getElementById("expDate").value;
   function popFunction(customer_Name,item_Code,item_Name,expected_Date){
	   text_cusName.value = cusName;
	   text_Code.value = Code;
	   text_Name.value = Name;
	   text_expDate.value = expDate;
   }  
submit_button.onclick = function(){
	text_cusName.setAttribute("customer_Name",text_cusName.value);
	text_Code.setAttribute("item_Code",text_Code.value);
	text_Name.setAttribute("item_Name",text_Name.value);
	text_expDate.setAttribute("expected_Date",text_expDate.value);
	opener.parent.location='${contextPath}/member/mainplan.do?customer_Name='+text_cusName.value+'&&item_Code='+text_Code.value+
						'&&item_Name'+text_Name.value+'&&expected_Date'+text_expDate.value+'&&submit='+0;
  	 window.close();
}        
</script>
</body>
</html>