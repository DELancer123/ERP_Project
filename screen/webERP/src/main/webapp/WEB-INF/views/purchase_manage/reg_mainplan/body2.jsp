<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
	String inputSeq = (String)request.getAttribute("inputSeq");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
#button {
	margin-top: 3%;
	margin-right: 3%;
	text-align: right;
}

#MPSTable {
	width: 100%;
	text-align: center;
	border: 1px solid black;  
}

#reqInput {
	background-color: rgb(255, 255, 149);
	text-align: center;
}
#MpsInfo{
    overflow: scroll;
    height: 100%;
    width: 100%;
}
</style>
</head>
<body>
<container1 id=contents1>
	<table class="con1_search">

<!-- 			<td>계획기간</td>
			<td colspan="2" style="width: 50px;"><input type="date"
				id='searchStartDate' style="width: 100%;" /></td>
			<td>~</td>
			<td><input type="date" id='searchEndDate' style="width: 100%;" /></td>
			<td></td> -->
<!-- 			 			 <td colspan="5">사원</td>
			<td style="width: 80px;"><input type="text" id="reqInput"
				style="width: 100%;" /></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>
			<td><input type="text" name="" disabled /></td>
					 -->
		</tr> 
	</table>
<!-- 	<div id="button">
		<input type="button" onclick="search2();" value="주문조회">
	</div> -->
	</container1>
<container2 id=contents2>
<div id="MpsInfo">
<form id="searchForm" mehtod="get" commandName="ListVO">
	<table id="MPSTable">
		<thead align="center" style="background-color: gray">
		 <td ><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
			<td>계획번호</td>
			<td>계획일</td>
			<td>품번</td>
			<td>품명</td>
			<td>규격</td>
			<td>단위</td>
			<td>순서</td>
			<td>출하예정일</td>
			<td>납기일</td>
			<td>계획수량</td>
			<td>고객</td>
			<td>비고</td>
		</thead>
		<tbody>
		<c:forEach var="mainplan" items="${mainplanList}"  varStatus="status">
			<tr align="center">
			<td><input type="checkbox" name="content" value="${mainplan.sequence}"/></td>
 				<td><input type="text" name="ListVO[${status.index}].planNO" value = '${mainplan.planNO}' readonly /></td>				
 				<td><input type="date" name="ListVO[${status.index}].plandate" value = '${mainplan.plandate}' /></td>				
 				<td><input type="text" name="ListVO[${status.index}].item_Code" value = '${mainplan.item_Code}'ondblclick="search2()" readonly/></td>				
<%--  				<td><input type="text" name="ListVO[${status.index}].item_Code" value = '${mainplan.CorVO.item_Code}' readonly/></td>	 --%>			
 				<td><input type="text" name="ListVO[${status.index}].item_Name" value = '${mainplan.item_Name}' readonly/></td>				
<%--  				<td><input type="text" name="ListVO[${status.index}].item_Name" value = '${mainplan.CorVO.item_Name}' readonly/></td>				 --%>
 				<td><input type="text" name="ListVO[${status.index}].standard" value = '${mainplan.standard}' style="width:100%" /></td>				
<%--  				<td><input type="text" name="ListVO[${status.index}].standard" value = '${mainplan.CorVO.stand}' style="width:100%" /></td>				 --%>
 				<td><input type="text" name="ListVO[${status.index}].inventory_unit" value = '${mainplan.inventory_unit}' style="width:100%" readonly/></td>				
<%--  				<td><input type="text" name="ListVO[${status.index}].inventory_unit" value = '${mainplan.CorVO.unit}' style="width:100%" readonly/></td>				 --%>
  		 	<td style="width:13px;"><input type="text" name="ListVO[${status.index}].sequence" value = '${mainplan.sequence}'readonly style="width:100%"/></td> 		 				
 				<td><input type="date" name="ListVO[${status.index}].expected_date" value = '${mainplan.expected_date}' readonly/></td>				
<%--  				<td><input type="date" name="ListVO[${status.index}].expected_date" value = '${mainplan.CorVO.expdate}' readonly/></td>				 --%>
 				<td><input type="date" name="ListVO[${status.index}].due_date" value = '${mainplan.due_date}' /></td>				
<%--  				<td><input type="date" name="ListVO[${status.index}].due_date" value = '${mainplan.CorVO.duedate}' /></td>				 --%>
 				<td><input type="text" name="ListVO[${status.index}].plan_quantity" value = '${mainplan.plan_quantity}' /></td>				
 				<td><input type="text" name="ListVO[${status.index}].buyer" value = '${mainplan.buyer}' readonly/></td>				
 				<td><input type="text" name="ListVO[${status.index}].note" value = '${mainplan.note}' /></td>				
