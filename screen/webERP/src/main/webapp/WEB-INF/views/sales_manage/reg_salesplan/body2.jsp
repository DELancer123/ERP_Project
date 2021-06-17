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
<% String parent = request.getParameter("item_code");%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach var="item" items="${salesplan}"> 
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
        #reqInput {
            background-color: rgb(255, 255, 149);
            text-align: center;
        }

</style>
</head>
<body>
	<container2 id="contents2">
	<!-- <form name="frmsalesplanList" method="post"  action="${contextPath}/member/addsalesplan.do"> -->
	<table id="view">
		<thead>
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
		<c:forEach var="item" items="${salesplan}" varStatus="status" >
		<tbody>
			<td style="width: 5%;"><input type="checkbox" value="check"
				id="check" name="content" /></td>
					<td><input type="text" value="${item.item_code}" ondblclick="search12345()"/></td>
                    <td><input type="text" value="${item.item_name}" ondblclick="search12345()"/></td>
                    <td><input type="text" value="${item.standard}" readonly/></td>
                    <td><input type="text" value="${item.inventory_unit}" readonly/></td>
                    <td><input type="text" value="${item.planquantity}" readonly/></td>
                    <td><input type="text" value="${item.planprice}" readonly/></td>
                    <td><input type="text" value="${item.planquantity*item.planprice}" readonly/></td>
                    <td><input type="text" value="${item.newquantity}" readonly/></td>
                    <td><input type="text" value="${item.newprice}" readonly/></td>
                    <td><input type="text" value="${item.newquantity*item.newprice}" readonly/></td>

		</tbody>
		</c:forEach>
	</table>
	</container2>
	   <script>
          function search12345(){
    	  
        	  openWindowPop('http://localhost:8090/webERP/sales_manage/popItemBySalesReg.do','popItemBySalesReg');  
    }
    </script>
</body>
</html>