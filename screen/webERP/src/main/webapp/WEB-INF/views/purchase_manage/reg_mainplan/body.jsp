<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
String sequence = (String)request.getAttribute("sequence");
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

#contents1 div button {
	width: 80px;
	position: absolute;
	right: 20px;
	top: 10px;
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
		<tr>
			<td>사업장</td>
			<td style="width: 50px;"><input type="text" id="reqInput"
				style="width: 100%;" /></td>

			<td colspan="3"><input type="text" name="" disabled
				style="width: 100%;" /></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>
			<td colspan="5" style="width: 100px;">부서</td>
			<td style="width: 80px;"><input type="text" id="reqInput"
				style="width: 100%;" /></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>
			<td><input type="text" name="" disabled /></td>

		</tr>
		<tr>
			<td>계획기간</td>
			<td colspan="2" style="width: 50px;"><input type="date"
				id='searchStartDate' style="width: 100%;" /></td>
			<td>~</td>
			<td><input type="date" id='searchEndDate' style="width: 100%;" /></td>
			<td></td>
			<td colspan="5">사원</td>
			<td style="width: 80px;"><input type="text" id="reqInput"
				style="width: 100%;" /></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>
			<td><input type="text" name="" disabled /></td>
		</tr>
	</table>
	<div id="button">
		<input type="button" onclick="func_Popup();" value="주문적용">
		<input type="button" value="삭제" onClick="deleteData();">
		<input type="button" value="등록" onClick="newRow();">
		<input type="button" value="조회" onClick="searchPlan();">	
	</div>
	</container1>
<container2 id=contents2>
<div id="MpsInfo">
<form id="dataForm" mehtod="get" commandName="ListVO">
	<table id="MPSTable">
		<thead align="center" style="background-color: gray">
		 <td ><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
			<td>순서</td>
			<td>계획일</td>
			<td>품번</td>
			<td>품명</td>
			<td>규격</td>
			<td>단위</td>
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
  		 	<td style="width:13px;"><a href="${path}/member/detail?sequence=${mainplan.sequence}" 
		 	value="${mainplan.sequence}" style="width:100%"/>${mainplan.sequence}</a></td> 		
 				<td><input type="text" value="${mainplan.plandate}" /></td>				
				<td><input type="text" id="item_Code" value="${mainplan.item_Code}"  readonly/></td>
				<td><input type="text" id="item_Name" value="${mainplan.item_Name}"  readonly/></td>
				<td><input type="text" value="${mainplan.standard}" style="width:100%"/></td>
				<td><input type="text" value="${mainplan.unit}" style="width:100%"/></td>
				<td><input type="text" id="expected_Date" value="${mainplan.expected_date}"  readonly/></td>
				<td><input type="text" value="${mainplan.due_date}" /></td>
				<td><input type="text" value="${mainplan.plan_quantity}" /></td>
				<td><input type="text" id="customer_Name" value="${mainplan.customer_Name}" readonly/></td>
				<td><input type="text" value="${mainplan.note}" /></td>
			</tr>
		</c:forEach>	
		
		 <tr id ="insertTest" align="center">
    	<td><input type="checkbox" value = "checkPoint" name="content"/></td>
    	<td style="width:13px;"><input type="text" id="sequence" name="ListVO[${fn:length(mainplanList) }].sequence" value='${sequence}' readonly style="width:100%"/></td>
    	<td><input type="text" id="plandate" name="ListVO[${fn:length(mainplanList) }].plandate" value = '${param.plandate}'/></td>
    	<td><input type="text" id="item_Code" name="ListVO[${fn:length(mainplanList) }].item_Code" value='${param.item_Code}' "readonly/></td>
    	<td><input type="text" id="item_Name" name="ListVO[${fn:length(mainplanList) }].item_Name" value='${param.item_Name}' readonly/></td>
    	<td><input type="text" id="standard" name="ListVO[${fn:length(mainplanList) }].standard" value='${param.standard}' style="width:100%"/></td>
    	<td><input type="text" id="unit" name="ListVO[${fn:length(mainplanList) }].unit" value='${param.unit}' style="width:100%"/></td>
    	<td><input type="text" id="expected_Date" name="ListVO[${fn:length(mainplanList) }].expected_Date" value='${param.expected_Date}'readonly/></td>
    	<td><input type="text" id="due_date" name="ListVO[${fn:length(mainplanList) }].due_date" value='${param.due_date}'/></td>
    	<td><input type="text" id="plan_quantity" name="ListVO[${fn:length(mainplanList) }].plan_quantity" value='${param.plan_quantity}'/></td>
    	<td><input type="text" id="customer_Name" name="ListVO[${fn:length(mainplanList) }].customer_Name" value='${param.customer_Name}'readonly/></td>
    	<td><input type="text" id="note" name="ListVO[${fn:length(mainplanList) }].note"value='${param.note}'/></td>
    </tr>
	</tbody>
	</table>
	</form>
	</div>
</container2>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
var windowObj;

function func_Popup(){
	window.name = "member/mainplan.do";
	var settings ='width=1400, height=500, resizable = no, scrollbars = no';

	windowObj = window.open("applyorder.do","applyorder",settings);
	
	var txt_code = document.getelementById("item_Code");
	var txt_Name = document.getelementById("item_Name");
	var txt_CusName = document.getelementById("customer_Name");
	var txt_expDate = document.getelementById("expected_date");
	
	document.getElementById('item_Code').value= windowObj.document.getElementById("item_Code").value;  
	document.getElementById('item_Name').value= windowObj.document.getElementById("item_Name").value;  
	document.getElementById('customer_Name').value= windowObj.document.getElementById("customer_Name").value; 
	document.getElementById('expected_date').value= windowObj.document.getElementById("expected_date").value; 
}

function deleteData() {
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

function newRow(){
    var row = MPSTable.insertRow(); 
    const URLSearch = new URLSearchParams(location.search);
	  const newParam = URLSearch.toString();
	 var link = location.pathname +'?'+newParam;
		var linkPath = document.createElement("input");
	     linkPath.setAttribute("type","hidden");
	     linkPath.setAttribute("name","path");
	     linkPath.setAttribute("value", link);
	     document.getElementById('dataForm').appendChild(linkPath);
      document.getElementById('dataForm').action = "${contextPath}/member/mainplan.do";
		document.getElementById('dataForm').submit();  
	
}
view_button.onclick = function(){
	  if(startDate>endDate){
		  alert("지시기간 종료일은 시작일보다 작을수 없습니다.");
	  } else{
		  
	  const URLSearch = new URLSearchParams(location.search);
	  URLSearch.set('startDate', startDate);
	  URLSearch.set('endDate', endDate);
	  const newParam = URLSearch.toString();

	  window.open(location.pathname + '?' + newParam, '_self');
	  }
}
document.getElementById('searchStartDate').value = new Date().toISOString().substring(0,10);
document.getElementById('searchEndDate').value = new Date().toISOString().substring(0,10);

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
function searchPlan(){
  	  openWindowBroadPop('http://localhost:8090/webERP/member/mainplan.do','mainplan');
    }
</script>
</body>
</html>