<%--  				<td><input type="text" name="ListVO[${status.index}].note" value = '${mainplan.CorVO.note}' /></td>				 --%>
			</tr>
		</c:forEach>		
 		<tr id="insertTest" align="center">
		<td></td>    	
    	<td><input type="text" id="planNO" name="ListVO[${fn:length(mainplanList) }].planNO" value='${planNO}' readonly/></td>
    	<td><input type="date" id="plandate" name="ListVO[${fn:length(mainplanList) }].plandate" value = '${plandate}'/></td>
    	<td><input type="text" id="item_Code" name="ListVO[${fn:length(mainplanList) }].item_Code" value='${param.item_Code}' ondblclick="search2()" readonly/></td>
    	<td><input type="text" id="item_Name" name="ListVO[${fn:length(mainplanList) }].item_Name" value='${item_Name}' readonly/></td>
    	<td><input type="text" id="standard" name="ListVO[${fn:length(mainplanList) }].standard" value='${standard}' style="width:100%"/></td>
    	<td><input type="text" id="inventory_unit" name="ListVO[${fn:length(mainplanList) }].inventory_unit" value='${inventory_unit}' style="width:100%" /></td>
    	<td><input type="text" id="sequence" name="ListVO[${fn:length(mainplanList) }].sequence" value='${inputSeq}' readonly style="width:100%"/></td>
    	<td><input type="date" id="expected_date" name="ListVO[${fn:length(mainplanList) }].expected_date" value='${expected_date}'readonly/></td>
    	<td><input type="date" id="due_date" name="ListVO[${fn:length(mainplanList) }].due_date" value='${due_date}'/></td>
    	<td><input type="text" id="plan_quantity" name="ListVO[${fn:length(mainplanList) }].plan_quantity" value='${plan_quantity}' /></td>
    	<td><input type="text" id="buyer" name="ListVO[${fn:length(mainplanList) }].buyer" value='${buyer}'readonly/></td>
    	<td><input type="text" id="note" name="ListVO[${fn:length(mainplanList) }].note"value='${note}'/></td>
    </tr>
	</tbody>
	</table>
	</div>
</container2>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
var itemNumber = document.getElementById("itemCode");
var save_button = document.getElementById("save");
var update_button = document.getElementById('update');

function search2(){
	
  	openWindowPop('http://localhost:8090/webERP/member/applyorder.do','applyorder');
	 
  }
  function setChildValue(name){
	  
	  const URLSearch = new URLSearchParams(location.search);
	  URLSearch.set('submit', '2');
	  const newParam = URLSearch.toString();
    if(URLSearch.get('itemCode') == null){
	window.location.href = location.pathname +'?'+newParam + '&itemCode=' + name;
    }
    else{
    	URLSearch.set('itemCode', name);
    	const newParam = URLSearch.toString();
    	window.location.href = location.pathname +'?'+newParam;
    }
    
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
		  
			  window.location.href = "${contextPath}/member/delMps.do?sequence="+ary;
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
		document.getElementById('MainPlan').appendChild(Input);
		document.getElementById('MainPlan').action = "${contextPath}/member/addMPS.do";
		document.getElementById('MainPlan').submit();

	}


	function updateRow() {
			const URLSearch = new URLSearchParams(location.search);
			const newParam = URLSearch.toString();
			var link = location.pathname + '?' + newParam;
		document.getElementById("sequence").disabled = true;
		document.getElementById("planNO").disabled = true;		
		document.getElementById("plandate").disabled = true;
		document.getElementById("item_Code").disabled = true;
		document.getElementById("item_Name").disabled = true;
		document.getElementById("standard").disabled = true;
		document.getElementById("inventory_unit").disabled = true;
		document.getElementById("expected_date").disabled = true;
		document.getElementById("due_date").disabled = true;
		document.getElementById("plan_quantity").disabled = true;
		document.getElementById("buyer").disabled = true;
		document.getElementById("note").disabled = true;
		var Input = document.createElement("input");
		Input.setAttribute("type", "hidden");
		Input.setAttribute("name", "path");
		Input.setAttribute("value", link);
		document.getElementById('MainPlan').appendChild(Input);
		document.getElementById('MainPlan').action = "${contextPath}/member/updateMPS.do";
		document.getElementById('MainPlan').submit();
	}
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
	  ndDate = date;
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
</script>
</form>
</body>
</html>