<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 #contents1{
            position: absolute;
            left: 15%;
            top: 15%;
            width: 85%;
            height: 10%;
            border: 1px solid black;
            z-index: 1;
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
#reqInput {
	background-color: rgb(255, 255, 149);
	text-align: center;
}
</style>
<script>
		var plus_button = document.getElementById('plus');
		var minus_button = document.getElementById('minus');

		plus_button.onclick = function() {
			var year = document.getElementById('year');
			year.value = Number(year.value) + 1;
		}
		minus_button.onclick = function() {
			var year = document.getElementById('year');
			year.value = Number(year.value) - 1;
		}
		function sumPrice
</script>
</head>
<body>
	<container1 id=contents1>
	<table class="con1_search" id="view">
		<tr>
	
			<td align="center">품번</td>
			<td><input type="text" name="item" value='${param.item_name}' /></td>
			<td><a href="javascript:search1()"><i class="fas fa-search"></i></a></td>
			<td><input type="text" disabled></td>
			<form name="frmSearchDate" method="get"  action="${contextPath}/member/searchdate.do">
			<td align="right" colspan="2">대상년월</td>
			<td colspan="2">
				<button id="minus"> << </button> <input type="text" value="2021"
				id="year"
				style="background-color: rgb(255, 255, 149); width: 60px; text-align: center;">
				<button id="plus"> >> </button> <select name="Plan_Date" id="reqInput">
					<option value="1">1월</option>
					<option value="2">2월</option>
					<option value="3">3월</option>
					<option value="4">4월</option>
					<option value="5">5월</option>
					<option value="6">6월</option>
					<option value="7">7월</option>
					<option value="8">8월</option>
					<option value="9">9월</option>
					<option value="10">10월</option>
					<option value="11">11월</option>
					<option value="12">12월</option>
			</select>
			</td>
			</form>
		</tr>
		<tr>

			<td align="center">품목군</td>
			<td><input type="text" name="Plan_Item_Code" id="piCodeSearch"></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>
			<td><input type="text" disabled></td>
			<td align="center">판매 계획 수량</td>
			<td><input type="text" name="Plan_Item_Quantity"></td>
			<td><i class="fas fa-search" style="color: blue;"></i></td>
			<td><input type="text" disabled></td>
		</tr>
	</table>
	</container1>
	   <script>
          function search1(){
    	  
        	  openWindowPop('http://localhost:8090/webERP/sales_manage/popItemBySalesList.do','popItemBySalesList');  
    }
    </script>
</body>
</html>