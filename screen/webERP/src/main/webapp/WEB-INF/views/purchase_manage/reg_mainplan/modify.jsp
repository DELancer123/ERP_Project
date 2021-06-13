<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
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
<title>Document</title>
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
<form name="modify" action="${contextPath}/member/mainplan.do?action=modifyMPS" method="get">
<h1  class="text_center">수정창</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">순서</td>
	      <td width="400"><p><input type="text" name="sequence" value="${mainplan.sequence}" readonly="readonly"/></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">계획일</td>
	      <td width="400"><p><input type="text" name="plandate"  value="${mainplan.plandate}"/></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">품번</td>
	       <td width="400"><p><input type="text" name="item_Code" value="${mainplan.item_Code}" readonly="readonly"/></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">품명</td>
	       <td width="400"><p><input type="text" name="item_Name" value="${mainplan.item_Name}" readonly="readonly"/></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">규격</td>
	       <td width="400"><p><input type="text" name="standard" value="${mainplan.standard}" readonly="readonly"/></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">단위</td>
	       <td width="400"><p><input type="text" name="unit"  value="${mainplan.unit}" readonly="readonly"/></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">출하예정일</td>
	       <td width="400"><p><input type="text" name="expected_date" value="${mainplan.expected_date}" readonly="readonly"/></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">납기일</td>
	       <td width="400"><p><input type="text" name="due_date" value="${mainplan.due_date}" readonly="readonly"/></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">계획수량</td>
	       <td width="400"><p><input type="text" name="plan_quantity" value="${mainplan.plan_quantity}"/></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">고객</td>
	       <td width="400"><p><input type="text" name="customer_Name" value="${mainplan.customer_Name}" readonly="readonly"/></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">비고</td>
	       <td width="400"><p><input type="text" name="note" value="${mainplan.note}"/></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="수정하기">
	       <input type="reset" value="다시입력"></td>
	    </tr>
</body>
</html>