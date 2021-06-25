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
<% String code = request.getParameter("custCode");%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach var="order" items="${orderInsert}"> 
	<c:set var="ordCode" value="${order.ordCode}"/>
	<c:set var="ordDate" value="${order.ordDate}"/>
	<c:set var="custCode" value="${order.custCode}"/>
	<c:set var="tax" value="${order.tax}"/>
	<c:set var="note" value="${order.note}"/>
	<c:set var="item_code" value="${order.corVO.item_code}"/>
	<c:set var="item_name" value="${order.corVO.item_name}"/>
	<c:set var="stand" value="${order.corVO.stand}"/>
	<c:set var="unit" value="${order.corVO.unit}"/>
	<c:set var="dueDate" value="${order.corVO.dueDate}"/>
	<c:set var="orderQuant" value="${order.corVO.orderQuant}"/>
	<c:set var="price" value="${order.corVO.price}"/>
	<c:set var="expDate" value="${order.corVO.expDate}"/>
	<c:set var="relDate" value="${order.corVO.relDate}"/>
	<c:set var="inspection" value="${order.corVO.inspection}"/>
	<c:set var="orderOX" value="${order.corVO.orderOX}"/>	
</c:forEach>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
        #addOrder{
            width: 100%;
            text-align: center;
            border: 1px solid black;
        }
        #addOrder td:not(#no){
            width: 8%;
        }
        #addOrder td input{
            width: 100%;
        }
