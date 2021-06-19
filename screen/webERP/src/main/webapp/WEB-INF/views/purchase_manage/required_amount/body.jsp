<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>
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
}

.con1_search {
	padding: 0;
	text-align: center;
	position: absolute;
	top: 25%;
	left: 18%;
}

#MRPTable {
	width: 100%;
	text-align: center;
	border: 1px solid black;
}

#total {
	position: absolute;
	bottom: 0;
	left: 0;
	width: 100%;
	text-align: center;
}

#total input {
	width: 7.7%;
	text-align: justify;
	border-style: none;
	background-color: rgb(223, 223, 223);
}

#total td {
	margin: 0;
	padding: 0;
}

#contents1 div {
	position: absolute;
	right: 20px;
	top: 10px;
}
#MrpInfo{
    overflow: scroll;
    height: 100%;
    width: 100%;
}
#button {
	margin-top: 3%;
	margin-right: 3%;
	text-align: right;
}
</style>
</head>
<body>
	<container1 id=contents1>
	<table class="con1_search">
		<tr>
			<td>사업장</td>
			<td style="width: 70px;"><input type="text" style="width: 100%;" /></td>
			<td><i class="fas fa-search" style="color: blue;"></td>
			<td><input type="text" disabled /></td>
			<td>품번</td>
			<td style="width: 70px;"><input type="text" style="width: 100%;" /></td>
			<td><i class="fas fa-search" style="color: blue;"></td>
			<td><input type="text" disabled /></td>
		</tr>
		<tr>
			<td>전개구분</td>
			<td colspan="3"><select name="division" style="width: 80%;">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4" selected>4</option>
			</select>
			<td>계정구분</td>
			<td colspan="3"><select name="division" style="width: 80%;">
					<option value="">원재료</option>
					<option value="">반제품</option>
					<option value="">제품</option>
			</select></td>
			</td>
		</tr>
	</table>
	<div id="button">
		<!-- <button id="btn">소요량전개</button> -->
		<input type="submit" id="btn" value="소요량전개" />
	</div>
	</container1>
	<container2 id=contents2>
	<div id="MrpInfo">
<form id="MRP" mehtod="get" commandName="ListVO">
	<table id="MRPTable">
		<thead align="center" style="background-color: gray">
			<td><input type="checkbox" name="content"
				onclick="selectAll(this)" /></td>
			<td>순서</td>
			<td>품번</td>
			<td>품명</td>
			<td>규격</td>
			<td>소요일자</td>
			<td>예정발주일</td>
			<td>예정수량</td>
			<td>단위</td>
		</thead>
		<tbody>
		<c:forEach var="mrp" items="${mrpList}" varStatus="status">
			<tr align="center">
				<td ><input type="checkbox" name="content" value="${mrp.sequence}"/></td>
		<td style="width:13px;"><input type="text" name="ListVO[${status.index}].item_Code" value='${mrp.sequence}' readonly style="width:100%"/></td>
			<td><input type="text" name="ListVO[${status.index}].item_Code" value='${mrp.item_Code}' readonly/></td>
				<td><input type="text" name="ListVO[${status.index}].item_Name" value='${mrp.item_Name}' readonly/></td>
				<td><input type="text" name="ListVO[${status.index}].standard" value='${mrp.standard}' readonly style="width:100%"/></td>
				<td><input type="date" name="ListVO[${status.index}].need_date" value='${mrp.need_date}' readonly/></td>
				<td><input type="date" name="ListVO[${status.index}].expected_order" value='${mrp.expected_order}' readonly/></td>
				<td><input type="text" name="ListVO[${status.index}].expected_quantity" value='${mrp.expected_quantity}' readonly/></td>
				<td><input type="text" name="ListVO[${status.index}].inventory_unit" value='${mrp.inventory_unit}' readonly style="width:100%"/></td>
			</tr>	
		</c:forEach>
		<tr id ="insertTest" align="center">
		<td></td>    	
    	<td><input type="text" id="sequence" name="ListVO[${fn:length(mrp) }].sequence" value='${sequence}' style="width:100%"/></td>
    	<td><input type="text" id="item_Code" name="ListVO[${fn:length(mrp) }].item_Code" value='${item_Code}' readonly/></td>
    	<td><input type="text" id="item_Name" name="ListVO[${fn:length(mrp) }].item_Name" value='${item_Name}' readonly/></td>
    	<td><input type="text" id="standard" name="ListVO[${fn:length(mrp) }].standard" value='${standard}' style="width:100%"/></td>
    	<td><input type="date" id="need_date" name="ListVO[${fn:length(mrp) }].need_date" value='${need_date}' style="width:100%" /></td>
    	<td><input type="date" id="expected_order" name="ListVO[${fn:length(mrp) }].expected_order" value='${expected_order}'readonly/></td>
    	<td><input type="text" id="expected_quantity" name="ListVO[${fn:length(mrp) }].expected_quantity" value='${expected_quantity}'/></td>
    	<td><input type="text" id="inventory_unit" name="ListVO[${fn:length(mrp) }].inventory_unit" value='${inventory_unit}' /></td>
    	</tr>
		</tbody>
	</table>
	</div>
	</container2>
<script type="text/javascript">
var Upd_Btn = document.getElementById('btn');

Upd_Btn.onclick = function() {
	const URLSearch = new URLSearchParams(location.search);
	const newParam = URLSearch.toString();
	var link = location.pathname + '?' + newParam;
document.getElementById("sequence").disabled = true;
document.getElementById("item_Code").disabled = true;		
document.getElementById("item_Name").disabled = true;
document.getElementById("standard").disabled = true;
document.getElementById("need_date").disabled = true;
document.getElementById("expected_order").disabled = true;
document.getElementById("expected_quantity").disabled = true;
document.getElementById("inventory_unit").disabled = true;
var Input = document.createElement("input");
Input.setAttribute("type", "hidden");
Input.setAttribute("name", "path");
Input.setAttribute("value", link);
document.getElementById('MRP').appendChild(Input);
document.getElementById('MRP').action = "${contextPath}/member/updateMRP.do";
document.getElementById('MRP').submit();
console.log('error');
}
</script>
</form>
</body>
</html>