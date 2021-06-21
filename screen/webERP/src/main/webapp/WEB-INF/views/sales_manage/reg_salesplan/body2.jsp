<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%> 
<%
	String inputNo = (String)request.getAttribute("inputNo");
%>
<c:forEach var="sale" items="${salesplan}"> 
    <c:set var="code" value="${item.item_code}"/>
	<c:set var="name" value="${item.item_name}"/>
	<c:set var="standard" value="${item.standard}"/>
	<c:set var="unit" value="${item.inventory_unit}"/>
	<c:set var="status" value="${item.inspection_status}"/>
	<c:set var="plancode" value="${item.plancode}"/>
	<c:set var="planquan" value="${item.planquantity}"/>
	<c:set var="price" value="${item.planprice}"/>
	<c:set var="newquan" value="${item.newquantity}"/>
	<c:set var="newprice" value="${item.newprice}"/>
	<c:set var="plandate" value="${item.plandate}"/>
</c:forEach>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #contents2{
            position: absolute;
            left: 15%;
            top: 25%;
            width: 85%;
            height: 70%;
            border: 1px solid black;
            z-index: 1;
            overflow: scroll;
        }
        .con1_search{
            padding:0;
            text-align: center;
            position: absolute;
            top: 25%;
            left: 15%;
        }
        #view1{
            width: 150%;
            text-align: center;
            border: 1px solid black;
        }
        #view1 th{
            width: 30px;
        }
        #contents2 div{
            position: absolute;
            bottom: 0;
            text-align: right;
        }
        #contents2 div input{
            width: 11%;
        }
</style>
</head>
<body>
	<container2 id="contents2">
	<!-- <form name="frmsalesplanList" method="post"  action="${contextPath}/member/addsalesplan.do"> -->
	<table id="view1">
		<thead align="center">
			<td style="width: 5%;"><input type="checkbox" name="content"
				onclick="selectAll(this)"></td>
			<td align="center">품번</td>
			<td align="center">품명</td>
			<td align="center">규격</td>
			<td align="center">단위(관리)</td>
			<td align="center">판매 계획 수량</td>
			<td align="center">판매 계획단가</td>
			<td align="center">판매 계획 금액</td>
			<td align="center">계획 수정 수량</td>
			<td align="center">계획 수정 단가</td>
			<td align="center">계획 수정 금액</td>			
		</thead>
			<c:forEach var="sale" items="${salesplan}" varStatus="status" >
				<tbody align="center">
					<td style="width: 5%;"><input type="checkbox" value="check" id="check" name="content" /></td>
					<td><input type="text" name="List[${status.index}].item_code" value="${sale.item_code}" ondblclick="search2()"/></td>
                    <td><input type="text" name="List[${status.index}].item_name" value="${sale.item_name}" ondblclick="search2()"/></td>
                    <td><input type="text" name="List[${status.index}].standard" value="${sale.standard}" readonly/></td>
                    <td><input type="text" name="List[${status.index}].inventory_unit" value="${sale.inventory_unit}" readonly/></td>
                    <td><input type="text" name="List[${status.index}].planquantity" value="${sale.planquantity}" readonly/></td>
                    <td><input type="text" name="List[${status.index}].planprice" value="${sale.planprice}" readonly/></td>
                    <td><input type="text" value="${sale.planquantity*sale.planprice}" readonly/></td>
                    <td><input type="text" name="List[${status.index}].newquantity" value="${sale.newquantity}" readonly/></td>
                    <td><input type="text" name="List[${status.index}].newprice" value="${sale.newprice}" readonly/></td>
                    <td><input type="text" value="${sale.newquantity*sale.newprice}" readonly/></td>
            	</tbody>
			</c:forEach>
				<tbody align="center">
					<td style="width: 5%;"><input type="checkbox" value="check" name="content" /></td>
					<td><input type="text" id="item_code" name="List[${fn.length(salesplan)}].item_code" value="${param.item_code}" ondblclick="search2()"/></td>
                    <td><input type="text" name="List[${fn.length(salesplan)}].item_name" value="${param.item_name}" ondblclick="search2()"/></td>
                    <td><input type="text" name="List[${fn.length(salesplan)}].standard" value="${standard}" readonly/></td>
                    <td><input type="text" name="List[${fn.length(salesplan)}].inventory_unit" value="${inventory_unit}"/></td>
                    <td><input type="text" name="List[${fn.length(salesplan)}].planquantity" value="${planquantity}" /></td>
                    <td><input type="text" name="List[${fn.length(salesplan)}].planprice" value="${planprice}" /></td>
                    <td><input type="text" value="${planquantity*planprice}" /></td>
                    <td><input type="text" name="List[${fn.length(salesplan)}].newquantity" value="${newquantity}" /></td>
                    <td><input type="text" name="List[${fn.length(salesplan)}].newprice" value="${newprice}" /></td>
                    <td><input type="text" value="${newquantity*newprice}" /></td>
            	</tbody>
	</table>
	</container2>
	   <script>
          function search2(){
    	  
        	  openWindowPop('http://localhost:8090/webERP/sales_manage/pop/popItemBySalesReg.do','popItemBySalesReg');  
    }
    </script>
</body>
</html>