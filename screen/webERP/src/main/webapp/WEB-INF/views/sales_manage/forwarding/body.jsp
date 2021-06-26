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
	String relCode = request.getParameter("relCode");
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
	<c:forEach var="forward" items="${forwardInsert}">
	<c:set var="relCode" value="${forward.relCode}"/>
	<c:set var="relDate" value="${forward.relDate}"/>
	<c:set var="custCode" value="${forward.custCode}"/>
	<c:set var="deadLine" value="${forward.deadLine}"/>
	<c:set var="note" value="${forward.note}"/>
	</c:forEach>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출고 처리 등록</title>
<style>
#contents1{
            position: absolute;
            padding: 10px;
            right: 0;
            top: 15%;
            width: 85%;
            height: 10%;
            border: 1px solid black;
            z-index: 1;
        }
        #contents2{
            position: absolute;
            right: 0;
            top: 25%;
            width: 85%;
            height: 35%;
            border: 1px solid black;
            z-index: 1;
        }
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
                #reqInput {
            background-color: rgb(255, 255, 149);
            text-align: center;
        }
</style>
</head>
<body>
<container1 id = contents1>
            <table class="con1_search">
                <tr>
                    <td>거래처 명</td>
                    <td><input type="text" name="cust" value='${param.custCode}'disabled /></td>
                    <td><input type="text" name="cust" value='${param.custName}'disabled /></td>
                    <td style="width: 50px;"><a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                    <td>출고기간</td>
                    <td><input type="date" id="reqInput"></td>
                    <td>~</td>
                    <td><input type="date" id="reqInput"></td>
                </tr>
               <!--  <tr>
                    <td>고객</td>
                    <td><input type="text"></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" disabled></td>
                    <td>출고창고</td>
                    <td><input type="text" id="reqInput"></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" disabled></td>
                </tr>
                 -->
            </table>
        </container1>
            <container2 id="contents2">
           <table id="view">
               <thead>
                   <td colspan="7">주문출고</td>
               </thead>
                <thead>
                    <td><input type="checkbox" id="check" name="content" onclick="selectAll(this)"/></td>
                    <td>출고번호</td>
                    <td>출고일자</td>
                    <td>고객</td>
                    <td>마감</td>
                    <td>비고</td>
                </thead>
                <c:forEach var="supForwarding" items="${supForwardList}" varStatus="status">
                <tbody id="updForward" align="center">
                    <td><input type="checkbox" value = "${supForwarding.relCode}" name="content"/></td>
                    <td><input type="text"  name="ListVO[${status.index}].relCode" value="${supForwarding.relCode}" readonly/></td>
                    <td><input type="text"  name="ListVO[${status.index}].relDate" value="${supForwarding.relDate}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].custCode" value="${supForwarding.custCode}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].deadLine" value="${supForwarding.deadLine}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].note" value="${supForwarding.note}" readonly /></td>
                </tbody>
                </c:forEach>
                    <tbody id="insertForward" align="center">
                    <td><input type="checkbox"/></td>
                    <td><input type="text"  name="ListVO[${fn:length(forward)}].relCode" value="${relCode}" readonly/></td>
                    <td><input type="text"  name="ListVO[${fn:length(forward)}].relDate" value="${relDate}" readonly /></td>
                    <td><input type="text" name="ListVO[${fn:length(forward)}].custCode" value="${custCode}" readonly /></td>
                    <td><input type="text" name="ListVO[${fn:length(forward)}].deadLine" value="${deadLine}" readonly /></td>
                    <td><input type="text" name="ListVO[${fn:length(forward)}].note" value="${note}" readonly /></td>
                </tbody>
           </table>
        </container2>
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
                </thead>
                <tbody>
                    <td style="width: 5%;"><input type="checkbox" value = "check1" id="check" name="content1"/></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                </tbody>
            </table>
        </container3>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
function search1(){
    	  
openWindowPop('http://localhost:8090/webERP/sales_manage/pop/regforwardCust.do','regforwardCust');  
}
</script>
</body>
</html>