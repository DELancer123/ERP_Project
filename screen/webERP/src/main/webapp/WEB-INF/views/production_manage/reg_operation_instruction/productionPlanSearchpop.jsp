<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    
    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <style>
    	a{
    		text-decoration:none;
    	}
        #wrap{
            width: 1000px;
            height: 800px;
            border: 1px solid black;
        }
        #searchBox{
            width: 100%;
            height: 10%;
            border: 1px solid black;
        }
        #button{
            margin-right: 3%;
            text-align: right;
        }
        #search{
            margin-left: 30px;
        }
        #view{
        	width:100%;
        	height:90%;
        	overflow:scroll;
        }
    </style>
</head>
<body>
<form name="popForm" method="get" action="${contextPath }/member/productionPlanSearch.do" >
    <div id="wrap">
        <div id="searchBox">
            <table id="search">
                <tr>
                    <td>계획기간</td>
                    <td><input type="date" name="dateStart" style="background-color: yellow;"/></td>
                	<td>~</td>
                    <td><input type="date" name="dateEnd" style="background-color: yellow;"/></td>
                </tr>
            </table>
            <div id="button">
                <button id="planSearch">조회</button>
                <button id="submit">적용</button>
            </div>
        </div>
        <div id="view">
            <table style="width: 100%;">
                <tr align="center">
                	<td ><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                    <td>품번</td>
                    <td>품명</td>
                    <td>규격</td>
                    <td>단위</td>
                    <td>계획잔량</td>
                    <td>작업예정일</td>
                    <td>비고</td>
                </tr>
     <c:forEach var="productionPlan" items="${productionPlanView}" >     
		<tr align="center">
			<td><input type="checkbox" name="content" /></td>
      		<td>${productionPlan.itemCode }</td>
      		<td><a href="#">${productionPlan.itemName}</a></td>
      		<td>${productionPlan.standard }</td>
      		<td>${productionPlan.inventoryUnit }</td>
      		<td>${productionPlan.quantity }</td>
      		<td>${productionPlan.schedule }</td>
      		<td>${productionPlan.note }</td>
    	</tr> 
    </c:forEach> 
            </table>
        </div>
    </div>
    <script>
    	var submit_button = document.getElementById("submit");
    	var text_code = document.getElementById("code");
    	var text_name = document.getElementById("name");
    		
    	function popFunction(code,name){
    			text_code.value = code;
    			text_name.value = name;
    	}
    	
    	submit_button.onclick = function(){
    		opener.parent.location='${contextPath }/member/regoperins.do?itemNumber='+text_code.value+'&&itemName='+text_name.value;
    		window.close();
    	}
    	
    	function selectAll(selectAll){
            const checkbox = document.getElementsByName('content');
            checkbox.forEach((checkbox) => {
            checkbox.checked = selectAll.checked;
           })
    </script>
    </form>
</body>
</html>