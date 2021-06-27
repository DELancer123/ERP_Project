<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    
<% 
	String item_code = request.getParameter("item_code");
%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach var="forwarditem" items="${forwardItemInsert}">
	<c:set var="relCode" value="${forwarditem.relCode}"/>
	<c:set var="item_code" value="${forwarditem.item_code}"/>
	<c:set var="item_name" value="${forwarditem.item_name}"/>
	<c:set var="stand" value="${forwarditem.stand}"/>
	<c:set var="unit" value="${forwarditem.unit}"/>
	<c:set var="orderQuant" value="${forwarditem.orderQuant}"/>
	<c:set var="price" value="${forwarditem.price}"/>
	<c:set var="dueDate" value="${forwarditem.dueDate}"/>
	<c:set var="expDate" value="${forwarditem.expDate}"/>
	<c:set var="inspection" value="${forwarditem.inspection}"/>
	<c:set var="orderOX" value="${forwarditem.orderOX}"/>
	</c:forEach>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출고 처리 등록</title>
<style>
        #contents3{
            position: absolute;
            right: 0;
            top:60%;
            width: 85%;
            height: 35%;
            border: 1px solid black;
            z-index: 1;
        }
         #view{
            width: 100%;
            text-align: center;
            border: 1px solid black;
        }
        #view td:not(#no){
            width: 8%;
        }
        #view td input{
            width: 100%;
        }
</style>
</head>
<body>
        <container3 id="contents3">
            <table id="view">
                <thead>
                    <td style="width: 5%;"><input type="checkbox" name="content1" onclick="selectAll1(this)"></td>
                    <td>품번</td>
                    <td>품명</td>
                    <td>규격</td>
                    <td>주문단위수량</td>
                    <td>단위</td>
                    <td>단가</td>
                    <td>공급가</td>
                    <td>부가세</td>
                    <td>합계액</td>
                    <td>주문 유무</td>
                    <td>합계액</td>
                </thead>
                 <c:forEach var="subForward" items="${forwardItemList}" varStatus="status">
                <tbody id="updsubForward" align="center">
                    <td><input type="checkbox" value = "${subForward.relCode}" name="content"/></td>
                    <td><input type="text"  name="ListVO[${status.index}].corVO.item_code" value="${subForward.corVO.item_code}" ondbclick="submit2()" readonly/></td>
                    <td><input type="text"  name="ListVO[${status.index}].corVO.item_name" value="${subForward.corVO.item_name}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].corVO.stand" value="${subForward.corVO.stand}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].corVO.unit" value="${subForward.corVO.unit}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].corVO.unit" value="${subForward.corVO.deadLine}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].corVO.deadLine" value="${subForward.corVO.deadLine}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].corVO.deadLine" value="${subForward.corVO.deadLine}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].corVO.deadLine" value="${subForward.corVO.deadLine}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].corVO.deadLine" value="${subForward.corVO.deadLine}" readonly /></td>
                    
                    <td><input type="text" name="ListVO[${status.index}].note" value="${subForward.note}" readonly /></td>
                </tbody>
                </c:forEach>
                    <tbody id="insertsubForward" align="center">
                    <td><input type="checkbox"/></td>
                    <td><input type="text" id=item_code name="ListVO[${fn:length(forward)}].item_code" value="${item_code}" readonly/></td>
                    <td><input type="date" id="item_name" name="ListVO[${fn:length(forward)}].item_name" value="${item_name}" readonly /></td>
                    <td><input type="text" id="stand" name="ListVO[${fn:length(forward)}].stand" value="${stand}" readonly /></td>
                    <td><input type="text" id="unit" name="ListVO[${fn:length(forward)}].unit" value="${unit}" readonly /></td>
                    <td><input type="text" id="orderQuant" name="ListVO[${fn:length(forward)}].orderQuant" value="${orderQuant}" readonly /></td>
                    <td><input type="text" id="price" name="ListVO[${fn:length(forward)}].price" value="${price}" readonly /></td>
                    <td><input type="date" id="dueDate" name="ListVO[${fn:length(forward)}].dueDate" value="${dueDate}" readonly /></td>
                    <td><input type="text" id="expDate" name="ListVO[${fn:length(forward)}].expDate" value="${expDate}" readonly /></td>
                    <td><input type="text" id="inspection" name="ListVO[${fn:length(forward)}].inspection" value="${inspection}" readonly /></td>
                </tbody>
            </table>
        </container3>
</body>
</html>