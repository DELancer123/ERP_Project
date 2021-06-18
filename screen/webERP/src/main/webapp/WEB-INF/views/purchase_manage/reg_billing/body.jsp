<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.con1_search {
	padding: 0;
	text-align: center;
	position: absolute;
	top: 25%;
	left: 18%;
}

 #view2 {
	width: 100%;
	text-align: center;
	border: 1px solid black;
}

#total {
	position: absolute;
	bottom: 0;
	right: 0;
}

#button {
	position: absolute;
	top: 10px;
	right: 20px;
}

#contents3 {
	/* overflow: scroll; */
	
}

#total td {
	width: 10%;
}

#total td input {
	width: 100%;
}

#reqInput {
	background-color: rgb(255, 255, 149);
	text-align: center;
}

#BillingInfo,#BottomInfo {
/* 	overflow: scroll; */
	height: 70%;
	width: 70%;
}
#BottomInfo {
	overflow: scroll;
	height: 100%;
	width: 100%;
}
#BillingTable,#BottomTable {
	width: 100%;
	text-align: center;
	border: 1px solid black;
}
</style>
</head>
<body>
	<container1 id=contents1>
	<table class="con1_search">
		<tr>
			<td>�����</td>
			<td style="width: 50px;"><input type="text" id="reqInput"
				style="width: 100%;" /></td>

			<td colspan="3"><input type="text" name="" disabled
				style="width: 100%;" /></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>
			<td colspan="5" style="width: 50px;">�μ�</td>
			<td style="width: 80px;"><input type="text" id="reqInput"
				style="width: 100%;" /></td>
			<td><input type="text" name="" disabled /></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>

		</tr>
		<tr>
			<td>��û����</td>
			<td colspan="2" style="width: 80px;"><input type="date"
				id="reqInput" style="width: 100%;" /></td>
			<td>~</td>
			<td><input type="date" id="reqInput" style="width: 100%;" /></td>
			<td></td>
			<td colspan="5">���</td>
			<td style="width: 80px;"><input type="text" id="reqInput"
				style="width: 100%;" /></td>
			<td><input type="text" name="" disabled /></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>
		</tr>
	</table>
	<div id="button">
		<input type="button" id="Popup" onclick="func_Popup();" value="�ҿ䷮����" />
	</div>
	</container1>
	<container2 id="contents2">
<div id="BillingInfo">
<form id="Billing" mehtod="get" commandName="ListVO">
	<table id="BillingTable">
		<thead align="center" style="background-color: gray">
			<td><input type="checkbox" name="content"/></td>
			<td>����</td>
			<td>û����ȣ</td>
			<td>û������</td>
			<td>û������</td>
			<td>���</td>
		</thead>
		<c:forEach var="cm" items="${cmList}" varStatus="status">
			<tr align="center">
				<td><input type="checkbox" name="content" value="${cm.sequence}"/></td>
		<td style="width:13px;"><input type="text" name="ListVO[${status.index}].sequence" value = '${cm.sequence}' readonly style="width:100%"/></td>
		<td><input type="text" name="ListVO[${status.index}].claim_no" value = '${cm.claim_no}' readonly style="width:100%"/></td>
		<td><input type="date" name="ListVO[${status.index}].claim_date" value = '${cm.claim_date}' readonly style="width:100%"/></td>
		<td style="width:33px;"><input type="text" name="ListVO[${status.index}].claim_division" value = '${cm.claim_division}' style="width:100%"/></td>
		<td><input type="text" name="ListVO[${status.index}].note" value = '${cm.note}' style="width:100%"/></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</container2>
	<container3 id="contents3">
<div id="BottomInfo">
	<table id="BottomTable">
				<thead align="center" style="background-color: gray">
			<td><input type="checkbox" name="content"/></td>
			<td>����</td>
			<td>ǰ��</td>
			<td>ǰ��</td>
			<td>�԰�</td>
			<td>��û��</td>
			<td>������</td>
			<td>����������</td>
			<td>û������</td>
			<td>û����������</td>
			<td>�ְŷ�ó</td>
		</thead>
		<c:forEach var="btm" items="${bottomList}">
			<tr align="center">
				<td><input type="checkbox" name="content" /></td>
					<td style="width:13px;"><input type="text" value="${btm.sequence}" readonly style="width:100%"/></td>
					<td><input type="text" value="${btm.item_Code}" readonly/></td>
					<td><input type="text" value="${btm.item_Name}" readonly/></td>
					<td style="width:13px;"><input type="text" value="${btm.standard}" readonly style="width:100%"/></td>
					<td><input type="text" value="${btm.requestdate}" readonly/></td>
					<td style="width:33px;"><input type="text" value="${btm.inventory_unit}" readonly style="width:100%"/></td>
					<td><input type="text" value="${btm.inventory_qty}" readonly/></td>
					<td style="width:33px;"><input type="text" value="${btm.claim_unit}" readonly style="width:100%"/></td>
					<td><input type="text" value="${btm.claim_quantity}" readonly/></td>
					<td><input type="text" value="${btm.buyer}" readonly/></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div id="total">
		<table>
			<tr>
				<td>���ּ����հ�</td>
				<td><input type="text" disabled /></td>
				<td>���ް��հ�</td>
				<td><input type="text" disabled /></td>
				<td>���ް��հ�</td>
				<td><input type="text" disabled /></td>
				<td>���ް��հ�</td>
				<td><input type="text" disabled /></td>
				<td>���ް��հ�</td>
				<td><input type="text" disabled /></td>
			</tr>
			<tr>
				<td>�����</td>
				<td><input type="text" disabled /></td>
				<td>�������</td>
				<td><input type="text" disabled /></td>
				<td>�԰�����</td>
				<td><input type="text" disabled /></td>
			</tr>
		</table>
	</div>
	</container3>
<script type="text/javascript" src="jquery-2.2.2.min.js"></script>
<script type="text/javascript">
var windowObj;

function func_Popup(){	
	window.name = "member/regbilling.do";
	var settings ='width=1400, height=500, resizable = no, scrollbars = no';

	windowObj = window.open("mrpamount.do","mrpamount",settings);
	
	var txt_requestdate = document.getelementById("requestdate");
	var txt_code = document.getelementById("item_Code");
	var txt_Name = document.getelementById("item_Name");
	var txt_claim_Qty = document.getelementById("claim_quantity");
	
	document.getElementById('requestdate').value= windowObj.document.getElementById("need_date").value; 
	document.getElementById('item_Code').value= windowObj.document.getElementById("item_Code").value;  
	document.getElementById('item_Name').value= windowObj.document.getElementById("item_Name").value;  
	document.getElementById('claim_quantity').value= windowObj.document.getElementById("expected_quantity").value; 
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
		  
			  window.location.href = "${contextPath}/member/delbilling.do?sequence="+ary;
	  }
}
</script>
</form>
</body>
</html>