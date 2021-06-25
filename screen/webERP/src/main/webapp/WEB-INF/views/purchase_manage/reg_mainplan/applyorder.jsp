<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import ="java.util.Arrays"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
	String inputSeq = (String)request.getAttribute("inputSeq");
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
	margin-top: -3%;
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
<form name="popForm" method="get">
	<div id="wrap">
		<div id="searchBox">
			<table id="search">
<!--  				<tr>
					<td>주문기간</td>
						<td><input type="date" id="dateStart"
							style="background-color: yellow;" /></td>
						<td>~</td>
						<td><input type="date" id="dateEnd"
							style="background-color: yellow;" /></td>
						<td></td>
				</tr> -->
					<tr>
						<td>품목코드</td>
						<td><input type="text" id="code" name="code" /></td>
					</tr>
					<tr>
						<td>품목명</td>
						<td><input type="text" id="name" name="name" class="name" /></td>
					</tr>
					<tr>
			</table>
			<div id="button">
				<input type="button" id="planSearch" value="조회" onClick="sendData();" />			
				<button id="submit" onclick="submitClick(this.form)">적용</button>
                <input type="hidden" name="inputSeq" value=""/>
			</div>
		</div>
		<div id="view">
			<table style="width: 100%;" id="searchItem">
				<thead align="center" style="background-color: gray">
					<td ><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
<!-- 					<td>순서</td>
					<td>주문번호</td>
					<td>주문일자</td>
					<td>고객</td> -->
					<td>품번</td>
					<td>품명</td>
<!-- 					<td>규격</td>
					<td>단위</td>
					<td>주문수량</td>
					<td>출하예정일</td>
					<td>비고</td> -->
				</thead>	
				<c:forEach var="MpsOS" items="${mpsosList}">
					<tr align="center" id="searchItem">
					      <td><a href="javascript:popFunction('${MpsOS.item_Code }','${MpsOS.item_Name }')">${MpsOS.item_Code}</a></td>
      					  <td><a href="#">${MpsOS.item_Name}</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
<script type="text/javascript">
var submit_button = document.getElementById("submit");
var text_code = document.getElementById("code");
var text_name = document.getElementById("name");
		
	function popFunction(code,name){
			text_code.value = code;
			text_name.value = name;
			
	}
	function submitClick(form){
		opener.setChildValue(text_code.value)
		window.close(); 
	}
	
	
var startDate;
var endDate;


$('#dateStart').change(function (){
    var date = $('#dateStart').val();
    startDate = date;
});
$('#dateEnd').change(function (){
    var date = $('#dateEnd').val();
    endDate = date;
});

function sendData() {
	if(startDate == null && endDate == null){
		alert("시작일과 종료일은 필수 입력 요소입니다!");
	} else if(startDate == null) {
		alert("시작일은 필수 입력 요소입니다!");
	} else if(endDate == null){
		alert("종료일은 필수 입력 요소입니다!");
	} else if(startDate > endDate){
		alert("종료일은 시작일보다 커야합니다!");
	} else {
		location.href='${contextPath }/member/applyorder.do?dateStart='+startDate+'&&dateEnd='+endDate;
	}
}

//ajax 구문
$('.name').keyup(function(){
//변수 words에 id가 name인것의 값을 저장한다
var words = $('#name').val();
$.ajax({
	type : 'GET',
	url : '/webERP/member/searchMPSOS.do',
	//words값을 "itemName"이라는 이름의 파라미터로 전송한다.
	data : { "itemName" : words},
	success : function(responseData){
	var data = responseData.popName;
	
	//검색을 시작할시 원래 있던 데이터를 지운다.
	$("#searchItem").empty();
					
		for(var i = 0 ; i<data.length ; i++){
			var str = '';
				str += 	'<tr align="center" id = "yahoo">';
				str +=  '<td>'+ data[i].item_Code + '</a></td>';  
				str +=  '<td>'+ data[i].item_Name + '</a></td>';  
				str +=  '<td><input type = "hidden" id="iCode" name ="iCode" value = "'+data[i].item_Code+'"></td>';  
				str +=  '<td><input type = "hidden" id="iName" value = "'+data[i].item_Name+'" ></td>';  
				str +=	'</tr>';
				//반복문을 사용하여 searchItem table에 추가
				$("#searchItem").append(str);
			}	    					    						
				},
	error: function(request,status,error){
      alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    	}
});
		
});

$(document).on("click", "#yahoo", function (e){

var initCode = 	$(this).find('input[id=iCode]').val();	
var initName = 	$(this).find('input[id=iName]').val();

$('input[name=code]').val(initCode);
$('input[name=name]').val(initName);

});
</script>
</form>
</body>
</html>