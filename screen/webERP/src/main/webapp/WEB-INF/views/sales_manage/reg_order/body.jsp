<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
String inputNo = (String) request.getAttribute("inputNo");
%>
<%
String parent = request.getParameter("itemNumber");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#contents1 {
	position: absolute;
	padding: 10px;
	right: 0;
	top: 15%;
	width: 85%;
	height: 10%;
	border: 1px solid black;
	z-index: 1;
}

#contents2 {
	position: absolute;
	right: 0;
	top: 25%;
	width: 85%;
	height: 35%;
	border: 1px solid black;
	z-index: 1;
}

#contents3 {
	position: absolute;
	right: 0;
	top: 60%;
	width: 85%;
	height: 35%;
	border: 1px solid black;
	z-index: 1;
}

#view {
	width: 100%;
	text-align: center;
	border: 1px solid black;
}

#view td:not(#no) {
	width: 8%;
}

#view td input {
	width: 100%;
}
</style>
</head>
<body>
	<container1 id=contents1>
	<form id="searchForm" method="get"
		action="${pageContext.request.contextPath }/member/regorder.do">
		<table class="con1_search">
			<tr>
				<td>사업장</td>
				<td><input type="text" id="reqInput" name="bus_code"
					style="width: 100%;" value="${bus_code}" /></td>
				<td><a href="javascript:search1()"><i class="fas fa-search"
						style="color: blue;"></i></a></td>
				<td><input type="text" disabled value="${bus_name}"}></td>
			</tr>

		</table>
	</form>
	</container1>
	<container2 id="contents2">
	<table id="view">
		<thead>
			<td><input type="checkbox" id="check" name="content"
				onclick="selectAll(this)" /></td>
			<td>주문번호</td>
			<td>주문일자</td>
			<td>납품처</td>
			<td>부가세구분</td>
			<td>비고</td>
		</thead>
		<tbody id="table1">
			<c:forEach var="item" items="${customerList}" varStatus="sts">
				<tr class="moveNum2">
					<td><input type="checkbox" value="${item.ordersNum }"
						name="content" /></td>
					<td><input type="text" class="moveNum"
						name="StoVO[${sts.index}].moveNum" value="${item.ordersNum }" /></td>
					<td><input type="date" name="StoVO[${sts.index}].moveDate"
						value="${item.ordersdate }" /></td>
					<td><input type="text"
						name="StoVO[${sts.index}].outputWarehouse"
						value="${item.customerCode }" /></td>
					<td><input type="text" name="StoVO[${sts.index}].outputPlace"
						value='${item.tax }' /></td>
					<td><input type="text" name="StoVO[${sts.index}].inputWarehouse"
						value='${item.note }' /></td>
				</tr>
			</c:forEach> 
			<tr id="insertWareStock">
					<td><input type="checkbox" value="check1" id="check"
						name="content" /></td>
					<td><input type="text" id="moveNum"
						name="StoVO[${fn:length(stockList)}].moveNum" value="" /></td>
					<td><input type="date" id="moveDate"
						name="StoVO[${fn:length(stockList)}].moveDate" value="" /></td>
					<td><input type="text" id="outPutWare"
						name="StoVO[${fn:length(stockList)}].outputWarehouse" value="" /></td>
					<td><input type="text" id="outPutPlace"
						name="StoVO[${fn:length(stockList)}].outputPlace" value="" /></td>
					<td><input type="text" id="inPutWare"
						name="StoVO[${fn:length(stockList)}].inputWarehouse" value="" /></td>
				</tr>
		</tbody>
	</table>
	</container2>
	<container3 id="contents3">
	<table id="view">
		<thead>
			<td style="width: 5%;"><input type="checkbox" name="content1"
				onclick="selectAll1(this)"></td>
			<td>품번</td>
			<td>품명</td>
			<td>규격</td>
			<td>단위</td>
			<td>납기일</td>
			<td>주문수량</td>
			<td>단가</td>
			<td>출하예정일</td>
			<td>검사</td>
		</thead>
		<tbody>
			<td style="width: 5%;"><input type="checkbox" value="check1"
				id="check" name="content1" /></td>
			<td><input type="text" name="" id=""></td>
			<td><input type="text" name="" id=""></td>
			<td><input type="text" name="" id=""></td>
			<td><input type="text" name="" id=""></td>
			<td><input type="date" name="" id=""></td>
			<td><input type="text" name="" id=""></td>
			<td><input type="text" name="" id=""></td>
			<td><input type="text" name="" id=""></td>
			<td><input type="text" name="" id=""></td>
		</tbody>
	</table>
	</container3>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script>
	function search1(){
      	openWindowPop('http://localhost:8090/webERP/member/searchcus.do','searchcus');
}
	function openWindowPop(url, name){
        var options = 'top=0, left=0, width=320, height=420, status=no, menubar=no, toolbar=no, resizable=no';
        window.open(url, name, options);
    }
	function setChildValue(code, name) {
    	$('input[name=bus_code]').val(code);
    	$('input[name=bus_name]').val(name);
    }
	view_button.onclick = function(){
    	
    	var searchForm = $('#searchForm');
    	
    	searchForm.submit();
	}
	 
	
	</script>
</html>