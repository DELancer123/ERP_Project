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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script type="text/javascript">
function Check(){
	var select = eval("document.select");
	
	var cntCheck =0;
	for(i=0; i<select.content.length; i++){
		if(select.content[i].checked == true){
			cntCheck++;			
		}
	}
}
function setcontent(){
	var select = eval("document.select");
	var checked = document.getElementsByName("content");
	var chkList = "";
	
	for(var i=0; i<select.content.length; i++){
		if(checked[i].checked == true){
			chkList += checked[i].value+" ";
		}
	}
	opener.document.reserve.item_Code.value = chkList;
	window.close();
}
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
	width: 1400px;
	height: 800px;
	/* overflow: scroll; */
}
</style>
</head>
<body>
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
				<input type="button" onclick="selectcontent(this.form);" value="적용"/>
				<button>취소</button>
			</div>
		</div>
		<div id="view">
			<form id="select">
			<table style="width: 100%;">
				<thead align="center" style="background-color: gray">
					<td></td>
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
						<td>${MpsOS.ordersno}</td>
						<td>${MpsOS.sequence}</td>
						<td>${MpsOS.orderdate}</td>
						<td>${MpsOS.okeydate}</a></td>
						<td>${MpsOS.customer_Name}</td>
						<td>${MpsOS.item_Code}</td>
						<td>${MpsOS.item_Name}</td>
						<td>${MpsOS.standard}</a></td>
						<td>${MpsOS.unit}</a></td>
						<td>${MpsOS.order_quantity}</td>
						<td>${MpsOS.apply_quantity}</td>
						<td>${MpsOS.order_Balance}</td>
						<td>${MpsOS.expected_Date}</td>
						<td>${MpsOS.note}</td>
					</tr>
				</c:forEach>
			</table>
			</form>
		</div>
	</div>
</body>
</html>