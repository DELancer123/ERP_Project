<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    
<% 
	String custCode1 = request.getParameter("general_Customer_Code");
	String custCode = request.getParameter("custCode");
	String relCode = request.getParameter("relCode");	
%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach var="forwarditem" items="${submitItemList}">
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
            overflow-x: scroll;
        }
         #view{
         	width:220%;
         	text-align: center;
            border: 1px solid black;
        }
        #view td:not(#no){
              width: 5%
        }
        #view td input{
            width: 100%;
        }
        #itemPop{
         	width:220%;
         	text-align: center;
            border: 1px solid black;
        }
        #itemPop td:not(#no){
              width: 5%
        }
        #itemPop td input{
            width: 100%;
        }
       #insertsubForward{
         	width:220%;
         	text-align: center;
            border: 1px solid black;
        }
        #insertsubForward td:not(#no){
              width: 5%
        }
        #insertsubForward td input{
            width: 100%;
        }
</style>
</head>
<body>
        <container3 id="contents3">
            <table id="view">
                <thead>
                    <td style="width: 5%;"><input type="checkbox" name="content1" onclick="selectAll1(this)"></td>
                   <td>번호</td>
                   <td>주문 번호</td>
                   <td>품번</td>
                    <td>품명</td>
                    <td>규격</td>
                    <td>주문수량</td>
                    <td>단위</td>
                    <td>단가</td>
                    <td>공급가</td>
					<td>부가세</td>
					<td>합계액</td>
                    <td>납기일</td>
                    <td>출하 예정일</td>
                    <td>주문 유무</td>
                    <td>검사</td>
                </thead>
 				</table>
 				<table id = "itemPop"></table>
                 <table id="insertsubForward" align="center">
                    <td><input type="checkbox" value="${corVO.no}"/></td>
                    <td><input type="text" id="no" name="ListVO[${fn:length(forward)}].corVO.no" value="${corVO.no}" /></td>
                    <td><input type="text" id="relCode" name="ListVO[${fn:length(forward)}].corVO.relCode" value="${corVO.relCode}" /></td>
                    <td><a href="javascript:search5()"><input type="text" id=item_code name="ListVO[${fn:length(forward)}].corVO.item_code" value="${param.item_code}" readonly/></td>
                    <td><a href="javascript:search5()"><input type="text" id="item_name" name="ListVO[${fn:length(forward)}].corVO.item_name" value="${param.item_name}" readonly /></td>
                    <td><input type="text" id="stand" name="ListVO[${fn:length(forward)}].corVO.stand" value="${corVO.stand}" /></td>
                    <td><input type="text" id="unit" name="ListVO[${fn:length(forward)}].corVO.unit" value="${corVO.unit}" /></td>
                    <td><input type="text" id="orderQuant" name="ListVO[${fn:length(forward)}].corVO.orderQuant" value="${corVO.unit}" /></td>
                    <td><input type="text" id="price" name="ListVO[${fn:length(forward)}].corVO.price" value="${corVO.price}" /></td>
                    <td><input type="text" id="publicSumPrice" value="${corVO.price*corVO.orderQuant}" readonly /></td>
                    <td><input type="text" id="vatPrice" value="${(corVO.price*corVO.orderQuant)*0.1}" readonly /></td>
                    <td><input type="text" id="sumPrice" value="${corVO.price*corVO.orderQuant}" readonly /></td>
                    <td><input type="date" id="dueDate" name="ListVO[${fn:length(forward)}].corVO.dueDate" value="${corVO.dueDate}" /></td>
                    <td><input type="date" id="expDate" name="ListVO[${fn:length(forward)}].corVO.expDate" value="${corVO.expDate}" /></td>
                    <td><input type="text" id="orderOX" name="ListVO[${fn:length(forward)}].corVO.orderOX" value="${corVO.orderOX}" /></td>
                    <td><input type="text" id="inspection" name="ListVO[${fn:length(forward)}].corVO.inspection" value="${corVO.inspection}" /></td>
                </table>
         
          </container3>
          <script type="text/javascript">
          
                function search5(){
    	  
        	  openWindowPop('http://localhost:8090/webERP/member/salsplanhelper.do','popupItem');  
    			}
                function setChildView(code, name) {
                	$('input[id=item_code]').val(code);
                	$('input[id=item_name]').val(name);
                }
            	
                </script>
</body>
</html>