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
 <c:forEach var="mainplan" items="${MPSInsert}" >     
 	<c:set var="planNO" value="${mainplan.planNO }"/>
 	<c:set var="plandate" value="${mainplan.plandate }"/>
 	<c:set var="item_Code" value="${mainplan.item_Code }"/>
 	<c:set var="item_Name" value="${mainplan.item_Name }"/>
 	<c:set var="standard" value="${mainplan.standard }"/>
 	<c:set var="inventory_unit" value="${mainplan.inventory_unit }"/>
 	<c:set var="sequence" value="${mainplan.sequence }"/>
 	<c:set var="expected_date" value="${mainplan.expected_date }"/>
 	<c:set var="due_date" value="${mainplan.due_date }"/>
 	<c:set var="plan_quantity" value="${mainplan.plan_quantity }"/>
 	<c:set var="buyer" value="${mainplan.buyer }"/>
 	<c:set var="note" value="${mainplan.note }"/>
 </c:forEach>
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
<container2 id=contents2>
<div id="MpsInfo">
<form id="MainPlan" mehtod="get" commandName="ListVO">
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
		<c:forEach var="mainplan" items="${MPSView}"  varStatus="status">
			<tr align="center">
			<td><input type="checkbox" name="content" value="${mainplan.sequence}"/></td>
 				<td><input type="text" name="ListVO[${status.index}].planNO" value = '${mainplan.planNO}' readonly /></td>				
 				<td><input type="date" name="ListVO[${status.index}].plandate" value = '${mainplan.plandate}' /></td>				
 				<td><input type="text" name="ListVO[${status.index}].item_Code" value = '${mainplan.item_Code}'readonly/></td>					
 				<td><input type="text" name="ListVO[${status.index}].item_Name" value = '${mainplan.item_Name}' readonly/></td>				
 				<td><input type="text" name="ListVO[${status.index}].standard" value = '${mainplan.standard}' style="width:100%" /></td>				
 				<td><input type="text" name="ListVO[${status.index}].inventory_unit" value = '${mainplan.inventory_unit}' style="width:100%" readonly/></td>				
  		 	<td style="width:13px;"><input type="text"  value = '${mainplan.sequence}'readonly style="width:100%"/></td> 		 				
 				<td><input type="date" name="ListVO[${status.index}].expected_date" value = '${mainplan.expected_date}' /></td>				
 				<td><input type="date" name="ListVO[${status.index}].due_date" value = '${mainplan.due_date}' /></td>				
 				<td><input type="text" name="ListVO[${status.index}].plan_quantity" value = '${mainplan.plan_quantity}' /></td>				
 				<td><input type="text" name="ListVO[${status.index}].buyer" value = '${mainplan.buyer}' /></td>				
 				<td><input type="text" name="ListVO[${status.index}].note" value = '${mainplan.note}' /></td>				
			</tr>
		</c:forEach>		
  	<tr id="insertTest" align="center">
		<td></td>    	
    	<td><input type="text" id="planNO"  value='${planNO}' readonly/></td>
    	<td><input type="date" id="plandate" name="ListVO[${fn:length(MPSView) }].plandate" value = '${plandate}'/></td>
    	<td><input type="text" id="item_Code" name="ListVO[${fn:length(MPSView) }].item_Code" value='${param.item_Code}'readonly/></td>
    	<td><input type="text" id="item_Name" name="ListVO[${fn:length(MPSView) }].item_Name" value='${param.item_Name}' readonly/></td>
    	<td><input type="text" id="standard" name="ListVO[${fn:length(MPSView) }].standard" value='${param.standard}'readonly style="width:100%"/></td>
    	<td><input type="text" id="inventory_unit" name="ListVO[${fn:length(MPSView) }].inventory_unit" value='${param.inventory_unit}' style="width:100%" /></td>
    	<td><input type="text" id="sequence" value='${inputSeq}' readonly style="width:100%"/></td>
    	<td><input type="date" id="expected_date" name="ListVO[${fn:length(MPSView) }].expected_date" value='${expected_date}'/></td>
    	<td><input type="date" id="due_date" name="ListVO[${fn:length(MPSView) }].due_date" value='${due_date}'/></td>
    	<td><input type="text" id="plan_quantity" name="ListVO[${fn:length(MPSView) }].plan_quantity" value='${plan_quantity}' /></td>
    	<td><input type="text" id="buyer" name="ListVO[${fn:length(MPSView) }].buyer" value='${param.buyer}'readonly/></td>
    	<td><input type="text" id="note" name="ListVO[${fn:length(MPSView) }].note"value='${param.note}'/></td>
    </tr>
	</tbody>
	</table>
	</div>
</container2>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
function search2(){
	
  	openWindowPop('http://localhost:8090/webERP/member/applyorder.do','applyorder');
	 
  }
function setChildValue(code,name,buyer,standard,inventory_unit,note){
	  const URLSearch = new URLSearchParams(location.search);
	  URLSearch.set('submit', '2');
	  const newParam = URLSearch.toString();
  if(URLSearch.get('item_Code') == null){
		window.location.href = location.pathname +'?'+newParam +'&item_Code='+code+'&item_Name='+name+'&buyer='+buyer+'&standard='+standard
		+'&inventory_unit='+inventory_unit+'&note='+note;
  }
  else{
  	URLSearch.set('item_Code',name,buyer,standard,inventory_unit,note);
  	const newParam = URLSearch.toString();
  	window.location.href = location.pathname +'?'+newParam;
  }
  
}

function deleteRow() {
	  var item = document.getElementsByName("content").length;
	  const URLSearch = new URLSearchParams(location.search); 	
	  var submit = URLSearch.get('submit');
	  var item_Code = URLSearch.get('item_Code');
	  var item_Name = URLSearch.get('item_Name');
	  var buyer = URLSearch.get('buyer');
	  var standard = URLSearch.get('standard');
	  var inventory_unit = URLSearch.get('inventory_unit');
	  var note = URLSearch.get('note');
	  var no = "";
	  var ary = [];
	  for(var i=0; i<item;i++){
		  if(document.getElementsByName("content")[i].checked==true){
			  sequence = document.getElementsByName("content")[i].value;
			  ary.push(sequence);
		  }
			  window.location.href = "${contextPath}/member/delMps.do?sequence="+ary+"&submit=" + submit+"&item_Code="+item_Code+"&item_Name="+item_Name+
			 "&buyer="+buyer+"&standard="+standard+"&inventory_unit="+inventory_unit+"&note="+note;
	  }
}

function InsertRow(){	 
   		const URLSearch = new URLSearchParams(location.search);
   		
	 	URLSearch.set('submit', '1');
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
		  var MPSTable = document.getElementById('MPSTable');
          var row = MPSTable.insertRow(); 
          const URLSearch = new URLSearchParams(location.search);
          URLSearch.set('submit', '1');
			const newParam = URLSearch.toString();
			var link = location.pathname + '?' + newParam;
		document.getElementById("planNO").disabled = true;		
		document.getElementById("plandate").disabled = true;
		document.getElementById("item_Code").disabled = true;
		document.getElementById("item_Name").disabled = true;
		document.getElementById("standard").disabled = true;
		document.getElementById("inventory_unit").disabled = true;
		document.getElementById("sequence").disabled = true;
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

view_button.onclick = function(){
	const URLSearch = new URLSearchParams(location.search);
	URLSearch.set('submit', '1');
	const newParam = URLSearch.toString();

	window.open(location.pathname + '?' + newParam, '_self');
}

</script>
</form>
</body>
</html>