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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script type="text/javascript">
$("#join").click(function(){
	var rowData = new Array();
	var tdArr = new Array();
		var checkbox = $("input[name=content]:checked");
		
		checkbox.each(function(i) {
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			var item_Code = td.eq(1).text();
			var item_Name = td.eq(2).text();
			var expected_date = td.eq(3).text();
			var customer_Name = td.eq(4).text();
			
			tdArr.push(itemCode);
			tdArr.push(itemName);
			tdArr.push(expected_Date);
			tdArr.push(customer_Name);

			opener.parent.location='${contextPath}member/mainplan.do?item_Code='+tdArr[0]+'&&item_Name='+tdArr[1]+'&&expected_date='+tdArr[2]+'&&customer_Name='+tdArr[3];
		window.close();

		});
	});
</script>
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
					<td colspan="2" style="width: 80px;"><input type="date"
						id="reqInput" style="width: 100%;" /></td>
					<td>~</td>
					<td><input type="date" id="reqInput" style="width: 100%;" /></td>
					<td></td>
				</tr>
			</table>
			<div id="button">
				<button>조회</button>
				<input type="submit" id="join" value="적용" />
				<button>취소</button>
			</div>
		</div>
		<div id="view">
			<table style="width: 100%;">
				<thead align="center" style="background-color: gray">
					<td ><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
					<td>주문번호</td>
					<td>순서</td>
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
						<td><a href="#">${MpsOS.ordersno}</a></td>
						<td><a href="#">${MpsOS.sequence}</a></td>
						<td><a href="#">${MpsOS.orderdate}</a></td>
						<td><a href="#">${MpsOS.okeydate}</a></td>
						<td><a href="#">${MpsOS.customer_Name}</a></td>
						<td><a href="#">${MpsOS.item_Code}</a></td>
						<td><a href="#">${MpsOS.item_Name}</a></td>
						<td><a href="#">${MpsOS.standard}</a></td>
						<td><a href="#">${MpsOS.unit}</a></td>
						<td><a href="#">${MpsOS.order_quantity}</a></td>
						<td><a href="#">${MpsOS.apply_quantity}</a></td>
						<td><a href="#">${MpsOS.order_Balance}</a></td>
						<td><a href="#">${MpsOS.expected_Date}</a></td>
						<td><a href="#">${MpsOS.note}</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</form>
		</div>
	</div>
</body>
</html>