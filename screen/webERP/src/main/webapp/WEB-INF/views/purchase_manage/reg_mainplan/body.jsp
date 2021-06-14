<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
var openWin;
function func_Popup(){
	window.name = "member/mainplan.do";
	
	openWin = window.open("applyorder.do","applyorder",
			"width=1400, height=500, resizable = no, scrollbars = no");
}

</script>
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

#view {
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
			<td>�����</td>
			<td style="width: 50px;"><input type="text" id="reqInput"
				style="width: 100%;" /></td>

			<td colspan="3"><input type="text" name="" disabled
				style="width: 100%;" /></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>
			<td colspan="5" style="width: 100px;">�μ�</td>
			<td style="width: 80px;"><input type="text" id="reqInput"
				style="width: 100%;" /></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>
			<td><input type="text" name="" disabled /></td>

		</tr>
		<tr>
			<td>��ȹ�Ⱓ</td>
			<td colspan="2" style="width: 80px;"><input type="date"
				id="reqInput" style="width: 100%;" /></td>
			<td>~</td>
			<td><input type="date" id="reqInput" style="width: 100%;" /></td>
			<td></td>
			<td colspan="5">���</td>
			<td style="width: 80px;"><input type="text" id="reqInput"
				style="width: 100%;" /></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>
			<td><input type="text" name="" disabled /></td>
		</tr>
	</table>
	<div id="button">
		<input type="button" onclick="func_Popup();" value="�ֹ�����" />
	</div>
	</container1>
<container2 id=contents2>
<div id="MpsInfo">
	<table id="view">
		<thead align="center" style="background-color: gray">
		<td><input type="checkbox" name="content"/></td>
			<td>��ȹ��</td>
			<td>ǰ��</td>
			<td>ǰ��</td>
			<td>�԰�</td>
			<td>����</td>
			<td>����</td>
			<td>���Ͽ�����</td>
			<td>������</td>
			<td>��ȹ����</td>
			<td>��</td>
			<td>���</td>
		</thead>
		<tbody>
		<c:forEach var="mainplan" items="${mainplanList}">
			<tr align="center">
			<td><input type="checkbox" name="content"/></td>
				<td><input type="text" value="${mainplan.plandate}"/></td>
				<td><input type="text" value="${mainplan.item_Code}"/></td>
				<td><input type="text" value="${mainplan.item_Name}"/></td>
				<td><input type="text" value="${mainplan.standard}"/></td>
				<td><input type="text" value="${mainplan.unit}"/></td>
				<td><input type="text" value="${mainplan.sequence}"/></td>
				<td><input type="text" value="${mainplan.expected_date}"/></td>
				<td><input type="text" value="${mainplan.due_date}"/></td>
				<td><input type="text" value="${mainplan.plan_quantity}"/></td>
				<td><input type="text" value="${mainplan.customer_Name}"/></td>
				<td><input type="text" value="${mainplan.note}"/></td>
			</tr>
		</c:forEach>	
	</tbody>
	</table>
	</div>
</container2>
</body>
</html>