</style>
</head>
<body>
        <form id="regOrd" method="get" commandName = "ListOrd">
        <container2 id="contents2">
           <table id="addOrder">
                <thead>
                    <td><input type="checkbox" id="check" name="content" onclick="selectAll(this)"/></td>
                    <td>주문번호</td>
                    <td>주문일자</td>
                    <td>고객</td>
                    <td>과세구분</td>
                    <td>비고</td>
                </thead>
                <c:forEach var="cust" items="${orderList}" varStatus="status"> 
                <tbody>
                    <td><input type="checkbox" value="${cust.ordCode}" name="content"/></td>
                    <td><input type="text" id="ordCode" name="ListOrd[${status.index}].ordCode" value="${cust.ordCode}" /></td>
                    <td><input type="date" name="ListOrd[${status.index}].ordDate"value="${cust.ordDate}"/></td>
                    <td><input type="text" name="ListOrd[${status.index}].custCode" value="${cust.custCode}"/></td>
                    <td><input type="text" name="ListOrd[${status.index}].tax" value="${cust.tax}"/></td>
                    <td><input type="text" name="ListOrd[${status.index}].note" value="${cust.note}"/></td>
                </tbody>
                </c:forEach>
                <tbody>
                    <td><input type="checkbox" name="content"/></td>
                    <td><input type="text" id="ordCode" name="ListOrd[${fn:length(orderInsert)}].ordCode" value="${ordCode}" /></td>
                    <td><input type="date" name="ListOrd[${fn:length(orderInsert)}].ordDate" value="${ordDate}" /></td>
                    <td><input type="text" name="ListOrd[${fn:length(orderInsert)}].custCode" value="${custCode}" ondblclick="submit1()"/></td>
                    <td><input type="text" name="ListOrd[${fn:length(orderInsert)}].tax" value="${tax}"/></td>
                    <td><input type="text" name="ListOrd[${fn:length(orderInsert)}].note" value="${note}"/></td>
                </tbody>
           </table>
        </container2>
        </form>
        <form id="submitOrd" method="get" >
        <container3 id="contents3">
            <table id="addOrder">
                <thead>
                    <td style="width: 5%;"><input type="checkbox" name="content1" onclick="selectAll1(this)"></td>
                    <td>품번</td>
                    <td>품명</td>
                    <td>규격</td>
                    <td>단위</td>
                    <td>납기일</td>
                    <td>주문수량</td>
                    <td>단가</td>
                    <td>공급가</td>
                    <td>부가세</td>
                    <td>합계액</td>
                    <td>검사</td>
                </thead>
               <!--     <c:forEach var="cust" items="${orderList}" varStatus="status"> 
                <tbody>
                    <td><input type="checkbox" value = "${cust.corVO.item_code}" name="content"/></td>
                    <td><input type="text" id="item_code" value="${cust.corVO.item_code}" readonly/></td>
                    <td><input type="text" name="ListOrd[${status.index}].corVO.item_name" value="${cust.corVO.item_name}" readonly/></td>
                    <td><input type="text" name="ListOrd[${status.index}].corVO.stand" value="${cust.corVO.stand}" readonly/></td>
                    <td><input type="text" name="ListOrd[${status.index}].corVO.unit" value="${cust.corVO.unit}" readonly/></td>
                    <td><input type="date" name="ListOrd[${status.index}].corVO.dueDate" value="${cust.corVO.dueDate}" readonly/></td>
                    <td><input type="text" name="ListOrd[${status.index}].corVO.orderQuant" value="${cust.corVO.orderQuant}" readonly/></td>
                    <td><input type="text" name="ListOrd[${status.index}].corVO.price" value="${cust.corVO.price}" readonly/></td>
                    <td><input type="text" value="${cust.corVO.orderQuant*cust.corVO.price}" readonly/></td>
                    <td><input type="text" value="${(cust.corVO.orderQuant*cust.corVO.price)*0.1}" readonly/></td>
                    <td><input type="text" value="${cust.corVO.orderQuant*cust.corVO.price}" readonly/></td>
                    <td><input type="text" name="ListOrd[${status.index}].corVO.orderOX" value="${cust.corVO.orderOX}"readonly/></td>
                </tbody>
                </c:forEach>
                <tbody>
                    <td><input type="checkbox" name="content"/></td>
                    <td><input type="text" id="item_code" name="ListOrd[${fn:length(orderList)}].corVO.item_code" value="${corVO.item_code}"/></td>
                    <td><input type="text" name="ListOrd[${fn:length(orderInsert)}].corVO.item_name" value="${corVO.item_name}"/></td>
                    <td><input type="text" name="ListOrd[${fn:length(orderInsert)}].corVO.stand" value="${corVO.stand}"/></td>
                    <td><input type="text" name="ListOrd[${fn:length(orderInsert)}].corVO.unit" value="${corVO.unit}"/></td>
                    <td><input type="date" name="ListOrd[${fn:length(orderInsert)}].corVO.dueDate" value="${corVO.dueDate}"/></td>
                    <td><input type="text" name="ListOrd[${fn:length(orderInsert)}].corVO.orderQuant" value="${corVO.orderQuant}"/></td>
                    <td><input type="text" name="ListOrd[${fn:length(orderInsert)}].corVO.price" value="${corVO.price}"/></td>
                    <td><input type="text" value="${corVO.orderQuant*corVO.price}"/></td>
                    <td><input type="text" value="${(corVO.orderQuant*corVO.price)*0.1}"/></td>
                    <td><input type="text" value="${corVO.orderQuant*corVO.price}"/></td>
                    <td><input type="text" name="ListOrd[${fn:length(orderInsert)}].corVO.orderOX" value="${corVO.orderOX}"/></td>
                </tbody> -->
            </table>
        </container3>
        </form>
        <script>

        var ordCode = document.getElementById("ordCode");
        var ordDate = document.getElementById("dataoutput");
        var custCode = document.getElementById("dataoutput");
        var tax = document.getElementById("dataoutput");
        var note = document.getElementById("dataoutput");

        var item_code = document.getElementById("item_code");
        var item_name = document.getElementById("dataoutput");
        var stand = document.getElementById("dataoutput");
        var unit = document.getElementById("dataoutput");
        var dueDate = document.getElementById("dataoutput");
        var orderQuant = document.getElementById("dataoutput");
        var price = document.getElementById("dataoutput");
        var orderOX = document.getElementById("dataoutput");
        var save_button = document.getElementById("save");
        var update_button = document.getElementById('update');
        
        
        function newRow(){            
            var addOrder = document.getElementById('addOrder');
            var row = addOrder.insertRow();
    			var link = document.location.href;
    			var articleNOInput = document.createElement("input");
    		     articleNOInput.setAttribute("type","hidden");
    		     articleNOInput.setAttribute("name","path");
    		     articleNOInput.setAttribute("value", link);
    		     document.getElementById('regOrd').appendChild(articleNOInput);
              document.getElementById('regOrd').action = "${contextPath}/member/addorder.do";
              /*openWindowPop('http://localhost:8090/webERP/member/addorder.do?custCode="+custCode','addorder'); */
    			document.getElementById('regOrd').submit(); 
        }
        /*function setChildValue(name){
        	  
        	  const URLSearch = new URLSearchParams(location.search);
    		  URLSearch.set('submit', '2');
    		  const newParam = URLSearch.toString();
            if(URLSearch.get('item_code') == null){
    		window.location.href = location.pathname +'?'+newParam + '&item_code=' + name;
            }
            else{
            	URLSearch.set('item_code', name);
            	const newParam = URLSearch.toString();
            	window.location.href = location.pathname +'?'+newParam;
            }
            
        }*/
		function submit(){
        	var addOrder = document.getElementById('addOrder');
            var row = addOrder.insertRow();
			var link = document.location.href;
			var articleNOInput = document.createElement("input");
		     articleNOInput.setAttribute("type","hidden");
		     articleNOInput.setAttribute("name","path");
		     articleNOInput.setAttribute("value", link);
		     document.getElementById('submitOrd').appendChild(articleNOInput);
          document.getElementById('submitOrd').action = "${contextPath}/member/suborderlist.do";
          /*openWindowPop('http://localhost:8090/webERP/member/addorder.do?custCode="+custCode','addorder'); */
			document.getElementById('submitOrd').submit(); 
        }
        function search2(){
        	
          	openWindowPop('http://localhost:8090/webERP/sales_manage/pop/regorderItem.do','regorderItem');
        	 
          }
        

        function deleteData() {
        
      	  var item = document.getElementsByName("content").length;
      	  var no = "";
      	  var ary = [];
      	  for(var i=0; i<item;i++){
      		  if(document.getElementsByName("content")[i].checked==true){
      			no = document.getElementsByName("content")[i].value;
      			
      			   ary.push(no); 
      		  }
      		 	  window.location.href = "${contextPath}/member/delorder.do?no="+ary;
      	  }
        }
        </script>
</body>
</html>