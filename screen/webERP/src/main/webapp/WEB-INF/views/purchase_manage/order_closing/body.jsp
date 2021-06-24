<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
String sequence = (String) request.getAttribute("sequence");
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
	left: 15%;
}

#OrderClosingTable {
	width: 100%;
	text-align: center;
	border: 1px solid black;
}

#contents2 div {
	position: absolute;
	right: 0;
	bottom: 0;
}

#button {
	margin-top: 3%;
	margin-right: 3%;
	text-align: right;
}

#view {
	overflow: scroll;
	height: 100%;
	width: 100%;
}

</style>
</head>
<body>
	<container1 id=contents1>
	<table class="con1_search">
		<tr>
			<td>사업장</td>
			<td style="width: 50px;"><input type="text" id="reqInput"
				style="width: 100%;" /></td>

			<td colspan="3"><input type="text" name="" disabled
				style="width: 100%;" /></td>
			<td><i class="fas fa-search" style="color: blue;"></td>
			<td colspan="5" style="width: 100px;">거래구분</td>
			<td style="width: 80px;"><input type="text" style="width: 100%;" /></td>
			<td><input type="text" name="" disabled /></td>
			<td><i class="fas fa-search" style="color: blue;"></td>

		</tr>
		<tr>
			<td>발주기간</td>
			<td colspan="2" style="width: 50px;"><input type="date"
				id='searchStartDate' style="width: 100%;" /></td>
			<td>~</td>
			<td><input type="date" id='searchEndDate' style="width: 100%;" /></td>
			<td></td>
			<td colspan="5">사원</td>
			<td style="width: 80px;"><input type="text" style="width: 100%;" /></td>
			<td><input type="text" name="" disabled /></td>
			<td><i class="fas fa-search" style="color: blue;"></td>
		</tr>
	</table>
	<div id="button">
		<input type="button" onClick="func_DeadLine()" value="마감처리" />
	</div>
	</container1>
	<container2 id=contents2>
	<div id=view>
		<form id="OrderClosing" mehtod="get" commandName="ListVO">
			<table id="OrderClosingTable">
				<thead align="center" style="background-color: gray">
					<td><input type="checkbox" name="content" /></td>
					<td>발주번호</td>
					<td>발주일자</td>
					<td>코드</td>
					<td>거래처명</td>
					<td>No</td>
					<td>품번</td>
					<td>품명</td>
					<td>규격</td>
					<td>단위</td>
					<td>발주수량</td>
					<td>단가</td>
					<td>마감</td>
					<td>비고</td>
<!-- 	 				<td>공급가</td>
					<td>부가세</td>
					<td>합계액</td> -->
				</thead>
				<tbody>
					<c:forEach var="OrderClosing" items="${ClosingList}"
						varStatus="status">
						<tr align="center">
				<td><input type="checkbox" name="content" value="${OrderClosing.sequence}" /></td>
				<td><input type="text" name="ListVO[${status.index}].order_no" value='${OrderClosing.order_no}' readonly /></td>
				<td><input type="date" name="ListVO[${status.index}].order_date" value='${OrderClosing.order_date}' /></td>
				<td><input type="text" name="ListVO[${status.index}].code" value='${OrderClosing.code}' style="width: 100%" readonly /></td>
				<td><input type="text" name="ListVO[${status.index}].buyer" value='${OrderClosing.buyer}' readonly /></td>
			<td style="width: 13px;"><input type="text" name="ListVO[${status.index}].sequence" value='${OrderClosing.sequence}' readonly style="width: 100%" /></td>
				<td><input type="text" name="ListVO[${status.index}].item_Code" value='${OrderClosing.item_Code}' readonly /></td>
				<td><input type="text" name="ListVO[${status.index}].item_Name" value='${OrderClosing.item_Name}' readonly /></td>
				<td><input type="text" name="ListVO[${status.index}].standard" value='${OrderClosing.standard}' style="width: 100%" readonly /></td>
				<td><input type="text" name="ListVO[${status.index}].inventory_unit" value='${OrderClosing.inventory_unit}' style="width: 100%" readonly /></td>
				<td><input type="text" name="ListVO[${status.index}].order_quantity" value='${OrderClosing.order_quantity}' /></td>
				<td><input type="text" name="ListVO[${status.index}].price" value='${OrderClosing.price}' /></td>
				<td><input type="text" name="ListVO[${status.index}].deadline" value='${OrderClosing.deadline}' /></td>
				<td><input type="text" name="ListVO[${status.index}].note" value='${OrderClosing.note}' /></td>
				<%-- <td><input type="text" value = '${OrderClosing.order_quantity*OrderClosing.price}' readonly/></td>
				<td><input type="text" value = '${OrderClosing.order_quantity*OrderClosing.price*0.1}' readonly/></td>
				<td><input type="text" value = '${OrderClosing.order_quantity*OrderClosing.price+(OrderClosing.order_quantity*OrderClosing.price*0.1)}' readonly/></td> --%>
						</tr>
					</c:forEach>
				<tr align="center">
					<td></td>
				<td><input type="text" id="order_no" name="ListVO[${fn:length(ClosingList) }].order_no" value='${order_no}' readonly/></td>
				<td><input type="date" id="order_date" name="ListVO[${fn:length(ClosingList) }].order_date" value='${order_date}' /></td>
				<td><input type="text" id="code" name="ListVO[${fn:length(ClosingList) }].code" value='${code}' style="width: 100%" /></td>
				<td><input type="text" id="buyer" name="ListVO[${fn:length(ClosingList) }].buyer" value='${buyer}'  /></td>
				<td><input type="text" id="sequence" name="ListVO[${fn:length(ClosingList) }].sequence" value='${sequence}' style="width: 100%" /></td>
				<td><input type="text" id="item_Code" name="ListVO[${fn:length(ClosingList) }].item_Code" value='${item_Code}' /></td>
				<td><input type="text" id="item_Name" name="ListVO[${fn:length(ClosingList) }].item_Name" value='${item_Name}' /></td>
				<td><input type="text" id="standard" name="ListVO[${fn:length(ClosingList) }].standard" value='${standard}' style="width: 100%" /></td>
				<td><input type="text" id="inventory_unit" name="ListVO[${fn:length(ClosingList) }].inventory_unit" value='${inventory_unit}' style="width: 100%" /></td>
				<td><input type="text" id="order_quantity" name="ListVO[${fn:length(ClosingList) }].order_quantity" value='${order_quantity}' /></td>
				<td><input type="text" id="price" name="ListVO[${fn:length(ClosingList) }].price" value='${price}' /></td>
				<td><input type="text" id="deadline" name="ListVO[${fn:length(ClosingList) }].deadline" value='${deadline}' /></td>
				<td><input type="text" id="note" name="ListVO[${fn:length(ClosingList) }].note" value='${note}' /></td>
