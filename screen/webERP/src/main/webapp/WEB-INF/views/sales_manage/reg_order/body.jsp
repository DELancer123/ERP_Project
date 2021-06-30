<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
String inputNo = (String) request.getAttribute("inputNo");
%>
<%
String parent = request.getParameter("itemNumber");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수주등록</title>
<style>
#contents1 {
	position: absolute;
	padding: 10px;
	right: 0;
	top: 15%;
	width: 85%;
	height: 10%;
	border: 1px solid black;
	z-index: 1;
}

#contents2 {
	position: absolute;
	right: 0;
	top: 25%;
	width: 85%;
	height: 35%;
	border: 1px solid black;
	z-index: 1;
}

#contents3 {
	position: absolute;
	right: 0;
	top: 60%;
	width: 85%;
	height: 35%;
	border: 1px solid black;
	z-index: 1;
}

#view {
	width: 100%;
	text-align: center;
	border: 1px solid black;
}

#view td:not(#no) {
	width: 8%;
}

#view td input {
	width: 100%;
}
</style>
</head>
<body>
	<container1 id=contents1>
	<form id="searchForm" method="get"
		action="${pageContext.request.contextPath }/member/regorder.do">
		<table class="con1_search">
			<tr>
				<td>거래처</td>
				<td><input type="text" id="reqInput" name="bus_code"
					style="width: 100%;" value="${bus_code}" /></td>
				<td><a href="javascript:search1()"><i class="fas fa-search"
						style="color: blue;"></i></a></td>
				<td><input type="text" disabled value="${bus_name}"}></td>
			</tr>

		</table>
	</form>
	</container1>
	<container2 id="contents2">
	<table id="view">
		<thead>
			<td><input type="checkbox" id="check" name="content"
				onclick="selectAll(this)" /></td>
			<td>주문번호</td>
			<td>주문일자</td>
			<td>고객</td>
			<td>과세구분</td>
			<td>비고</td>
		</thead>
		<tbody id="table1">
			<c:forEach var="item" items="${customerList}" varStatus="sts">
				<tr class="moveNum2">
					<td><input type="checkbox" value="${item.ordersNum }"
						name="content" /></td>
					<td><input type="text" class="ordersNum" 
						name="StoVO[${sts.index}].moveNum" value="${item.ordersNum }" /></td>
					<td><input type="date" name="StoVO[${sts.index}].moveDate"
						value="${item.ordersdate }" /></td>
					<td><input type="text"
						name="StoVO[${sts.index}].outputWarehouse"
						value="${item.customerCode }" /></td>
					<td><input type="text" name="StoVO[${sts.index}].outputPlace"
						value='${item.tax }' /></td>
					<td><input type="text" name="StoVO[${sts.index}].inputWarehouse"
						value='${item.note }' /></td>
				</tr>
			</c:forEach> 
			<tr id="insertsuju">
					<td><input type="checkbox" value="check1" id="check"
						name="content" /></td>
					<td><input type="text" id="ordersNum"
						name="sujuVO[${fn:length(stockList)}].ordersNum" value="" /></td>
					<td><input type="date" id="ordersdate"
						name="sujuVO[${fn:length(stockList)}].ordersdate" value="" /></td>
					<td><input type="text" id="customerCode"
						name="sujuVO[${fn:length(stockList)}].General_Customer_Code" value="" /></td>
					<td><input type="text" id="tax"
						name="sujuVO[${fn:length(stockList)}].tax" value="" /></td>
					<td><input type="text" id="Note"
						name="sujuVO[${fn:length(stockList)}].Note" value="" /></td>
				</tr>
		</tbody>
	</table>
	</container2>
	<container3 id="contents3">
	<table id="view">
			<tr>
			<td style="width: 5%;"><input type="checkbox" name="content1"
				onclick="selectAll1(this)"></td>
			<td>코드</td>
			<td>품번</td>
			<td>품명</td>
			<td>규격</td>
			<td>단위</td>
			<td>납기일</td>
			<td>주문수량</td>
			<td>단가</td>
			<td>부가세단가</td>
			<td>출하예정일</td>
			<td>검사</td>
			</tr>
		<tbody id="table3">
		</tbody>
		<tr>
			<td><span id="addInsertSubStoBlock" style="cursor: pointer;">+</span></td>
		</tr>
			
		</tbody>
	</table>
	</container3>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script>
	function search1(){
      	openWindowPop('http://localhost:8090/webERP/member/searchcus.do','searchcus');
}
	function openWindowPop(url, name){
        var options = 'top=0, left=0, width=320, height=420, status=no, menubar=no, toolbar=no, resizable=no';
        window.open(url, name, options);
    }
	function setChildValue(code, name) {
    	$('input[name=bus_code]').val(code);
    	$('input[name=bus_name]').val(name);
    }
	view_button.onclick = function(){
    	
    	var searchForm = $('#searchForm');
    	
    	searchForm.submit();
	}
	
	 var table3 = document.getElementById('table3');
    
    $('.ordersNum').dblclick(function(e) {
    	
//	        var checkMoveNum = document.getElementById('moveNum').value;
   //     deleteTbody3();
        
        var code = $(this).val();
    	$.ajax({ type: "GET",
    		url: "/webERP/member/searchsujusub.do",
    		data : {	"ordersNum" : code},
    		//dataType : 'text',
    		success: function(responseData){
    			var data = responseData.sujusub;
    			
    			// id=table3 안의 모든 요소 지우기
    			$("#table3").empty();
    			
    		/* 	var tbody4index = 0; */
    			for(var i =0; i<data.length; i++){
    				var html = '';
        			html += '<tr>';
        			html += '<td><input type = "checkbox" name = "content2" value = "'+data[i].no+'" "></td>';  	
        			html += '<td><input type = "text" name = ""  value = "'+data[i].code+'" "></td>';  		
        			html += '<td><input type = "text" name = ""  value = "'+data[i].itemCode +'" "></td>';  		
        			html += '<td><input type = "text" name = "" value = "'+data[i].itemName +'"></td>';  			
        			html += '<td><input type = "text" name = "" value = "'+data[i].standard+'"></td>';  			
        			html += '<td><input type = "text" name = "" value = "'+data[i].inventoryUnit+'"></td>';  			
        			html += '<td><input type = "date" name = "" value = "'+data[i].dueDate+'"></td>';  			
        			html += '<td><input type = "text" name = "" value = "'+data[i].ordersQuantity+'"></td>';  			
        			html += '<td><input type = "text" name = "" value = "'+data[i].productPrice+'"></td>';  			
        			html += '<td><input type = "text" name = "" value = "'+data[i].vatPrice+'"></td>';  			
        			html += '<td><input type = "date" name = "" value = "'+data[i].expectedDate+'"></td>';  			
        			html += '<td><input type = "text" name = "" value = "'+data[i].inspection+'"></td>';  			
        			html += '</tr>';
        			//  id=table3 안에 넣기
        			$("#table3").append(html);
    			} 
    			 
    			/* addTbody3(); */
    		},
    		error: function(request,status,error){
    	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    	       }
    	});
    });
    
    /* 
    $('#delete').click(function () {
    	deleteData();
    });
    
    $('#save').click(function () {
    	newRow();
    });
    
    function deleteData() {
  	  var no = "";
  	  var secno = "";
  	  var ary = [];
  	  var secarr = [];
  	  var item = document.getElementsByName("content").length;
  	  var item2 = document.getElementsByName("content2").length;

  	  for(var i=0 ; i<item ; i++){
  		  if(document.getElementsByName("content")[i].checked==true){
  			no = document.getElementsByName("content")[i].value;
  			ary.push(no);
  		  }
  	  }
  	  
  	  for(var i=0 ; i<item2 ; i++){
  		  if(document.getElementsByName("content2")[i].checked==true){
  			secno = document.getElementsByName("content2")[i].value;
  			secarr.push(secno);
  			

  		  }
  	  }
  	  
  	  
  	  
  	if (Array.isArray(ary) && ary.length){
  		if(Array.isArray(secarr) && secarr.length){
		  alert("부모데이터와 자식데이터를 함께 삭제할 수 없습니다 한쪽만 체크하십시오.");
  		}
  		else{
  			 window.location.href = "${contextPath}/member/delWareStock.do?moveNum="+ary;
  		}
	 }
  	else{
  		
		 window.location.href = "${contextPath}/member/delWareStockSub.do?no="+secarr;
	 }
    }
    
    
    var tbody3Index = 0;
    
    function addTbody3() {
    	
        var tbody2html = '<tr>'
            + '<td><input type="checkbox" name="content2" /></td>'
            + '<td><input type="text" name="subListStoVO[' + tbody3Index + '].no" value=""/></td>'
            + '<td><input type="text" name="subListStoVO[' + tbody3Index + '].moveNum" value=""/></td>'
            + '<td><input type="text" name="subListStoVO[' + tbody3Index + '].itemCode" value=""/></td>'
            + '<td><input type="text" name="subListStoVO[' + tbody3Index + '].itemName" value=""/></td>'
            + '<td><input type="text" name="subListStoVO[' + tbody3Index + '].standard" value=""/></td>'
            + '<td><input type="text" name="subListStoVO[' + tbody3Index + '].inventoryUnit" value=""/></td>'
            + '<td><input type="text" name="subListStoVO[' + tbody3Index + '].moveQuantity" value=""/></td>'
            + '</tr>';
    	$('#table3').append(tbody2html);
    	
    	tbody3Index++;
    }
    
    function deleteTbody3() {
    	$('#table3').empty();
    	tbody3Index = 0;
    }
    function deleteTbody4() {
    	$('#table3').empty();
    }
    
    $('#insertWareStock').dblclick(function() {
    	deleteTbody3();
    	addTbody3();
    });
    
    $('#addInsertSubStoBlock').click(function(){
    	addTbody3();
    })
    
    
    function newRow(){
    	// 추가하는 메인 값이 있는지 체크
    	var addDate = $('#moveDate').val();
    	
    	var datetime_pattern = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1]) (0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$/; 

    	if(!datetime_pattern.test(addDate)){
    		$('#insertWareStock').remove();
    	}
    	
        // dao에서 저장
        var row = view1.insertRow(); 
        const URLSearch = new URLSearchParams(location.search);
		  	URLSearch.set('submit', '1');
		  	const newParam = URLSearch.toString();
		 	var link = location.pathname +'?'+newParam;
		var articleNOInput = document.createElement("input");
		    articleNOInput.setAttribute("type","hidden");
		    articleNOInput.setAttribute("name","path");
		    articleNOInput.setAttribute("value", link);
		    var regForm = document.getElementById('regWareStock');
		    regForm.appendChild(articleNOInput);
		    regForm.action = "${contextPath}/member/addWareStock.do";
		    regForm.submit();  
    }
    $('#update').click(function(){
    	updateRow();
    })
    function updateRow(){
    	
    	deleteTbody4();
		var addDate = $('#moveDate').val();
    	
    	var datetime_pattern = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1]) (0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$/; 

    	if(!datetime_pattern.test(addDate)){
    		$('#insertWareStock').remove();
    	}
    	
        const URLSearch = new URLSearchParams(location.search);
        	URLSearch.set('submit', '1');
		  	const newParam = URLSearch.toString();
		 	var link = location.pathname +'?'+newParam;
		   	var articleNOInput = document.createElement("input");
		     	articleNOInput.setAttribute("type","hidden");
		     	articleNOInput.setAttribute("name","path");
		     	articleNOInput.setAttribute("value", link);
		     	var regForm = document.getElementById('regWareStock');
		     	regForm.appendChild(articleNOInput);
		     	regForm.action = "${contextPath}/member/updateWareStock.do";
		     	regForm.submit();  
    }
	  */
	 
	</script>
</body>
</html>