<%-- 				<td><input type="text" id="price" value = '${OrderClosing.order_quantity*OrderClosing.price}' readonly/></td>
				<td><input type="text" id="price" value = '${OrderClosing.order_quantity*OrderClosing.price*0.1}' readonly/></td>
				<td><input type="text" id="price" value = '${OrderClosing.order_quantity*OrderClosing.price+(OrderClosing.order_quantity*OrderClosing.price*0.1)}' readonly/></td> --%>
				</tr>
				</tbody>
			</table>
	</div>

 	<div>
		담당자: <input type="text" disabled />

	</div>
	</container2>
	</form>
</body>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
/* input date의 현재 날짜 기본값 설정*/
document.getElementById('searchStartDate').value = new Date().toISOString().substring(0,10);;
document.getElementById('searchEndDate').value = new Date().toISOString().substring(0,10);;

/* 검색부 date onChange 함수 설정 */
		var startDate = new Date().toISOString().substring(0,10);;
   	var endDate = new Date().toISOString().substring(0,10);;
   	
   	$('#searchStartDate').change(function (){
           var date = $('#searchStartDate').val();
           startDate = date;
       });
   	$('#searchEndDate').change(function (){
           var date = $('#searchEndDate').val();
           endDate = date;
       });
   	
   	 /* 조회버튼 클릭시 기능 구현 */
       view_button.onclick = function(){
 		  if(startDate>endDate){
 			  alert(" 종료일은 시작일보다 작을수 없습니다.");
 		  } else{
 			  
     	  const URLSearch = new URLSearchParams(location.search);
 		  URLSearch.set('startDate', startDate);
 		  URLSearch.set('endDate', endDate);
 		  const newParam = URLSearch.toString();

 		  window.open(location.pathname + '?' + newParam, '_self');
 		  }
   	}

function InsertRow(){
	const URLSearch = new URLSearchParams(location.search);
	const newParam = URLSearch.toString();
	var link = location.pathname + '?' + newParam;
	var Input = document.createElement("input");
	Input.setAttribute("type", "hidden");
	Input.setAttribute("name", "path");
	Input.setAttribute("value", link);
	document.getElementById('OrderClosing').appendChild(Input);
	document.getElementById('OrderClosing').action = "${contextPath}/member/addClosing.do";
	document.getElementById('OrderClosing').submit();

}

function updateRow() {
	const URLSearch = new URLSearchParams(location.search);
	const newParam = URLSearch.toString();
	var link = location.pathname + '?' + newParam;
document.getElementById("order_no").disabled = true;		
document.getElementById("order_date").disabled = true;
document.getElementById("code").disabled = true;
document.getElementById("buyer").disabled = true;
document.getElementById("sequence").disabled = true;
document.getElementById("item_code").disabled = true;
document.getElementById("item_name").disabled = true;
document.getElementById("standard").disabled = true;
document.getElementById("inventory_unit").disabled = true;
document.getElementById("order_quantity").disabled = true;
document.getElementById("price").disabled = true;
document.getElementById("deadline").disabled = true;
document.getElementById("note").disabled = true;
var Input = document.createElement("input");
Input.setAttribute("type", "hidden");
Input.setAttribute("name", "path");
Input.setAttribute("value", link);
document.getElementById('OrderClosing').appendChild(Input);
document.getElementById('OrderClosing').action = "${contextPath}/member/updateClosing.do";
document.getElementById('OrderClosing').submit();
}
function deleteRow() {
	  var item = document.getElementsByName("content").length;
	  var no = "";
	  var ary = [];
	  for(var i=0; i<item;i++){
		  if(document.getElementsByName("content")[i].checked==true){
			  sequence = document.getElementsByName("content")[i].value;
			  ary.push(sequence);
		  }
		  
			  window.location.href = "${contextPath}/member/delClosing.do?sequence="+ary;
	  }
}
function func_DeadLine(){
	  var item = document.getElementsByName("content").length;
	  var no = "";
	  var ary = [];
	  for(var i=0; i<item;i++){
		  if(document.getElementsByName("content")[i].checked==true){
			  sequence = document.getElementsByName("content")[i].value;
			  ary.push(sequence);
		  }
		  
			  window.location.href = "${contextPath}/member/updateOrderClosing.do?sequence="+ary;
	}
}
</script>
</html>